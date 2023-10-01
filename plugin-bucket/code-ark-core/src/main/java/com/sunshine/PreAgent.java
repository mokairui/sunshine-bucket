package com.sunshine;

import cn.hutool.core.util.StrUtil;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 * @author Mokairui
 * @description
 * @since 2023/9/30
 */
public class PreAgent {
    
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("hi premain :" + agentArgs);
        AgentBuilder.Transformer transformer = (builder, typeDescription, classLoader, javaModule) -> {
            return builder.method(ElementMatchers.any().and(ElementMatchers.not(ElementMatchers.named("main"))))
                    .intercept(MethodDelegation.to(MonitorMethod.class));
        };

        String methodMatcher = StrUtil.isNotBlank(agentArgs) ? agentArgs : "com.sunshine";
        new AgentBuilder
                .Default()
                .type(ElementMatchers.nameStartsWith(methodMatcher))
                .transform(transformer)
                .installOn(inst);
    }
    
}
