package com.currencyfair.service.persistence;

import com.currencyfair.model.Trade;

import com.currencyfair.service.TradeLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class TradeActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public TradeActionableDynamicQuery() throws SystemException {
        setBaseLocalService(TradeLocalServiceUtil.getService());
        setClass(Trade.class);

        setClassLoader(com.currencyfair.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("tradeId");
    }
}
