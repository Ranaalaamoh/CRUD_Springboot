package com.example.demo.mapper;

import org.mapstruct.Mapper;

import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
UserDTO toUserDTO(User user);
User toUser(UserDTO userDTO);
}
