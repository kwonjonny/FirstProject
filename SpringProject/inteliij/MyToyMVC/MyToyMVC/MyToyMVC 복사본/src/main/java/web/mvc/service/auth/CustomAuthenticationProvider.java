package web.mvc.service.auth;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import web.mvc.domain.User;
import web.mvc.service.login.LoginService;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    // LoginService interface 인스턴스 변수 정의
    private final LoginService loginService;
    private  UserDetailsService userDetailsService;


    // LoginService interface 인스턴스 변수 초기화 매개변수로 받는 생성자 정의
    @Autowired
    public CustomAuthenticationProvider(LoginService loginService) {
        this.loginService = loginService;
    }

    // 인증 메소드
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("authenticateIsOk");

        // 아이디와 패스워드 가져온다
        String id = authentication.getName();
        String password = authentication.getCredentials().toString();

        // 아이디와 패스워드 로그 찍기
        log.info("Authentication 메소드  id: " + id + ", Password: " + password);

        // 로그인 서비스 호출 값 전달
        User user;
        try {
            log.info("로그인 SERVICE CALLING SUCCESS");
            user = loginService.login(id, password);
            log.info("로그인 SERVICE RETURN 값 : " + user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // User 가 있을때 없을때
        if (user == null) {
            log.info("유저의 정보가 없다 BadCredentialsException Calling");
            throw new BadCredentialsException("유저의 정보가 없다");
        } else {
            log.info("유저의 정보가 있다");
        }

        // User 가 활성화일때 비활성화일때
        if(user.getStatus().equals("INACTIVE")) {
            log.info(user.getStatus().equals("INACTIVE"));
            throw new BadCredentialsException("비활성화 된 유저이다");
        } else {
            log.info("활성화 된 유저이다");
        }

        // 인증 성공 시 사용자에게 부여할 권한을 설정
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        log.info("권한 부여 --->>>>>>>> " + authorities);
        return new UsernamePasswordAuthenticationToken(user, password, authorities);

    }

    @Override
    public boolean supports(Class<?> authentication) {
        log.info("CREATE USER AUTHENTICATION TOKEN");
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
