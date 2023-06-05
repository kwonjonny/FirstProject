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
import web.mvc.domain.BoardListPage;
import web.mvc.domain.User;
import web.mvc.domain.page.BoardSearchOption;
import web.mvc.service.board.BoardListService;


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
    public String getBoardList(@RequestParam(value = "p", defaultValue = "1") int pageNum,
                               @RequestParam(value = "searchType", defaultValue = "") String searchType,
                               @RequestParam(value = "keyword", defaultValue = "") String keyword,
                               Model model, Authentication authentication) throws Exception {
        // 로그 출력
        log.info("isOkGetBoardList");

        // user 의 인증 토큰 객체 가져온다
        authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        // principal 객체가 user 클래스의 인스턴스인지 확인 하고
        // user 의 id 를 가져온다 있는 경우 모델 객체에 currentUserId 저장
        if(principal instanceof User) {
            User user = (User) principal;
            String currentUserId = user.getId();
            model.addAttribute("currentUserId", currentUserId);
        }

        // builder() 를 사용하여 searchType 과 keyword 값 지정 없는 경우 null
        BoardSearchOption searchOption = BoardSearchOption
                .builder()
                .searchType(keyword.trim().length() <1 ? null : searchType)
                .keyword(keyword.trim().length() <1 ? null : keyword)
                .build();

        // boardListService 호출 값 전달
        BoardListPage page = boardListService.getPage(pageNum, searchOption);

        // model 객체에 page 저장
        model.addAttribute("page", page);

        return "BoardListPage";
    }
}
