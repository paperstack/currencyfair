package com.currencyfair.service.persistence;

import com.currencyfair.model.Trade;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the trade service. This utility wraps {@link TradePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TradePersistence
 * @see TradePersistenceImpl
 * @generated
 */
public class TradeUtil {
    private static TradePersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Trade trade) {
        getPersistence().clearCache(trade);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Trade> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Trade> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Trade> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Trade update(Trade trade) throws SystemException {
        return getPersistence().update(trade);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Trade update(Trade trade, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(trade, serviceContext);
    }

    /**
    * Returns all the trades where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching trades
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.currencyfair.model.Trade> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    /**
    * Returns a range of all the trades where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.currencyfair.model.impl.TradeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of trades
    * @param end the upper bound of the range of trades (not inclusive)
    * @return the range of matching trades
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.currencyfair.model.Trade> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    /**
    * Returns an ordered range of all the trades where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.currencyfair.model.impl.TradeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of trades
    * @param end the upper bound of the range of trades (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching trades
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.currencyfair.model.Trade> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

    /**
    * Returns the first trade in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching trade
    * @throws com.currencyfair.NoSuchTradeException if a matching trade could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.currencyfair.model.Trade findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.currencyfair.NoSuchTradeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first trade in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching trade, or <code>null</code> if a matching trade could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.currencyfair.model.Trade fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the last trade in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching trade
    * @throws com.currencyfair.NoSuchTradeException if a matching trade could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.currencyfair.model.Trade findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.currencyfair.NoSuchTradeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last trade in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching trade, or <code>null</code> if a matching trade could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.currencyfair.model.Trade fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the trades before and after the current trade in the ordered set where uuid = &#63;.
    *
    * @param tradeId the primary key of the current trade
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next trade
    * @throws com.currencyfair.NoSuchTradeException if a trade with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.currencyfair.model.Trade[] findByUuid_PrevAndNext(
        long tradeId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.currencyfair.NoSuchTradeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_PrevAndNext(tradeId, uuid, orderByComparator);
    }

    /**
    * Removes all the trades where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of trades where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching trades
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Returns all the trades where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching trades
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.currencyfair.model.Trade> findByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(userId);
    }

    /**
    * Returns a range of all the trades where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.currencyfair.model.impl.TradeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of trades
    * @param end the upper bound of the range of trades (not inclusive)
    * @return the range of matching trades
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.currencyfair.model.Trade> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(userId, start, end);
    }

    /**
    * Returns an ordered range of all the trades where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.currencyfair.model.impl.TradeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of trades
    * @param end the upper bound of the range of trades (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching trades
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.currencyfair.model.Trade> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserId(userId, start, end, orderByComparator);
    }

    /**
    * Returns the first trade in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching trade
    * @throws com.currencyfair.NoSuchTradeException if a matching trade could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.currencyfair.model.Trade findByUserId_First(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.currencyfair.NoSuchTradeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the first trade in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching trade, or <code>null</code> if a matching trade could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.currencyfair.model.Trade fetchByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the last trade in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching trade
    * @throws com.currencyfair.NoSuchTradeException if a matching trade could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.currencyfair.model.Trade findByUserId_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.currencyfair.NoSuchTradeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId_Last(userId, orderByComparator);
    }

    /**
    * Returns the last trade in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching trade, or <code>null</code> if a matching trade could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.currencyfair.model.Trade fetchByUserId_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId_Last(userId, orderByComparator);
    }

    /**
    * Returns the trades before and after the current trade in the ordered set where userId = &#63;.
    *
    * @param tradeId the primary key of the current trade
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next trade
    * @throws com.currencyfair.NoSuchTradeException if a trade with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.currencyfair.model.Trade[] findByUserId_PrevAndNext(
        long tradeId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.currencyfair.NoSuchTradeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserId_PrevAndNext(tradeId, userId, orderByComparator);
    }

    /**
    * Removes all the trades where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUserId(userId);
    }

    /**
    * Returns the number of trades where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching trades
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUserId(userId);
    }

    /**
    * Caches the trade in the entity cache if it is enabled.
    *
    * @param trade the trade
    */
    public static void cacheResult(com.currencyfair.model.Trade trade) {
        getPersistence().cacheResult(trade);
    }

    /**
    * Caches the trades in the entity cache if it is enabled.
    *
    * @param trades the trades
    */
    public static void cacheResult(
        java.util.List<com.currencyfair.model.Trade> trades) {
        getPersistence().cacheResult(trades);
    }

    /**
    * Creates a new trade with the primary key. Does not add the trade to the database.
    *
    * @param tradeId the primary key for the new trade
    * @return the new trade
    */
    public static com.currencyfair.model.Trade create(long tradeId) {
        return getPersistence().create(tradeId);
    }

    /**
    * Removes the trade with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param tradeId the primary key of the trade
    * @return the trade that was removed
    * @throws com.currencyfair.NoSuchTradeException if a trade with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.currencyfair.model.Trade remove(long tradeId)
        throws com.currencyfair.NoSuchTradeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(tradeId);
    }

    public static com.currencyfair.model.Trade updateImpl(
        com.currencyfair.model.Trade trade)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(trade);
    }

    /**
    * Returns the trade with the primary key or throws a {@link com.currencyfair.NoSuchTradeException} if it could not be found.
    *
    * @param tradeId the primary key of the trade
    * @return the trade
    * @throws com.currencyfair.NoSuchTradeException if a trade with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.currencyfair.model.Trade findByPrimaryKey(long tradeId)
        throws com.currencyfair.NoSuchTradeException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(tradeId);
    }

    /**
    * Returns the trade with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param tradeId the primary key of the trade
    * @return the trade, or <code>null</code> if a trade with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.currencyfair.model.Trade fetchByPrimaryKey(long tradeId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(tradeId);
    }

    /**
    * Returns all the trades.
    *
    * @return the trades
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.currencyfair.model.Trade> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.currencyfair.model.Trade> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the trades.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.currencyfair.model.impl.TradeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of trades
    * @param end the upper bound of the range of trades (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of trades
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.currencyfair.model.Trade> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the trades from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of trades.
    *
    * @return the number of trades
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static TradePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (TradePersistence) PortletBeanLocatorUtil.locate(com.currencyfair.service.ClpSerializer.getServletContextName(),
                    TradePersistence.class.getName());

            ReferenceRegistry.registerReference(TradeUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(TradePersistence persistence) {
    }
}
