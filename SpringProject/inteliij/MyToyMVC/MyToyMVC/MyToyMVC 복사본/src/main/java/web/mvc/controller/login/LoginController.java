package web.mvc.controller.login;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
@RequestMapping("/custom-login")
public class LoginController {
    // Main.jsp 에서는 href = /login 로 지정

    // get
    @GetMapping
    public String getLogin() {
        log.info("isOkGetLogin");
        return "loginUser";
    }
}

