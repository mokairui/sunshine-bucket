package com.sunshine.agent03;

import com.sunshine.agent02.MonitorTransformer;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;

/**
 * @author Mokairui
 * @description
 * @since 2023/9/23
 */
public class MyAgent {
    
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("this is agent: " + agentArgs);
        // buddy中有两种拦截方式一种是 visit 需要配置 Advice 注解, 一种是 method + intercept 的方式
        AgentBuilder.Transformer transformer = (builder, typeDescription, clasLoader, javaModule, domain) -> {
            // 使用委托类的方式拦截
            return builder.method(ElementMatchers.any()) // 拦截所有方法
                    .intercept(MethodDelegation.to(MethodCostTimeInterceptor.class)); // 委托

            // visit 是用于 Advice 也就是 @Advice.OnMethodEnter @Advice.OnMethodExit 这两个注解
//            return builder.visit(Advice.to(MethodCostTimeInterceptor.class).on(ElementMatchers.any()));
        };

        AgentBuilder.Listener listener = new AgentBuilder.Listener() {
            @Override
            public void onDiscovery(String s, ClassLoader classLoader, JavaModule javaModule, boolean b) {

            }

            @Override
            public void onTransformation(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, boolean b, DynamicType dynamicType) {

            }

            @Override
            public void onIgnored(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, boolean b) {

            }

            @Override
            public void onError(String s, ClassLoader classLoader, JavaModule javaModule, boolean b, Throwable throwable) {

            }

            @Override
            public void onComplete(String s, ClassLoader classLoader, JavaModule javaModule, boolean b) {

            }
        };
        
        new AgentBuilder.Default().type(ElementMatchers.nameStartsWith("com.sunshine.agent01"))
                .transform(transformer)
                .with(listener)
                .installOn(inst);
    }
    
}
