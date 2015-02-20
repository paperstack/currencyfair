package com.currencyfair.service.messaging;

import com.currencyfair.service.ClpSerializer;
import com.currencyfair.service.TradeLocalServiceUtil;
import com.currencyfair.service.TradeServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            TradeLocalServiceUtil.clearService();

            TradeServiceUtil.clearService();
        }
    }
}
