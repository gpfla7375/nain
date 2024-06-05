package io.paioneer.nain.companylist.model.dto;

import io.paioneer.nain.member.jpa.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Component
public class CompanylistDto {
    private Long comNo;
    private String comName;
    private String comTitle;
    private LocalDate comDate;
    private long comLink;

    public CompanylistDto toEntity() {
        return CompanylistDto.builder()
                .comNo(this.comNo)
                .comName(this.comName)
                .comTitle(this.comTitle)
                .comDate(this.comDate)
                .comLink(this.comLink)
                .build();
    }


}


