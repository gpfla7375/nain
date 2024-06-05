package io.paioneer.nain.resume.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_SKILL")
public class SkillEntity {
    @Id
    @Column(name="SKILL_NAME", nullable = false)
    private String skillName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="RESUME_NO", insertable = false, updatable = false)
    private ResumeEntity resumeEntity;
}
