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

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        DynamicType.Unloaded<Object> dynamicClazz = new ByteBuddy().subclass(Object.class)
                .method(ElementMatchers.named("toString"))
                .intercept(FixedValue.value("Hello World!"))
                .make();
        Class<?> dynamicType = dynamicClazz.load(GeneratorClazzMethod.class.getClassLoader()).getLoaded();

        String msg = dynamicType.getDeclaredConstructor().newInstance().toString();
        System.out.println(msg);


        DynamicType.Unloaded<Object> clazzLoad = new ByteBuddy().subclass(Object.class)
                .defineMethod("main", void.class, Modifier.PUBLIC + Modifier.STATIC)
                .withParameter(String[].class, "args")
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
