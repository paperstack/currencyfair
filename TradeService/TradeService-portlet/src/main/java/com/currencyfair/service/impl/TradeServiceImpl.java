package com.currencyfair.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.currencyfair.model.Trade;
import com.currencyfair.model.impl.TradeImpl;
import com.currencyfair.service.base.TradeServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the trade remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.currencyfair.service.TradeService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Alex Rud
 * @see com.currencyfair.service.base.TradeServiceBaseImpl
 * @see com.currencyfair.service.TradeServiceUtil
 */
public class TradeServiceImpl extends TradeServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.currencyfair.service.TradeServiceUtil} to access the trade remote service.
     */
	
	/**
	 * Adds a trade to the system given a JSON string representing the trade data
	 * @param json Trade information in JSON format
	 * @result The newly created trade
	 */
	@AccessControlled(guestAccessEnabled=true)
	public Trade addTrade(String json) throws SystemException, ParseException, PortalException{
		Company company = CompanyLocalServiceUtil.getCompanyByMx("currencyfair.com");
		
		Trade trade = createTradeFromJSON(json);
		
		//Lets check if we already have this user in the system. If not lets add them as a means of populating our user base (for demo purposes only)
		try {
			UserLocalServiceUtil.getUserByScreenName(company.getCompanyId(), String.valueOf(trade.getUserId()));
		} catch (PortalException e) {// We dont have the user so lets add 'em 
			
			String password = String.valueOf(trade.getUserId());
			String email = password + "@currencyfair.com";
			List<Role> roles = RoleLocalServiceUtil.getRoles(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			long userRoleId = 0L;
			for(Role role: roles){
				if(role.getName().equalsIgnoreCase("CFUser")){//Hard code the user role for now
					userRoleId = role.getRoleId();
				}
			}
			long[] roleIds = new long[]{userRoleId};
			long companyId = company.getCompanyId();
			
			//Create and assign arbitrary contact information
			UserLocalServiceUtil.addUser(0, companyId, false, password, password, false, password, email, 0L, StringPool.BLANK, LocaleUtil.fromLanguageId(trade.getOriginatingCountry()), "TestUser"+password, null, "TestUser"+password, 0, 0, true, 0, 1, 1980, null, new long[]{10182}, null, roleIds, null, false, null);
		}
		
		
		
		trade = tradeLocalService.addTrade(trade);
		return trade;
	}
	
	/**
	 * Creates an empty Trade object and populates w/ the provided data
	 * @param json Trade data in JSON format
	 * @return Trade object w/ populated data
	 */
	public Trade createTradeFromJSON(String json) throws JSONException, ParseException {
		Trade trade = tradeLocalService.createTrade(0);
		JSONObject o = JSONFactoryUtil.createJSONObject(json);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy HH:mm:ss");
		trade.setTimePlaced(sdf.parse(o.getString("timePlaced")));
		trade.setUserId(o.getLong("userId"));
		trade.setCurrencyFrom(o.getString("currencyFrom"));
		trade.setCurrencyTo(o.getString("currencyTo"));
		trade.setAmountSell(o.getDouble("amountSell"));
		trade.setAmountBuy(o.getDouble("amountBuy"));
		trade.setRate(o.getDouble("rate"));
		trade.setOriginatingCountry(o.getString("originatingCountry"));
		return trade;
	}
}