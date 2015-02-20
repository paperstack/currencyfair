package com.currencyfair.tradematrix;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.portlet.PortletContext;
import javax.portlet.PortletSession;

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
import com.vaadin.server.WrappedPortletSession;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * The UI component of the tradematrix portlet. Which will display a table of to-from currency counts of the trades selected by the user.
 * @author Alex Rud
 *
 */
@Theme("valo")
@SuppressWarnings("serial")
@Widgetset("com.currencyfair.tradematrix.AppWidgetSet")
public class TradeMatrixUI extends UI {

	
	//A loose check for the user rights. As long as a role has "Admin" in the name we'll let them see all trades
	//This would be tighter implementation in a real system
    private static final String ADMIN_ROLE_NAME = "Admin";  
		
    private static Log log = LogFactoryUtil.getLog(TradeMatrixUI.class);
    private LiferayIPC ipc = null;
    String userId = null; //Keep track of the user interacting w/ this instance of the UI - each user will have their own instance of the UI
    VerticalLayout mainLayout = null;
    @Override
    protected void init(VaadinRequest request) {
        //Init the ipc
    	ipc = new LiferayIPC();
    	ipc.extend(this);
    	ipc.addLiferayIPCEventListener("update", new LiferayIPCEventListener() {
			
			@Override
			public void eventReceived(LiferayIPCEvent event) {
				processTrades(event.getData());
			}
		});
    	
    	//Init the UI 
    	mainLayout = new VerticalLayout();
    	
    	
    	if(request.getUserPrincipal() != null){ //Only do this if the user is logged in otherwise ask for log in
        	userId = request.getUserPrincipal().getName();
        	try{
        		if(isAdmin(userId)){
        			populateMatrix(TradeLocalServiceUtil.getTrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS));
        		}else{
        			String userName = UserLocalServiceUtil.getUser(Long.parseLong(userId)).getScreenName(); //Use the screen name as a link to the provided user ids
        			populateMatrix(TradeLocalServiceUtil.findByUserId(Long.parseLong(userName)));
        		}
        	}catch(Exception e){
        		log.error(e);
        	}
    	}else{
    		setContent(new Label("You must login to view trade data"));
    	}
    	
    	
    	
    	
    	setContent(mainLayout);
    	
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
     * Called when the trade display portlet wants to update the trade matrix (through an IPC call)
     * @param data
     */
	protected void processTrades(String data) {
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
			
			populateMatrix(trades);
		} catch (NumberFormatException e) {
			log.error(e);
		} catch (PortalException e) {
			log.error(e);
		} catch (SystemException e) {
			log.error(e);
		}
		
	}

	/**
	 * This method will (re)draw the currency conversion matrix
	 * @param trades
	 */
	private void populateMatrix(List<Trade> trades) {
		//We'll hold a 2d array of the various conversions in our trade set
		HashMap<String, HashMap<String, BigInteger>> conversionMatrix = new HashMap<String, HashMap<String,BigInteger>>();
		
		//We'll also hold a set of "To" currencies to know all the currencies we need to account for on the X axis 
		HashSet<String> toKeys = new HashSet<String>();
		
		//Populate the matrix
		for(Trade trade: trades){
			String from = trade.getCurrencyFrom();
			String to = trade.getCurrencyTo();
			if(conversionMatrix.containsKey(from)){
				if(conversionMatrix.get(from).containsKey(to)){//We've made this conversion before so increment
					BigInteger i = conversionMatrix.get(from).get(to).add(new BigInteger("1"));
					conversionMatrix.get(from).put(to, i);
				}else{//First time making a conversion to this destination from this source
					conversionMatrix.get(from).put(to, new BigInteger("1"));
					toKeys.add(to);
				}
			}else{//First time we've encountered this source, start a new row for it
				toKeys.add(to);
				HashMap<String, BigInteger> toMap = new HashMap<String, BigInteger>();
				toMap.put(to, new BigInteger("1"));
				conversionMatrix.put(from, toMap);
			}
		}
		
		//Clear the parent component and create a new grid inside it
		mainLayout.removeAllComponents();
		
		GridLayout matrix = new GridLayout(toKeys.size() + 1, conversionMatrix.size() + 1); //Add one row and column for the labels
		matrix.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		//Populate the top row w/ our destination currencies
		String[] destinations = new String[toKeys.size()];
		toKeys.toArray(destinations);
		for(int i=0; i < destinations.length; i++){
			matrix.addComponent(new Label(destinations[i]), i+1, 0);
		}
		
		int rowTracker = 1;
		for(String key: conversionMatrix.keySet()){
			HashMap<String, BigInteger> conversionCount = conversionMatrix.get(key);//The counts of all the conversions from this specific currency
			matrix.addComponent(new Label(key), 0, rowTracker);
			for(int i=0; i < destinations.length; i++){
				if(conversionCount.containsKey(destinations[i])){//If we have conversions print the value
					matrix.addComponent(new Label(conversionCount.get(destinations[i]).toString()), i + 1, rowTracker);
				}else{//Otherwise print 0
					matrix.addComponent(new Label("0"), i + 1, rowTracker);
				}
			}
			rowTracker++; //Move on to the next row
		}
		
		mainLayout.addComponent(matrix);
		
	}
	
	/**
     * Repaints the portlet to emulate a page refresh as the init method is only called once per user session
     */
    
	@Override
	protected void refresh(VaadinRequest request) {
    	if(request.getUserPrincipal() != null){ //Only do this if the user is logged in otherwise ask for log in
        	userId = request.getUserPrincipal().getName();
        	try{
        		if(isAdmin(userId)){
        			populateMatrix(TradeLocalServiceUtil.getTrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS));
        		}else{
        			String userName = UserLocalServiceUtil.getUser(Long.parseLong(userId)).getScreenName(); //Use the screen name as a link to the provided user ids
        			populateMatrix(TradeLocalServiceUtil.findByUserId(Long.parseLong(userName)));
        		}
        	}catch(Exception e){
        		log.error(e);
        	}
    	}else{
    		setContent(new Label("You must login to view trade data"));
    	}
		super.refresh(request);
	}

}
