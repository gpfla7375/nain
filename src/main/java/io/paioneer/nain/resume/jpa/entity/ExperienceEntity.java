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
@Table(name = "TB_EXPERIENCE")
public class ExperienceEntity {
    @Id
    @Column(name="EXPERIENCE_NO", nullable = false)
    private Long experienceNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="RESUME_NO", insertable = false, updatable = false)
    private ResumeEntity resumeEntity;

    @Column(name="COM_NAME", nullable = false)
    private String comName;

    @Column(name="EX_DURATION", nullable = false)
    private Long exDuration;

    @Column(name="EX_CURRENT", nullable = false)
    private String exCurrent;

    @Column(name="DEPARTMENT", nullable = false)
    private String department;

    @Column(name="EX_POSITION", nullable = false)
    private String exPosition;

    @Column(name="RESPONSIBILITIES", nullable = false)
    private String responsibilities;

    @Column(name="START_DATE", nullable = false)
    private Date startDate;

    @Column(name="END_DATE")
    private Date endDate;
}
