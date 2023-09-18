package com.sunshine;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Mokairui
 * @description
 * @since 2023/9/18
 */
public class GeneratorClazzMethod {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> dynamicType = new ByteBuddy().subclass(Object.class)
                .method(ElementMatchers.named("toString"))
                .intercept(FixedValue.value("Hello World!"))
                .make()
                .load(GeneratorClazzMethod.class.getClassLoader())
                .getLoaded();

        String msg = dynamicType.getDeclaredConstructor().newInstance().toString();
        System.out.println(msg);
    }
    
}
