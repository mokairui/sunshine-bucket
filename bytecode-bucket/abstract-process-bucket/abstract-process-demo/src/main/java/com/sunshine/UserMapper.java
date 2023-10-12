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
@ApiAnnotation(date = "2023-10-12")
public interface UserMapper {
    
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    
    UserDTO userPOToUserDTO(UserPO userPO);
    
}
