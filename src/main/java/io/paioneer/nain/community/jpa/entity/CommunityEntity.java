package io.paioneer.nain.community.jpa.entity;

import io.paioneer.nain.community.model.dto.CommunityDto;
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
@Table(name = "TB_COMMUNITY_BOARD")
public class CommunityEntity {
    @Id
    @Column(name="COMMUNITY_NO", nullable = false)
    private Long communityNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MEMBER_NO", referencedColumnName = "MEMBER_NO")
    private MemberEntity memberEntity;

    @Column(name="TITLE", nullable = false)
    private String title;

    @Column(name="COMMUNITY_CONTENT", nullable = false)
    private String content;

    @Column(name="FILE_UPLOAD", nullable = false)
    private String fileUpload;

    @Column(name="FILE_MODIFIED", nullable = false)
    private String fileModified;

    @Column(name="COMMUNITY_DATE")
    private Date communityDate;

    @Column(name="READCOUNT", nullable = false)
    private String readCount;

    public CommunityEntity(CommunityDto communityDto){
        this.communityNo = communityDto.getCommunityNo();
        this.memberEntity = communityDto.getMemberEntity();
        this.title = communityDto.getTitle();
        this.content = communityDto.getContent();
        this.fileUpload = communityDto.getFileUpload();
        this.fileModified = communityDto.getFileModified();
        this.communityDate = communityDto.getCommunityDate();
        this.readCount = communityDto.getReadCount();
    }
}
