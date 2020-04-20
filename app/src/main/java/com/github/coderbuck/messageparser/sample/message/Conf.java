package com.github.coderbuck.messageparser.sample.message;

import com.github.coderbuck.messageparser.EmMsg;
import com.github.coderbuck.messageparser.annotation.Message;

@Message({
        EmMsg.Conf_D,
        EmMsg.Conf_E,
})
public interface Conf {
}
