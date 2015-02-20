package com.currencyfair.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TradeService}.
 *
 * @author Brian Wing Shun Chan
 * @see TradeService
 * @generated
 */
public class TradeServiceWrapper implements TradeService,
    ServiceWrapper<TradeService> {
    private TradeService _tradeService;

    public TradeServiceWrapper(TradeService tradeService) {
        _tradeService = tradeService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _tradeService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _tradeService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _tradeService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Adds a trade to the system given a JSON string representing the trade data
    *
    * @param json Trade information in JSON format
    * @result The newly created trade
    */
    @Override
    public com.currencyfair.model.Trade addTrade(java.lang.String json)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.text.ParseException {
        return _tradeService.addTrade(json);
    }

    /**
    * Creates an empty Trade object and populates w/ the provided data
    *
    * @param json Trade data in JSON format
    * @return Trade object w/ populated data
    */
    @Override
    public com.currencyfair.model.Trade createTradeFromJSON(
        java.lang.String json)
        throws com.liferay.portal.kernel.json.JSONException,
            java.text.ParseException {
        return _tradeService.createTradeFromJSON(json);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public TradeService getWrappedTradeService() {
        return _tradeService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedTradeService(TradeService tradeService) {
        _tradeService = tradeService;
    }

    @Override
    public TradeService getWrappedService() {
        return _tradeService;
    }

    @Override
    public void setWrappedService(TradeService tradeService) {
        _tradeService = tradeService;
    }
}
