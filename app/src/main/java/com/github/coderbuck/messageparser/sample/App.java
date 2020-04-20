package com.github.coderbuck.messageparser.sample;

import android.app.Application;
import android.util.Log;

import com.github.coderbuck.messageparser.AutoParser;
import com.github.coderbuck.messageparser.bean.BBean;
import com.github.coderbuck.messageparser.sample.message.Ai;
import com.github.coderbuck.messageparser.sample.message.Conf;

import kd.message.parser.AiInterceptor;

public class App extends Application {
    private static final String TAG = "App";

    @Override
    public void onCreate() {
        super.onCreate();
        AutoParser.inject(Ai.class, Conf.class);
        mAiInterceptor.register();
    }

    AiInterceptor mAiInterceptor = new AiInterceptor.Simple() {

        @Override
        public boolean Ai_B(BBean body) {
            LogUtils.d(TAG, "AiInterceptor 拦截了消息 B ");
            return true;
        }
    };
}
