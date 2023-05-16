package com.hi.deptspring.deptspring.controller;

import com.hi.deptspring.deptspring.service.DeptListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
public class DeptListController {

    private final DeptListService listService;

    @Autowired
    public DeptListController(DeptListService listService) {
        this.listService = listService;
    }

    @RequestMapping("/dept/list")
    public void getListPage(Model model) {
        log.info("GET /dept/list");
        model.addAttribute("list", listService.getList());
    }
}
