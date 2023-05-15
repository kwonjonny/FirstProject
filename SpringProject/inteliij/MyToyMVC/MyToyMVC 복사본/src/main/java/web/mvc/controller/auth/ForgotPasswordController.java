package web.mvc.controller.auth;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.mvc.domain.User;
import web.mvc.service.email.EmailService;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Controller
@RequestMapping("/forgotPassword")
public class ForgotPasswordController {

    private final EmailService emailService;

    @Autowired
    public ForgotPasswordController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public String getForgotPassword() {
        log.info("isOkGetForgotPassword");
        return "/ForgotPassword";
    }

    @PostMapping
    public String postForgotPassword(HttpServletRequest request) throws Exception {
        log.info("isOkPostForgotPassword");
        String email = request.getParameter("email");
        User user = emailService.findByEmail(email);
        if (user != null) {
            return "/loginUser";
        }
        return "redirect:/";
    }
}

