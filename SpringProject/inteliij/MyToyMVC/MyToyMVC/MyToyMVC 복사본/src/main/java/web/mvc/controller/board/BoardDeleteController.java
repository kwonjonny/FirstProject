package web.mvc.controller.board;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.mvc.service.board.BoardDeleteService;

@Log4j2
@Controller
@RequestMapping("/boardDelete")
public class BoardDeleteController {

    // BoardDeleteService interface 인스턴스 변수 정의
    private final BoardDeleteService boardDeleteService;

    // BoardDeleteService interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public BoardDeleteController(BoardDeleteService boardDeleteService) {
        this.boardDeleteService = boardDeleteService;
    }

    // Post
    @DeleteMapping("/{bno}")
    public String postBoardDelete(@RequestParam("user_id") String user_id, @RequestParam("bno") int bno) {
        boardDeleteService.deleteBoard(user_id, bno);

        return "redirect:/boardList";
    }
}
