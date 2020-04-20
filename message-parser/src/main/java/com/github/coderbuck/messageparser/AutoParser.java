package com.github.coderbuck.messageparser;

import com.github.coderbuck.messageparser.annotation.Message;

import java.lang.annotation.Annotation;

public class AutoParser {

    /**
     * 注入要处理的消息类
     *
     * @param clazzs 带 @Message 注解的消息类
     */
    public static void inject(Class... clazzs) {
        for (Class clazz : clazzs) {
            Annotation annotation = clazz.getAnnotation(Message.class);
            if (annotation == null) {
                throw new IllegalArgumentException(clazz.getSimpleName() + " 没有@Message注解不能自动注入");
            }
            String parserClassName = "kd.message.parser." + clazz.getSimpleName() + "Parser";
            try {
                Class<?> parserClass = Class.forName(parserClassName);
                AbstractParser parser = (AbstractParser) parserClass.newInstance();
                ParserManager.register(parser);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("找不到 " + clazz.getSimpleName() + " 消息解析类", e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
