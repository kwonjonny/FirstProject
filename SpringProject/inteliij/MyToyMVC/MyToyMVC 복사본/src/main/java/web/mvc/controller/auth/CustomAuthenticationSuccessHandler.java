package web.mvc.controller.auth;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import web.mvc.domain.User;
import web.mvc.service.auth.LoginService;
import web.mvc.service.auth.PasswordRequiredService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final LoginService loginService;

    private final PasswordRequiredService passwordRequiredService;

    @Autowired
    public CustomAuthenticationSuccessHandler(LoginService loginService, PasswordRequiredService passwordRequiredService) {
        this.loginService = loginService;
        this.passwordRequiredService = passwordRequiredService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("onAuthenticationSuccessIsOk");
        User user = (User) authentication.getPrincipal();

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        // 패스워드 변경 3개월 지났는지 체크
        boolean isPasswordChangeRequired = false;
        try {
            isPasswordChangeRequired = passwordRequiredService.isPasswordChangeRequired(user.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (isPasswordChangeRequired) {
            log.info("isNotOkPasswordRequired");
            session.setAttribute("warning", "password 변경한지 3개월이 지났습니다 업데이트 바랍니다");
        }

        response.sendRedirect("/");
    }
}