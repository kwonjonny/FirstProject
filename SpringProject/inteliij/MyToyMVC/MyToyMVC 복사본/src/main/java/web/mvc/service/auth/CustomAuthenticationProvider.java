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
import org.springframework.stereotype.Component;
import web.mvc.domain.User;
import web.mvc.service.login.LoginService;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final LoginService loginService;

    @Autowired
    public CustomAuthenticationProvider(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("authenticateIsOk");
        String id = authentication.getName();
        String password = authentication.getCredentials().toString();

        log.info("Authentication 메소드  id: " + id + ", Password: " + password);

        User user;
        try {
            log.info("로그인 SERVICE CALLING SUCCESS");
            user = loginService.login(id, password);
            log.info("로그인 SERVICE RETURN 값 : " + user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (user == null) {
            log.info("유저가 없다 BadCredentialsException Calling");
            throw new BadCredentialsException("유저가 없다");
        }

        // 인증 성공 시 사용자에게 부여할 권한을 설정합니다.
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
