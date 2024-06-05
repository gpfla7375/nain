package io.paioneer.nain.resume.jpa.entity;

import io.paioneer.nain.member.jpa.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_EDUCATION")
public class EducationEntity {
    @Id
    @Column(name="EDUCATION_NO", nullable = false)
    private Long educationNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="RESUME_NO", insertable = false, updatable = false)
    private ResumeEntity resumeEntity;

    @Column(name="EDUCATION_CURRENT", nullable = false)
    private String educationCurrent;

    @Column(name="MAJOR", nullable = false)
    private String major;

    @Column(name="EDUCATION_DEGREE", nullable = false)
    private String educationDegree;

    @Column(name="SCORE", nullable = false)
    private Long score;

    @Column(name="START_DATE", nullable = false)
    private Date startDate;

    @Column(name="END_DATE")
    private Date endDate;
}
