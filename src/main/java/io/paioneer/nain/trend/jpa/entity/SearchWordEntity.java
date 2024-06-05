package io.paioneer.nain.trend.jpa.entity;

import io.paioneer.nain.trend.model.dto.SearchWordDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "TB_SEARCHWORD")
@Entity
public class SearchWordEntity {
    @Id
    @Column(name = "SEARCHWORD_NO", nullable = false)
    private Long searchwordNo;

    @Column(name = "KEYWORD", nullable = false)
    private String keyword;

    @Column(name = "SEARCHWORD_COUNT", nullable = false)
    private int searchwordCount;

    public SearchWordDto toDto() {
        return SearchWordDto.builder()
                .searchwordNo(this.searchwordNo)
                .keyword(this.keyword)
                .searchwordCount(this.searchwordCount)
                .build();
    }
}
