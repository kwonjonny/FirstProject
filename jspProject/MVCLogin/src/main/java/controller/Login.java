package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member/login")
public class Login extends HttpServlet {
private MemberService memberService = MemberServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 화면(회원 등록)
		req.getRequestDispatcher("/WEB-INF/lib/jsp/member/login.jsp").forward(req, resp);
	}
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로직(회원 등록)
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		System.out.println(id);
		System.out.println(pwd);
		
		req.getSession().setAttribute("member", memberService.login(id, pwd));
		req.getSession().setMaxInactiveInterval(600);
        
		resp.sendRedirect("list");
	}
}
