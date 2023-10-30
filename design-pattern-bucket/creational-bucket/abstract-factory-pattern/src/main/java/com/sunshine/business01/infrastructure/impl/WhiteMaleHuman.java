package com.sunshine.business01.infrastructure.impl;

import com.sunshine.business01.infrastructure.AbstractWhiteHuman;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/30
 */
public class WhiteMaleHuman extends AbstractWhiteHuman {
    @Override
    public void sex() {
        System.out.println("该白种人的性别为男....");
    }
}
