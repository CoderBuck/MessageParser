package com.github.coderbuck.messageparser.bean;

import com.github.coderbuck.messageparser.GsonUtils;

public class MessageBean {

    String head;

    String body;

    public MessageBean(String head, String body) {
        this.head = head;
        this.body = body;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String toJson() {
        return GsonUtils.toJson(this);
    }
}
