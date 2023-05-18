package web.mvc.controller.auth;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import web.mvc.domain.User;
import web.mvc.service.login.LoginService;
import web.mvc.service.auth.PasswordRequiredService;

import javax.servlet.FilterChain;
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

        HttpSession session = request.getSession(true);
        // 세션에 사용자 정보 저장
        User user = (User) authentication.getPrincipal();
        session.setAttribute("user", user);
        // 세션 정보 조회
        session = request.getSession(false); // false를 주면, 세션이 존재하지 않을 경우 null을 반환합니다.
        if (session != null) {
            log.info("인증된 세션: " + session.getId() + ", User: " + session.getAttribute("user"));
        } else {
            log.info("세션이 없음");
        }

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