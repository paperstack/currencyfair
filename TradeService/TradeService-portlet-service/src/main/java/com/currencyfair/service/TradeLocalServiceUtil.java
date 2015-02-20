package com.currencyfair.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Trade. This utility wraps
 * {@link com.currencyfair.service.impl.TradeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TradeLocalService
 * @see com.currencyfair.service.base.TradeLocalServiceBaseImpl
 * @see com.currencyfair.service.impl.TradeLocalServiceImpl
 * @generated
 */
public class TradeLocalServiceUtil {
    private static TradeLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.currencyfair.service.impl.TradeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the trade to the database. Also notifies the appropriate model listeners.
    *
    * @param trade the trade
    * @return the trade that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.currencyfair.model.Trade addTrade(
        com.currencyfair.model.Trade trade)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addTrade(trade);
    }

    /**
    * Creates a new trade with the primary key. Does not add the trade to the database.
    *
    * @param tradeId the primary key for the new trade
    * @return the new trade
    */
    public static com.currencyfair.model.Trade createTrade(long tradeId) {
        return getService().createTrade(tradeId);
    }

    /**
    * Deletes the trade with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param tradeId the primary key of the trade
    * @return the trade that was removed
    * @throws PortalException if a trade with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.currencyfair.model.Trade deleteTrade(long tradeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteTrade(tradeId);
    }

    /**
    * Deletes the trade from the database. Also notifies the appropriate model listeners.
    *
    * @param trade the trade
    * @return the trade that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.currencyfair.model.Trade deleteTrade(
        com.currencyfair.model.Trade trade)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteTrade(trade);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.currencyfair.model.Trade fetchTrade(long tradeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchTrade(tradeId);
    }

    /**
    * Returns the trade with the primary key.
    *
    * @param tradeId the primary key of the trade
    * @return the trade
    * @throws PortalException if a trade with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.currencyfair.model.Trade getTrade(long tradeId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getTrade(tradeId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.currencyfair.model.Trade> getTrades(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getTrades(start, end);
    }

    /**
    * Returns the number of trades.
    *
    * @return the number of trades
    * @throws SystemException if a system exception occurred
    */
    public static int getTradesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getTradesCount();
    }

    /**
    * Updates the trade in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param trade the trade
    * @return the trade that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.currencyfair.model.Trade updateTrade(
        com.currencyfair.model.Trade trade)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateTrade(trade);
    }

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
    * Finds all trades for a given user
    */
    public static java.util.List<com.currencyfair.model.Trade> findByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByUserId(userId);
    }

    /**
    * Takes a locale code and returns a ":" delimited set of geo coordinates
    *
    * @param locale - 2 letter country code
    * @return Geo coordinates
    */
    public static java.lang.String getLocaleCoordinates(java.lang.String locale) {
        return getService().getLocaleCoordinates(locale);
    }

    public static void clearService() {
        _service = null;
    }

    public static TradeLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    TradeLocalService.class.getName());

            if (invokableLocalService instanceof TradeLocalService) {
                _service = (TradeLocalService) invokableLocalService;
            } else {
                _service = new TradeLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(TradeLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(TradeLocalService service) {
    }
}
