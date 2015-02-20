package com.currencyfair.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Trade. This utility wraps
 * {@link com.currencyfair.service.impl.TradeServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TradeService
 * @see com.currencyfair.service.base.TradeServiceBaseImpl
 * @see com.currencyfair.service.impl.TradeServiceImpl
 * @generated
 */
public class TradeServiceUtil {
    private static TradeService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.currencyfair.service.impl.TradeServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Adds a trade to the system given a JSON string representing the trade data
    *
    * @param json Trade information in JSON format
    * @result The newly created trade
    */
    public static com.currencyfair.model.Trade addTrade(java.lang.String json)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.text.ParseException {
        return getService().addTrade(json);
    }

    /**
    * Creates an empty Trade object and populates w/ the provided data
    *
    * @param json Trade data in JSON format
    * @return Trade object w/ populated data
    */
    public static com.currencyfair.model.Trade createTradeFromJSON(
        java.lang.String json)
        throws com.liferay.portal.kernel.json.JSONException,
            java.text.ParseException {
        return getService().createTradeFromJSON(json);
    }

    public static void clearService() {
        _service = null;
    }

    public static TradeService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    TradeService.class.getName());

            if (invokableService instanceof TradeService) {
                _service = (TradeService) invokableService;
            } else {
                _service = new TradeServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(TradeServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(TradeService service) {
    }
}
