package com.github.coderbuck.messageparser.sample.message;

import com.github.coderbuck.messageparser.EmMsg;
import com.github.coderbuck.messageparser.annotation.Message;

@Message({
        EmMsg.Ai_A,
        EmMsg.Ai_B,
        EmMsg.Ai_C,
})
public interface Ai {
}
