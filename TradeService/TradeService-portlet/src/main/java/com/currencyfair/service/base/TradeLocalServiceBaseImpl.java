package com.currencyfair.service.base;

import com.currencyfair.model.Trade;

import com.currencyfair.service.TradeLocalService;
import com.currencyfair.service.persistence.TradePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the trade local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.currencyfair.service.impl.TradeLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.currencyfair.service.impl.TradeLocalServiceImpl
 * @see com.currencyfair.service.TradeLocalServiceUtil
 * @generated
 */
public abstract class TradeLocalServiceBaseImpl extends BaseLocalServiceImpl
    implements TradeLocalService, IdentifiableBean {
    @BeanReference(type = com.currencyfair.service.TradeLocalService.class)
    protected com.currencyfair.service.TradeLocalService tradeLocalService;
    @BeanReference(type = com.currencyfair.service.TradeService.class)
    protected com.currencyfair.service.TradeService tradeService;
    @BeanReference(type = TradePersistence.class)
    protected TradePersistence tradePersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private TradeLocalServiceClpInvoker _clpInvoker = new TradeLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.currencyfair.service.TradeLocalServiceUtil} to access the trade local service.
     */

    /**
     * Adds the trade to the database. Also notifies the appropriate model listeners.
     *
     * @param trade the trade
     * @return the trade that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Trade addTrade(Trade trade) throws SystemException {
        trade.setNew(true);

        return tradePersistence.update(trade);
    }

    /**
     * Creates a new trade with the primary key. Does not add the trade to the database.
     *
     * @param tradeId the primary key for the new trade
     * @return the new trade
     */
    @Override
    public Trade createTrade(long tradeId) {
        return tradePersistence.create(tradeId);
    }

    /**
     * Deletes the trade with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param tradeId the primary key of the trade
     * @return the trade that was removed
     * @throws PortalException if a trade with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Trade deleteTrade(long tradeId)
        throws PortalException, SystemException {
        return tradePersistence.remove(tradeId);
    }

    /**
     * Deletes the trade from the database. Also notifies the appropriate model listeners.
     *
     * @param trade the trade
     * @return the trade that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Trade deleteTrade(Trade trade) throws SystemException {
        return tradePersistence.remove(trade);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(Trade.class,
            clazz.getClassLoader());
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
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return tradePersistence.findWithDynamicQuery(dynamicQuery);
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
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return tradePersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return tradePersistence.findWithDynamicQuery(dynamicQuery, start, end,
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
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return tradePersistence.countWithDynamicQuery(dynamicQuery);
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
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return tradePersistence.countWithDynamicQuery(dynamicQuery, projection);
    }

    @Override
    public Trade fetchTrade(long tradeId) throws SystemException {
        return tradePersistence.fetchByPrimaryKey(tradeId);
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
    public Trade getTrade(long tradeId) throws PortalException, SystemException {
        return tradePersistence.findByPrimaryKey(tradeId);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return tradePersistence.findByPrimaryKey(primaryKeyObj);
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
    public List<Trade> getTrades(int start, int end) throws SystemException {
        return tradePersistence.findAll(start, end);
    }

    /**
     * Returns the number of trades.
     *
     * @return the number of trades
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getTradesCount() throws SystemException {
        return tradePersistence.countAll();
    }

    /**
     * Updates the trade in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param trade the trade
     * @return the trade that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Trade updateTrade(Trade trade) throws SystemException {
        return tradePersistence.update(trade);
    }

    /**
     * Returns the trade local service.
     *
     * @return the trade local service
     */
    public com.currencyfair.service.TradeLocalService getTradeLocalService() {
        return tradeLocalService;
    }

    /**
     * Sets the trade local service.
     *
     * @param tradeLocalService the trade local service
     */
    public void setTradeLocalService(
        com.currencyfair.service.TradeLocalService tradeLocalService) {
        this.tradeLocalService = tradeLocalService;
    }

    /**
     * Returns the trade remote service.
     *
     * @return the trade remote service
     */
    public com.currencyfair.service.TradeService getTradeService() {
        return tradeService;
    }

    /**
     * Sets the trade remote service.
     *
     * @param tradeService the trade remote service
     */
    public void setTradeService(
        com.currencyfair.service.TradeService tradeService) {
        this.tradeService = tradeService;
    }

    /**
     * Returns the trade persistence.
     *
     * @return the trade persistence
     */
    public TradePersistence getTradePersistence() {
        return tradePersistence;
    }

    /**
     * Sets the trade persistence.
     *
     * @param tradePersistence the trade persistence
     */
    public void setTradePersistence(TradePersistence tradePersistence) {
        this.tradePersistence = tradePersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();

        PersistedModelLocalServiceRegistryUtil.register("com.currencyfair.model.Trade",
            tradeLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "com.currencyfair.model.Trade");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return Trade.class;
    }

    protected String getModelClassName() {
        return Trade.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = tradePersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
