package org.example.internmanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.internmanagement.dto.request.InternshipPhaseRequestDTO;
import org.example.internmanagement.dto.request.InternshipPhaseUpdateDTO;
import org.example.internmanagement.dto.response.InternshipPhaseResponseDTO;
import org.example.internmanagement.entity.InternshipPhase;
import org.example.internmanagement.entity.User;
import org.example.internmanagement.exception.DuplicateResourceException;
import org.example.internmanagement.exception.ResourceNotFoundException;
import org.example.internmanagement.mapper.InternshipPhaseMapper;
import org.example.internmanagement.repository.InternshipPhaseRepository;
import org.example.internmanagement.service.InternshipPhaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InternshipPhaseServiceImpl implements InternshipPhaseService {

    private final InternshipPhaseRepository internshipPhaseRepository;
    private final InternshipPhaseMapper internshipPhaseMapper;

    @Override
    public Page<InternshipPhaseResponseDTO> getAllPhases(User user, Pageable pageable) {
        if (user.getRole() != User.Role.ADMIN && user.getRole() != User.Role.MENTOR && user.getRole() != User.Role.STUDENT) {
            throw new ResourceNotFoundException("Access denied");
        }

        Page<InternshipPhase> phases = internshipPhaseRepository.findAll(pageable);
        return phases.map(internshipPhaseMapper::toDto);
    }

    @Override
    public InternshipPhaseResponseDTO getPhaseById(Integer phaseId, User user) {
        if (user.getRole() != User.Role.ADMIN && user.getRole() != User.Role.MENTOR && user.getRole() != User.Role.STUDENT) {
            throw new ResourceNotFoundException("Access denied");
        }

        InternshipPhase phase = internshipPhaseRepository.findById(phaseId)
                .orElseThrow(() -> new ResourceNotFoundException("Internship phase not found with id: " + phaseId));
        return internshipPhaseMapper.toDto(phase);
    }

    @Override
    @Transactional
    public InternshipPhaseResponseDTO createPhase(InternshipPhaseRequestDTO request, User user) {
        if (user.getRole() != User.Role.ADMIN) {
            throw new ResourceNotFoundException("Access denied");
        }

        if (internshipPhaseRepository.existsByPhaseName(request.getPhaseName())) {
            throw new DuplicateResourceException("Phase name already exists");
        }

        InternshipPhase phase = internshipPhaseMapper.toEntity(request);

        return internshipPhaseMapper.toDto(internshipPhaseRepository.save(phase));
    }

    @Override
    @Transactional
    public InternshipPhaseResponseDTO updatePhase(Integer phaseId, InternshipPhaseUpdateDTO request, User user) {
        if (user.getRole() != User.Role.ADMIN) {
            throw new ResourceNotFoundException("Access denied");
        }

        InternshipPhase phase = internshipPhaseRepository.findById(phaseId)
                .orElseThrow(() -> new ResourceNotFoundException("Internship phase not found with id: " + phaseId));

        if (request.getPhaseName() != null && !phase.getPhaseName().equals(request.getPhaseName()) &&
                internshipPhaseRepository.existsByPhaseName(request.getPhaseName())) {
            throw new DuplicateResourceException("Phase name already exists");
        }

        internshipPhaseMapper.updateEntityFromDto(request, phase);

        return internshipPhaseMapper.toDto(internshipPhaseRepository.save(phase));
    }

    @Override
    @Transactional
    public void deletePhase(Integer phaseId, User user) {
        if (user.getRole() != User.Role.ADMIN) {
            throw new ResourceNotFoundException("Access denied");
        }

        InternshipPhase phase = internshipPhaseRepository.findById(phaseId)
                .orElseThrow(() -> new ResourceNotFoundException("Internship phase not found with id: " + phaseId));

        internshipPhaseRepository.delete(phase);
    }
}
