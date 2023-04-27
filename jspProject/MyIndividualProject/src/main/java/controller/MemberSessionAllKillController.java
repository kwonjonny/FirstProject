package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberSessionAllKillController {
	
public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String userID = (String)session.getAttribute("userID");		
		// 세션 종료
		if ( userID != null ) {		
			session.invalidate();
			System.out.println("세션 종료");
			res.sendRedirect("login.do");
		}
	}
}
