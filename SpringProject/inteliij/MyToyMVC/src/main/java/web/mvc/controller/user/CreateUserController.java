package web.mvc.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.mvc.domain.User;
import web.mvc.service.user.CreateUserService;

import java.sql.Date;
import java.time.LocalDate;

@Controller
@RequestMapping("/create")
public class CreateUserController {
    // Main.jsp 에서는 href = /create 로 지정

    // CreateUserService interface 인스턴스 변수 정의
    private final CreateUserService createUserService;

    // CreateUserService interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public CreateUserController(CreateUserService createUserService) {
        this.createUserService = createUserService;
    }

    // get
    @GetMapping
    public String getCreate() {
        return "/CreateUser";
    }

    // post
    @PostMapping
    public String postCreate(@ModelAttribute User user) {
        user.setPasswordChangeInterval(30);
        user.setLast_password_change(Date.valueOf(LocalDate.now()));
        user.setVerified(true);
        // createUserService 호출 값 전달
        createUserService.createUser(user);
        return "redirect:/";
    }
}
