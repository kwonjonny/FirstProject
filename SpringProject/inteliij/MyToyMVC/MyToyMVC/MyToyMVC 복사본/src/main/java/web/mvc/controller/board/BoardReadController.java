package web.mvc.controller.board;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.mvc.domain.TblBoard;
import web.mvc.domain.User;
import web.mvc.domain.page.PageOption;
import web.mvc.service.board.BoardReadService;

import java.util.List;

@Log4j2
@Controller
@RequestMapping("/boardRead")
public class BoardReadController {

    // BoardRaedService interface 인스턴스 변수 정의
    private final BoardReadService boardReadService;

    // BoardReadService interface 인스턴스 변수 초기화 매개변수로 받는 생성자
    @Autowired
    public BoardReadController(BoardReadService boardReadService) {
        this.boardReadService = boardReadService;
    }

    @PostMapping
    public String postBoardRead(Model model, @RequestParam(value = "searchType", defaultValue = "") String searchType,
                  @RequestParam(value = "keyword", defaultValue = "") String keyword,
                  Authentication authentication) {
        log.info("isOkPostBoardRead");

        authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        String currentUserId = user.getId();

        PageOption searchOption = PageOption.builder()
                .searchType(keyword.trim().length() < 1 ? null : searchType)
                .keyword(keyword.trim().length() < 1 ? null : keyword)
                .build();

        List<TblBoard> boardList = boardReadService.getBoardList(searchOption);

        model.addAttribute("list", boardList);
        model.addAttribute("currentUserId", currentUserId);
        return "BoardRead";
    }
}