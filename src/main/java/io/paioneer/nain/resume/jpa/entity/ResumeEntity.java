package io.paioneer.nain.resume.jpa.entity;

import io.paioneer.nain.member.jpa.entity.MemberEntity;
import io.paioneer.nain.resume.model.dto.ResumeDto;
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
@Table(name = "TB_RESUME")
public class ResumeEntity {
    @Id
    @Column(name="RESUME_NO", nullable = false)
    private Long resumeNo;            //이력서 번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MEMBER_NO", insertable = false, updatable = false)
    private MemberEntity memberEntity;//회원번호

    @Column(name="TITLE", nullable = false)
    private String title;             //이력서 제목

    @Column(name="RESUME_NAME", nullable = false)
    private String resumeName;        //이름

    @Column(name="EMAIL", nullable = false)
    private String email;             //이메일

    @Column(name="PHONE", nullable = false)
    private String phone;             //전화번호

    @Column(name="BOOKMARKED", nullable = false)
    private String bookMarked;        //스크랩 여부

    @Column(name="JOB_CATEGORY", nullable = false)
    private String jobCategory;       //직무 카테고리

    @Column(name="MODIFICATION_DATE")
    private Date modificationDate;    //이력서 수정일

    public ResumeDto toDto() {
        return ResumeDto.builder()
                .resumeNo(this.resumeNo)
                .memberEntity(this.memberEntity.getMemberNo())
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
