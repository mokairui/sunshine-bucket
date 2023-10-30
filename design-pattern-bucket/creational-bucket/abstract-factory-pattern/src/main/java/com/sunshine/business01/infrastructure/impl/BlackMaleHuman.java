package com.sunshine.business01.infrastructure.impl;

import com.sunshine.business01.infrastructure.AbstractBlackHuman;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/30
 */
public class BlackMaleHuman extends AbstractBlackHuman {
    @Override
    public void sex() {
        System.out.println("该黑种人的性别为男...");
    }
}
