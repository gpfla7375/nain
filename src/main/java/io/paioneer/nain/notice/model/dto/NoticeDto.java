<<<<<<< HEAD
package io.paioneer.nain.notice.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.paioneer.nain.notice.jpa.entity.NoticeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class NoticeDto {
    private int noticeNo;
    private String noticeTitle;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date noticeDate;
    private Long memberNo;
    private String noticeContent;
    private int noticeReadCount;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date noticeImportent;

    public NoticeEntity toEntity(){
        return NoticeEntity.builder()
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

