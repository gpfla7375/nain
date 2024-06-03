package io.paioneer.nain.security.jwt.model;

import io.paioneer.nain.member.model.dto.MemberDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//Spring Security 의 UserDetails 인터페이스를 상속받아서 구현함
public class CustomUserDetails implements UserDetails {

    private final MemberDto memberDto;

    //생성자로 의존성 주입
    public CustomUserDetails(MemberDto memberDto) {
        this.memberDto = memberDto;
    }

    //사용자의 권한 목록을 반환하는 메서드임
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        //사용자의 adminYN(관리자여부) 값에 따라 ROLE_ADMIN 또는 ROLE_USER 권한을 부여함
//        if(this.memberDto.getAdminYN().equals("Y")) {
//            authorities.add(new SimpleGrantedAuthority("ADMIN"));
//        } else {
//            authorities.add(new SimpleGrantedAuthority("USER"));
//        }
        return authorities;
    }

    //사용자의 비밀번호 반환
    @Override
    public String getPassword() {
        return "";
        //return memberDto.getUserPwd();
    }
    //사용자의 이름 반환
    @Override
    public String getUsername() {
        return "";
        //return memberDto.getUserName();
    }
    //계정이 만료되었는지를 반환

    @Override
    public boolean isAccountNonExpired() {
        return true;    //여기서는 만료되지 않았다고 가정함
    }

    //계정이 잠겼는지를 반환
    @Override
    public boolean isAccountNonLocked() {
        return true;
        //return this.memberDto.getLoginOk().equals("Y");
    }
    //사용자의 크리덴셜(비밀번호 등)이 만료되지 않았는지 를 반환
    @Override
    public boolean isCredentialsNonExpired() {
        return true;    //여기서는 크리덴셜이 만료되지 않았다고 가정함(db테이블에 해당 정보 저장 컬럼이 필요함)
    }
    //사용자 계정이 사용가능 상태인지를 반환
    @Override
    public boolean isEnabled() {
        return true;
        //return this.memberDto.getLoginOk().equals("Y"); //isActivated 컬럼을 db회원테이블에 추가하고 사용하면 됨
    }
}
