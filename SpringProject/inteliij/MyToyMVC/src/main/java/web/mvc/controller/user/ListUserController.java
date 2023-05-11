package web.mvc.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.mvc.service.user.ListUserService;

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

    // post
    // Session 을 통해 데이터를 전달받으므로 RequestParam
    @PostMapping
    public String postList(@RequestParam("id") String id) {
        // listUserService 호출 값 전달
        listUserService.readUser(id);
        return "ListUser";
    }

}
