package web.mvc.controller.user;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.mvc.domain.User;
import web.mvc.service.user.DeleteUserService;
import web.mvc.util.session.ManagementSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Log4j2
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
    @PostMapping
    public String PostDelete(HttpServletRequest request) throws Exception {
        log.info("isOkPostDelete");

        // SpringSecurity 의 인증 정보 가져옴
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // if 인증정보가 있으면
        if (authentication.isAuthenticated()) {
           User user = (User) authentication.getPrincipal();
            // deleteUserService 호출 값 전달
            boolean isDeleted = deleteUserService.deleteUser(user.getId());
            // if isDeleted = true 이면
            if(isDeleted) {
                // 인증 정보 삭제
                SecurityContextHolder.getContext().setAuthentication(null);
                // 삭제시 Main
                return "redirect:/";
            }
        }
        // 실패시 Main
        return "redirect:/";
    }
}
