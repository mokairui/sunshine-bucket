package com.sunshine.infrastructure.outer;

import java.util.Map;

/**
 * @author Mokairui
 * @description 外部系统的用户信息
 * @since 2023/10/31
 */
public interface IOuterUser {
    
    Map<String, String> getUserBaseInfo();
    
    Map<String, String> getUserOfficeInfo();

    Map<String, String> getUserHomeInfo();
    
}
