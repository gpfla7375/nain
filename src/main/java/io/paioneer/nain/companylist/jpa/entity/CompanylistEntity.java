package io.paioneer.nain.companylist.jpa.entity;

import io.paioneer.nain.member.model.dto.MemberDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="TB_COMPANY_LIST")
public class CompanylistEntity {
    @Id
    @Column(name="COM_NO")
    private Long comNo;
    @Column(name="COM_NAME", nullable = false)
    private String comName;
    @Column(name="COM_TITLE", nullable = false)
    private String comTitle;
    @Column(name="COM_LINK", nullable = false)
    private LocalDateTime comDate;
    @Column(name="COM_NAME", nullable = false)
    private long comLink;

    public CompanylistEntity toDto() {
        return CompanylistEntity.builder()
                .comNo(this.comNo)
                .comName(this.comName)
                .comTitle(this.comTitle)
                .comDate(this.comDate)
                .comLink(this.comLink)
                .build();

    }
}
