package com.sunshine.bytebuddy02;

import java.util.concurrent.TimeUnit;

/**
 * @author Mokairui
 * @description
 * @since 2023/9/23
 */
public class TargetMethod {

    public String queryUserInfo(String uid, String token) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return "用来模拟方法执行, 提供执行时间, 入参, 出参!";
    }
    
}
