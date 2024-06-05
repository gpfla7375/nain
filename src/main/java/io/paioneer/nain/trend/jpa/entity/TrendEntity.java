package io.paioneer.nain.trend.jpa.entity;

import io.paioneer.nain.trend.model.dto.TrendDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "TB_TREND")
@Entity
public class TrendEntity {

    @Id
    @Column(name = "TREND_NO", nullable = false)
    private Long trendNo;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "TREND_CONTENT", nullable = false)
    private String trendContent;

    @Column(name = "TREND_LINK", nullable = false)
    private String trendLink;

    @Column(name = "TREND_DATE", nullable = false)
    private Date trendDate;

    public TrendDto toDto() {
        return TrendDto.builder()
                .trendNo(this.trendNo)
                .title(this.title)
                .trendContent(this.trendContent)
                .trendLink(this.trendLink)
                .trendDate(this.trendDate)
                .build();
    }
}
