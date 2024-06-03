package io.paioneer.nain.security.handler;

import io.paioneer.nain.member.model.dto.MemberDto;
import io.paioneer.nain.member.model.service.MemberService;
import io.paioneer.nain.security.jpa.entity.RefreshToken;
import io.paioneer.nain.security.jwt.util.JWTUtil;
import io.paioneer.nain.security.model.service.RefreshTokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
public class CustomLogoutHandler implements LogoutHandler {
    private final JWTUtil jwtUtil;
    private final MemberService memberService;
    private final RefreshTokenService refreshTokenService;

    public CustomLogoutHandler(JWTUtil jwtUtil, RefreshTokenService refreshTokenService, MemberService memberService) {
        this.memberService = memberService;
        this.refreshTokenService = refreshTokenService;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.Authentication authentication) {
        //요청 헤더에서 'Authorization' 값을 추출함
        String authorization = request.getHeader("Authorization");
        if(authorization != null && authorization.startsWith("Bearer ")) {
            //"Bearer" 다음부터 시작하는 실제 토큰 값 추출
            String token = authorization.split(" ")[1];
            //토큰에서 사용자의 아이디 추출
            //String userId = jwtUtil.getUserIDFromToken(token);
            //사용자 아이디(이메일)을 통해서 사용자 정보 조회함
//            MemberDto loginMember = memberService.selectMember(jwtUtil.getUserIDFromToken(token));
//            if(loginMember != null) {
//                //해당 사용자의 리프레시 토큰을 데이터베이스에서 조회해 옴
//                Optional<RefreshToken> refresh = refreshTokenService.findByTokenValue(token);
//                if(refresh.isPresent()) {
//                    RefreshToken refreshTokenValue = refresh.get();
//                    //리프레시 토큰을 데이터베이스에서 삭제함
//                    refreshTokenService.deleteByTokenValue(refreshTokenValue.getTokenValue());
//                }
//
//            }
        }
        //로그아웃 성공
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
