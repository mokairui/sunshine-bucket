package com.sunshine;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/6
 */
@Mapper
public interface UserMapper {
    
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    
}
