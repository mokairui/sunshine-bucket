package com.sunshine;

import java.util.concurrent.Callable;

/**
 * @author Mokairui
 * @description
 * @since 2023/9/19
 */
public class MonitorMethod {
    
    public static Object intercept(Callable<?> callable) throws Exception {
        long start = System.currentTimeMillis();
    }
    
}
