package com.currencyfair.service.base;

import com.currencyfair.service.TradeLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TradeLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName34;
    private String[] _methodParameterTypes34;
    private String _methodName35;
    private String[] _methodParameterTypes35;
    private String _methodName40;
    private String[] _methodParameterTypes40;
    private String _methodName41;
    private String[] _methodParameterTypes41;
    private String _methodName42;
    private String[] _methodParameterTypes42;

    public TradeLocalServiceClpInvoker() {
        _methodName0 = "addTrade";

        _methodParameterTypes0 = new String[] { "com.currencyfair.model.Trade" };

        _methodName1 = "createTrade";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteTrade";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteTrade";

        _methodParameterTypes3 = new String[] { "com.currencyfair.model.Trade" };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchTrade";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getTrade";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getTrades";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getTradesCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateTrade";

        _methodParameterTypes15 = new String[] { "com.currencyfair.model.Trade" };

        _methodName34 = "getBeanIdentifier";

        _methodParameterTypes34 = new String[] {  };

        _methodName35 = "setBeanIdentifier";

        _methodParameterTypes35 = new String[] { "java.lang.String" };

        _methodName40 = "findByUserId";

        _methodParameterTypes40 = new String[] { "long" };

        _methodName41 = "updateTrade";

        _methodParameterTypes41 = new String[] { "com.currencyfair.model.Trade" };

        _methodName42 = "getLocaleCoordinates";

        _methodParameterTypes42 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return TradeLocalServiceUtil.addTrade((com.currencyfair.model.Trade) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return TradeLocalServiceUtil.createTrade(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return TradeLocalServiceUtil.deleteTrade(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return TradeLocalServiceUtil.deleteTrade((com.currencyfair.model.Trade) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return TradeLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return TradeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return TradeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return TradeLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return TradeLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return TradeLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return TradeLocalServiceUtil.fetchTrade(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return TradeLocalServiceUtil.getTrade(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return TradeLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return TradeLocalServiceUtil.getTrades(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return TradeLocalServiceUtil.getTradesCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return TradeLocalServiceUtil.updateTrade((com.currencyfair.model.Trade) arguments[0]);
        }

        if (_methodName34.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
            return TradeLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName35.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
            TradeLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName40.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
            return TradeLocalServiceUtil.findByUserId(((Long) arguments[0]).longValue());
        }

        if (_methodName41.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
            return TradeLocalServiceUtil.updateTrade((com.currencyfair.model.Trade) arguments[0]);
        }

        if (_methodName42.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
            return TradeLocalServiceUtil.getLocaleCoordinates((java.lang.String) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
