package web.mvc.controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.mvc.domain.TblBoard;
import web.mvc.service.board.BoardContentService;

import java.util.List;

@Controller
@RequestMapping("/boardContact")
public class BoardContentController {

    // BoardContentService interface 인스턴스 변수 정의
    private final BoardContentService boardContentService;

    // BoardContentService interface 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public BoardContentController(BoardContentService boardContentService) {
        this.boardContentService = boardContentService;
    }

    @GetMapping
    public String getBoardContact(Model model, @RequestParam("bno") int bno) {
        TblBoard content = boardContentService.boardContent(bno);
        model.addAttribute("content", content);
        return "BoardContent";
    }
}
