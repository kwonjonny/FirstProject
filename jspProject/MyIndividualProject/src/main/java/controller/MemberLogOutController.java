package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLogOutController {
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String userID = (String) session.getAttribute("userID");
		// 세션이 존재할 때
		if (userID != null) {
			session.removeAttribute("userID");
			session.removeAttribute("userName");
			System.out.println("세션 존재: 삭제완료");
			res.sendRedirect("login.do");
		}
	}
}
