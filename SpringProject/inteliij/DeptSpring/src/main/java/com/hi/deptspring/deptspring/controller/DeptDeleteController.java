package com.hi.deptspring.deptspring.controller;

import com.hi.deptspring.deptspring.service.DeptDeleteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@RequestMapping
public class DeptDeleteController {

    private final DeptDeleteService deptDeleteService;

    @Autowired
    public DeptDeleteController(DeptDeleteService deptDeleteService) {
        this.deptDeleteService = deptDeleteService;
    }

    @RequestMapping("/dept/delete")
    public String delete(@RequestParam("no") int deptno) {
        log.info(" /dept/delete");

        deptDeleteService.deleteDept(deptno);

        log.info(deptno + "번 부서 삭제 함 님 리다이렉트 리스트");

        return "redirect:/dept/list";
    }
}
