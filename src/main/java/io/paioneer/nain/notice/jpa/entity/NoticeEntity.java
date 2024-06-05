<<<<<<< HEAD
package io.paioneer.nain.notice.jpa.entity;

import io.paioneer.nain.notice.model.dto.NoticeDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="TB_NOTICE")
@Entity
public class NoticeEntity {

    @Id     //JPA 가 객체를 관리할 때 식별할 기본키 지정하는 어노테이션임
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //primary key 지정하는 어노테이션
    @Column(name = "NOTICE_NO")
    private int noticeNo;

    @Column(name = "NOTICE_TITLE", nullable = false, length = 50)
    private String noticeTitle;

    @Column(name = "NOTICE_DATE", nullable = false)
    private java.util.Date noticeDate;

    @Column(name = "MEMBER_NO", nullable = false)
    private Long memberNo;

    @Column(name = " NOTICE_CONTENT", nullable = false, length = 1000)
    private String noticeContent;

    @Column(name = "NOTICE_READCOUNT", nullable = false)
    private int noticeReadCount;

    @Column(name = "NOTICE_IMPORTENT", nullable = false)
    private Date noticeImportent;

    public NoticeDto toDto(){
        return NoticeDto.builder()
                .noticeNo(noticeNo)
                .noticeTitle(noticeTitle)
                .noticeDate(noticeDate)
                .memberNo(memberNo)
                .noticeContent(noticeContent)
                .noticeReadCount(noticeReadCount)
                .noticeImportent(noticeImportent)
                .build();
    }



}


=======
package io.paioneer.nain.notice.jpa.entity;

import io.paioneer.nain.notice.model.dto.NoticeDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="TB_NOTICE")
@Entity
public class NoticeEntity {

    @Id     //JPA 가 객체를 관리할 때 식별할 기본키 지정하는 어노테이션임
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //primary key 지정하는 어노테이션
    @Column(name = "NOTICE_NO")
    private int noticeNo;

    @Column(name = "NOTICE_TITLE", nullable = false, length = 50)
    private String noticeTitle;

    @Column(name = "NOTICE_DATE", nullable = false)
    private java.util.Date noticeDate;

    @Column(name = "MEMBER_NO", nullable = false)
    private Long memberNo;

    @Column(name = " NOTICE_CONTENT", nullable = false, length = 1000)
    private String noticeContent;

    @Column(name = "NOTICE_READCOUNT", nullable = false)
    private int noticeReadCount;

    @Column(name = "NOTICE_IMPORTENT", nullable = false)
    private Date noticeImportent;

    public NoticeDto toDto(){
        return NoticeDto.builder()
                .noticeNo(noticeNo)
                .noticeTitle(noticeTitle)
                .noticeDate(noticeDate)
                .memberNo(memberNo)
                .noticeContent(noticeContent)
                .noticeReadCount(noticeReadCount)
                .noticeImportent(noticeImportent)
                .build();
    }



}


>>>>>>> ef6239d6e78f36c17ac5809f35a9b1aa69dc937d
