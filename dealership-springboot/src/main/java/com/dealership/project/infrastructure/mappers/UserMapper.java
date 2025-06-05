package com.dealership.project.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dealership.project.api.dto.UserDTO;
import com.dealership.project.domain.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // Mapeamento de User para UserDTO
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    UserDTO userToUserDTO(User user);

    // Mapeamento de UserDTO para User
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    User userDTOToUser(UserDTO userDTO);
}
