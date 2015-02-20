package com.currencyfair.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Trade}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Trade
 * @generated
 */
public class TradeWrapper implements Trade, ModelWrapper<Trade> {
    private Trade _trade;

    public TradeWrapper(Trade trade) {
        _trade = trade;
    }

    @Override
    public Class<?> getModelClass() {
        return Trade.class;
    }

    @Override
    public String getModelClassName() {
        return Trade.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("tradeId", getTradeId());
        attributes.put("userId", getUserId());
        attributes.put("currencyFrom", getCurrencyFrom());
        attributes.put("currencyTo", getCurrencyTo());
        attributes.put("amountSell", getAmountSell());
        attributes.put("amountBuy", getAmountBuy());
        attributes.put("rate", getRate());
        attributes.put("timePlaced", getTimePlaced());
        attributes.put("originatingCountry", getOriginatingCountry());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long tradeId = (Long) attributes.get("tradeId");

        if (tradeId != null) {
            setTradeId(tradeId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String currencyFrom = (String) attributes.get("currencyFrom");

        if (currencyFrom != null) {
            setCurrencyFrom(currencyFrom);
        }

        String currencyTo = (String) attributes.get("currencyTo");

        if (currencyTo != null) {
            setCurrencyTo(currencyTo);
        }

        Double amountSell = (Double) attributes.get("amountSell");

        if (amountSell != null) {
            setAmountSell(amountSell);
        }

        Double amountBuy = (Double) attributes.get("amountBuy");

        if (amountBuy != null) {
            setAmountBuy(amountBuy);
        }

        Double rate = (Double) attributes.get("rate");

        if (rate != null) {
            setRate(rate);
        }

        Date timePlaced = (Date) attributes.get("timePlaced");

        if (timePlaced != null) {
            setTimePlaced(timePlaced);
        }

        String originatingCountry = (String) attributes.get(
                "originatingCountry");

        if (originatingCountry != null) {
            setOriginatingCountry(originatingCountry);
        }
    }

    /**
    * Returns the primary key of this trade.
    *
    * @return the primary key of this trade
    */
    @Override
    public long getPrimaryKey() {
        return _trade.getPrimaryKey();
    }

    /**
    * Sets the primary key of this trade.
    *
    * @param primaryKey the primary key of this trade
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _trade.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this trade.
    *
    * @return the uuid of this trade
    */
    @Override
    public java.lang.String getUuid() {
        return _trade.getUuid();
    }

    /**
    * Sets the uuid of this trade.
    *
    * @param uuid the uuid of this trade
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _trade.setUuid(uuid);
    }

    /**
    * Returns the trade ID of this trade.
    *
    * @return the trade ID of this trade
    */
    @Override
    public long getTradeId() {
        return _trade.getTradeId();
    }

    /**
    * Sets the trade ID of this trade.
    *
    * @param tradeId the trade ID of this trade
    */
    @Override
    public void setTradeId(long tradeId) {
        _trade.setTradeId(tradeId);
    }

    /**
    * Returns the user ID of this trade.
    *
    * @return the user ID of this trade
    */
    @Override
    public long getUserId() {
        return _trade.getUserId();
    }

    /**
    * Sets the user ID of this trade.
    *
    * @param userId the user ID of this trade
    */
    @Override
    public void setUserId(long userId) {
        _trade.setUserId(userId);
    }

    /**
    * Returns the user uuid of this trade.
    *
    * @return the user uuid of this trade
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _trade.getUserUuid();
    }

    /**
    * Sets the user uuid of this trade.
    *
    * @param userUuid the user uuid of this trade
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _trade.setUserUuid(userUuid);
    }

    /**
    * Returns the currency from of this trade.
    *
    * @return the currency from of this trade
    */
    @Override
    public java.lang.String getCurrencyFrom() {
        return _trade.getCurrencyFrom();
    }

    /**
    * Sets the currency from of this trade.
    *
    * @param currencyFrom the currency from of this trade
    */
    @Override
    public void setCurrencyFrom(java.lang.String currencyFrom) {
        _trade.setCurrencyFrom(currencyFrom);
    }

    /**
    * Returns the currency to of this trade.
    *
    * @return the currency to of this trade
    */
    @Override
    public java.lang.String getCurrencyTo() {
        return _trade.getCurrencyTo();
    }

    /**
    * Sets the currency to of this trade.
    *
    * @param currencyTo the currency to of this trade
    */
    @Override
    public void setCurrencyTo(java.lang.String currencyTo) {
        _trade.setCurrencyTo(currencyTo);
    }

    /**
    * Returns the amount sell of this trade.
    *
    * @return the amount sell of this trade
    */
    @Override
    public double getAmountSell() {
        return _trade.getAmountSell();
    }

    /**
    * Sets the amount sell of this trade.
    *
    * @param amountSell the amount sell of this trade
    */
    @Override
    public void setAmountSell(double amountSell) {
        _trade.setAmountSell(amountSell);
    }

    /**
    * Returns the amount buy of this trade.
    *
    * @return the amount buy of this trade
    */
    @Override
    public double getAmountBuy() {
        return _trade.getAmountBuy();
    }

    /**
    * Sets the amount buy of this trade.
    *
    * @param amountBuy the amount buy of this trade
    */
    @Override
    public void setAmountBuy(double amountBuy) {
        _trade.setAmountBuy(amountBuy);
    }

    /**
    * Returns the rate of this trade.
    *
    * @return the rate of this trade
    */
    @Override
    public double getRate() {
        return _trade.getRate();
    }

    /**
    * Sets the rate of this trade.
    *
    * @param rate the rate of this trade
    */
    @Override
    public void setRate(double rate) {
        _trade.setRate(rate);
    }

    /**
    * Returns the time placed of this trade.
    *
    * @return the time placed of this trade
    */
    @Override
    public java.util.Date getTimePlaced() {
        return _trade.getTimePlaced();
    }

    /**
    * Sets the time placed of this trade.
    *
    * @param timePlaced the time placed of this trade
    */
    @Override
    public void setTimePlaced(java.util.Date timePlaced) {
        _trade.setTimePlaced(timePlaced);
    }

    /**
    * Returns the originating country of this trade.
    *
    * @return the originating country of this trade
    */
    @Override
    public java.lang.String getOriginatingCountry() {
        return _trade.getOriginatingCountry();
    }

    /**
    * Sets the originating country of this trade.
    *
    * @param originatingCountry the originating country of this trade
    */
    @Override
    public void setOriginatingCountry(java.lang.String originatingCountry) {
        _trade.setOriginatingCountry(originatingCountry);
    }

    @Override
    public boolean isNew() {
        return _trade.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _trade.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _trade.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _trade.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _trade.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _trade.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _trade.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _trade.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _trade.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _trade.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _trade.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new TradeWrapper((Trade) _trade.clone());
    }

    @Override
    public int compareTo(Trade trade) {
        return _trade.compareTo(trade);
    }

    @Override
    public int hashCode() {
        return _trade.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<Trade> toCacheModel() {
        return _trade.toCacheModel();
    }

    @Override
    public Trade toEscapedModel() {
        return new TradeWrapper(_trade.toEscapedModel());
    }

    @Override
    public Trade toUnescapedModel() {
        return new TradeWrapper(_trade.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _trade.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _trade.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _trade.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TradeWrapper)) {
            return false;
        }

        TradeWrapper tradeWrapper = (TradeWrapper) obj;

        if (Validator.equals(_trade, tradeWrapper._trade)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Trade getWrappedTrade() {
        return _trade;
    }

    @Override
    public Trade getWrappedModel() {
        return _trade;
    }

    @Override
    public void resetOriginalValues() {
        _trade.resetOriginalValues();
    }
}
