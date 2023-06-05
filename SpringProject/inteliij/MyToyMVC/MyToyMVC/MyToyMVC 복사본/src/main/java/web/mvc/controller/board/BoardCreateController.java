package web.mvc.controller.board;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.mvc.domain.TblBoard;
import web.mvc.domain.User;
import web.mvc.service.board.BoardCreateService;

import java.sql.Date;
import java.time.LocalDate;

@Log4j2
@Controller
@RequestMapping("/boardCreate")
public class BoardCreateController {

    // BoardCreateService interface 인스턴스 변수 정의
    private final BoardCreateService boardCreateService;

    // BoardCreateService interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public BoardCreateController(BoardCreateService boardCreateService) {
        this.boardCreateService = boardCreateService;
    }

    // get
    @GetMapping
    public String getBoardCreate() {
        log.info("isOkGetBoardCreate");
        return "BoardCreatePage";
    }

    // post
    @PostMapping
    public String postBoardCreate(@ModelAttribute TblBoard tblBoard,
                                  Authentication authentication) throws Exception {
        // 로그 출력
        log.info("isOkPostBoardCreate");

        // 인증 토큰 객체 가져오기
        User currentUser = (User) authentication.getPrincipal();

        // 만약 인증이 되었을시에는 user 의 id를 가져와 값을 넣어준다
        if(authentication.isAuthenticated()) {
            TblBoard newPost = new TblBoard();
            newPost.setTitle(tblBoard.getTitle());
            newPost.setContent(tblBoard.getContent());
            newPost.setUser_id(currentUser.getId());

            // 로그 출력
            log.info("newPost 값 : " + newPost);

            // boardCreateService 호출 값 전달
            boardCreateService.createBoard(newPost);

        }
        return "redirect:/boardList";
    }
}
