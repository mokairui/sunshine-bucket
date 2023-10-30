package com.sunshine.business02.race;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/30
 */
public class YellowRace implements Race {
    @Override
    public void laugh() {
        System.out.println("黄种人大笑!");
    }

    @Override
    public void cry() {
        System.out.println("黄种人哭泣!");
    }

    @Override
    public void talk() {
        System.out.println("黄种人交谈!");
    }
}
