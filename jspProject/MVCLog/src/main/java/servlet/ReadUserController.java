package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserService;

@WebServlet("/readUser")
public class ReadUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private UserService userService;
	
	public ReadUserController() {
		userService = new UserService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		User user = userService.readUser(id);
		
		request.setAttribute("user", user);
		request.setAttribute("message", "회원 리스트 목록 출력");
		response.sendRedirect("main.jsp");
	}

}
