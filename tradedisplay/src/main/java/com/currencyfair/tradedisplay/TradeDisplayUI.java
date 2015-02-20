package com.currencyfair.tradedisplay;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.portlet.PortletContext;
import javax.portlet.PortletSession;

import org.tepi.filtertable.FilterTable;

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
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.Container.ItemSetChangeEvent;
import com.vaadin.data.Container.ItemSetChangeListener;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.WrappedPortletSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Shows a list of trades in the system in a filtering table.
 * The filtering table will allow the user to filter the table by inputing various criteria in the column headers.
 * When table data is updated the data all other portlets will be updated through the IPC mechanism (by subscribing to the "update" event)
 * either manually or automatically, depending on the mode selected by the user.
 * 
 * For admin users, trade deletion functionality is allowed as well. 
 *
 * @author Alex Rud
 * 
 */
@Theme("liferay")
@SuppressWarnings("serial")
@Widgetset("com.currencyfair.tradedisplay.AppWidgetSet")

public class TradeDisplayUI extends UI {

	//A loose check for the user rights. As long as a role has "Admin" in the name we'll let them see all trades
	//This would be tighter implementation in a real system
    private static final String ADMIN_ROLE_NAME = "Admin";  
	private static Log log = LogFactoryUtil.getLog(TradeDisplayUI.class);
    
    FilterTable tradesTable = null;
    VerticalLayout mainLayout = null;
    BeanItemContainer<Trade> tradesContainer = new BeanItemContainer<Trade>(Trade.class);
    NativeSelect updateMode = null;
    Button updateButton = null;
    Button deleteButton = null;
    
    //Keep track of how we want to update other portlets - automatically on data change or manually by button click
    boolean autoUpdate = false;
    
    //Inter-portlet communicator
    LiferayIPC ipc = null;
   
