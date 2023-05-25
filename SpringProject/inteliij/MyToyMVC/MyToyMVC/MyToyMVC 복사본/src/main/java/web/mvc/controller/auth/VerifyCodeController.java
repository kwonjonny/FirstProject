package web.mvc.controller.auth;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.mvc.domain.User;
import web.mvc.service.user.CreateUserService;
import web.mvc.util.session.ManagementSession;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalDate;

@Log4j2
@Controller
@RequestMapping("/waiting")
public class VerifyCodeController {

    private final CreateUserService createUserService;

    @Autowired
    public VerifyCodeController(CreateUserService createUserService) {
        this.createUserService = createUserService;
    }

    @GetMapping
    public String getWaiting() {
        log.info("isOkGetWaiting");
        return "waiting";
    }

    @PostMapping
    public String postWaiting(HttpServletRequest request) throws Exception {
        log.info("isOkPostWaiting");
        String authCode = request.getParameter("authCode");
        int inputAuthCode = Integer.parseInt(authCode);

        User user = ManagementSession.getSessionUser(request);
        if (user != null) {
            user.setPasswordChangeInterval(30);
            user.setLast_password_change(Date.valueOf(LocalDate.now()));  // 정상 로직
//          user.setLast_password_change(Date.valueOf(LocalDate.now().minusMonths(3))); // 테스트 로직 -3개월
            user.setVerified(true);
            user.setStatus("ACTIVE");

            int storedAuthCode = ManagementSession.getSessionAuthCode(request);
            if (inputAuthCode == storedAuthCode) {
                createUserService.createUser(user);
                ManagementSession.setSessionUser(request, user);
                ManagementSession.removeSessionAuthCode(request);
                return "redirect:/";
            }
        }
        return "waiting";
    }
}