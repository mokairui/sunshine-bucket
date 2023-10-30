package com.sunshine.business02.client;

import com.sunshine.business02.factory.support.YellowFemaleHumanFactory;
import com.sunshine.business02.gender.Gender;
import com.sunshine.business02.race.Race;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/30
 */
public class ApiMain {
    public static void main(String[] args) {
        YellowFemaleHumanFactory yellowFemaleHumanFactory = new YellowFemaleHumanFactory();
        Gender gender = yellowFemaleHumanFactory.createGender();
        Race race = yellowFemaleHumanFactory.createRace();
        
        gender.sex();
        race.cry();
        race.talk();
    }
}
