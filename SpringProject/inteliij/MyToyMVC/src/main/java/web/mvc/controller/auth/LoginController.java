package web.mvc.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {
    // Main.jsp 에서는 href = /login 로 지정

    // get
    @RequestMapping(method = RequestMethod.GET)
    public String getLogin() {
        // login service호출
        return "/login";
    }

}
