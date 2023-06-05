package com.hi.board.controller.member;

import com.hi.board.service.member.MemberIdCheckService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@Controller
public class IdCheckController {

    private final MemberIdCheckService memberIdCheckService;

    @Autowired
    public IdCheckController(MemberIdCheckService memberIdCheckService) {
        this.memberIdCheckService = memberIdCheckService;
    }

    @ResponseBody
    @RequestMapping("/member/idcheck")
    public String idCheck(@RequestParam("uid") String uid){
        return memberIdCheckService.idCheck(uid);
    }

}
