package com.hi.todo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Log4j2
@RequestMapping("todo/delete")
public class TodoDeleteController {

    // 삭제 번호 받고 -> 삭제 /todo/list
    @RequestMapping(method = RequestMethod.GET)
    public String deleteTodo() {
        log.info("/todo/delete");
        return "redirect:/todo/list";
    }
}
