package com.sunshine.business01.infrastructure.factory;

import com.sunshine.business01.infrastructure.Human;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/30
 */
public interface HumanFactory {
    Human createYellowHuman();
    
    Human createWhiteHuman();
    
    Human createBlackHuman();
}
