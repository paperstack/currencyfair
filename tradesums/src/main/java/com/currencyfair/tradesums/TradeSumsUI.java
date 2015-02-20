package com.currencyfair.tradesums;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;

import org.dussan.vaadin.dcharts.DCharts;
import org.dussan.vaadin.dcharts.data.DataSeries;
import org.dussan.vaadin.dcharts.metadata.LegendPlacements;
import org.dussan.vaadin.dcharts.metadata.locations.LegendLocations;
import org.dussan.vaadin.dcharts.metadata.renderers.LegendRenderers;
import org.dussan.vaadin.dcharts.metadata.renderers.SeriesRenderers;
import org.dussan.vaadin.dcharts.options.Legend;
import org.dussan.vaadin.dcharts.options.Options;
import org.dussan.vaadin.dcharts.options.SeriesDefaults;
import org.dussan.vaadin.dcharts.renderers.legend.EnhancedLegendRenderer;
import org.dussan.vaadin.dcharts.renderers.series.PieRenderer;

import com.currencyfair.model.Trade;
import com.currencyfair.service.TradeLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.vaadin.addon.ipcforliferay.LiferayIPC;
import com.vaadin.addon.ipcforliferay.event.LiferayIPCEvent;
import com.vaadin.addon.ipcforliferay.event.LiferayIPCEventListener;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Displays a sum table off all trades that were converted from a given currency and to a given currency as well as some fun interactive charts.
 * @author Alex Rud
 *
 */
@Theme("valo")
@SuppressWarnings("serial")
@Widgetset("com.currencyfair.tradesums.AppWidgetSet")
public class TradeSumsUI extends UI {

    private static Log log = LogFactoryUtil.getLog(TradeSumsUI.class);
    VerticalLayout mainLayout = null;
    LiferayIPC ipc = null;
    String userId = null;
    //A loose check for the user rights. As long as a role has "Admin" in the name we'll let them see all trades
  	//This would be tighter implementation in a real system
    private static final String ADMIN_ROLE_NAME = "Admin";  
    
    private DCharts fromChart = null;
    private DCharts toChart = null;
  	
