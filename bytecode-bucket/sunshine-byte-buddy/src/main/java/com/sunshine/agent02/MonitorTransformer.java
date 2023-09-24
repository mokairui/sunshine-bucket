package com.sunshine.agent02;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;

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

    // 这个方法中 transform 中是不允许重复申明类信息的,这里的执行段是在被加载到jvm之前, 可以做一些字节码的转换
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        String currentClassName = className.replaceAll("/", ".");
        if (!classNameSet.contains(currentClassName)) {
            return null;
        }

        System.out.println("transform: [" + currentClassName + "]");

        try {
            /* 
                    不能使用 byteBuddy 的方法redefine直接定义class来在这里完成字节码的修改, 因为可能这个类已经被加载了, 
                而bytebuddy.redefine(Class.forName( className ) 这个是需要在类还没有被 jvm 加载之前使用, 
                除非使用 typePool.describe() 这种方式实现
                
                * redefine(TypeDescription, ClassFileLocator)：
                    输入参数：使用 Byte Buddy 的 TypeDescription 对象和 ClassFileLocator 对象作为参数。
                    需要首先通过 TypePool 创建一个 TypeDescription 对象来描述要重新定义的类。
                    可以在运行期间重新定义已经加载的类。
                    适用于已经加载的类的重新定义场景。
                    
                * redefine(Class<?>, boolean, ClassLoader)：
                    输入参数：使用原始的 Java Class 对象、布尔值和类加载器作为参数。
                    不需要准备工作，直接使用传递进来的 Class 对象进行重新定义。
                    用于重新定义尚未加载的类。
                    布尔值参数表示是否保留原始类的调试信息。
                    类加载器用于加载重新定义后的类。
                    适用于未加载的类的重新定义场景。
                
                而这个方法中是不允许定义已经加载的类信息的类
            */ 
            TypePool typePool = TypePool.Default.ofSystemLoader();
            return new ByteBuddy()
                    .redefine(typePool.describe(currentClassName).resolve(), ClassFileLocator.ForClassLoader.ofSystemLoader())
                    .visit(Advice.to(MonitorAdvice.class).on(ElementMatchers.any()))
                    .make()
                    .getBytes();
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
