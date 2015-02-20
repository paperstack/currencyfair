package com.currencyfair.service.base;

import com.currencyfair.service.TradeServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TradeServiceClpInvoker {
    private String _methodName18;
    private String[] _methodParameterTypes18;
    private String _methodName19;
    private String[] _methodParameterTypes19;
    private String _methodName24;
    private String[] _methodParameterTypes24;
    private String _methodName25;
    private String[] _methodParameterTypes25;

    public TradeServiceClpInvoker() {
        _methodName18 = "getBeanIdentifier";

        _methodParameterTypes18 = new String[] {  };

        _methodName19 = "setBeanIdentifier";

        _methodParameterTypes19 = new String[] { "java.lang.String" };

        _methodName24 = "addTrade";

        _methodParameterTypes24 = new String[] { "java.lang.String" };

        _methodName25 = "createTradeFromJSON";

        _methodParameterTypes25 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName18.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
            return TradeServiceUtil.getBeanIdentifier();
        }

        if (_methodName19.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
            TradeServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName24.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
            return TradeServiceUtil.addTrade((java.lang.String) arguments[0]);
        }

        if (_methodName25.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
            return TradeServiceUtil.createTradeFromJSON((java.lang.String) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
