package org.example.internmanagement.mapper;

import org.example.internmanagement.dto.request.AssessmentResultRequestDTO;
import org.example.internmanagement.dto.request.AssessmentResultUpdateDTO;
import org.example.internmanagement.dto.response.AssessmentResultResponseDTO;
import org.example.internmanagement.entity.AssessmentResult;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {AssessmentRoundMapper.class, EvaluationCriterionMapper.class, UserMapper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssessmentResultMapper {

    @Mapping(target = "assignment", ignore = true)
    @Mapping(target = "round", ignore = true)
    @Mapping(target = "criterion", ignore = true)
    @Mapping(target = "evaluatedBy", ignore = true)
    @Mapping(target = "resultId", ignore = true)
    @Mapping(target = "evaluationDate", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    AssessmentResult toEntity(AssessmentResultRequestDTO request);

    @Mapping(target = "assignment", ignore = true)
    @Mapping(target = "round", ignore = true)
    @Mapping(target = "criterion", ignore = true)
    @Mapping(target = "evaluatedBy", ignore = true)
    @Mapping(target = "resultId", ignore = true)
    @Mapping(target = "evaluationDate", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromDto(AssessmentResultUpdateDTO request, @MappingTarget AssessmentResult result);

    @Mapping(source = "assignment.assignmentId", target = "assignmentId")
    AssessmentResultResponseDTO toDto(AssessmentResult result);
}
