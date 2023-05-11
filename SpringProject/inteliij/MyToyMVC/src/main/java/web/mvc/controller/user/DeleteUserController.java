package web.mvc.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.mvc.service.user.DeleteUserService;

@Controller
@RequestMapping("/delete")
public class DeleteUserController {
    // Main.jsp 에서는 href = /delete 로 지정

    // DeleteService interface 인스턴스 변수 정의
    private final DeleteUserService deleteUserService;

    // DeleteUserService interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public DeleteUserController(DeleteUserService deleteUserService) {
        this.deleteUserService = deleteUserService;
    }

    // post
    // Session 을 통해 데이터를 전달받으므로 RequestParam
    @PostMapping
    public String postDelete(@RequestParam("id") String id) {
        // deleteUserService 호출 값 전달
        deleteUserService.deleteUser(id);
        return "redirect:/";
    }

}
