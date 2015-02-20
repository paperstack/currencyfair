package com.currencyfair.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import com.currencyfair.model.Trade;
import com.currencyfair.model.impl.TradeImpl;
import com.currencyfair.service.TradeLocalService;
import com.currencyfair.service.TradeLocalServiceUtil;
import com.currencyfair.service.TradeService;
import com.currencyfair.service.TradeServiceUtil;
import com.currencyfair.service.http.TradeServiceSoap;
import com.currencyfair.service.impl.TradeLocalServiceImpl;
import com.currencyfair.service.impl.TradeServiceImpl;
import com.liferay.portal.kernel.bean.BeanLocator;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.util.service.ServiceProps;

public class TradeTest {
	private BeanLocator mockBeanLocator;
	
	@Before
	public void init(){
		mockBeanLocator = mock(BeanLocator.class);
		PortletBeanLocatorUtil.setBeanLocator("TradeService-portlet",mockBeanLocator);
		PortalBeanLocatorUtil.setBeanLocator(mockBeanLocator);
	}
	
	@Test
	public void localeTest() throws PortalException, SystemException, ParseException{
		//Get our biz logic classes
		TradeLocalService mockTradeLocalService = new TradeLocalServiceImpl();
		
		
		when(mockBeanLocator.locate("com.currencyfair.service.TradeLocalService")).thenReturn(mockTradeLocalService);

		//Existing locale
		String result = TradeLocalServiceUtil.getLocaleCoordinates("FR");
		assertEquals("46.0000:2.0000", result);
		
		//Fake locale
		result = TradeLocalServiceUtil.getLocaleCoordinates("99");
		assertNull(result);
	}
	
	
}
