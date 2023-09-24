package com.sunshine.agent05;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;

/**
 * @author Mokairui
 * @description
 * @since 2023/9/24
 */
public class MyAgent {
    
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("this is agent: " + agentArgs);

        new AgentBuilder.Default()
                .type(ElementMatchers.nameStartsWith("com.sunshine.agent05.ApiTest"))
                .transform((builder, typeDescription, classLoader, javaModule, domain) -> 
                        builder.visit(Advice.to(AdviceInterceptor.class)
                                .on(ElementMatchers.isMethod()
                                        .and(ElementMatchers.any())
                                        .and(ElementMatchers.not(ElementMatchers.nameStartsWith("main"))))))
                .with(new AgentBuilder.Listener() {
                    @Override
                    public void onDiscovery(String s, ClassLoader classLoader, JavaModule javaModule, boolean b) {
                        
                    }

                    @Override
                    public void onTransformation(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, boolean b, DynamicType dynamicType) {
                        // 监听当一个类的字节码开始发生转换的时候
                        System.out.println("onTransformation: " + typeDescription);
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
                })
                .installOn(inst);
    }
    
}
