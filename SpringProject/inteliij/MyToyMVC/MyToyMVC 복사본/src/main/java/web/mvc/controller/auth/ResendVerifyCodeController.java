package web.mvc.controller.auth;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.mvc.domain.User;
import web.mvc.service.email.EmailServiceVerifyCode;
import web.mvc.service.user.CreateUserService;
import web.mvc.util.session.ManagementSession;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Controller
@RequestMapping("/resendCode")
public class ResendVerifyCodeController {

    private final CreateUserService createUserService;
    private final EmailServiceVerifyCode emailServiceVerifyCode;

    @Autowired
    public ResendVerifyCodeController(CreateUserService createUserService, EmailServiceVerifyCode emailServiceVerifyCode) {
        this.createUserService = createUserService;
        this.emailServiceVerifyCode = emailServiceVerifyCode;
    }

    @PostMapping
    public String postResendCode(HttpServletRequest request) throws Exception {
        log.info("isOkPostResendCode");
        User user = ManagementSession.getSessionUser(request);

        int newAuthCode = emailServiceVerifyCode.sendEmailVerifyCode(user);
        ManagementSession.setSessionAuthCode(request, newAuthCode);

        return "redirect:/waiting";
    }
}
