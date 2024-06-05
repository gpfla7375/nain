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
    private Long memberNo; // *entity 연결 유의
    private String title;
    private String resumeName;
    private String email;
    private String phone;
    private String bookMarked;
    private String jobCategory;
    private Date modificationDate;

    public ResumeEntity toEntity() {
        ResumeEntity resumeEntity = ResumeEntity.builder()
                .resumeNo(this.resumeNo)
                .title(this.title)
                .resumeName(this.resumeName)
                .email(this.email)
                .phone(this.phone)
                .bookMarked(this.bookMarked)
                .jobCategory(this.jobCategory)
                .modificationDate(this.modificationDate)
                .build();

        // entity에서 값을 가져와서 넣어 줌 (memberNo)
        if (this.memberNo != null) {
            MemberEntity memberEntity = new MemberEntity();
            memberEntity.setMemberNo(this.memberNo);
            resumeEntity.setMemberEntity(memberEntity);
        }
        return resumeEntity;
    }
}
