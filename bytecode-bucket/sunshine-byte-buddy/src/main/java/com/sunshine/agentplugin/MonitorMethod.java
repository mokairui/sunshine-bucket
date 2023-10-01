package com.sunshine.agentplugin;

import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import net.bytebuddy.implementation.bind.annotation.This;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * @author Mokairui
 * @description
 * @since 2023/9/30
 */
public class MonitorMethod {
    
    @RuntimeType
    public static Object intercept(@This Object obj, @Origin Method method, @SuperCall Callable<?> callable, @AllArguments Object... args) throws Exception {
        long start = System.currentTimeMillis();
        Object resObj = null;
        try {
            resObj = callable.call();
            return resObj;
        } finally {
            System.out.println("方法名称: " + method.getName());
            System.out.println("入参个数: " + method.getParameterCount());
//            System.out.println("入参类型: " + method.getParameterTypes()[0].getTypeName() + ", " + method.getParameterTypes()[1].getTypeName());
            System.out.println("出参类型: " + method.getReturnType().getName());
            System.out.println("出参结果: " + resObj);
            System.out.println("方法耗时: " + (System.currentTimeMillis() - start) + "ms");
        }
    }
    
}
