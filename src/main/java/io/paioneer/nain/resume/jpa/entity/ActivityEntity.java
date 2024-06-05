package io.paioneer.nain.resume.jpa.entity;

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
@Table(name = "TB_ACTIVITY")
public class ActivityEntity {
    @Id
    @Column(name="ACTIVITY_NO", nullable = false)
    private Long activityNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="RESUME_NO", insertable = false, updatable = false)
    private ResumeEntity resumeEntity;

    @Column(name="ACTIVITY_NAME", nullable = false)
    private String activityName;

    @Column(name="ACTIVITY_DESCRIPTION", nullable = false)
    private String activityDescription;

    @Column(name="ORGANIZER", nullable = false)
    private String organizer;

    @Column(name="START_DATE", nullable = false)
    private Date startDate;

    @Column(name="END_DATE")
    private Date endDate;
}
