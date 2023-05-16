package com.hi.deptspring.deptspring.controller;

import com.hi.deptspring.deptspring.domain.DeptDTO;
import com.hi.deptspring.deptspring.service.DeptModfiyService;
import com.hi.deptspring.deptspring.service.DeptReadService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@RequestMapping("/dept/modify")
public class DeptModfiyController {

    private final DeptReadService deptReadService;
    private final DeptModfiyService modfiyService;

    @Autowired
    public DeptModfiyController(DeptReadService deptReadService, DeptModfiyService modfiyService) {
        this.deptReadService = deptReadService;
        this.modfiyService = modfiyService;
    }

    @GetMapping
    public String getModfiyForm(@RequestParam("no") int deptno, Model model) {
        log.info("GET /dept/modifiyForm");
        model.addAttribute("dept" , deptReadService.getDept(deptno));

        return "/dept/modifyForm";
    }

    @PostMapping
    public String postModfiyForm(DeptDTO dto) {
        log.info("POST /dept/list");
        log.info(dto);

        // DeptDTO 전달 받고 update 처리 하는 메소드 service 호출 값 전달
        modfiyService.modfiyDept(dto);

        return "redirect:/dept/list";
    }


}
