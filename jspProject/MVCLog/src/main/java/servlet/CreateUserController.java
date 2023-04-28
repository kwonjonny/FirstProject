package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import domain.User;

@WebServlet("/createUser")
public class CreateUserController extends HttpServlet {

	private UserService userService;

	public CreateUserController() {
		this.userService = UserService.getInstance();
	}

	private static CreateUserController controller = new CreateUserController();

	public static CreateUserController getInstance() {
		return controller;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		User user = new User(username, email, id, password);
		userService.createUser(user);

		request.setAttribute("message", "회원가입완료");
		response.sendRedirect("main.jsp");
	}
}
