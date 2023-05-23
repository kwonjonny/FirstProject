package web.mvc.controller.board;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.mvc.domain.TblBoard;
import web.mvc.domain.TblBoardUpdateBoardDTO;
import web.mvc.domain.User;
import web.mvc.service.board.BoardListService;
import web.mvc.service.board.BoardUpdateListBoardService;
import web.mvc.service.board.BoardUpdateService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Log4j2
@Controller
@RequestMapping("/boardUpdate")
public class BoardUpdateController {

    // BoardListService interface 인스턴스 변수 정의
    private final BoardUpdateService boardUpdateService;
    // BoardUpdateListService interface 인스턴스 변수 정의
    private final BoardUpdateListBoardService boardUpdateListBoardService;

    // BoardListService, BoardUpdateService interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public BoardUpdateController(BoardUpdateService boardUpdateService, BoardUpdateListBoardService boardUpdateListBoardService) {
        this.boardUpdateService = boardUpdateService;
        this.boardUpdateListBoardService = boardUpdateListBoardService;
    }

    // get
    @GetMapping
    public String getBoardUpdate(Authentication authentication, @RequestParam("bno") int bno, Model model) {
        log.info("isOkGetBoardUpdate");
        String userId = ((User) authentication.getPrincipal()).getId();

        if(authentication.isAuthenticated()) {
           model.addAttribute("board", boardUpdateListBoardService.updateListBoard(userId, bno));

            return "BoardUpdate";
        }
        return "BoardList";
    }

    // post
    @PostMapping
    public String PostBoardUpdate(Authentication authentication, @ModelAttribute TblBoardUpdateBoardDTO tblBoardUpdateBoardDTO) {
        log.info("isOkPostBoardUpdate");

        // 인증 토큰 객체 가져오기
        User currentUser = (User) authentication.getPrincipal();

        if(authentication.isAuthenticated()) {
            TblBoardUpdateBoardDTO newPost = new TblBoardUpdateBoardDTO();
            newPost.setUser_id(currentUser.getId());
            newPost.setTitle(tblBoardUpdateBoardDTO.getTitle());
            newPost.setContent(tblBoardUpdateBoardDTO.getContent());

            log.info("newPost 값 : " + newPost);

            boardUpdateService.updateBoard(newPost);
        }
        return "redirect:/boardList";
    }
}
