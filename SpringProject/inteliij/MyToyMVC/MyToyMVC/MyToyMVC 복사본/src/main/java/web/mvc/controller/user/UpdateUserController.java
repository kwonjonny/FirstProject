package web.mvc.controller.user;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.mvc.domain.User;
import web.mvc.service.user.UpdateUserService;
import web.mvc.util.session.ManagementSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;

@Log4j2
@Controller
@RequestMapping("/update")
public class UpdateUserController {
    // Main.jsp 에서는 href = /update 로 지정

    // UpdateUserService interface 인스턴스 변수 정의
    private final UpdateUserService updateUserService;

    // UpdateUserService interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public UpdateUserController(UpdateUserService updateUserService) {
        this.updateUserService = updateUserService;
    }

    // get
    @GetMapping
    public String getUpdate(Model model) {
        log.info("isOkGetUpdate");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            User user = (User) authentication.getPrincipal();
            model.addAttribute("user", user);
            return "UpdateUser";
        } else {
            return "redirect:/";
        }
    }

    // post
    @PostMapping
    public String postUpdate(@ModelAttribute User user, HttpServletRequest request) throws Exception {
        log.info("isOkPostUpdate");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {

            user.setPasswordChangeInterval(30);
            user.setLast_password_change(Date.valueOf(LocalDate.now()));
            user.setVerified(true);
            user.setStatus("ACTIVE");

            // updateUserService 호출 값 전달
            updateUserService.updateUser(user);

            HttpSession session = request.getSession(false);
            if (session != null) {
                session.setAttribute("user", user);
            }
        }  return "redirect:/";
    }
}
