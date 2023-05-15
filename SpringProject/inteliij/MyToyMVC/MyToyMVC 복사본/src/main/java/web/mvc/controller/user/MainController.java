package web.mvc.controller.user;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class MainController {

    // MainController get
    @RequestMapping("/")
    public String getMain() throws Exception {
        log.info("isOkMain");
        return "Main";
    }

}
