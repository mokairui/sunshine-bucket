package com.sunshine.agent02;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 * @author Mokairui
 * @description
 * @since 2023/9/23
 */
public class MyAgent {

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("this is my agent: " + agentArgs);
        // javaassit 和 asm 一般用这种原生的方式
//        MonitorTransformer monitorTransform = new MonitorTransformer();
//        inst.addTransformer(monitorTransform);
        
        // byteBuddy 在字节码未被加载到jvm时对字节码的转换操作, byteBuddy 一般用这种方式 已经封装过了
        new AgentBuilder.Default()
//                .type(ElementMatchers.nameStartsWith("com.sunshine.agent01."))
//                .type(ElementMatchers.named("com.sunshine.agent01.ApiTest"))
                .type(ElementMatchers.nameStartsWith("com.sunshine"))
                .transform((builder, type, classLoader, module, domain) ->
                        builder.visit(Advice.to(MonitorTransformer.MonitorAdvice .class).on(ElementMatchers.any())))
                .installOn(inst);
    }

}
