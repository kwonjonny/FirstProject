package com.hi.board.controller;


import com.hi.board.domain.BoardListPage;
import com.hi.board.domain.BoardSearchOption;
import com.hi.board.service.BoardListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@RequestMapping("/board/list")
public class BoardListController {

    private final BoardListService boardListService;

    @Autowired
    public BoardListController(BoardListService boardListService) {
        this.boardListService = boardListService;
    }

    @GetMapping
    public void boardList(@RequestParam(value = "p", defaultValue = "1") int pageNum, Model model
    , @RequestParam(value="searchType", defaultValue = "") String searchType,
                          @RequestParam(value = "keyword", defaultValue = "") String keyword,
                          BoardSearchOption searchOption) {

        log.info("/board/list");

        BoardListPage page = boardListService.getPage(pageNum, searchOption);

        searchOption = BoardSearchOption.builder().searchType(keyword.trim().length()<1?null : searchType)
                .keyword(keyword.trim().length()<1?null : keyword).build();

        log.info(page);

        model.addAttribute("list", boardListService.getBoardList());
        model.addAttribute("page", page);
        boardListService.getBoardList();



    }
}
