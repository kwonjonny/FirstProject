package com.hi.board.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j2
public class AuthCheckInterceptor implements HandlerInterceptor  {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        // 세션의 속성 "loginInfo" 속성 존재 유무에 따라
        HttpSession session = request.getSession();

        if(session.getAttribute("loginInfo") != null) {
            log.info("회원 로그인 체크 : 로그인 상태 ");
            return true;
        }

        // 있다면 return true


        // 없다면 /login 리디렉션 처리

        log.info("회원 로그인 체크 : 비 로그인 상태");
        response.sendRedirect("/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
