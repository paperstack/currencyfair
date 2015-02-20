package com.currencyfair.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for Trade. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TradeServiceUtil
 * @see com.currencyfair.service.base.TradeServiceBaseImpl
 * @see com.currencyfair.service.impl.TradeServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface TradeService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link TradeServiceUtil} to access the trade remote service. Add custom service methods to {@link com.currencyfair.service.impl.TradeServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    /**
    * Adds a trade to the system given a JSON string representing the trade data
    *
    * @param json Trade information in JSON format
    * @result The newly created trade
    */
    public com.currencyfair.model.Trade addTrade(java.lang.String json)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.text.ParseException;

    /**
    * Creates an empty Trade object and populates w/ the provided data
    *
    * @param json Trade data in JSON format
    * @return Trade object w/ populated data
    */
    public com.currencyfair.model.Trade createTradeFromJSON(
        java.lang.String json)
        throws com.liferay.portal.kernel.json.JSONException,
            java.text.ParseException;
}
