package io.paioneer.nain.trend.model.dto;

import io.paioneer.nain.trend.jpa.entity.TrendEntity;
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
public class TrendDto {
    private Long trendNo;
    private String title;
    private String trendContent;
    private String trendLink;
    private Date trendDate;

    public TrendEntity toEntity() {
        return TrendEntity.builder()
                .trendNo(this.trendNo)
                .title(this.title)
                .trendContent(this.trendContent)
                .trendLink(this.trendLink)
                .trendDate(this.trendDate)
                .build();
    }
}
