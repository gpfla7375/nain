package io.paioneer.nain.resume.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_ACCEPTED_KEYWORDS")
public class AcceptedKeywordEntity {
    @Id
    @Column(name="JOB_TITLE", nullable = false)
    private String jobTitle;

    @Column(name="KEYWORD", nullable = false)
    private String keyword;
}
