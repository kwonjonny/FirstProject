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
@RequestMapping("/forgotPassword")
public class ForgotPasswordController {

    private final EmailServiceForgot emailServiceForgot;

    @Autowired
    public ForgotPasswordController(EmailServiceForgot emailServiceForgot) {
        this.emailServiceForgot = emailServiceForgot;
    }

    @GetMapping
    public String getForgotPassword() {
        log.info("isOkGetForgotPassword");
        return "ForgotPassword";
    }

    @PostMapping
    public String postForgotPassword(HttpServletRequest request) throws Exception {
        log.info("isOkPostForgotPassword");
        String email = request.getParameter("email");

        User user = emailServiceForgot.findByEmail(email);
        if (user == null) {
            log.info("User 정보가 없음");
            // 유저 정보가 없는 경우에 대한 처리
            return "redirect:/";
        } else if (user.getStatus() == null) {
            log.info("User의 Status가 null");
            // 유저의 status가 null인 경우에 대한 처리
            return "redirect:/";
        } else if (user.getStatus().trim().equals("ACTIVE")) {
            log.info("Status = 활성화 유저");
            log.info(user.getStatus());
            // 활성화 된 유저에 대한 처리
        } return "loginUser";
    }
}

