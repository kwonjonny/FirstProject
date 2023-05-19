package com.hi.board.controller;

import com.hi.board.domain.RequestRegBoard;
import com.hi.board.service.BoardWriteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Controller
@RequestMapping("/board/write")
public class BoardWriteController {

    private final BoardWriteService boardWriteService;

    @Autowired
    public BoardWriteController(BoardWriteService boardWriteService) {
        this.boardWriteService = boardWriteService;
    }

    @GetMapping
    public void getBoardWrite() {
        log.info("GET /board/write");
    }

    @PostMapping
    public String write(RequestRegBoard requestRegBoard, HttpServletRequest request) {
        log.info("POST /board/write");

        log.info(requestRegBoard);

        boardWriteService.writeBoard(requestRegBoard, request);

        return "redirect:/board/list";
    }
}
