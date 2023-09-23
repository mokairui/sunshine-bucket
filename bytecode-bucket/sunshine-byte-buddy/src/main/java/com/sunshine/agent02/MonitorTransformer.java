package com.sunshine.agent02;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Mokairui
 * @description
 * @since 2023/9/23
 */
public class MonitorTransformer implements ClassFileTransformer {

    private static final Set<String> classNameSet = new HashSet<>();

    static {
        classNameSet.add("com.sunshine.agent01.ApiTest");
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        String currentClassName = className.replaceAll("/", ".");
        if (!classNameSet.contains(currentClassName)) {
            return null;
        }

        System.out.println("transform: [" + currentClassName + "]");

        try {
            /* 
                    不能使用 byteBuddy 的方法来在这里完成字节码的修改, 因为可能这个类已经被加载了, 而bytebuddy这里方法都是新建了一个类,
                在这个方法中 transform 中是不允许重复申明类信息的,这里的执行段是在被加载到jvm之前, 可以做一些字节码的转换
                很遗憾这个只能使用 javaassist 或则 asm (目前感觉是这样 需要进一步了解, 可能理解有误). 当然 bytebuddy 也是支持在加载到
                jvm 之前就对字节码进行修改的操作, 使用 AgentBuild 就可以做到他优化了使用方式, 不用自己再去定义 ClassFileTransformer
                或则在 类信息的字节码被加载到了 jvm 中之后再去使用 byteBuddy 的 redefine 来重新定义类信息
            */ 
//            new ByteBuddy()
//                    .redefine(Class.forName(currentClassName, false, loader))
//                    .visit(Advice.to(MonitorAdvice.class).on(ElementMatchers.any()))
//                    .make();
            return classfileBuffer;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static class MonitorAdvice {

        @Advice.OnMethodEnter
        public static long enter() {
            return System.nanoTime();
        }

        @Advice.OnMethodExit
        public static void exit(@Advice.Origin String methodName, @Advice.Enter long startTime) {
            long elapsedTime = System.nanoTime() - startTime;
            System.out.println("method: [" + methodName + "] cost: [" + elapsedTime + "ns]");
        }
        
    }
}
