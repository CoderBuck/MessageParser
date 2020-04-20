package com.github.coderbuck.messageparser.sample;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.github.coderbuck.messageparser.EventUtils;
import com.github.coderbuck.messageparser.bean.ABean;
import com.github.coderbuck.messageparser.bean.BBean;
import com.github.coderbuck.messageparser.bean.CBean;
import com.github.coderbuck.messageparser.bean.DBean;
import com.github.coderbuck.messageparser.bean.Empty;

import kd.message.parser.AiHandler;
import kd.message.parser.ConfHandler;

public class ConfActivity extends AppCompatActivity {
    private static final String TAG = "ConfActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.go).setVisibility(View.GONE);

        mConfHandler.register();
        EventUtils.autoNotify(mConfHandler);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mConfHandler.unregister();
    }

    ConfHandler mConfHandler = new ConfHandler.Simple() {

        @Override
        public void Conf_D(DBean body) {
            LogUtils.d(TAG, "mConfHandler D: " + body.name);
        }

        @Override
        public void Conf_E(Empty body) {
            LogUtils.d(TAG, "mConfHandler E: Empty ");
        }
    };


}
