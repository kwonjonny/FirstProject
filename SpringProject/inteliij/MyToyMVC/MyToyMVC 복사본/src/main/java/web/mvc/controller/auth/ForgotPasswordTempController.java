package web.mvc.controller.auth;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.mvc.domain.User;
import web.mvc.service.email.EmailServiceForgot;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Controller
@RequestMapping("/send-temp-password")
public class ForgotPasswordTempController {

    private final EmailServiceForgot emailServiceForgot;

    @Autowired
    public ForgotPasswordTempController(EmailServiceForgot emailServiceForgot) {
        this.emailServiceForgot = emailServiceForgot;
    }

    @GetMapping
    public String getForgotPasswordTemp() {
        log.info("getForgotPasswordTempIsOk");
        return "sendTempPassword";
    }

    @PostMapping
    public String postForgotPasswordTemp(HttpServletRequest request) throws Exception {
        log.info("postForgotPasswordTempIsOk");
        String email = request.getParameter("email");
        User user = emailServiceForgot.findByEmailTempPassword(email);
        if (user != null) {
            return "loginUser";
        }
        return "redirect:/";
    }
}
