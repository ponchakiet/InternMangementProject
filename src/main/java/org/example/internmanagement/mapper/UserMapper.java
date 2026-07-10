package org.example.internmanagement.mapper;

import org.example.internmanagement.dto.request.UserRequestDTO;
import org.example.internmanagement.dto.request.UserUpdateDTO;
import org.example.internmanagement.dto.response.UserResponseDTO;
import org.example.internmanagement.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(source = "phone", target = "phoneNumber")
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    User toEntity(UserRequestDTO request);

    @Mapping(source = "phone", target = "phoneNumber")
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromDto(UserUpdateDTO request, @MappingTarget User user);

    UserResponseDTO toDto(User user);
}
