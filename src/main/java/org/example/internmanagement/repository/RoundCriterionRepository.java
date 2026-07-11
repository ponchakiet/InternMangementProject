package org.example.internmanagement.repository;

import org.example.internmanagement.entity.AssessmentRound;
import org.example.internmanagement.entity.RoundCriterion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoundCriterionRepository extends JpaRepository<RoundCriterion, Integer> {
    List<RoundCriterion> findByRound_RoundId(Integer roundId);
    boolean existsByRound_RoundIdAndCriterion_CriterionId(Integer roundId, Integer criterionId);
    void deleteAllByRound_Phase_PhaseId(Integer phaseId);
    void deleteAllByCriterion_CriterionId(Integer criterionId);
    void deleteAllByRound_RoundId(Integer roundId);
}