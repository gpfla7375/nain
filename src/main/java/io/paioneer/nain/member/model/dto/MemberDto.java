package io.paioneer.nain.member.model.dto;

import io.paioneer.nain.member.jpa.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data   //Getter, Setter, toString 메서드를 자동으로 생성해주는 기능.
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class MemberDto {

    private Long memberNo;            //회원 번호
    private String memberEmail;         //회원 이메일, 회원아이디로 사용됨
    private String memberPwd;           //회원 비밀번호
    private String memberName;          //회원 이름
    private String memberNickName;      //회원 닉네임
    private String subscribeYN;         //회원 구독여부
    private String admin;               //관리자
    private Date paymentDate;           //회원 결제일
    private Date expireDate;            //회원 구독만료일
    private Date signUpDate;            //회원 가입일
    private Date withDrawalDate;        //회원 탈퇴일
    private Date memberUpdate;          //회원 정보수정일

    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .memberNo(this.memberNo)
                .memberEmail(this.memberEmail)
                .memberPwd(this.memberPwd)
                .memberName(this.memberName)
                .memberNickName(this.memberNickName)
                .subscribeYN(this.subscribeYN)
                .admin(this.admin)
                .paymentDate(this.paymentDate)
                .expireDate(this.expireDate)
                .signUpDate(this.signUpDate)
                .withDrawalDate(this.withDrawalDate)
                .memberUpdate(this.memberUpdate)
                .build();
    }


}
