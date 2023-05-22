package web.mvc.util.session;

import web.mvc.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ManagementSession {

    // default 생성자 private 정의
    private ManagementSession() {
    }

    // AuthCodesetSession: 세션에 인증 코드를 저장하는 메소드
    public static void setSessionAuthCode(HttpServletRequest request, int authCode) {
        HttpSession session = request.getSession();
        session.setAttribute("authCode", authCode);
    }

    // getSessionAuthCode: 세션에 저장된 인증 코드를 가져오는 메소드
    public static int getSessionAuthCode(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Integer authCode = (Integer) session.getAttribute("authCode");
            if (authCode != null) {
                return authCode;
            }
        }
        return -1;
    }

    // removeAuthCode: 세션에서 인증 코드를 제거하는 메소드
    public static void removeAuthCode(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("authCode");
        }
    }

    // setSession: 세션에 User 객체를 저장하는 메소드
    public static void setSession(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
    }

    // getSessionUser: 현재 사용자가 세션에 저장한 User 객체를 가져오는 메소드
    public static User getSessionUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return (User) session.getAttribute("user");
        }
        return null;
    }

    // removeSession: 세션을 삭제하는 메소드
    public static void removeSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

    public static void updateSetSession(HttpServletRequest request, User user) {
        HttpSession session = request.getSession(false); // 이전 세션을 먼저 찾아본다.
        if (session != null) {
            session.invalidate(); // 이전 세션을 삭제한다.
        }
        session = request.getSession(true); // 새로운 세션을 생성한다.
        session.setAttribute("user", user); // 사용자 정보를 세션에 저장한다.
    }

    public static void updateRemoveSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // 세션을 먼저 찾아본다.
        if (session != null) {
            session.removeAttribute("user"); // 사용자 정보를 삭제한다.
            session.invalidate(); // 세션을 삭제한다.
        }
    }
}
