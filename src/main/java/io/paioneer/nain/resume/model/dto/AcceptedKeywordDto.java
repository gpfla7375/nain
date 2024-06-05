package io.paioneer.nain.resume.model.dto;

import io.paioneer.nain.member.jpa.entity.MemberEntity;
import io.paioneer.nain.resume.jpa.entity.AcceptedKeywordEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AcceptedKeywordDto {
    private String jobTitle;
    private String keyword;

    public AcceptedKeywordEntity toEntity(){
        return AcceptedKeywordEntity.builder()
                .jobTitle(this.jobTitle)
                .keyword(this.keyword)
                .build();
    }

}
