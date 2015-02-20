package com.currencyfair.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.currencyfair.service.http.TradeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.currencyfair.service.http.TradeServiceSoap
 * @generated
 */
public class TradeSoap implements Serializable {
    private String _uuid;
    private long _tradeId;
    private long _userId;
    private String _currencyFrom;
    private String _currencyTo;
    private double _amountSell;
    private double _amountBuy;
    private double _rate;
    private Date _timePlaced;
    private String _originatingCountry;

    public TradeSoap() {
    }

    public static TradeSoap toSoapModel(Trade model) {
        TradeSoap soapModel = new TradeSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setTradeId(model.getTradeId());
        soapModel.setUserId(model.getUserId());
        soapModel.setCurrencyFrom(model.getCurrencyFrom());
        soapModel.setCurrencyTo(model.getCurrencyTo());
        soapModel.setAmountSell(model.getAmountSell());
        soapModel.setAmountBuy(model.getAmountBuy());
        soapModel.setRate(model.getRate());
        soapModel.setTimePlaced(model.getTimePlaced());
        soapModel.setOriginatingCountry(model.getOriginatingCountry());

        return soapModel;
    }

    public static TradeSoap[] toSoapModels(Trade[] models) {
        TradeSoap[] soapModels = new TradeSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static TradeSoap[][] toSoapModels(Trade[][] models) {
        TradeSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new TradeSoap[models.length][models[0].length];
        } else {
            soapModels = new TradeSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static TradeSoap[] toSoapModels(List<Trade> models) {
        List<TradeSoap> soapModels = new ArrayList<TradeSoap>(models.size());

        for (Trade model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new TradeSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _tradeId;
    }

    public void setPrimaryKey(long pk) {
        setTradeId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getTradeId() {
        return _tradeId;
    }

    public void setTradeId(long tradeId) {
        _tradeId = tradeId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getCurrencyFrom() {
        return _currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        _currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return _currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        _currencyTo = currencyTo;
    }

    public double getAmountSell() {
        return _amountSell;
    }

    public void setAmountSell(double amountSell) {
        _amountSell = amountSell;
    }

    public double getAmountBuy() {
        return _amountBuy;
    }

    public void setAmountBuy(double amountBuy) {
        _amountBuy = amountBuy;
    }

    public double getRate() {
        return _rate;
    }

    public void setRate(double rate) {
        _rate = rate;
    }

    public Date getTimePlaced() {
        return _timePlaced;
    }

    public void setTimePlaced(Date timePlaced) {
        _timePlaced = timePlaced;
    }

    public String getOriginatingCountry() {
        return _originatingCountry;
    }

    public void setOriginatingCountry(String originatingCountry) {
        _originatingCountry = originatingCountry;
    }
}
