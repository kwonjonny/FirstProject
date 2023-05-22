package com.hi.board.controller.member;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Log4j2
@Controller
public class MemberLogoutController {

    @RequestMapping("/logout")
    public String  logout(HttpSession session) {

        session.invalidate();

        log.info("/logout ...");
        
        return "redirect:/login";
    }



}
