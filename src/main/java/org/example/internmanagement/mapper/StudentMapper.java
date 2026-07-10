package org.example.internmanagement.mapper;

import org.example.internmanagement.dto.request.StudentRequestDTO;
import org.example.internmanagement.dto.request.StudentUpdateDTO;
import org.example.internmanagement.dto.response.StudentResponseDTO;
import org.example.internmanagement.entity.Student;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = UserMapper.class, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "studentId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Student toEntity(StudentRequestDTO request);

    @Mapping(target = "studentId", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromDto(StudentUpdateDTO request, @MappingTarget Student student);

    StudentResponseDTO toDto(Student student);
}
