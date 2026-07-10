package org.example.internmanagement.mapper;

import org.example.internmanagement.dto.request.RoundCriterionRequestDTO;
import org.example.internmanagement.dto.request.RoundCriterionUpdateDTO;
import org.example.internmanagement.dto.response.RoundCriterionResponseDTO;
import org.example.internmanagement.entity.RoundCriterion;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {EvaluationCriterionMapper.class, AssessmentRoundMapper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoundCriterionMapper {

    @Mapping(target = "round", ignore = true)
    @Mapping(target = "criterion", ignore = true)
    @Mapping(target = "roundCriterionId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    RoundCriterion toEntity(RoundCriterionRequestDTO request);

    @Mapping(target = "round", ignore = true)
    @Mapping(target = "criterion", ignore = true)
    @Mapping(target = "roundCriterionId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromDto(RoundCriterionUpdateDTO request, @MappingTarget RoundCriterion roundCriterion);

    RoundCriterionResponseDTO toDto(RoundCriterion roundCriterion);
}
