package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet("/deleteUser")
public class DeleteUserController extends HttpServlet {

	private UserService userService;
	
	public DeleteUserController() {
		this.userService = UserService.getInstance();
	}
	
	private static DeleteUserController controller = new DeleteUserController();
	
	public static DeleteUserController getInstance() {
		return controller;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		userService.deleteUser(id);

		request.setAttribute("message", "회원삭제완료");
		response.sendRedirect("main.jsp");
	}
}
