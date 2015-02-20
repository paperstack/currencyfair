package com.currencyfair.model;

import com.currencyfair.service.ClpSerializer;
import com.currencyfair.service.TradeLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class TradeClp extends BaseModelImpl<Trade> implements Trade {
    private String _uuid;
    private long _tradeId;
    private long _userId;
    private String _userUuid;
    private String _currencyFrom;
    private String _currencyTo;
    private double _amountSell;
    private double _amountBuy;
    private double _rate;
    private Date _timePlaced;
    private String _originatingCountry;
    private BaseModel<?> _tradeRemoteModel;

    public TradeClp() {
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
    public long getPrimaryKey() {
        return _tradeId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setTradeId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _tradeId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_tradeRemoteModel != null) {
            try {
                Class<?> clazz = _tradeRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_tradeRemoteModel, uuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getTradeId() {
        return _tradeId;
    }

    @Override
    public void setTradeId(long tradeId) {
        _tradeId = tradeId;

        if (_tradeRemoteModel != null) {
            try {
                Class<?> clazz = _tradeRemoteModel.getClass();

                Method method = clazz.getMethod("setTradeId", long.class);

                method.invoke(_tradeRemoteModel, tradeId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_tradeRemoteModel != null) {
            try {
                Class<?> clazz = _tradeRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_tradeRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getCurrencyFrom() {
        return _currencyFrom;
    }

    @Override
    public void setCurrencyFrom(String currencyFrom) {
        _currencyFrom = currencyFrom;

        if (_tradeRemoteModel != null) {
            try {
                Class<?> clazz = _tradeRemoteModel.getClass();

                Method method = clazz.getMethod("setCurrencyFrom", String.class);

                method.invoke(_tradeRemoteModel, currencyFrom);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCurrencyTo() {
        return _currencyTo;
    }

    @Override
    public void setCurrencyTo(String currencyTo) {
        _currencyTo = currencyTo;

        if (_tradeRemoteModel != null) {
            try {
                Class<?> clazz = _tradeRemoteModel.getClass();

                Method method = clazz.getMethod("setCurrencyTo", String.class);

                method.invoke(_tradeRemoteModel, currencyTo);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getAmountSell() {
        return _amountSell;
    }

    @Override
    public void setAmountSell(double amountSell) {
        _amountSell = amountSell;

        if (_tradeRemoteModel != null) {
            try {
                Class<?> clazz = _tradeRemoteModel.getClass();

                Method method = clazz.getMethod("setAmountSell", double.class);

                method.invoke(_tradeRemoteModel, amountSell);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getAmountBuy() {
        return _amountBuy;
    }

    @Override
    public void setAmountBuy(double amountBuy) {
        _amountBuy = amountBuy;

        if (_tradeRemoteModel != null) {
            try {
                Class<?> clazz = _tradeRemoteModel.getClass();

                Method method = clazz.getMethod("setAmountBuy", double.class);

                method.invoke(_tradeRemoteModel, amountBuy);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getRate() {
        return _rate;
    }

    @Override
    public void setRate(double rate) {
        _rate = rate;

        if (_tradeRemoteModel != null) {
            try {
                Class<?> clazz = _tradeRemoteModel.getClass();

                Method method = clazz.getMethod("setRate", double.class);

                method.invoke(_tradeRemoteModel, rate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getTimePlaced() {
        return _timePlaced;
    }

    @Override
    public void setTimePlaced(Date timePlaced) {
        _timePlaced = timePlaced;

        if (_tradeRemoteModel != null) {
            try {
                Class<?> clazz = _tradeRemoteModel.getClass();

                Method method = clazz.getMethod("setTimePlaced", Date.class);

                method.invoke(_tradeRemoteModel, timePlaced);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getOriginatingCountry() {
        return _originatingCountry;
    }

    @Override
    public void setOriginatingCountry(String originatingCountry) {
        _originatingCountry = originatingCountry;

        if (_tradeRemoteModel != null) {
            try {
                Class<?> clazz = _tradeRemoteModel.getClass();

                Method method = clazz.getMethod("setOriginatingCountry",
                        String.class);

                method.invoke(_tradeRemoteModel, originatingCountry);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getTradeRemoteModel() {
        return _tradeRemoteModel;
    }

    public void setTradeRemoteModel(BaseModel<?> tradeRemoteModel) {
        _tradeRemoteModel = tradeRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _tradeRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_tradeRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            TradeLocalServiceUtil.addTrade(this);
        } else {
            TradeLocalServiceUtil.updateTrade(this);
        }
    }

    @Override
    public Trade toEscapedModel() {
        return (Trade) ProxyUtil.newProxyInstance(Trade.class.getClassLoader(),
            new Class[] { Trade.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        TradeClp clone = new TradeClp();

        clone.setUuid(getUuid());
        clone.setTradeId(getTradeId());
        clone.setUserId(getUserId());
        clone.setCurrencyFrom(getCurrencyFrom());
        clone.setCurrencyTo(getCurrencyTo());
        clone.setAmountSell(getAmountSell());
        clone.setAmountBuy(getAmountBuy());
        clone.setRate(getRate());
        clone.setTimePlaced(getTimePlaced());
        clone.setOriginatingCountry(getOriginatingCountry());

        return clone;
    }

    @Override
    public int compareTo(Trade trade) {
        int value = 0;

        if (getTradeId() < trade.getTradeId()) {
            value = -1;
        } else if (getTradeId() > trade.getTradeId()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TradeClp)) {
            return false;
        }

        TradeClp trade = (TradeClp) obj;

        long primaryKey = trade.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", tradeId=");
        sb.append(getTradeId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", currencyFrom=");
        sb.append(getCurrencyFrom());
        sb.append(", currencyTo=");
        sb.append(getCurrencyTo());
        sb.append(", amountSell=");
        sb.append(getAmountSell());
        sb.append(", amountBuy=");
        sb.append(getAmountBuy());
        sb.append(", rate=");
        sb.append(getRate());
        sb.append(", timePlaced=");
        sb.append(getTimePlaced());
        sb.append(", originatingCountry=");
        sb.append(getOriginatingCountry());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(34);

        sb.append("<model><model-name>");
        sb.append("com.currencyfair.model.Trade");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tradeId</column-name><column-value><![CDATA[");
        sb.append(getTradeId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>currencyFrom</column-name><column-value><![CDATA[");
        sb.append(getCurrencyFrom());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>currencyTo</column-name><column-value><![CDATA[");
        sb.append(getCurrencyTo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>amountSell</column-name><column-value><![CDATA[");
        sb.append(getAmountSell());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>amountBuy</column-name><column-value><![CDATA[");
        sb.append(getAmountBuy());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>rate</column-name><column-value><![CDATA[");
        sb.append(getRate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>timePlaced</column-name><column-value><![CDATA[");
        sb.append(getTimePlaced());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>originatingCountry</column-name><column-value><![CDATA[");
        sb.append(getOriginatingCountry());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
