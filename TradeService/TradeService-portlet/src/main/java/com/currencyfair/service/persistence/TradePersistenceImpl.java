package com.currencyfair.service.persistence;

import com.currencyfair.NoSuchTradeException;

import com.currencyfair.model.Trade;
import com.currencyfair.model.impl.TradeImpl;
import com.currencyfair.model.impl.TradeModelImpl;

import com.currencyfair.service.persistence.TradePersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the trade service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TradePersistence
 * @see TradeUtil
 * @generated
 */
public class TradePersistenceImpl extends BasePersistenceImpl<Trade>
    implements TradePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link TradeUtil} to access the trade persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = TradeImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TradeModelImpl.ENTITY_CACHE_ENABLED,
            TradeModelImpl.FINDER_CACHE_ENABLED, TradeImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TradeModelImpl.ENTITY_CACHE_ENABLED,
            TradeModelImpl.FINDER_CACHE_ENABLED, TradeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TradeModelImpl.ENTITY_CACHE_ENABLED,
            TradeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(TradeModelImpl.ENTITY_CACHE_ENABLED,
            TradeModelImpl.FINDER_CACHE_ENABLED, TradeImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(TradeModelImpl.ENTITY_CACHE_ENABLED,
            TradeModelImpl.FINDER_CACHE_ENABLED, TradeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            TradeModelImpl.UUID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(TradeModelImpl.ENTITY_CACHE_ENABLED,
            TradeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "trade.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "trade.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(trade.uuid IS NULL OR trade.uuid = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(TradeModelImpl.ENTITY_CACHE_ENABLED,
            TradeModelImpl.FINDER_CACHE_ENABLED, TradeImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
        new FinderPath(TradeModelImpl.ENTITY_CACHE_ENABLED,
            TradeModelImpl.FINDER_CACHE_ENABLED, TradeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
            new String[] { Long.class.getName() },
            TradeModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(TradeModelImpl.ENTITY_CACHE_ENABLED,
            TradeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_USERID_USERID_2 = "trade.userId = ?";
    private static final String _SQL_SELECT_TRADE = "SELECT trade FROM Trade trade";
    private static final String _SQL_SELECT_TRADE_WHERE = "SELECT trade FROM Trade trade WHERE ";
    private static final String _SQL_COUNT_TRADE = "SELECT COUNT(trade) FROM Trade trade";
    private static final String _SQL_COUNT_TRADE_WHERE = "SELECT COUNT(trade) FROM Trade trade WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "trade.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Trade exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Trade exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(TradePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static Trade _nullTrade = new TradeImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Trade> toCacheModel() {
                return _nullTradeCacheModel;
            }
        };

    private static CacheModel<Trade> _nullTradeCacheModel = new CacheModel<Trade>() {
            @Override
            public Trade toEntityModel() {
                return _nullTrade;
            }
        };

    public TradePersistenceImpl() {
        setModelClass(Trade.class);
    }

    /**
     * Returns all the trades where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching trades
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Trade> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Trade> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
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
    @Override
    public List<Trade> findByUuid(String uuid, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid, start, end, orderByComparator };
        }

        List<Trade> list = (List<Trade>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Trade trade : list) {
                if (!Validator.equals(uuid, trade.getUuid())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_TRADE_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(TradeModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                if (!pagination) {
                    list = (List<Trade>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Trade>(list);
                } else {
                    list = (List<Trade>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Trade findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchTradeException, SystemException {
        Trade trade = fetchByUuid_First(uuid, orderByComparator);

        if (trade != null) {
            return trade;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTradeException(msg.toString());
    }

    /**
     * Returns the first trade in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching trade, or <code>null</code> if a matching trade could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Trade fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Trade> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Trade findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchTradeException, SystemException {
        Trade trade = fetchByUuid_Last(uuid, orderByComparator);

        if (trade != null) {
            return trade;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTradeException(msg.toString());
    }

    /**
     * Returns the last trade in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching trade, or <code>null</code> if a matching trade could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Trade fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Trade> list = findByUuid(uuid, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Trade[] findByUuid_PrevAndNext(long tradeId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchTradeException, SystemException {
        Trade trade = findByPrimaryKey(tradeId);

        Session session = null;

        try {
            session = openSession();

            Trade[] array = new TradeImpl[3];

            array[0] = getByUuid_PrevAndNext(session, trade, uuid,
                    orderByComparator, true);

            array[1] = trade;

            array[2] = getByUuid_PrevAndNext(session, trade, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Trade getByUuid_PrevAndNext(Session session, Trade trade,
        String uuid, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_TRADE_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_UUID_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(TradeModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(trade);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Trade> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the trades where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Trade trade : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(trade);
        }
    }

    /**
     * Returns the number of trades where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching trades
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid(String uuid) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_TRADE_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the trades where userId = &#63;.
     *
     * @param userId the user ID
     * @return the matching trades
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Trade> findByUserId(long userId) throws SystemException {
        return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Trade> findByUserId(long userId, int start, int end)
        throws SystemException {
        return findByUserId(userId, start, end, null);
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
    @Override
    public List<Trade> findByUserId(long userId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
            finderArgs = new Object[] { userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
            finderArgs = new Object[] { userId, start, end, orderByComparator };
        }

        List<Trade> list = (List<Trade>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Trade trade : list) {
                if ((userId != trade.getUserId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_TRADE_WHERE);

            query.append(_FINDER_COLUMN_USERID_USERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(TradeModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (!pagination) {
                    list = (List<Trade>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Trade>(list);
                } else {
                    list = (List<Trade>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Trade findByUserId_First(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchTradeException, SystemException {
        Trade trade = fetchByUserId_First(userId, orderByComparator);

        if (trade != null) {
            return trade;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTradeException(msg.toString());
    }

    /**
     * Returns the first trade in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching trade, or <code>null</code> if a matching trade could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Trade fetchByUserId_First(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Trade> list = findByUserId(userId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Trade findByUserId_Last(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchTradeException, SystemException {
        Trade trade = fetchByUserId_Last(userId, orderByComparator);

        if (trade != null) {
            return trade;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTradeException(msg.toString());
    }

    /**
     * Returns the last trade in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching trade, or <code>null</code> if a matching trade could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Trade fetchByUserId_Last(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUserId(userId);

        if (count == 0) {
            return null;
        }

        List<Trade> list = findByUserId(userId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Trade[] findByUserId_PrevAndNext(long tradeId, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchTradeException, SystemException {
        Trade trade = findByPrimaryKey(tradeId);

        Session session = null;

        try {
            session = openSession();

            Trade[] array = new TradeImpl[3];

            array[0] = getByUserId_PrevAndNext(session, trade, userId,
                    orderByComparator, true);

            array[1] = trade;

            array[2] = getByUserId_PrevAndNext(session, trade, userId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Trade getByUserId_PrevAndNext(Session session, Trade trade,
        long userId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_TRADE_WHERE);

        query.append(_FINDER_COLUMN_USERID_USERID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(TradeModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(trade);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Trade> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the trades where userId = &#63; from the database.
     *
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUserId(long userId) throws SystemException {
        for (Trade trade : findByUserId(userId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(trade);
        }
    }

    /**
     * Returns the number of trades where userId = &#63;.
     *
     * @param userId the user ID
     * @return the number of matching trades
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUserId(long userId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

        Object[] finderArgs = new Object[] { userId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_TRADE_WHERE);

            query.append(_FINDER_COLUMN_USERID_USERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the trade in the entity cache if it is enabled.
     *
     * @param trade the trade
     */
    @Override
    public void cacheResult(Trade trade) {
        EntityCacheUtil.putResult(TradeModelImpl.ENTITY_CACHE_ENABLED,
            TradeImpl.class, trade.getPrimaryKey(), trade);

        trade.resetOriginalValues();
    }

    /**
     * Caches the trades in the entity cache if it is enabled.
     *
     * @param trades the trades
     */
    @Override
    public void cacheResult(List<Trade> trades) {
        for (Trade trade : trades) {
            if (EntityCacheUtil.getResult(TradeModelImpl.ENTITY_CACHE_ENABLED,
                        TradeImpl.class, trade.getPrimaryKey()) == null) {
                cacheResult(trade);
            } else {
                trade.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all trades.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(TradeImpl.class.getName());
        }

        EntityCacheUtil.clearCache(TradeImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the trade.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Trade trade) {
        EntityCacheUtil.removeResult(TradeModelImpl.ENTITY_CACHE_ENABLED,
            TradeImpl.class, trade.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Trade> trades) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Trade trade : trades) {
            EntityCacheUtil.removeResult(TradeModelImpl.ENTITY_CACHE_ENABLED,
                TradeImpl.class, trade.getPrimaryKey());
        }
    }

    /**
     * Creates a new trade with the primary key. Does not add the trade to the database.
     *
     * @param tradeId the primary key for the new trade
     * @return the new trade
     */
    @Override
    public Trade create(long tradeId) {
        Trade trade = new TradeImpl();

        trade.setNew(true);
        trade.setPrimaryKey(tradeId);

        String uuid = PortalUUIDUtil.generate();

        trade.setUuid(uuid);

        return trade;
    }

    /**
     * Removes the trade with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param tradeId the primary key of the trade
     * @return the trade that was removed
     * @throws com.currencyfair.NoSuchTradeException if a trade with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Trade remove(long tradeId)
        throws NoSuchTradeException, SystemException {
        return remove((Serializable) tradeId);
    }

    /**
     * Removes the trade with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the trade
     * @return the trade that was removed
     * @throws com.currencyfair.NoSuchTradeException if a trade with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Trade remove(Serializable primaryKey)
        throws NoSuchTradeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Trade trade = (Trade) session.get(TradeImpl.class, primaryKey);

            if (trade == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchTradeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(trade);
        } catch (NoSuchTradeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Trade removeImpl(Trade trade) throws SystemException {
        trade = toUnwrappedModel(trade);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(trade)) {
                trade = (Trade) session.get(TradeImpl.class,
                        trade.getPrimaryKeyObj());
            }

            if (trade != null) {
                session.delete(trade);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (trade != null) {
            clearCache(trade);
        }

        return trade;
    }

    @Override
    public Trade updateImpl(com.currencyfair.model.Trade trade)
        throws SystemException {
        trade = toUnwrappedModel(trade);

        boolean isNew = trade.isNew();

        TradeModelImpl tradeModelImpl = (TradeModelImpl) trade;

        if (Validator.isNull(trade.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            trade.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (trade.isNew()) {
                session.save(trade);

                trade.setNew(false);
            } else {
                session.merge(trade);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !TradeModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((tradeModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { tradeModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { tradeModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((tradeModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { tradeModelImpl.getOriginalUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);

                args = new Object[] { tradeModelImpl.getUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);
            }
        }

        EntityCacheUtil.putResult(TradeModelImpl.ENTITY_CACHE_ENABLED,
            TradeImpl.class, trade.getPrimaryKey(), trade);

        return trade;
    }

    protected Trade toUnwrappedModel(Trade trade) {
        if (trade instanceof TradeImpl) {
            return trade;
        }

        TradeImpl tradeImpl = new TradeImpl();

        tradeImpl.setNew(trade.isNew());
        tradeImpl.setPrimaryKey(trade.getPrimaryKey());

        tradeImpl.setUuid(trade.getUuid());
        tradeImpl.setTradeId(trade.getTradeId());
        tradeImpl.setUserId(trade.getUserId());
        tradeImpl.setCurrencyFrom(trade.getCurrencyFrom());
        tradeImpl.setCurrencyTo(trade.getCurrencyTo());
        tradeImpl.setAmountSell(trade.getAmountSell());
        tradeImpl.setAmountBuy(trade.getAmountBuy());
        tradeImpl.setRate(trade.getRate());
        tradeImpl.setTimePlaced(trade.getTimePlaced());
        tradeImpl.setOriginatingCountry(trade.getOriginatingCountry());

        return tradeImpl;
    }

    /**
     * Returns the trade with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the trade
     * @return the trade
     * @throws com.currencyfair.NoSuchTradeException if a trade with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Trade findByPrimaryKey(Serializable primaryKey)
        throws NoSuchTradeException, SystemException {
        Trade trade = fetchByPrimaryKey(primaryKey);

        if (trade == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchTradeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return trade;
    }

    /**
     * Returns the trade with the primary key or throws a {@link com.currencyfair.NoSuchTradeException} if it could not be found.
     *
     * @param tradeId the primary key of the trade
     * @return the trade
     * @throws com.currencyfair.NoSuchTradeException if a trade with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Trade findByPrimaryKey(long tradeId)
        throws NoSuchTradeException, SystemException {
        return findByPrimaryKey((Serializable) tradeId);
    }

    /**
     * Returns the trade with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the trade
     * @return the trade, or <code>null</code> if a trade with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Trade fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Trade trade = (Trade) EntityCacheUtil.getResult(TradeModelImpl.ENTITY_CACHE_ENABLED,
                TradeImpl.class, primaryKey);

        if (trade == _nullTrade) {
            return null;
        }

        if (trade == null) {
            Session session = null;

            try {
                session = openSession();

                trade = (Trade) session.get(TradeImpl.class, primaryKey);

                if (trade != null) {
                    cacheResult(trade);
                } else {
                    EntityCacheUtil.putResult(TradeModelImpl.ENTITY_CACHE_ENABLED,
                        TradeImpl.class, primaryKey, _nullTrade);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(TradeModelImpl.ENTITY_CACHE_ENABLED,
                    TradeImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return trade;
    }

    /**
     * Returns the trade with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param tradeId the primary key of the trade
     * @return the trade, or <code>null</code> if a trade with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Trade fetchByPrimaryKey(long tradeId) throws SystemException {
        return fetchByPrimaryKey((Serializable) tradeId);
    }

    /**
     * Returns all the trades.
     *
     * @return the trades
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Trade> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Trade> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Trade> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Trade> list = (List<Trade>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_TRADE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_TRADE;

                if (pagination) {
                    sql = sql.concat(TradeModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Trade>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Trade>(list);
                } else {
                    list = (List<Trade>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the trades from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Trade trade : findAll()) {
            remove(trade);
        }
    }

    /**
     * Returns the number of trades.
     *
     * @return the number of trades
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_TRADE);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the trade persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.currencyfair.model.Trade")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Trade>> listenersList = new ArrayList<ModelListener<Trade>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Trade>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(TradeImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
