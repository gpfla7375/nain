package io.paioneer.nain.resume.model.dto;

import io.paioneer.nain.resume.jpa.entity.EducationEntity;
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
public class EducationDto {
    private Long educationNo;
    private Long resumeNo; // *entity 연결 유의
    private String educationCurrent;
    private String major;
    private String educationDegree;
    private Long score;
    private Date startDate;
    private Date endDate;

    public EducationEntity toEntity(){
        EducationEntity educationEntity = EducationEntity.builder()
                .educationNo(this.educationNo)
                .educationCurrent(this.educationCurrent)
                .major(this.major)
                .educationDegree(this.educationDegree)
                .score(this.score)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .build();

        if (this.resumeNo != null) {
            ResumeEntity resumeEntity = new ResumeEntity();
            resumeEntity.setResumeNo(this.resumeNo);
            educationEntity.setResumeEntity(resumeEntity);
        }
        return educationEntity;
    }
}
