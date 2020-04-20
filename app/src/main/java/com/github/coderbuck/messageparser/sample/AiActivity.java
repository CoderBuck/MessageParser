package com.github.coderbuck.messageparser.sample;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.coderbuck.messageparser.EmMsg;
import com.github.coderbuck.messageparser.GsonUtils;
import com.github.coderbuck.messageparser.ParserManager;
import com.github.coderbuck.messageparser.bean.ABean;
import com.github.coderbuck.messageparser.bean.BBean;
import com.github.coderbuck.messageparser.bean.CBean;
import com.github.coderbuck.messageparser.bean.DBean;
import com.github.coderbuck.messageparser.bean.MessageBean;

import kd.message.parser.AiHandler;
import kd.message.parser.AiInterceptor;
import kd.message.parser.AiParser;
import kd.message.parser.ConfHandler;
import kd.message.parser.ConfParser;

public class AiActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.go).setOnClickListener(v -> startActivity(new Intent(this,ConfActivity.class)));

        mAiHandler.register();

        // AI
        Mock.sendMessageA();
        Mock.sendMessageB();
        Mock.sendMessageC();

        // Conf
        Mock.sendMessageD();
        Mock.sendMessageE();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAiHandler.unregister();
    }

    AiHandler mAiHandler = new AiHandler.Simple() {

        @Override
        public void Ai_A(ABean body) {
            LogUtils.d(TAG, "mAiHandler A: " + body.name);
        }

        @Override
        public void Ai_B(BBean body) {
            LogUtils.d(TAG, "mAiHandler B: " + body.name);
        }

        @Override
        public void Ai_C(CBean body) {
            LogUtils.d(TAG, "mAiHandler C: " + body.name);
        }
    };


}
