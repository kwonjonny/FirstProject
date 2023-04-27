package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberProcessController {
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id;
		String passwd;
		String charset;
		HttpSession session;
		charset = (String) req.getAttribute("charset");
		req.setCharacterEncoding(charset);
		id = req.getParameter("userID");
		passwd = req.getParameter("password");
		// System.out.println("userID:" + id);
		// System.out.println("password:" + passwd);

		// 세션 정보
		session = req.getSession();

		// 세션 생성
		if (id.equals("user") && passwd.equals("1234")) {
			session.setAttribute("userID", id);
			session.setAttribute("userName", "회원");
			res.sendRedirect("logon.do");
		} else {
			session.setAttribute("member_error_msg", "아이디와 비밀번호를 확인하세요.");
			session.setAttribute("member_redirect_url", "login.do");
			res.sendRedirect("errorAlert.do");
		}
	}
}
