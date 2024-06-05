package io.paioneer.nain.community.jpa.entity;

import io.paioneer.nain.community.model.dto.CommentDto;
import io.paioneer.nain.member.jpa.entity.MemberEntity;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_CB_COMMENT")
public class CommentEntity {
    @Id
    @Column(name="COMMENT_NO", nullable=false)
    private Long commentNo;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MEMBER_NO", insertable = false, updatable = false)
    private MemberEntity memberEntity;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="COMMUNITY_NO", referencedColumnName = "COMMUNITY_NO")
    private CommunityEntity communityEntity;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="COMMENT_PARENT", referencedColumnName = "COMMENT_NO")
    private CommentEntity commentEntity;

    @Column(name="COMMENT_CONTENT", nullable=false)
    private String content;

    @Column(name="COMMENT_DATE", nullable=false)
    private Date commentDate;

    public CommentEntity(CommentDto commentDto){
        this.commentNo = commentDto.getCommentNo();
        this.memberEntity = commentDto.getMemberDto().toEntity();
        this.communityEntity = new CommunityEntity(commentDto.getCommunityDto());
        this.commentEntity = new CommentEntity(commentDto.getCommentDto());
        this.content = commentDto.getContent();
        this.commentDate = commentDto.getCommentDate();
    }
}
