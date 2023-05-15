package web.mvc.controller.auth;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import web.mvc.domain.User;
import web.mvc.util.session.ManagementSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Log4j2
@Controller
@RequestMapping("/logout")
public class LogoutController {


    @RequestMapping
    public String getLogout(HttpServletRequest request) throws Exception {
        log.info("isOkLogout");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/";
    }
}