    @Override
    protected void init(VaadinRequest request) {
    	//Init ipc
    	ipc = new LiferayIPC();
    	ipc.extend(this);
    	ipc.addLiferayIPCEventListener("update", new LiferayIPCEventListener() {
			
			@Override
			public void eventReceived(LiferayIPCEvent event) {
				processTrades(event.getData());
				
			}
		});
    	mainLayout = new VerticalLayout();
    	
    	if(request.getUserPrincipal() != null){ //Only do this if the user is logged in otherwise ask for log in
    		userId = request.getUserPrincipal().getName();
        	try{
        		if(isAdmin(userId)){
        			populateTradeSums(TradeLocalServiceUtil.getTrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS));
        		}else{
        			String userName = UserLocalServiceUtil.getUser(Long.parseLong(userId)).getScreenName(); //Use the screen name as a link to the provided user ids
        			populateTradeSums(TradeLocalServiceUtil.findByUserId(Long.parseLong(userName)));
        		}
        	}catch(Exception e){
        		log.error(e);
        	}
        	setContent(mainLayout);
        }else{
    		setContent(new Label("You must login to view trade data"));
    	}
    }
    
    /**
     * Called when the data in the trades table changes (or when user requests an update to refresh)
     * Will clear out all currently set data and update UI components as needed.
     * @param data
     */
    private void processTrades(String data){
    	if(data == null || data.length() == 0){//If the trades table has no data
			mainLayout.removeAllComponents();
			mainLayout.addComponent(new Label("No data selected"));
			return;
		}
    	
    	//Determine if the user is admin, if not we'll check that the screenname matches the trade userId as a security precaution 
		boolean isUserAdmin = isAdmin(userId); 
		List<Trade> trades = new ArrayList<Trade>();
		String[] ids = data.split(",");
		String screenName = "";
		try {
			screenName = UserLocalServiceUtil.getUser(Long.parseLong(userId)).getScreenName();
			for(int i = 0; i < ids.length; i++){
				
				Trade trade = TradeLocalServiceUtil.getTrade(Long.parseLong(ids[i]));
				if(isUserAdmin || trade.getUserId() == Long.parseLong(screenName)){
					trades.add(trade);
				}else{//Someone who is not a trade owner or an admin tried to access a trade, dont show the trade and send an alert (just log for now)
					log.warn("UNAUTHORIZED ATTEMPT TO ACCESS TRADE: " + trade.getTradeId());
				}
			}
			
			populateTradeSums(trades);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
    /**
     * Populates all UI components w/ the given list of trades
     * @param trades Trades to count and the respective data to display
     */
    private void populateTradeSums(List<Trade> trades){
    	mainLayout.removeAllComponents();
    	HorizontalLayout columnContainer = new HorizontalLayout();
    	VerticalLayout fromLabelsLayout = new VerticalLayout();
    	VerticalLayout fromValuesLayout = new VerticalLayout();
    	VerticalLayout toLabelsLayout = new VerticalLayout();
    	VerticalLayout toValuesLayout = new VerticalLayout();
    	
    	//Set alignment
    	fromLabelsLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
    	fromValuesLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
    	toLabelsLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
    	toValuesLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
    	
    	Hashtable<String, BigDecimal> fromCounts = new Hashtable<String, BigDecimal>();
    	Hashtable<String, BigDecimal> toCounts = new Hashtable<String, BigDecimal>();
    	BigDecimal one = new BigDecimal(1);
    	for(Trade trade: trades){
    		String fromKey = trade.getCurrencyFrom();
    		String toKey = trade.getCurrencyTo();
    		
    		//Increment the from count
    		if(fromCounts.containsKey(fromKey)){
    			fromCounts.put(fromKey, fromCounts.get(fromKey).add(one));
    		}else{
    			fromCounts.put(fromKey, one);
    		}
    		
    		//Increment the to count
    		if(toCounts.containsKey(toKey)){
    			toCounts.put(toKey, toCounts.get(toKey).add(one));
    		}else{
    			toCounts.put(toKey, one);
    		}
    	}
    	fromLabelsLayout.addComponent(new Label("From Currency"));
    	fromValuesLayout.addComponent(new Label("Trade Count"));
    	toLabelsLayout.addComponent(new Label("To Currency"));
    	toValuesLayout.addComponent(new Label("Trade Count"));
    	
    	//Populate the layout w/ the results
    	for(String key: fromCounts.keySet()){
    		fromLabelsLayout.addComponent(new Label(key));
    		fromValuesLayout.addComponent(new Label(fromCounts.get(key).toString()));
    	}
    	
    	for(String key: toCounts.keySet()){
    		toLabelsLayout.addComponent(new Label(key));
    		toValuesLayout.addComponent(new Label(toCounts.get(key).toString()));
    	}
    	
    	columnContainer.addComponent(fromLabelsLayout);
    	columnContainer.addComponent(fromValuesLayout);
    	columnContainer.addComponent(toLabelsLayout);
    	columnContainer.addComponent(toValuesLayout);
    	
    	//Build the charts
    	DataSeries fromDataSeries = new DataSeries();
    	DataSeries toDataSeries = new DataSeries();
    	
    	for(Entry<String, BigDecimal> entry: fromCounts.entrySet()){
    		fromDataSeries.newSeries().add(entry.getKey(), entry.getValue());
    	}
    	
    	for(Entry<String, BigDecimal> entry: toCounts.entrySet()){
    		toDataSeries.newSeries().add(entry.getKey(), entry.getValue());
    	}
    	
    	Legend legend = new Legend().setShow(true).setLocation(
                LegendLocations.EAST).setRenderer(LegendRenderers.ENHANCED).setRendererOptions(new EnhancedLegendRenderer().setSeriesToggleReplot(true));
  
        SeriesDefaults seriesDefaults = new SeriesDefaults().setRenderer(
                SeriesRenderers.PIE).setRendererOptions(
                new PieRenderer().setShowDataLabels(true));
  
        Options options = new Options().setSeriesDefaults(seriesDefaults).setLegend(legend).setTitle("Currencies converted from: (click the legend keys)");
        Options options2 = new Options().setSeriesDefaults(seriesDefaults).setLegend(legend).setTitle("Currencies converted to: (click the legend keys)");
        fromChart = new DCharts();
        fromChart.setDataSeries(fromDataSeries).setOptions(options).show();
        
        toChart = new DCharts();
        toChart.setDataSeries(toDataSeries).setOptions(options2).show();
        mainLayout.addComponent(columnContainer);
    	mainLayout.addComponent(fromChart);
    	mainLayout.addComponent(toChart);
    }
    
    /**
     * Method will take the user id and determine if the user has the rights to view all trades(admin) or just their own (user)
     * 
     * @param userId
     * @return true if the user is considered an administrator
     */
    private boolean isAdmin(String userId) {
    	boolean result = false;
    	List<Role> roles = null;
    	try {
			roles = RoleLocalServiceUtil.getUserRoles(Long.parseLong(userId));
			for(Role role: roles){
				if(role.getName().contains(ADMIN_ROLE_NAME)){
					result = true;
				}
			}
		} catch (NumberFormatException e) {
			log.error(e);
		} catch (SystemException e) {
			log.error(e);
		}
    	
    	return result;
	}
    
    /**
     * Repaints the portlet to emulate a page refresh as the init method is only called once per user session
     */
    @Override
    protected void refresh(VaadinRequest request) {
    	try{
    		if(isAdmin(userId)){
    			populateTradeSums(TradeLocalServiceUtil.getTrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS));
    		}else{
    			String userName = UserLocalServiceUtil.getUser(Long.parseLong(userId)).getScreenName(); //Use the screen name as a link to the provided user ids
    			populateTradeSums(TradeLocalServiceUtil.findByUserId(Long.parseLong(userName)));
    		}
    	}catch(Exception e){
    		log.error(e);
    	}
    	super.refresh(request);
    }
}