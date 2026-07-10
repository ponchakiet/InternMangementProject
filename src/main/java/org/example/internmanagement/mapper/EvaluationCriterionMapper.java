package org.example.internmanagement.mapper;

import org.example.internmanagement.dto.request.EvaluationCriterionRequestDTO;
import org.example.internmanagement.dto.request.EvaluationCriterionUpdateDTO;
import org.example.internmanagement.dto.response.EvaluationCriterionResponseDTO;
import org.example.internmanagement.entity.EvaluationCriterion;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EvaluationCriterionMapper {

    @Mapping(target = "criterionId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    EvaluationCriterion toEntity(EvaluationCriterionRequestDTO request);

    @Mapping(target = "criterionId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromDto(EvaluationCriterionUpdateDTO request, @MappingTarget EvaluationCriterion criterion);

    EvaluationCriterionResponseDTO toDto(EvaluationCriterion criterion);
}
