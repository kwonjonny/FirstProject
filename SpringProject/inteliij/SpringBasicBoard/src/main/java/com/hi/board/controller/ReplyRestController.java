package com.hi.board.controller;

import com.hi.board.domain.ReplyDTO;
import com.hi.board.service.ReplyInsertService;
import com.hi.board.service.ReplyReadService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Log4j2
@RequestMapping("/board/reply")
@RestController
public class ReplyRestController {

    private final ReplyInsertService replyInsertService;
    private final ReplyReadService replyReadService;

    @DeleteMapping("/{rno}")
    public ResponseEntity<String> deleteReply(@PathVariable("rno") int rno) {


        return new ResponseEntity<>("sucess", HttpStatus.OK);
    }

    @Autowired
    public ReplyRestController(ReplyInsertService replyInsertService, ReplyReadService replyReadService) {
        this.replyInsertService = replyInsertService;
        this.replyReadService = replyReadService;
    }

    @PostMapping
    public ResponseEntity<ReplyDTO> insertReply(
            @RequestBody ReplyDTO replyDTO
    ){

        log.info("replyDTO insert 전"+ replyDTO);
        replyInsertService.insertReply(replyDTO);
        log.info("replyDTO insert 후 : " + replyDTO);
        // rno

        ReplyDTO result = replyReadService.getReply(replyDTO.getRno());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
