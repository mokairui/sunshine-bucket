package com.sunshine.bytebuddy01;

import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.util.concurrent.Callable;

/**
 * @author Mokairui
 * @description
 * @since 2023/9/19
 */
public class MonitorMethod {
    
    public static Object intercept(@SuperCall Callable<?> callable) throws Exception {
        long start = System.currentTimeMillis();
        try {
            return callable.call();
        } finally {
            System.out.println("方法耗时: " + (System.currentTimeMillis() - start) + "ms");
        }
    }
    
}
