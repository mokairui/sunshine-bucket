package com.sunshine.bytebuddy02;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.Test;

/**
 * @author Mokairui
 * @description
 * @since 2023/9/23
 */
public class ApiTest {

    @Test
    public void test_getMethodInfo() throws Exception {
        DynamicType.Unloaded<TargetMethod> dynamicType = new ByteBuddy().subclass(TargetMethod.class)
                .method(ElementMatchers.named("queryUserInfo"))
                .intercept(MethodDelegation.to(MonitorInterceptor.class))
                .make();

        // 加载类
        Class<? extends TargetMethod> clazz = dynamicType.load(ApiTest.class.getClassLoader()).getLoaded();

        // 反射调用执行方法
        TargetMethod instance = clazz.getDeclaredConstructor().newInstance();
        clazz.getMethod("queryUserInfo", String.class, String.class).invoke(instance, "10001", "Bear token");
    }

}
  