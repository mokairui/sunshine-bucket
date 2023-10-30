package com.sunshine.business01.infrastructure.impl;

import com.sunshine.business01.infrastructure.AbstractYellowHuman;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/30
 */
public class YellowMaleHuman extends AbstractYellowHuman {
    @Override
    public void sex() {
        System.out.println("该黄种人的性别为男....");
    }
}
