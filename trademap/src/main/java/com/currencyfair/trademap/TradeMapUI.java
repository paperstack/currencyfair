package com.currencyfair.trademap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.vaadin.addon.leaflet.LMap;
import org.vaadin.addon.leaflet.LMarker;
import org.vaadin.addon.leaflet.LPolyline;
import org.vaadin.addon.leaflet.LTileLayer;
import org.vaadin.addon.leaflet.shared.Point;
import org.vaadin.addon.leaflet.util.JTSUtil;
import org.vaadin.addon.leafletheat.LHeatMapLayer;

import com.currencyfair.model.Trade;
import com.currencyfair.service.TradeLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.vaadin.addon.ipcforliferay.LiferayIPC;
import com.vaadin.addon.ipcforliferay.event.LiferayIPCEvent;
import com.vaadin.addon.ipcforliferay.event.LiferayIPCEventListener;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vividsolutions.jts.io.ParseException;

/**
 * @author Alex Rud
 * 
 * The user intrface class of the trademap portlet showing a heat map of all the trades by orginiating country
 *
 */
@Theme("liferay")
@SuppressWarnings("serial")
@Widgetset("com.currencyfair.trademap.AppWidgetSet")
public class TradeMapUI extends UI {

    private static Log log = LogFactoryUtil.getLog(TradeMapUI.class);
    
    private LMap leafletMap = null;
    private LTileLayer tileLayer = null;
   
    private LHeatMapLayer layer = null;
    
    private LiferayIPC ipc = null;
    
    private final int MAX_POINTS = 10000; //The map cant handle an excessive number of points so we'll cap it at 10k

    @Override
    protected void init(VaadinRequest request) {
    	//Init the IPC
    	ipc = new LiferayIPC();
    	ipc.extend(this);
    	ipc.addLiferayIPCEventListener("update", new LiferayIPCEventListener() {
			
			@Override
			public void eventReceived(LiferayIPCEvent event) {
				processTrades(event.getData());
			}
		});
    	leafletMap = new LMap();
    	layer = getHeatLayer();

    	try {//Create all the points that we want to plot 
			List<Trade> trades = TradeLocalServiceUtil.getTrades(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			int totalPoints = 0;
			if(trades.size() > MAX_POINTS){
				totalPoints = MAX_POINTS;
			}else{
				totalPoints = trades.size();
			}
			Point[] points = new Point[totalPoints];
			for(int i = 0; i < totalPoints; i++){
				String coord = TradeLocalServiceUtil.getLocaleCoordinates(trades.get(i).getOriginatingCountry());
				Point p = new Point(Double.parseDouble(coord.split(":")[0]), Double.parseDouble(coord.split(":")[1]));
				points[i] = p;
			}
			layer.setPoints(points);
		} catch (SystemException e) {
			log.error(e);
		}
    	

    	//Set the tile map info
    	tileLayer = new LTileLayer("http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png");
    	leafletMap.addBaseLayer(tileLayer, "Base");
    	leafletMap.addLayer(layer);
    	
    	leafletMap.setHeight("380px");
    	setContent(leafletMap);
    }


    private LHeatMapLayer getHeatLayer() {
    	LHeatMapLayer layer = new LHeatMapLayer();
    	leafletMap.setMinZoom(2);
    	leafletMap.setZoomLevel(2);
    	HashMap<Double,String> gradient = new LinkedHashMap<Double, String>();
    	// {0.4: 'blue', 0.65: 'lime', 1: 'red'}
    	gradient.put(0.4, "blue");
    	gradient.put(0.65, "lime");
    	gradient.put(1.0, "red");
    	layer.setGradient(gradient);
    	return layer;
	}


	/**
     * Called when the trade display portlet wants to update the map (through an IPC call)
     * @param data
     */
	protected void processTrades(String data) {
		if(data == null || data.length() == 0){//If the trades table has no data
			setContent(new Label("No data selected"));
			return;
		}
		
		leafletMap.removeAllComponents();
		String[] ids = data.split(",");
		
		int totalPoints = 0;
		
		if(ids.length > MAX_POINTS){
			totalPoints = MAX_POINTS;
		}else{
			totalPoints = ids.length;
		}
		Point[] points = new Point[totalPoints];
		
		try{
			for(int i = 0; i < totalPoints; i++){
				
				Trade trade = TradeLocalServiceUtil.getTrade(Long.parseLong(ids[i]));
				String coord = TradeLocalServiceUtil.getLocaleCoordinates(trade.getOriginatingCountry());
				Point p = new Point(Double.parseDouble(coord.split(":")[0]), Double.parseDouble(coord.split(":")[1]));
				points[i] = p;
			}
		}catch(PortalException e){
			log.error(e);
		}catch(SystemException e){
			log.error(e);
		}
		
		layer = getHeatLayer();
		layer.setPoints(points);
		leafletMap.addBaseLayer(tileLayer, "Base");
		leafletMap.addLayer(layer);
		setContent(leafletMap);
	}
}
