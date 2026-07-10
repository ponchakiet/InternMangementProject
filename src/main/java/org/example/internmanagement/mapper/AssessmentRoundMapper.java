package org.example.internmanagement.mapper;

import org.example.internmanagement.dto.request.AssessmentRoundRequestDTO;
import org.example.internmanagement.dto.request.AssessmentRoundUpdateDTO;
import org.example.internmanagement.dto.response.AssessmentRoundResponseDTO;
import org.example.internmanagement.entity.AssessmentRound;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = InternshipPhaseMapper.class, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssessmentRoundMapper {

    @Mapping(target = "phase", ignore = true)
    @Mapping(target = "roundId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    AssessmentRound toEntity(AssessmentRoundRequestDTO request);

    @Mapping(target = "phase", ignore = true)
    @Mapping(target = "roundId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromDto(AssessmentRoundUpdateDTO request, @MappingTarget AssessmentRound round);

    @Mapping(target = "criteria", ignore = true)
    AssessmentRoundResponseDTO toDto(AssessmentRound round);
}
