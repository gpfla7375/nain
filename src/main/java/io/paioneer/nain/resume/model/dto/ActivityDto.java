package io.paioneer.nain.resume.model.dto;

import io.paioneer.nain.resume.jpa.entity.ActivityEntity;
import io.paioneer.nain.resume.jpa.entity.ResumeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ActivityDto {
    private Long activityNo;
    private Long resumeNo; // *entity 연결 유의
    private String activityName;
    private String activityDescription;
    private String organizer;
    private Date startDate;
    private Date endDate;

    public ActivityEntity toEntity(){
        ActivityEntity activityEntity = ActivityEntity.builder()
                .activityNo(this.activityNo)
                .activityName(this.activityName)
                .activityDescription(this.activityDescription)
                .organizer(this.organizer)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .build();

        if (this.resumeNo != null) {
            ResumeEntity resumeEntity = new ResumeEntity();
            resumeEntity.setResumeNo(this.resumeNo);
            activityEntity.setResumeEntity(resumeEntity);
        }
        return activityEntity;
    }
}
