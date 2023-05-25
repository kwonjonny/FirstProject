package web.mvc.controller.login;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Log4j2
@Controller
@RequestMapping("/logout")
public class LogoutController {

    // post
    @PostMapping
    public String postLogout(HttpServletRequest request) throws Exception {
        log.info("isOkPostLogout");
        // 인증된 정보 가져옴
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            HttpSession session = request.getSession(false);
            // session = null 이 아니라면 session 삭제
            if (session != null) {
                session.invalidate();
            }
            // 인증정보 삭제 => null
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/";
    }
}