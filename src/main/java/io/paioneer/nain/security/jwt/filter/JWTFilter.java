package io.paioneer.nain.security.jwt.filter;

import io.paioneer.nain.member.model.dto.MemberDto;
import io.paioneer.nain.security.jwt.model.CustomUserDetails;
import io.paioneer.nain.security.jwt.util.JWTUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j  //Lombok의 Slf4j 어노테이션 사용해서 로깅 기능을 자동 추가함
//Spring Security 의 OncePerRequestFilter 를 상속받음
//모든 요청에 대해 한번씩 실행되는 필터가 됨
public class JWTFilter extends OncePerRequestFilter {
    //JWT 관련 유틸리티 메서드를 제공하는 JWTUtil 의 인스턴스를 멤버로 선언함
    private final JWTUtil jwtUtil;

    //생성자를 통해 멤버변수 의존성 주입함
    public JWTFilter(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        //요청(request)에서 'Authorization' 헤더를 추출함
        String authorization = request.getHeader("Authorization");
        String requestURI = request.getRequestURI();
        if("/reissue".equals(requestURI)) { //클라이언트가 토큰 재발행 요청을 했다면
            chain.doFilter(request, response); //해당 요청을 처리할 컨트롤러 메서드로 전달해라 "/reissu"로
            return;
        }
        if("/logout".equals(requestURI)) {
            //찾아갈 대상으로 그대로 전달함
            chain.doFilter(request, response); //SecurityConfig 에 설정된 LogoutHandler
            return;
        }
        //토큰 확인이 필요없는 요청(로그인하지 않고 이용하는 서비스 url은 그대로 다음 단계로 넘김
        //'Authorization'이 헤더에 없거나 Bearer토큰이 아니면 요청을 계속 진행함
        if(authorization == null || !authorization.startsWith("Bearer ")) {
            //permitAll() 에 등록된 url이면 해당 컨트롤러로 전달
            //토큰이 필요한(로그인해야 요청되는) 요청은 에러를 클라이언트에게 보냄
            log.info("여기만 옴");
                chain.doFilter(request, response);
                log.info("갔다가 옴");
                return;
        }
        //Bearer 토큰에서 JWT 추출함
        //authorization 이 가진 값 : "Bearer 토큰문자열"
        String token = authorization.split(" ")[1];

        //토큰 만료 여부 확인, 만료시 다음 필터로 넘기지 않음
        if(jwtUtil.isTokenExpired(token)) {
            //response body
            PrintWriter printWriter = response.getWriter();
            printWriter.println("access token expired");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        //token 에서 category (access, refresh) 추출
        String category = jwtUtil.getCategoryFromToken(token);
        //토큰 category 가 access 가 아니라면 만료된 토큰으로 판단함
        if(!category.equals("access")) {
            //response body
            PrintWriter printWriter = response.getWriter();
            printWriter.println("invalid access token");
            //response status code
            //응답 코드를 front와 맞추는 부분 401 에러 외 다른 상태코드로 맞추면
            //리프레시 토큰 발급 체크를 좀 더 빠르게 할 수 있음
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        //위의 조건들에 해당되지 않으면, 만료되지 않은 access 토큰으로 요청이 왔다면
        //사용자 아이디(또는 이메일), 관리자 여부 추출함
        String userId = jwtUtil.getUserIDFromToken(token);
        String admin = jwtUtil.getAdminFromToken(token);

        //인증에 사용할 임시 User객체를 생성하고, 추출한 정보 저장함
        MemberDto memberDto = new MemberDto();
        //memberDto.setUserId(userId);
        //memberDto.setAdminYN(admin);
        //memberDto.setUserPwd("temp");   //실제 인증에서는 사용되지 않는 임시 비밀번호를 설정함

        //인증에 사용할 user를 기반으로 한 CustomUserDetail객체가 필요함
        //Security 가 제공하는 UserDetails 를 상속받은 인증용 클래스 : security.jwt.model.CustomUserDetails
        CustomUserDetails userDetails = new CustomUserDetails(memberDto);

        //Spring Security 의 Authentication 객체를 생성하고, SecurityContext에 등록 설정함
        //이것으로 해당 요청에 대한 사용자 인증이 완료됨
        Authentication authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken);

        //엑세스 토큰(로그인 상태 확인)이 이상이 없다면 처리할 내용임
        //필터 체인을 계속 진행함
        chain.doFilter(request, response); //컨트롤러로 넘김
    }
}
