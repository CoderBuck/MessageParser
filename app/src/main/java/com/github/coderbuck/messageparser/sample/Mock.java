package com.github.coderbuck.messageparser.sample;

import com.github.coderbuck.messageparser.EmMsg;
import com.github.coderbuck.messageparser.GsonUtils;
import com.github.coderbuck.messageparser.ParserManager;
import com.github.coderbuck.messageparser.bean.ABean;
import com.github.coderbuck.messageparser.bean.MessageBean;

/**
 * 模拟业务发送消息
 */
public class Mock {
    private static final String TAG = "Mock";

    public static void sendMessageA() {
        MessageBean msg = new MessageBean(EmMsg.Ai_A.name(), GsonUtils.toJson(new ABean("Hello A")));
        sendMessage(msg);
    }

    public static void sendMessageB() {
        MessageBean msg = new MessageBean(EmMsg.Ai_B.name(), GsonUtils.toJson(new ABean("Hello B")));
        sendMessage(msg);
    }

    public static void sendMessageC() {
        MessageBean msg = new MessageBean(EmMsg.Ai_C.name(), GsonUtils.toJson(new ABean("Hello C")));
        sendMessage(msg);
    }

    public static void sendMessageD() {
        MessageBean msg = new MessageBean(EmMsg.Conf_D.name(), GsonUtils.toJson(new ABean("Hello D")));
        sendMessage(msg);
    }

    public static void sendMessageE() {
        MessageBean msg = new MessageBean(EmMsg.Conf_E.name(), GsonUtils.toJson(new ABean("Hello E")));
        sendMessage(msg);
    }

    public static void sendMessage(MessageBean msg) {
        LogUtils.d(TAG, "sendMessage : " + msg.getHead());
        ParserManager.getCallback().callback(msg.toJson());
    }

}
