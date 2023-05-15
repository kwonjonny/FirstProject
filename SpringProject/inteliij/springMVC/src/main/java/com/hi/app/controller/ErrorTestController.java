package com.hi.app.controller;

import org.springframework.stereotype.Controller;

@Controller
public class ErrorTestController {

    public String getError() {
        String str = null;
        str.toString();

        return "index";
    }
}
