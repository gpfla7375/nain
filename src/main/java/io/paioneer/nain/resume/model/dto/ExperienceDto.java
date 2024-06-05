package io.paioneer.nain.resume.model.dto;

import io.paioneer.nain.resume.jpa.entity.ExperienceEntity;
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
public class ExperienceDto {
    private Long experienceNo;
    private Long resumeNo; // *entity 연결 유의
    private String comName;
    private Long exDuration;
    private String exCurrent;
    private String department;
    private String exPosition;
    private String responsibilities;
    private Date startDate;
    private Date endDate;

    public ExperienceEntity toEntity() {
        ExperienceEntity experienceEntity = ExperienceEntity.builder()
                .experienceNo(this.experienceNo)
                .comName(this.comName)
                .exDuration(this.exDuration)
                .exCurrent(this.exCurrent)
                .department(this.department)
                .exPosition(this.exPosition)
                .responsibilities(this.responsibilities)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .build();

        if (this.resumeNo != null) {
            ResumeEntity resumeEntity = new ResumeEntity();
            resumeEntity.setResumeNo(this.resumeNo);
            experienceEntity.setResumeEntity(resumeEntity);
        }
        return experienceEntity;
    }
}
