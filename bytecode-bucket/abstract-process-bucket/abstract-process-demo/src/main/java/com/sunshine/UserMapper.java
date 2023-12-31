package com.sunshine;

import com.sunshine.annotation.ApiAnnotation;
import com.sunshine.dto.UserDTO;
import com.sunshine.po.UserPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/6
 */
//@Mapper
@Mapper
public interface UserMapper {
    
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    
    UserDTO userPOToUserDTO(UserPO userPO);
    
}
