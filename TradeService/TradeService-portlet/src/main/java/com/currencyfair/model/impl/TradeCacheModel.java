package com.currencyfair.model.impl;

import com.currencyfair.model.Trade;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Trade in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Trade
 * @generated
 */
public class TradeCacheModel implements CacheModel<Trade>, Externalizable {
    public String uuid;
    public long tradeId;
    public long userId;
    public String currencyFrom;
    public String currencyTo;
    public double amountSell;
    public double amountBuy;
    public double rate;
    public long timePlaced;
    public String originatingCountry;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", tradeId=");
        sb.append(tradeId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", currencyFrom=");
        sb.append(currencyFrom);
        sb.append(", currencyTo=");
        sb.append(currencyTo);
        sb.append(", amountSell=");
        sb.append(amountSell);
        sb.append(", amountBuy=");
        sb.append(amountBuy);
        sb.append(", rate=");
        sb.append(rate);
        sb.append(", timePlaced=");
        sb.append(timePlaced);
        sb.append(", originatingCountry=");
        sb.append(originatingCountry);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Trade toEntityModel() {
        TradeImpl tradeImpl = new TradeImpl();

        if (uuid == null) {
            tradeImpl.setUuid(StringPool.BLANK);
        } else {
            tradeImpl.setUuid(uuid);
        }

        tradeImpl.setTradeId(tradeId);
        tradeImpl.setUserId(userId);

        if (currencyFrom == null) {
            tradeImpl.setCurrencyFrom(StringPool.BLANK);
        } else {
            tradeImpl.setCurrencyFrom(currencyFrom);
        }

        if (currencyTo == null) {
            tradeImpl.setCurrencyTo(StringPool.BLANK);
        } else {
            tradeImpl.setCurrencyTo(currencyTo);
        }

        tradeImpl.setAmountSell(amountSell);
        tradeImpl.setAmountBuy(amountBuy);
        tradeImpl.setRate(rate);

        if (timePlaced == Long.MIN_VALUE) {
            tradeImpl.setTimePlaced(null);
        } else {
            tradeImpl.setTimePlaced(new Date(timePlaced));
        }

        if (originatingCountry == null) {
            tradeImpl.setOriginatingCountry(StringPool.BLANK);
        } else {
            tradeImpl.setOriginatingCountry(originatingCountry);
        }

        tradeImpl.resetOriginalValues();

        return tradeImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        tradeId = objectInput.readLong();
        userId = objectInput.readLong();
        currencyFrom = objectInput.readUTF();
        currencyTo = objectInput.readUTF();
        amountSell = objectInput.readDouble();
        amountBuy = objectInput.readDouble();
        rate = objectInput.readDouble();
        timePlaced = objectInput.readLong();
        originatingCountry = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(tradeId);
        objectOutput.writeLong(userId);

        if (currencyFrom == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(currencyFrom);
        }

        if (currencyTo == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(currencyTo);
        }

        objectOutput.writeDouble(amountSell);
        objectOutput.writeDouble(amountBuy);
        objectOutput.writeDouble(rate);
        objectOutput.writeLong(timePlaced);

        if (originatingCountry == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(originatingCountry);
        }
    }
}
