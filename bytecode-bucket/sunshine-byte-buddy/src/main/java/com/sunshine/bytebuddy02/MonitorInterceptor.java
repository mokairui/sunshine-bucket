package com.sunshine.bytebuddy02;

import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Argument;
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
public class MonitorInterceptor {

    /*
     * @Argument 绑定单个参数
     * @AllArguments 绑定所有参数的数组
     * @This 当前被拦截的, 动态生成的对象
     * @Super 当前被拦截的, 动态生成的对象的父类对象
     * @Origin 可以绑定到以下类型的参数: Method 被调用的原始方法 Constructor 被调用的原始构造器 Class 当前动态创建的类
     *          MethodHandle MethodType String 动态类的 toString() 的返回值 int 动态方法的修饰符
     * @DefaultCall 调用默认方法而非 super 的方法
     * @SuperCall 用于调用父类版本的方法
     * @Super 注入父类型对象, 可以是接口, 从而调用它的任何方法
     * @RuntimeType 可以用在返回值, 参数上, 提示 ByteBuddy 禁用严格的类型检查
     * @Empty 注入参数的类型的默认值
     * @StubValue 注入一个存根值. 对于返回引用, void的方法, 注入null; 对于返回原始类型的方法, 注入0
     * @FieldValue 注入被拦截对象的一个字段值
     * @Morph 类似于 @SuperCall, 但是允许指定调用参数
     */
    @RuntimeType
    public static Object intercept(@Origin Method method, @AllArguments Object[] args, @Argument(0) Object arg0, @SuperCall Callable<?> callable) throws Exception {
        long start = System.currentTimeMillis();
        Object resObj = null;
        try {
            resObj = callable.call();
            return resObj;
        } finally {
            System.out.println("方法名称: " + method.getName());
            System.out.println("入参个数: " + method.getParameterCount());
            System.out.println("入参类型: " + method.getParameterTypes()[0].getTypeName() + ", " + method.getParameterTypes()[1].getTypeName());
            System.out.println("出参类型: " + method.getReturnType().getName());
            System.out.println("出参结果: " + resObj);
            System.out.println("方法耗时: " + (System.currentTimeMillis() - start) + "ms");
        }
    }
    
}
