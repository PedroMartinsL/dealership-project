package com.dealership.project.infrastructure.mappers;

import org.mapstruct.Mapper;

import com.dealership.project.api.dto.UserDTO;
import com.dealership.project.domain.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // Mapeamento de User para UserDTO
    UserDTO userToUserDTO(User user);

    // Mapeamento de UserDTO para User
    User userDTOToUser(UserDTO userDTO);
}
