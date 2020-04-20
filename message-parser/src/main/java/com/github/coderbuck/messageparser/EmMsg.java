package com.github.coderbuck.messageparser;

import com.github.coderbuck.messageparser.annotation.Body;
import com.github.coderbuck.messageparser.bean.ABean;
import com.github.coderbuck.messageparser.bean.BBean;
import com.github.coderbuck.messageparser.bean.CBean;
import com.github.coderbuck.messageparser.bean.DBean;
import com.github.coderbuck.messageparser.bean.Empty;

public enum EmMsg {

    // AI
    @Body(ABean.class) Ai_A,
    @Body(BBean.class) Ai_B,
    @Body(CBean.class) Ai_C,

    // Conf
    @Body(DBean.class) Conf_D,
    @Body(Empty.class) Conf_E,
    ;
}
