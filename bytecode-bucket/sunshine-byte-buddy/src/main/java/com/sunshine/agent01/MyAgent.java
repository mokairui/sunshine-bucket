package com.sunshine.agent01;

import java.lang.instrument.Instrumentation;

/**
 * @author Mokairui
 * @description 
 * @since 2023/9/23
 */
public class MyAgent {
    
    // 如果实现了这个方法, 那么会默认先走此方法
//    public static void premain(String agentArgs, Instrumentation inst) {
//        System.out.println("this is my agent: " + agentArgs);
//    }

    public static void premain(String agentArgs) {
        System.out.println("如果代理类没有实现上面的方法, 那么 JVM 将尝试调用该方法!");
    }
    
}
