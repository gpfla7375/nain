package io.paioneer.nain.trend.model.dto;

import io.paioneer.nain.trend.jpa.entity.SearchWordEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class SearchWordDto {
    private Long searchwordNo;
    private String keyword;
    private int searchwordCount;

    public SearchWordEntity toEntity() {
        return SearchWordEntity.builder()
                .searchwordNo(this.searchwordNo)
                .keyword(this.keyword)
                .searchwordCount(this.searchwordCount)
                .build();
    }
}
