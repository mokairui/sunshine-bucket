package com.sunshine.business01.infrastructure.client;

import com.sunshine.business01.infrastructure.Human;
import com.sunshine.business01.infrastructure.factory.support.FemaleHumanFactory;
import com.sunshine.business01.infrastructure.factory.support.MaleHumanFactory;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/30
 */
public class ApiMain {
    public static void main(String[] args) {
        MaleHumanFactory maleHumanFactory = new MaleHumanFactory();
        FemaleHumanFactory femaleHumanFactory = new FemaleHumanFactory();

        Human maleYellowHuman = maleHumanFactory.createYellowHuman();
        Human femaleYeloowHuman = femaleHumanFactory.createYellowHuman();
        
        maleYellowHuman.cry();
        maleYellowHuman.laugh();
        femaleYeloowHuman.sex();
    }
}
