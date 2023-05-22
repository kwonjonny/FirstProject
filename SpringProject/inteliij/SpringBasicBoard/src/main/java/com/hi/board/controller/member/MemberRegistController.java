package com.hi.board.controller.member;

import com.hi.board.domain.member.MemberRegistRequest;
import com.hi.board.service.member.MemberRegistService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Controller
@RequestMapping("/member/regist")
public class MemberRegistController {

    private final MemberRegistService memberRegistService;

    public MemberRegistController(MemberRegistService memberRegistService) {
        this.memberRegistService = memberRegistService;
    }

    @GetMapping
    public void getRegistForm() {



        log.info("GET /member/regist");

    }

    @PostMapping
    public String regist(MemberRegistRequest registRequest, HttpServletRequest request) {

        log.info("registReuqest : " +registRequest);

        memberRegistService.registMember(registRequest, request);

        return "redirect:/login";
    }


}
