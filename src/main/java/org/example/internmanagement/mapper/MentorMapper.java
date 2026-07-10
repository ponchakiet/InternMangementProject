package org.example.internmanagement.mapper;

import org.example.internmanagement.dto.request.MentorRequestDTO;
import org.example.internmanagement.dto.request.MentorUpdateDTO;
import org.example.internmanagement.dto.response.MentorResponseDTO;
import org.example.internmanagement.entity.Mentor;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = UserMapper.class, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MentorMapper {

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "mentorId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Mentor toEntity(MentorRequestDTO request);

    @Mapping(target = "mentorId", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromDto(MentorUpdateDTO request, @MappingTarget Mentor mentor);

    MentorResponseDTO toDto(Mentor mentor);
}
