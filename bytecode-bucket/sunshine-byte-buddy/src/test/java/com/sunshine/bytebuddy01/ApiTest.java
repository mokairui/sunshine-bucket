package com.sunshine.bytebuddy01;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.NamingStrategy;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.pool.TypePool;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Mokairui
 * @description
 * @since 2023/9/24
 */
public class ApiTest {
    
    @Test
    public void create_byteBuddy01() {
        DynamicType.Unloaded<?> dynamicType = new ByteBuddy()
                .subclass(Object.class)
                .name("example.Type")
                .make();
    }
    
    @Test
    public void create_byteBuddy02() {
        DynamicType.Unloaded<?> dynamicType = new ByteBuddy()
                .with(new NamingStrategy.AbstractBase() {
                    @Override
                    protected String name(TypeDescription superClass) {
                        return "i.love.ByteBuddy." + superClass.getSimpleName();
                    }
                })
                .subclass(Object.class)
                .make();
    }
    
    /*
            JVM在我们有机会重新定义它之前就已经加载了这个类，我们的重新定义尝试将无效
            redefine 必须在这个类定义之前
     */
    @Test
    public void redefine_byteBuddy01() {
        TypePool typePool = TypePool.Default.ofSystemLoader();
        Class<?> bar = new ByteBuddy()
                .redefine(typePool.describe("com.sunshine.bytebuddy01.Bar").resolve(), // do not use 'Bar.class'
                        ClassFileLocator.ForClassLoader.ofSystemLoader())
                .defineField("qux", String.class) // we learn more about defining fields later
                .make()
                .load(ClassLoader.getSystemClassLoader(), ClassLoadingStrategy.Default.INJECTION)
                .getLoaded();
        System.out.println(Arrays.toString(bar.getDeclaredFields()));
    }
    
}
