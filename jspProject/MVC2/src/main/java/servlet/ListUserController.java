
package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import service.UserService;

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
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");

		// 세션 connect 성공시
		if (user != null) {
			// 모든 회원 정보를 가져옴
			List<User> userList = userService.getUserList();
			request.setAttribute("userList", userList);

			request.getRequestDispatcher("list.jsp").forward(request, response);
		} else {
			// 세션 connect 실패시
			request.setAttribute("errorMessage", "로그인 후 이용 바랍니다");

			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}


