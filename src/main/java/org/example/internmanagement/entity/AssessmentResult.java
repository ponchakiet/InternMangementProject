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
@Table(name = "assessment_results", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"assignment_id", "round_id", "criterion_id"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE assessment_results SET deleted = true WHERE result_id = ?")
@SQLRestriction("deleted = false")
public class AssessmentResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private Integer resultId;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;

    @ManyToOne
    @JoinColumn(name = "assignment_id", nullable = false)
    private InternshipAssignment assignment;

    @ManyToOne
    @JoinColumn(name = "round_id", nullable = false)
    private AssessmentRound round;

    @ManyToOne
    @JoinColumn(name = "criterion_id", nullable = false)
    private EvaluationCriterion criterion;

    @Column(name = "score", nullable = false, precision = 5, scale = 2)
    private BigDecimal score;

    @Column(name = "comments", columnDefinition = "TEXT")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "evaluated_by", nullable = false)
    private User evaluatedBy;

    @Column(name = "evaluation_date", nullable = false)
    private LocalDateTime evaluationDate = LocalDateTime.now();

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}

