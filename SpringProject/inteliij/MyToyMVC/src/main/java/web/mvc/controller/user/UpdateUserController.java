package web.mvc.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.mvc.domain.User;
import web.mvc.service.user.UpdateUserService;

import java.sql.Date;
import java.time.LocalDate;

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
    public String getUpdate() {
        return "/UpdateUser";
    }

    // post
    @PostMapping
    public String postUpdate(@ModelAttribute User user) {
        user.setPasswordChangeInterval(30);
        user.setLast_password_change(Date.valueOf(LocalDate.now()));
        user.setVerified(true);
        // updateUserService 호출 값 전달
        updateUserService.updateUser(user);
        return "redirect:/";
    }
}
