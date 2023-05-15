package com.hi.app.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@Log4j2
@ControllerAdvice
public class CommonExceptionAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody   // 응답하는 문자열 그대로 응답으로 사용
    public String exception(Exception e) {

        StringBuffer sb = new StringBuffer();
        sb.append("<h1>" + e.getMessage() +"</h1>");
        sb.append("<hr>");

        log.info(e.getMessage());
        StackTraceElement[] stackTraceElements = e.getStackTrace();
        for( StackTraceElement element : stackTraceElements) {
            sb.append(element);
        }
        return sb.toString();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound() {
        return "custom404";
    }
}
