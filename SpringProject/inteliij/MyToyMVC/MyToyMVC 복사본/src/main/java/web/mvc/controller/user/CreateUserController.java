package web.mvc.controller.user;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.mvc.domain.User;
import web.mvc.repository.auth.DuplicateCheckRepository;
import web.mvc.service.email.EmailServiceVerifyCode;
import web.mvc.util.session.ManagementSession;

import javax.servlet.http.HttpServletRequest;


@Log4j2
@Controller
@RequestMapping("/create")
public class CreateUserController {
    // Main.jsp 에서는 href = /create 로 지정

    private final EmailServiceVerifyCode emailServiceVerifyCode;
    private final DuplicateCheckRepository duplicateCheckRepository;

    // CreateUserService interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public CreateUserController(EmailServiceVerifyCode emailServiceVerifyCode, DuplicateCheckRepository duplicateCheckRepository) {
        this.emailServiceVerifyCode = emailServiceVerifyCode;
        this.duplicateCheckRepository = duplicateCheckRepository;
    }

    // get
    @GetMapping
    public String getCreate() {
        log.info("isOkGetCreate");
        return "/CreateUser";
    }

    // post
    @PostMapping
    public String postCreate(@ModelAttribute User user, Model model, HttpServletRequest request) throws Exception {
        log.info("isOkPostCreate");
        boolean isDuplicatedId = duplicateCheckRepository.isDuplicatedId(user.getId());
        boolean isDuplicatedEmail = duplicateCheckRepository.isDuplicatedEmail(user.getEmail());

        if (isDuplicatedEmail || isDuplicatedId) {
            model.addAttribute("error" ,"이미 사용 중인 이메일이거나 아이디 입니다");
            return "/CreateUser";
        }
        user.setVerified(false);
        int authCode = emailServiceVerifyCode.sendEmailVerifyCode(user);
        // session 인증 코드와 USER 정보 저장 - > waiting.jsp로 전달
        ManagementSession.setSession(request, user);
        ManagementSession.setSessionAuthCode(request, authCode);
        // waiting.jsp 에서는 createUserController 정보를 가지고 있다
        // 사용자가 제출시에 verifyCodeController 에서 session 정보를 사용하므로
        // session 을 여기서 삭제하면 안된다

        // redirect waiting.jsp
        return "redirect:/waiting";
    }
}