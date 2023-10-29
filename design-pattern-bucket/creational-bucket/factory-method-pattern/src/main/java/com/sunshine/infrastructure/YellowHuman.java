package com.sunshine.infrastructure;

/**
 * @author Mokairui
 * @description 接口的具体实现子类 黄种人
 * @since 2023/10/29
 */
public class YellowHuman implements Human {
    @Override
    public void laugh() {
        System.out.println("黄种人会笑");
    }

    @Override
    public void cry() {
        System.out.println("黄种人会哭");
    }

    @Override
    public void talk() {
        System.out.println("黄种人会说话, 一般说的都是双字节");
    }
}
