package com.sunshine;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/**
 * @author Mokairui
 * @description
 * @since 2023/9/18
 */
public class GeneratorClazzMethod {

    public static void main(String[] args) throws Exception {
        // 生成类信息
        createClazz();
        
        // 覆盖 toString 方法
        createMainMethod();
        
        // 委托函数使用
        delegateProcedureMethod();
    }

    private static void createClazz() {
        // 这样会在编译时 生成一个 com.sunshine.HelloByteBuddy 字节码文件
        DynamicType.Unloaded<Object> dynamicType = new ByteBuddy()
                .subclass(Object.class).name("com.sunshine.HelloByteBuddy")
                .make();
    }

    private static void createMainMethod() throws Exception {
        DynamicType.Unloaded<Object> dynamicClazz = new ByteBuddy().subclass(Object.class)
                .name("com.sunshine.HelloByteBuddy2")
                .method(ElementMatchers.named("toString"))
                .intercept(FixedValue.value("Hello World!"))
                .make();
        Class<?> dynamicType = dynamicClazz.load(GeneratorClazzMethod.class.getClassLoader()).getLoaded();

        String msg = dynamicType.getDeclaredConstructor().newInstance().toString();
        System.out.println(msg);
    }
    
    private static void delegateProcedureMethod() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        DynamicType.Unloaded<Object> clazzLoad = new ByteBuddy().subclass(Object.class)
                .name("com.sunshine.HelloByteBuddy3")
                .defineMethod("main", void.class, Modifier.PUBLIC + Modifier.STATIC)
                .withParameter(String[].class, "args")
                // MethodDelegation 方法委托 但是需要方法的 入参和出参是一样才可以映射上
                .intercept(MethodDelegation.to(Hi.class))
                .make();
        Class<?> clazz = clazzLoad.load(GeneratorClazzMethod.class.getClassLoader()).getLoaded();
        clazz.getMethod("main", String[].class).invoke(clazz.getDeclaredConstructor().newInstance(), (Object) new String[1]);
    }

    public static class Hi {
        public static void main(String[] args) {
            System.out.println("helloWorld");
        }
    }
    
}
