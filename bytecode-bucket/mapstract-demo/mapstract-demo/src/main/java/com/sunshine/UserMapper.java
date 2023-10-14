package com.sunshine;

import com.sunshine.dto.UserDTO;
import com.sunshine.po.UserPO;

/**
 * @author Mokairui
 * @description
 * @since 2023/10/6
 */
//@Mapper
@Mapper
public interface UserMapper {

    UserDTO userPOToUserDTO(UserPO userPO);

}