    @Override
    protected void init(VaadinRequest request) {

        //Init ipc
        ipc = new LiferayIPC();
        ipc.extend(this);
        
        //Init UI components
        mainLayout = new VerticalLayout();
        tradesTable = new FilterTable();
        try {
        	tradesTable.setFilterDecorator(new Decorator());
        	List<Trade> trades = null;
        	if(request.getUserPrincipal() != null){ //Only do this if the user is logged in otherwise ask for log in
        		String userId = request.getUserPrincipal().getName();
        		if(isAdmin(userId)){// Build the admin table showing the trades of all the users
        			trades = TradeLocalServiceUtil.getTrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        			tradesContainer.addAll(trades);
    	           	tradesTable.setContainerDataSource(tradesContainer);
    	          	tradesTable.setVisibleColumns(new Object[]{"tradeId", "userId","currencyFrom", "currencyTo", "amountSell", "amountBuy", "rate", "timePlaced", "originatingCountry"});
    	          	tradesTable.setColumnHeaders(new String[]{"Trade Id", "User Id", "Currency From", "Currency To", "Amount Sell", "Amount Buy", "Rate", "Time Placed", "Originating Country"});
    	          	deleteButton = new Button("Delete Selected Trades");
    	          	deleteButton.addClickListener(new ClickListener() {
						
						@Override
						public void buttonClick(ClickEvent event) {
							deleteTrades();
							
						}
					});
    	          	tradesTable.setSelectable(true);
    	          	tradesTable.setMultiSelect(true);
        		}else{ //Build a table for a regular user only showing the user's trades
        			String userName = UserLocalServiceUtil.getUser(Long.parseLong(userId)).getScreenName(); //Use the screen name as a link to the provided user ids
        			trades = TradeLocalServiceUtil.findByUserId(Long.parseLong(userName));
        			tradesContainer.addAll(trades);
    	           	tradesTable.setContainerDataSource(tradesContainer);
    	          	tradesTable.setVisibleColumns(new Object[]{"tradeId", "currencyFrom", "currencyTo", "amountSell", "amountBuy", "rate", "timePlaced", "originatingCountry"});
    	          	tradesTable.setColumnHeaders(new String[]{"Trade Id", "Currency From", "Currency To", "Amount Sell", "Amount Buy", "Rate", "Time Placed", "Originating Country"});
        		}
        		
	        	tradesTable.setFilterBarVisible(true);
	          	tradesTable.setColumnReorderingAllowed(true);
	          	tradesTable.addItemSetChangeListener(new ItemSetChangeListener() {
					
					@Override
					public void containerItemSetChange(ItemSetChangeEvent event) {
						if(autoUpdate){//Only send update if we're set to auto mode
							sendUpdate();
						}
						
					}
				});
	          	
	          	//Update mode init
	          	updateMode = new NativeSelect("Update Mode");
	          	updateMode.addItem("Automatic");
	          	updateMode.addItem("Manual");
	          	updateMode.setNullSelectionAllowed(false);
	          	updateMode.select("Manual");
	          	updateMode.addValueChangeListener(new ValueChangeListener() {
					
					@Override
					public void valueChange(ValueChangeEvent event) {
						changeUpdateMode();
						
					}
				});
				
				//Button to manually send out an update event to other portlets
				updateButton = new Button("Update");
				updateButton.addClickListener(new ClickListener() {
					
					@Override
					public void buttonClick(ClickEvent event) {
						
						sendUpdate();
					}
				});
	          	//Layout out our UI items in a vertical stack
				
	          	mainLayout.addComponent(tradesTable);
	          	if(isAdmin(userId)){//Add the delete button for admins
					mainLayout.addComponent(deleteButton);
				}
	          	mainLayout.addComponent(updateMode);
	          	mainLayout.addComponent(updateButton);
	          	
        	}else{ //Just show a message asking for a login
        		mainLayout.addComponent(new Label("You must login to view trade data"));
        	}
        } catch (SystemException e) {
			log.error(e);
		} catch (NumberFormatException e) {
			log.error(e);
		} catch (PortalException e) {
			log.error(e);
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
     * Repaints the portlet to emulate a page refresh as the init method is only called once per user session
     */
    @Override
    protected void refresh(VaadinRequest request) {
    	try {
    		List<Trade> trades = null;
        	if(request.getUserPrincipal() != null){ //Only do this if the user is logged in, otherwise ask for log in
        		String userId = request.getUserPrincipal().getName();
        		if(isAdmin(userId)){// Build the admin table showing the trades of all the users
        			trades = TradeLocalServiceUtil.getTrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        			tradesTable.clearFilters();
        			tradesContainer.removeAllItems();
        			tradesContainer.addAll(trades);
    	          	tradesTable.refreshRowCache();
        		}else{
        			String userName = UserLocalServiceUtil.getUser(Long.parseLong(userId)).getScreenName(); //Use the screen name as a link to the provided user ids
        			trades = TradeLocalServiceUtil.findByUserId(Long.parseLong(userName));
        			tradesTable.clearFilters();
        			tradesContainer.removeAllItems();
        			tradesContainer.addAll(trades);
    	          	tradesTable.refreshRowCache();
	          	
        		}
    		}else{
    			//Just show a message asking for a login
        		mainLayout.addComponent(new Label("You must login to view trade data"));
    		}
		} catch (SystemException e) {
			log.error(e);
		} catch (NumberFormatException e) {
			log.error(e);
		} catch (PortalException e) {
			log.error(e);
		}
    	super.refresh(request);
    	
    }
    
    /**
     * Will perform necessary UI changes depending on how the user wants the interaction to work
     */
    private void changeUpdateMode(){
    	//Hide or show the button depending on how the user wants the table to work
    	String selected = (String)updateMode.getValue();
    	if("Automatic".equalsIgnoreCase(selected)){
    		updateButton.setVisible(false);
    		autoUpdate = true;
    	}else{
    		updateButton.setVisible(true);
    		autoUpdate = false;
    	}
    }
    
    /**
     * Get all the data in our table and send an update even to all other portlets w/ the ids of the trades to process
     */
    private void sendUpdate(){
    	StringBuffer ids = new StringBuffer();
    	//Build the list of ids we want other portlets to process - comma delimited
    	Collection<Trade> trades = (Collection<Trade>) tradesTable.getItemIds();
    	for(Trade trade: trades){
    		ids.append(trade.getTradeId());
    		ids.append(",");
    	}
    	

    	//Strip off the last comma and send the event 
    	if(ids.length() > 0){
	    	ids.deleteCharAt(ids.lastIndexOf(","));
    	}
	    ipc.sendEvent("update", ids.toString());
    	
    }
    
    /**
     * Allows admins to delete trades from the system. Probably more useful in a demo/test environment than real production
     */
    private void deleteTrades(){
    	Set<Trade> selectedTrades = (Set<Trade>)tradesTable.getValue();
    	for(Trade trade: selectedTrades){
    		try {
				TradeLocalServiceUtil.deleteTrade(trade);
				tradesTable.removeItem(trade);
			} catch (SystemException e) {
				log.error(e);
			}
    	}
    }
}
