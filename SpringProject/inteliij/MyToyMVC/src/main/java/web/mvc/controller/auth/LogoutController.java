package web.mvc.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    // get
    @RequestMapping(method = RequestMethod.POST)
    public String postLogout() {
        return "redirect:/Main";
    }
}
