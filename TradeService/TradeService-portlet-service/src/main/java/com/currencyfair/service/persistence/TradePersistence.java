package com.currencyfair.service.persistence;

import com.currencyfair.model.Trade;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the trade service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TradePersistenceImpl
 * @see TradeUtil
 * @generated
 */
public interface TradePersistence extends BasePersistence<Trade> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link TradeUtil} to access the trade persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the trades where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching trades
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.currencyfair.model.Trade> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.currencyfair.model.Trade> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.currencyfair.model.Trade> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first trade in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching trade
    * @throws com.currencyfair.NoSuchTradeException if a matching trade could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.currencyfair.model.Trade findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.currencyfair.NoSuchTradeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first trade in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching trade, or <code>null</code> if a matching trade could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.currencyfair.model.Trade fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last trade in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching trade
    * @throws com.currencyfair.NoSuchTradeException if a matching trade could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.currencyfair.model.Trade findByUuid_Last(java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.currencyfair.NoSuchTradeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last trade in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching trade, or <code>null</code> if a matching trade could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.currencyfair.model.Trade fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.currencyfair.model.Trade[] findByUuid_PrevAndNext(long tradeId,
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.currencyfair.NoSuchTradeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the trades where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of trades where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching trades
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the trades where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching trades
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.currencyfair.model.Trade> findByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.currencyfair.model.Trade> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.currencyfair.model.Trade> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first trade in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching trade
    * @throws com.currencyfair.NoSuchTradeException if a matching trade could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.currencyfair.model.Trade findByUserId_First(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.currencyfair.NoSuchTradeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first trade in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching trade, or <code>null</code> if a matching trade could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.currencyfair.model.Trade fetchByUserId_First(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last trade in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching trade
    * @throws com.currencyfair.NoSuchTradeException if a matching trade could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.currencyfair.model.Trade findByUserId_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.currencyfair.NoSuchTradeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last trade in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching trade, or <code>null</code> if a matching trade could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.currencyfair.model.Trade fetchByUserId_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.currencyfair.model.Trade[] findByUserId_PrevAndNext(
        long tradeId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.currencyfair.NoSuchTradeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the trades where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of trades where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching trades
    * @throws SystemException if a system exception occurred
    */
    public int countByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the trade in the entity cache if it is enabled.
    *
    * @param trade the trade
    */
    public void cacheResult(com.currencyfair.model.Trade trade);

    /**
    * Caches the trades in the entity cache if it is enabled.
    *
    * @param trades the trades
    */
    public void cacheResult(java.util.List<com.currencyfair.model.Trade> trades);

    /**
    * Creates a new trade with the primary key. Does not add the trade to the database.
    *
    * @param tradeId the primary key for the new trade
    * @return the new trade
    */
    public com.currencyfair.model.Trade create(long tradeId);

    /**
    * Removes the trade with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param tradeId the primary key of the trade
    * @return the trade that was removed
    * @throws com.currencyfair.NoSuchTradeException if a trade with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.currencyfair.model.Trade remove(long tradeId)
        throws com.currencyfair.NoSuchTradeException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.currencyfair.model.Trade updateImpl(
        com.currencyfair.model.Trade trade)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the trade with the primary key or throws a {@link com.currencyfair.NoSuchTradeException} if it could not be found.
    *
    * @param tradeId the primary key of the trade
    * @return the trade
    * @throws com.currencyfair.NoSuchTradeException if a trade with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.currencyfair.model.Trade findByPrimaryKey(long tradeId)
        throws com.currencyfair.NoSuchTradeException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the trade with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param tradeId the primary key of the trade
    * @return the trade, or <code>null</code> if a trade with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.currencyfair.model.Trade fetchByPrimaryKey(long tradeId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the trades.
    *
    * @return the trades
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.currencyfair.model.Trade> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.currencyfair.model.Trade> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.currencyfair.model.Trade> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the trades from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of trades.
    *
    * @return the number of trades
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
