package web.mvc.util.cookie;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ManagementCookie {

    // default 생성자 정의
    private ManagementCookie(){
    }

    // Singleton Pattern
    private static ManagementCookie managementCookie = new ManagementCookie();

    public static ManagementCookie getInstance() {
        return managementCookie;
    }

    private static final String REMEMBER_ME_COOKIE_NAME = "rememberMe";
    private static final int rememberMeCookieAge = 6 * 30 * 24 * 60 * 60; // 6 개월 생명 주기

    // 쿠키 생성 생명 주기 6개월 and 모든 경로에서 쿠키 유효
    public void createRememberMeCookie(HttpServletResponse httpServletResponse) {
        Cookie rememberMeCookie = new Cookie(REMEMBER_ME_COOKIE_NAME, "true");
        rememberMeCookie.setMaxAge(rememberMeCookieAge);
        rememberMeCookie.setPath("/");
        httpServletResponse.addCookie(rememberMeCookie);
    }

    // 쿠키 삭제 생명주기 0 and 모든 경로에서 쿠키 유효
    public void deleteRememberMeCookie(HttpServletResponse httpServletResponse) {
        Cookie rememberMeCookie = new Cookie(REMEMBER_ME_COOKIE_NAME, null);
        rememberMeCookie.setMaxAge(0);
        rememberMeCookie.setPath("/");
        httpServletResponse.addCookie(rememberMeCookie);
    }

    public boolean isRememberMeRequested(HttpServletRequest httpServletRequest) {
        Cookie [] cookies = httpServletRequest.getCookies();
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                if(REMEMBER_ME_COOKIE_NAME.equals(cookie.getName())  && "true".equals(cookie.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }
}
