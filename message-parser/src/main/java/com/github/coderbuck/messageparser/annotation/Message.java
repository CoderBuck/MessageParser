package com.github.coderbuck.messageparser.annotation;

import com.github.coderbuck.messageparser.EmMsg;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Message {
    EmMsg[] value();
}
