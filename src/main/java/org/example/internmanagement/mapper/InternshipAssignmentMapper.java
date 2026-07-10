package org.example.internmanagement.mapper;

import org.example.internmanagement.dto.request.InternshipAssignmentRequestDTO;
import org.example.internmanagement.dto.response.InternshipAssignmentResponseDTO;
import org.example.internmanagement.entity.InternshipAssignment;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {StudentMapper.class, MentorMapper.class, InternshipPhaseMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InternshipAssignmentMapper {

    @Mapping(target = "student", ignore = true)
    @Mapping(target = "mentor", ignore = true)
    @Mapping(target = "phase", ignore = true)
    @Mapping(target = "assignmentId", ignore = true)
    @Mapping(target = "assignedDate", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    InternshipAssignment toEntity(InternshipAssignmentRequestDTO request);

    InternshipAssignmentResponseDTO toDto(InternshipAssignment assignment);
}
