package web.mvc.controller.board;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.mvc.domain.TblBoard;
import web.mvc.domain.User;
import web.mvc.service.board.BoardCreateService;

import java.sql.Date;
import java.time.LocalDate;

@Log4j2
@Controller
@RequestMapping("/boardCreate")
public class BoardCreateController {
    // boardList.jsp 에서는 /board/create 로 지정

    // BoardCreateService interface 인스턴스 변수 정의
    private final BoardCreateService boardCreateService;

    // BoardCreateService interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public BoardCreateController(BoardCreateService boardCreateService) {
        this.boardCreateService = boardCreateService;
    }

    // get
    @GetMapping
    public String getCreateBoard() {
        log.info("isOkCreateBoard");
        return "BoardCreate";
    }

    // post
    @PostMapping
    public String postCreateBoard(TblBoard tblBoard) {
        log.info("isOkPostCreateBoard");

        // 인증 토큰 객체 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();

        if (authentication.isAuthenticated()) {

            TblBoard newPost = new TblBoard();
            newPost.setUser_id(currentUser.getId());
            newPost.setTitle(tblBoard.getTitle());
            newPost.setContent(tblBoard.getContent());
            newPost.setRegdate(Date.valueOf(LocalDate.now()));
            newPost.setUpdatedate(Date.valueOf(LocalDate.now()));

            log.info("newPost 값 : " + newPost);

            boardCreateService.createBoard(newPost);
        }
        return "redirect:/boardList";
    }
}