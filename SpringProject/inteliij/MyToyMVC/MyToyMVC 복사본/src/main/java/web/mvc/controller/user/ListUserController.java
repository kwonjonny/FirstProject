package web.mvc.controller.user;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.mvc.domain.User;
import web.mvc.service.user.ListUserService;
import web.mvc.util.session.ManagementSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Log4j2
@Controller
@RequestMapping("/list")
public class ListUserController {
    // Main.jsp 에서는 href = /list 로 지정

    // ListUserService interface 인스턴스 변수 정의
    private final ListUserService listUserService;

    // ListUserService interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public ListUserController(ListUserService listUserService) {
        this.listUserService = listUserService;
    }

    @GetMapping
    public String getList(Model model, HttpServletRequest request) throws Exception {
        log.info("isOkGetList");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            User user = (User) authentication.getPrincipal();
            // 인증된 사용자의 처리 로직
            List<User> userList = listUserService.userList();
            model.addAttribute("users", userList);

            // Log the user retrieved from authentication object
            log.info("User retrieved from authentication: " + user);

            return "ListUser";
        } else {
            return "redirect:/";
        }
    }
}
