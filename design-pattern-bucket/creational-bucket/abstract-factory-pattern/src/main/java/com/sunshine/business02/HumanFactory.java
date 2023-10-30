package com.sunshine.business02;

import com.sunshine.business02.gender.Gender;
import com.sunshine.business02.race.Race;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/30
 */
public interface HumanFactory {
    
    Gender createGender();
    
    Race createRace();
    
}
