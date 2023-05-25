package web.mvc.controller.board;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.mvc.domain.TblBoard;
import web.mvc.domain.User;
import web.mvc.service.board.BoardListService;

import java.util.List;

@Log4j2
@Controller
@RequestMapping("/boardList")
public class BoardListController {

    // BoardListService interface 인스턴스 변수 정의
    private final BoardListService boardListService;

    // BoardListService interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public BoardListController(BoardListService boardListService) {
        this.boardListService = boardListService;
    }

    // get
    @GetMapping
    public String getBoardList(Model model, Authentication authentication) {
        log.info("isOkGetBoardList");


        authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if(principal instanceof User) {
            User user = (User) principal;
            String currentUserId = user.getId();
            model.addAttribute("currentUserId", currentUserId);
        }

        List<TblBoard> boardList =  boardListService.listBoard();
        model.addAttribute("boardList", boardList);

        return "BoardList";
    }
}