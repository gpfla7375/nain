package io.paioneer.nain.resume.model.dto;

import io.paioneer.nain.member.jpa.entity.MemberEntity;
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
public class ResumeDto {
    private Long resumeNo;
    private MemberEntity memberEntity;
    private String title;
    private String resumeName;
    private String email;
    private String phone;
    private String bookMarked;
    private String jobCategory;
    private Date modificationDate;

    public ResumeEntity toEntity() {
        return ResumeEntity.builder()
                .resumeNo(this.resumeNo)
                .memberEntity(this.memberEntity)
                .title(this.title)
                .resumeName(this.resumeName)
                .email(this.email)
                .phone(this.phone)
                .bookMarked(this.bookMarked)
                .jobCategory(this.jobCategory)
                .modificationDate(this.modificationDate)
                .build();
    }


}
