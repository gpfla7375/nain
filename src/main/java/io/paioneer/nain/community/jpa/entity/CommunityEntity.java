package io.paioneer.nain.community.jpa.entity;

import io.paioneer.nain.member.jpa.entity.Member;
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
    @JoinColumn(name="MEMBER_NO", insertable = false, updatable = false)
    private Member memberEntity;

    @Column(name="TITLE", nullable = false)
    private String title;

    @Column(name="COMMUNITY_CONTENT", nullable = false)
    private String content;

    @Column(name="FILE_UPLOAD", nullable = false)
    private String filedUpload;

    @Column(name="FILE_MODIFIED", nullable = false)
    private String fileModified;

    @Column(name="COMMUNITY_DATE")
    private Date communityDate;

    @Column(name="READCOUNT", nullable = false)
    private String readCount;
}
