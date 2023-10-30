package com.sunshine.business02.factory.support;

import com.sunshine.business02.HumanFactory;
import com.sunshine.business02.gender.Gender;
import com.sunshine.business02.gender.MaleGender;
import com.sunshine.business02.race.Race;
import com.sunshine.business02.race.YellowRace;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/30
 */
public class YellowMaleHumanFactory implements HumanFactory {
    @Override
    public Gender createGender() {
        return new MaleGender();
    }

    @Override
    public Race createRace() {
        return new YellowRace();
    }
}
