package web.mvc.controller.board;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.mvc.domain.User;
import web.mvc.service.board.BoardDeleteService;

@Log4j2
@Controller
public class BoardDeleteController {

    // BoardDeleteService interface 인스턴스 변수 정의
    private final BoardDeleteService boardDeleteService;

    // BoardDeleteService interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public BoardDeleteController(BoardDeleteService boardDeleteService) {
        this.boardDeleteService = boardDeleteService;
    }

    @RequestMapping(value = "/boardDelete", method = {RequestMethod.GET, RequestMethod.POST})
    public String postBoardDelete(@RequestParam("bno") int bno, Authentication authentication) throws Exception {
        // 로그 출력
        log.info("isOkPostBoardDelete");

        // 인증 토큰 객체 user 의 id 를 가져온다
        String userId = ((User) authentication.getPrincipal()).getId();

        // 만약 인증이 되었을시에는 user 의 id 를 가져와 값을 넣어준다
        if(authentication.isAuthenticated()) {
            // 로그 출력
            log.info("board delete calling", userId, bno);
            // boardDeleteService 호출 값 전달
            boardDeleteService.deleteBoard(userId, bno);
            return "redirect:/boardList";
        }
        return "redirect:/";
    }
}
