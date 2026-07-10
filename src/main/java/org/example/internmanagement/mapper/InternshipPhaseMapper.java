package org.example.internmanagement.mapper;

import org.example.internmanagement.dto.request.InternshipPhaseRequestDTO;
import org.example.internmanagement.dto.request.InternshipPhaseUpdateDTO;
import org.example.internmanagement.dto.response.InternshipPhaseResponseDTO;
import org.example.internmanagement.entity.InternshipPhase;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InternshipPhaseMapper {

    @Mapping(target = "phaseId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    InternshipPhase toEntity(InternshipPhaseRequestDTO request);

    @Mapping(target = "phaseId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromDto(InternshipPhaseUpdateDTO request, @MappingTarget InternshipPhase phase);

    InternshipPhaseResponseDTO toDto(InternshipPhase phase);
}
