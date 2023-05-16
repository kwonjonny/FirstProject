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

        log.info("id: " + id + ", Password: " + password);

        User user;
        try {
            log.info("Calling loginService.login");
            user = loginService.login(id, password);
            log.info("Returned from loginService.login, user: " + user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (user == null) {
            log.info("User is null, throwing BadCredentialsException");
            throw new BadCredentialsException("Invalid username or password");
        }

        // 인증 성공 시 사용자에게 부여할 권한을 설정합니다. 별도의 권한 관리 로직을 구현해야 합니다.
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        log.info("Creating new UsernamePasswordAuthenticationToken");
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
