package com.currencyfair.service.http;

import com.currencyfair.service.TradeServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.currencyfair.service.TradeServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.currencyfair.model.TradeSoap}.
 * If the method in the service utility returns a
 * {@link com.currencyfair.model.Trade}, that is translated to a
 * {@link com.currencyfair.model.TradeSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TradeServiceHttp
 * @see com.currencyfair.model.TradeSoap
 * @see com.currencyfair.service.TradeServiceUtil
 * @generated
 */
public class TradeServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(TradeServiceSoap.class);

    /**
    * Adds a trade to the system given a JSON string representing the trade data
    *
    * @param json Trade information in JSON format
    * @result The newly created trade
    */
    public static com.currencyfair.model.TradeSoap addTrade(
        java.lang.String json) throws RemoteException {
        try {
            com.currencyfair.model.Trade returnValue = TradeServiceUtil.addTrade(json);

            return com.currencyfair.model.TradeSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Creates an empty Trade object and populates w/ the provided data
    *
    * @param json Trade data in JSON format
    * @return Trade object w/ populated data
    */
    public static com.currencyfair.model.TradeSoap createTradeFromJSON(
        java.lang.String json) throws RemoteException {
        try {
            com.currencyfair.model.Trade returnValue = TradeServiceUtil.createTradeFromJSON(json);

            return com.currencyfair.model.TradeSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
