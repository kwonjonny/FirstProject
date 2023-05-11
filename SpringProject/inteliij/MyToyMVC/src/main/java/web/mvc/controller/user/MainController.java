package web.mvc.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    // MainController get
    @RequestMapping("/")
    public String getMain() {
        return "Main";
    }

}
