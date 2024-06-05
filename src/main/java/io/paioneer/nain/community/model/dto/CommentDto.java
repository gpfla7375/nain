package io.paioneer.nain.community.model.dto;

import io.paioneer.nain.community.jpa.entity.CommentEntity;
import io.paioneer.nain.community.jpa.entity.CommunityEntity;
import io.paioneer.nain.member.jpa.entity.MemberEntity;
import io.paioneer.nain.member.model.dto.MemberDto;
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
public class CommentDto {
    private Long commentNo;
    private MemberDto memberDto;
    private CommunityDto communityDto;
    private CommentDto commentDto;
    private String content;
    private Date commentDate;

    public CommentDto(CommentEntity commentEntity) {
        this.commentNo = commentEntity.getCommentNo();
        this.memberDto = commentEntity.getMemberEntity().toDto();
        this.communityDto = new CommunityDto(commentEntity.getCommunityEntity());
        this.commentDto = new CommentDto(commentEntity.getCommentEntity());
        this.content = commentEntity.getContent();
        this.commentDate = commentEntity.getCommentDate();
    }
}
