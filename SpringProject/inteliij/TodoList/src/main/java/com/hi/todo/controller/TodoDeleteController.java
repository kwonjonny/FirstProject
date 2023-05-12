package com.hi.todo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
@RequestMapping("todo/delete")
public class TodoDeleteController {

    // 삭제 번호 받고 -> 삭제 /todo/list
    @RequestMapping(method = RequestMethod.GET)
    public String deleteTodo(@RequestParam("tno") String tno) {
        log.info("/todo/delete");
        log.info("삭제 요청 번호" + tno);

        return "redirect:/todo/list";
    }
}
