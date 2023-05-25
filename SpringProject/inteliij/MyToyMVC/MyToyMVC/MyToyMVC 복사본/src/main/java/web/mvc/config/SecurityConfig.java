package web.mvc.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import web.mvc.controller.auth.CustomAuthenticationSuccessHandler;
import web.mvc.service.auth.CustomAuthenticationProvider;

@Log4j2
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // Spring Security 설정을 위한 클래스

    // CustomAuthenticationSuccessHandler, CustomAuthenticationProvider 인스턴스 변수 정의
    private final CustomAuthenticationSuccessHandler successHandler;
    private final CustomAuthenticationProvider authenticationProvider;

    // CustomAuthenticationSuccessHandler, CustomAuthenticationProvider 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public SecurityConfig(CustomAuthenticationSuccessHandler successHandler, CustomAuthenticationProvider authenticationProvider) {
        this.successHandler =successHandler;
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        log.info("HttpSecurityIsOk");
        httpSecurity
            .csrf().disable()                           // CSRF(Cross-Site Request Forgery) 보호 비활성화
            .authorizeRequests()
                    .antMatchers("/", "/custom-login", "/logout", "/CreateUser",
                    "/forgotPassword", "/waiting", "/create", "/resendCode", "/send-temp-password",
                     "/sendTempPassword", "/boardList", "BoardList", "/BoardRead", "/boardRead",
                     "/boardContact", "/BoardContent")
            .permitAll()                                // 접근 허용할 URL 패턴 설정
                    .anyRequest().authenticated()       // 나머지 요청은 인증된 사용자만 접근 가능
            .and()
            .formLogin().successHandler(successHandler) // 로그인 성공 시 처리를 담당하는 커스텀 핸들러
                .loginPage("/custom-login")             // 커스텀 로그인 페이지 경로
                .usernameParameter("id")                // 사용자 아이디 파라미터명
                .passwordParameter("password")          // 사용자 비밀번호 파라미터명
            .and()
                .rememberMe()                           // Remember Me 기능 활성화
            .and()
            .logout()
                    .logoutSuccessUrl("/")              // 로그아웃 성공 후 Main
            .and()
            .headers()
                    .cacheControl().disable();          // 캐시 제어 헤더 설정 비활성화
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);    // 커스텀 인증 프로바이더 설정
    }

}
