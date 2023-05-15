package web.mvc.controller.auth;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.mvc.domain.User;
import web.mvc.service.auth.LoginService;
import web.mvc.service.auth.PasswordRequiredService;
import web.mvc.util.session.ManagementSession;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Controller
@RequestMapping("/login")
public class LoginController {
    // Main.jsp 에서는 href = /login 로 지정

    // LoginService interface 인스턴스 변수 정의
    private final LoginService loginService;
    private final PasswordRequiredService passwordRequiredService;

    // LoginService interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public LoginController(LoginService loginService, PasswordRequiredService passwordRequiredService) {
        this.loginService = loginService;
        this.passwordRequiredService = passwordRequiredService;
    }

    // get
    @GetMapping
    public String getLogin() {
        log.info("isOkGetLogin");
        return "/loginUser";
    }
}
//
//    // post
//    @PostMapping
//    public String postLogin(@RequestParam String id, @RequestParam String password, HttpServletRequest request) throws Exception {
//        log.info("isOkPostLogin");
//
//        User user = loginService.login(id,password);
//        if(user != null) {
//            ManagementSession.setSession(request, user);
//            // 패스 워드 변경 3개월 지났는지 체크
//            boolean isPasswordChangeRequired = passwordRequiredService.isPasswordChangeRequired(user.getId());
//
//            if (isPasswordChangeRequired) {
//                log.info("isNotOkPasswordRequired");
//                request.getSession().setAttribute("warning", "password 변경한지 3개월이 지났습니다 업데이트 바랍니다");
//                return "redirect:/"; // main 에서 warning 메시지 전달
//            }
//
//        } return "redirect:/";
//    }
//}
