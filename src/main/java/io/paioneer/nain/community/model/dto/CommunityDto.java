package io.paioneer.nain.community.model.dto;

import io.paioneer.nain.community.jpa.entity.CommunityEntity;
import io.paioneer.nain.member.jpa.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class CommunityDto {
    private Long communityNo;
    private MemberEntity memberEntity;
    private String title;
    private String content;
    private String fileUpload;
    private String fileModified;
    private Date communityDate;
    private String readCount;

    public CommunityDto(CommunityEntity communityEntity){
        this.communityNo = communityEntity.getCommunityNo();
        this.memberEntity = communityEntity.getMemberEntity();
        this.title = communityEntity.getTitle();
        this.content = communityEntity.getContent();
        this.fileUpload = communityEntity.getFileUpload();
        this.fileModified = communityEntity.getFileModified();
        this.communityDate = communityEntity.getCommunityDate();
        this.readCount = communityEntity.getReadCount();
    }
}
