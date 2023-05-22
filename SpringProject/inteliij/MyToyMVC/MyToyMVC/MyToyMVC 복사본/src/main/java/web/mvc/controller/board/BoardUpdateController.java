package web.mvc.controller.board;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import web.mvc.domain.TblBoard;
import web.mvc.service.board.BoardListService;
import web.mvc.service.board.BoardUpdateService;

@Log4j2
@Controller
@RequestMapping("/boardUpdate")
public class BoardUpdateController {

    // BoardListService interface 인스턴스 변수 정의
    private final BoardListService boardListService;
    // BoardUpdateService interface 인스턴스 변수 정의
    private final BoardUpdateService boardUpdateService;

    // BoardListService, BoardUpdateService interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public BoardUpdateController(BoardListService boardListService, BoardUpdateService boardUpdateService) {
        this.boardListService = boardListService;
        this.boardUpdateService = boardUpdateService;
    }

    // get
    @GetMapping
    public ModelAndView getBoardUpdate(@PathVariable("bno") int bno) {
        ModelAndView modelAndView = new ModelAndView();
        boardListService.listBoard();
        modelAndView.setViewName("redirect:BoardUpdate");
    }

    // post
    @PostMapping
    public String PostBoardUpdate() {
        return "redirect:/boardList";
    }

}
