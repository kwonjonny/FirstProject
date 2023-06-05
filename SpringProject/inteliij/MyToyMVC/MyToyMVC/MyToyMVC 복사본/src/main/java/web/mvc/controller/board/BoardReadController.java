package web.mvc.controller.board;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.mvc.domain.User;
import web.mvc.service.board.BoardReadService;

@Log4j2
@Controller
@RequestMapping("/boardRead")
public class BoardReadController {

    // BoardReadService interface 인스턴스 변수 정의
    private final BoardReadService boardReadService;

    // BoardReadService interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public BoardReadController(BoardReadService boardReadService) {
        this.boardReadService = boardReadService;
    }

    // get
    @GetMapping
    public String getBoardRead(@RequestParam("bno") int bno, Model model, Authentication authentication) throws Exception {
        // 로그 출력
        log.info("isOkGetBoardRead");

        // model 객체에 "article" 으로 jsp 에 전달하고 boardReadService 호출 값 전달
        model.addAttribute("article", boardReadService.selectByBno(bno));

        // 유저의 인증 객체 가져온다
        // 만약 유저가 로그인 했을시에 user 의 인증 토큰 객체를 model 에 currentUserId 로 저장하여 jsp 에 전달 
        authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if(principal instanceof User) {
            User user = (User) principal;
            String currentUserId = user.getId();
            model.addAttribute("currentUserId", currentUserId);
        }
        return "BoardReadPage";
    }
}
