package web.mvc.util.session;

import org.springframework.stereotype.Component;
import web.mvc.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class ManagementSession {

    private static final String USER_SESSION_ATTRIBUTE = "user";
    private static final String AUTH_CODE_SESSION_ATTRIBUTE = "authCode";

    public static User getSessionUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (User) session.getAttribute(USER_SESSION_ATTRIBUTE);
    }

    public static void setSessionUser(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();
        session.setAttribute(USER_SESSION_ATTRIBUTE, user);
    }

    public static int getSessionAuthCode(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer authCode = (Integer) session.getAttribute(AUTH_CODE_SESSION_ATTRIBUTE);
        return (authCode != null) ? authCode : 0;
    }

    public static void setSessionAuthCode(HttpServletRequest request, int authCode) {
        HttpSession session = request.getSession();
        session.setAttribute(AUTH_CODE_SESSION_ATTRIBUTE, authCode);
    }

    public static void removeSessionAuthCode(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(AUTH_CODE_SESSION_ATTRIBUTE);
    }
}
