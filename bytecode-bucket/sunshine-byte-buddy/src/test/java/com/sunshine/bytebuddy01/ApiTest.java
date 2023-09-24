package com.sunshine.bytebuddy01;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.NamingStrategy;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import org.junit.Test;

import java.lang.instrument.Instrumentation;
import java.util.Arrays;

/**
 * @author Mokairui
 * @description 
 * .type(...) 方法：
 *      通过传入一个 ElementMatcher 对象来选择要操作的类。
 *      可以使用一系列的 ElementMatchers 条件来匹配类的名称、注解、修饰符等属性。
 *      例如，.type(ElementMatchers.nameStartsWith("com.sunshine.agent01.")) 表示选择所有名称以 "com.sunshine.agent01." 开头的类。
 * 
 * .with(...) 方法：
 *      通过传入一个 Transformer 对象来定义要对选择的类执行的转换操作。
 *      可以使用 Transformer 接口的各种实现类，如 AgentBuilder.Transformer, AgentBuilder.Transformer.ForMethod, AgentBuilder.Transformer.ForField 等。
 *      例如，.with(AgentBuilder.Transformer.ForMethod.withModifiers(Modifier.PUBLIC).andThen(...)) 表示选择所有具有 public 修饰符的方法，并在之后进行其他转换操作。
 *
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


    class Foo {
        public String bar() { return null; }
        public String foo() { return null; }
        public String foo(Object o) { return null; }
    }
    
    @Test
    public void test_filedAndMethod01() throws InstantiationException, IllegalAccessException {
        Foo dynamicFoo = new ByteBuddy()
                .subclass(Foo.class)
                .method(ElementMatchers.isDeclaredBy(Foo.class)).intercept(FixedValue.value("One!"))
                .method(ElementMatchers.named("foo")).intercept(FixedValue.value("Two!"))
                .method(ElementMatchers.named("foo").and(ElementMatchers.takesArguments(1))).intercept(FixedValue.value("Three!"))
                .make()
                .load(getClass().getClassLoader())
                .getLoaded()
                .newInstance();
    }
    
    // 用于 javaAgent 中的 premain 方法中 通过这个来演示 type 和 with
    private void test_Type(Instrumentation inst) {
        new AgentBuilder.Default()
                .type(ElementMatchers.nameStartsWith("com.sunshine.agent01."))
                .transform((builder, typeDescription, classLoader, module, domain) ->
                        builder.method(ElementMatchers.any())
                                .intercept(FixedValue.value("Hello from Byte Buddy!")))
                .installOn(inst);

//        new AgentBuilder.Default()
//                .type(ElementMatchers.any())
//                .transform((builder, typeDescription, classLoader, module) ->
//                        builder.method(ElementMatchers.named("greeting"))
//                                .intercept(MethodDelegation.to(GreeterInterceptor.class)))
//                .with(AgentBuilder.Listener.StreamWriting.toSystemOut()) // 添加监听器
//                .installOn(inst);
    }
    
}
