package io.paioneer.nain.security.config;

import io.paioneer.nain.member.model.service.MemberService;
import io.paioneer.nain.security.handler.CustomLogoutHandler;
import io.paioneer.nain.security.jwt.filter.JWTFilter;
import io.paioneer.nain.security.jwt.filter.LoginFilter;
import io.paioneer.nain.security.jwt.util.JWTUtil;
import io.paioneer.nain.security.model.service.RefreshTokenService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j
@Configuration // 스프링부트의 설정을 담당하는 클래스임을 나타내는 어노테이션임
@EnableWebSecurity(debug = true) // 스프링 시큐리티 설정을 활성화함
public class SecurityConfig {
    // 생성자를 통한 의존성 주입으로, 필요한 서비스와 설정을 초기화함
    private final AuthenticationConfiguration authenticationConfiguration;
    private final RefreshTokenService refreshTokenService;
    private final MemberService memberService;
    private final JWTUtil jwtUtil;


    //생성자를 통한 의존성 주입으로, 필요한 서비스와 설정을 초기화함
    public SecurityConfig(AuthenticationConfiguration authenticationConfiguration, JWTUtil jwtUtil, MemberService memberService, RefreshTokenService refreshTokenService) {
        this.authenticationConfiguration = authenticationConfiguration;
        this.jwtUtil = jwtUtil;
        this.memberService = memberService;
        this.refreshTokenService = refreshTokenService;
    }

    // 인증(Authentication) 관리자를 스프링 컨테이너에 Bean으로 등록함. 인증 과정에서 중요한 클래스임
    @Bean
    public AuthenticationManager getAuthenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // HTTP 관련 보안 설정을 정의함
    // SecurityFilterChain을 Bean으로 등록하고, HTTP 요청에 대한 보안을 구성함
    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) //form login, http basic 인증 비활성화
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/notices").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/notices").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/notices").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/boards").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/boards").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/boards").hasAnyRole("USER", "ADMIN")
                        //회원서비스의 마이페이지(GET), 내정보 수정(PUT), 탈퇴(DELETE) 로그인해야 접근
                        .requestMatchers("/api/auth/login", "reissue", "/notices/**", "/boards/**", "/logout").permitAll()
                        .anyRequest().authenticated())
                //토큰 처리 : JWTFilter와 LoginFilter를 필터 체인에 등록
                //security config 앞에 실행
                .addFilterBefore(new JWTFilter(jwtUtil), LoginFilter.class)
                .addFilterAt(new LoginFilter(getAuthenticationManager(authenticationConfiguration), memberService, refreshTokenService, jwtUtil)
                        , UsernamePasswordAuthenticationFilter.class)
                .logout(logout -> logout
                        .addLogoutHandler(new CustomLogoutHandler(jwtUtil, refreshTokenService, memberService))
                        .logoutSuccessHandler((request, response, authentication) -> {
                            response.setStatus(HttpServletResponse.SC_OK);
                        }))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }
}