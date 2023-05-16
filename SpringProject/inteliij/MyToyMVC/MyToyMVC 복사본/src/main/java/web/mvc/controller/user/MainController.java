package web.mvc.controller.user;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
public class MainController {

    // MainController get
    @RequestMapping("/")
    public String getMain() throws Exception {
        log.info("isOkGetMain");
        return "Main";
    }

}
