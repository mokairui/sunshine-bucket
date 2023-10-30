package com.sunshine.business01.infrastructure.factory.support;

import com.sunshine.business01.infrastructure.Human;
import com.sunshine.business01.infrastructure.factory.AbstractHumanFactory;
import com.sunshine.business01.infrastructure.factory.HumanEnum;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/30
 */
public class MaleHumanFactory extends AbstractHumanFactory {
    @Override
    public Human createYellowHuman() {
        return super.createHuman(HumanEnum.YellowMaleHuman);
    }

    @Override
    public Human createWhiteHuman() {
        return super.createHuman(HumanEnum.WhiteMaleHuman);
    }

    @Override
    public Human createBlackHuman() {
        return super.createHuman(HumanEnum.BlackMaleHuman);
    }
}
