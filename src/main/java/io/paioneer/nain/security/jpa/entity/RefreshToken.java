package io.paioneer.nain.security.jpa.entity;

import io.paioneer.nain.member.jpa.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.UUID;


@Table(name="REFRESH_TOKEN")
@Slf4j
@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class RefreshToken {
    @Id
    @Column(length=36)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USER_ID", referencedColumnName="USERID", nullable=false)
    private MemberEntity member;
    private String userId;
    @Column(name="TOKEN_VALUE", nullable=false, length=255)
    private String tokenValue;
    @Column(name="ISSUED_AT", nullable=false)
    private LocalDateTime issuedAt;
    @Column(name="EXPIRES_IN", nullable=false)
    private Long expiresIn;
    @Column(name="EXPIRATION_DATE", nullable=false)
    private LocalDateTime expirationDate;
    @Column(name="USER_AGENT", length=255, nullable=false)
    private String userAgent;
    @Column(name="STATUS", length=50, nullable=false)
    private String status;

    @PrePersist   //jpa 로 가기 전에 작동됨
    public void prePersist(){
        LocalDateTime now = LocalDateTime.now();
        if (issuedAt == null){
        issuedAt = now;
        }
        if(expirationDate == null){
            expirationDate = now.plusSeconds(expiresIn / 1000);
        }
    }
}




