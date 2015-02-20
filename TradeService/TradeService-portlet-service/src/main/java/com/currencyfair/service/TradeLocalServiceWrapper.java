package com.currencyfair.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TradeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TradeLocalService
 * @generated
 */
public class TradeLocalServiceWrapper implements TradeLocalService,
    ServiceWrapper<TradeLocalService> {
    private TradeLocalService _tradeLocalService;

    public TradeLocalServiceWrapper(TradeLocalService tradeLocalService) {
        _tradeLocalService = tradeLocalService;
    }

    /**
    * Adds the trade to the database. Also notifies the appropriate model listeners.
    *
    * @param trade the trade
    * @return the trade that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.currencyfair.model.Trade addTrade(
        com.currencyfair.model.Trade trade)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tradeLocalService.addTrade(trade);
    }

    /**
    * Creates a new trade with the primary key. Does not add the trade to the database.
    *
    * @param tradeId the primary key for the new trade
    * @return the new trade
    */
    @Override
    public com.currencyfair.model.Trade createTrade(long tradeId) {
        return _tradeLocalService.createTrade(tradeId);
    }

    /**
    * Deletes the trade with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param tradeId the primary key of the trade
    * @return the trade that was removed
    * @throws PortalException if a trade with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.currencyfair.model.Trade deleteTrade(long tradeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _tradeLocalService.deleteTrade(tradeId);
    }

    /**
    * Deletes the trade from the database. Also notifies the appropriate model listeners.
    *
    * @param trade the trade
    * @return the trade that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.currencyfair.model.Trade deleteTrade(
        com.currencyfair.model.Trade trade)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tradeLocalService.deleteTrade(trade);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _tradeLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tradeLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.currencyfair.model.impl.TradeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _tradeLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.currencyfair.model.impl.TradeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tradeLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tradeLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tradeLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.currencyfair.model.Trade fetchTrade(long tradeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tradeLocalService.fetchTrade(tradeId);
    }

    /**
    * Returns the trade with the primary key.
    *
    * @param tradeId the primary key of the trade
    * @return the trade
    * @throws PortalException if a trade with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.currencyfair.model.Trade getTrade(long tradeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _tradeLocalService.getTrade(tradeId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _tradeLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the trades.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.currencyfair.model.impl.TradeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of trades
    * @param end the upper bound of the range of trades (not inclusive)
    * @return the range of trades
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.currencyfair.model.Trade> getTrades(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _tradeLocalService.getTrades(start, end);
    }

    /**
    * Returns the number of trades.
    *
    * @return the number of trades
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getTradesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tradeLocalService.getTradesCount();
    }

    /**
    * Updates the trade in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param trade the trade
    * @return the trade that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.currencyfair.model.Trade updateTrade(
        com.currencyfair.model.Trade trade)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tradeLocalService.updateTrade(trade);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _tradeLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _tradeLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _tradeLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Finds all trades for a given user
    */
    @Override
    public java.util.List<com.currencyfair.model.Trade> findByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return _tradeLocalService.findByUserId(userId);
    }

    /**
    * Takes a locale code and returns a ":" delimited set of geo coordinates
    *
    * @param locale - 2 letter country code
    * @return Geo coordinates
    */
    @Override
    public java.lang.String getLocaleCoordinates(java.lang.String locale) {
        return _tradeLocalService.getLocaleCoordinates(locale);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public TradeLocalService getWrappedTradeLocalService() {
        return _tradeLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedTradeLocalService(TradeLocalService tradeLocalService) {
        _tradeLocalService = tradeLocalService;
    }

    @Override
    public TradeLocalService getWrappedService() {
        return _tradeLocalService;
    }

    @Override
    public void setWrappedService(TradeLocalService tradeLocalService) {
        _tradeLocalService = tradeLocalService;
    }
}
