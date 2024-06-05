package io.paioneer.nain.resume.model.dto;

import io.paioneer.nain.resume.jpa.entity.ResumeEntity;
import io.paioneer.nain.resume.jpa.entity.SkillEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class SkillDto {
    private String skillName;
    private Long resumeNo; // *entity 연결 유의

    public SkillEntity toEntity(){
        SkillEntity skillEntity = SkillEntity.builder()
                .skillName(this.skillName)
                .build();

        if (this.resumeNo != null) {
            ResumeEntity resumeEntity = new ResumeEntity();
            resumeEntity.setResumeNo(this.resumeNo);
            skillEntity.setResumeEntity(resumeEntity);
        }
        return skillEntity;
    }
}
