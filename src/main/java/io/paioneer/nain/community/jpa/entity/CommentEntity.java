package io.paioneer.nain.community.jpa.entity;

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
    private MemberEntity member;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="COMMUNITY_NO", insertable = false, updatable = false)
    private CommunityEntity communityEntity;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="COMMENT_NO", insertable = false, updatable = false)
    private CommentEntity commentEntity;

    @Column(name="COMMENT_CONTENT", nullable=false)
    private String content;

    @Column(name="COMMENT_DATE", nullable=false)
    private Date commentDate;
}
