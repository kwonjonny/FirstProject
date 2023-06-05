package web.mvc.controller.board;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.mvc.domain.TblBoardUpdateBoardDTO;
import web.mvc.domain.User;
import web.mvc.service.board.BoardReadService;
import web.mvc.service.board.BoardUpdateService;

@Log4j2
@Controller
@RequestMapping("/boardUpdate")
public class BoardUpdateController {

    // BoardReadService interface 인스턴스 변수 정의
    // BoardUpdateService interface 인스턴스 변수 정의
    private final BoardReadService boardReadService;
    private final BoardUpdateService boardUpdateService;

    // BoardReadService interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    // BoardUpdateService interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public BoardUpdateController(BoardReadService boardReadService, BoardUpdateService boardUpdateService) {
        this.boardUpdateService = boardUpdateService;
        this.boardReadService = boardReadService;
    }

    // get
    @GetMapping
    public String getBoardUpdate(@RequestParam("bno") int bno, Model model) throws Exception {
        // 로그 출력
        log.info("isOkGetBoardUpdate");
        // model 객체에 "boardUpdate" 으로 jsp 에 전달하고 boardReadService 호출 값 전달
        model.addAttribute("boardUpdate", boardReadService.selectByBno(bno));
        return "BoardUpdatePage";
    }

    // post
    @PostMapping
    public String postBoardUpdate(@ModelAttribute TblBoardUpdateBoardDTO tblBoardUpdateBoardDTO,
                                  Authentication authentication) throws Exception {
        // 로그 출력
        log.info("isOkPostBoardUpdate");

        // 인증 토큰 객체 가져오기
        User currentUser = (User) authentication.getPrincipal();

        // 만약 인증이 되었을시에는 user 의 id를 가져와 값을 넣어준다
        if(authentication.isAuthenticated()) {
            TblBoardUpdateBoardDTO newPost = new TblBoardUpdateBoardDTO();

            newPost.setUser_id(currentUser.getId());
            newPost.setBno((tblBoardUpdateBoardDTO.getBno()));
            newPost.setTitle(tblBoardUpdateBoardDTO.getTitle());
            newPost.setContent(tblBoardUpdateBoardDTO.getContent());

            // 로그 출력
            log.info("newPost 값 " + newPost);

            // boardUpdateService 호출 값 전달
            boardUpdateService.updateBoard(newPost);
        }
        return "redirect:/boardList";
    }
}
