package com.github.coderbuck.messageparser;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class EventUtils {

    public static Map<String, Object> events = new HashMap<>();

    public static Object get(String name) {
        return events.get(name);
    }

    public static Object put(String name, Object body) {
        return events.put(name, body);
    }

    /**
     * 通知订阅者订阅的所有事件
     * @param subscriber
     */
    public static void autoNotify(Object subscriber) {
        Method[] methods = subscriber.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("autoNotify : method = " + method.getName());
            String name = method.getName();

            Object body = events.get(name);
            if (body == null) {
                System.out.println("autoNotify : body == null 忽略");
                break;
            }
            System.out.println("autoNotify : body = " + body.getClass());

            try {
                method.invoke(subscriber,body);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
