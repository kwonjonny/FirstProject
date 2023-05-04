
package controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import service.user.UserService;
import util.session.ManagementSession;

@WebServlet("/readUser")
public class ListUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	public ListUserController() {
		userService = new UserService();
	}

	private static ListUserController controller = new ListUserController();

	public static ListUserController getInstance() {
		return controller;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 세션에 있는 사용자 정보 가져옴
		User user = ManagementSession.getSessionUser(request);

		// 세션 connect 성공시
		if (user != null) {
			// 모든 회원 정보를 가져옴
			List<User> userList = userService.getUserList();
			response.sendRedirect("list.jsp");
		}
	}
}
