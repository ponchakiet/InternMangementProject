package org.example.internmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "round_criteria")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE round_criteria SET deleted = true WHERE round_criterion_id = ?")
@SQLRestriction("deleted = false")
public class RoundCriterion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "round_criterion_id")
    private Integer roundCriterionId;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;

    @ManyToOne
    @JoinColumn(name = "round_id", nullable = false)
    private AssessmentRound round;

    @ManyToOne
    @JoinColumn(name = "criterion_id", nullable = false)
    private EvaluationCriterion criterion;

    @Column(name = "weight", nullable = false, precision = 5, scale = 2)
    private BigDecimal weight;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}

