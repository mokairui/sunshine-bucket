package com.sunshine.agent03;

import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * @author Mokairui
 * @description
 * @since 2023/9/23
 */
public class MethodCostTimeInterceptor {
    
    @RuntimeType
    public static Object intercept(@Origin Method method, @SuperCall Callable<?> callable) throws Exception {
        long start = System.currentTimeMillis();
        try {
            return callable.call();
        } finally {
            System.out.println(method + " 方法耗时: " + (System.currentTimeMillis() - start) + "ms");
        }
    }
    
}
