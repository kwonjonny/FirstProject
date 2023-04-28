package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import domain.User;
import service.UserService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	public LoginController() {
		userService = new UserService();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		User user = userService.login(id, password);

		// 로그인 성공 세션에 사용자 정보 저장
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.setAttribute("message", "로그인 완료");
			// 로그인 완료 메시지를 전달하기 위해 RequestDispatcher를 사용
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} else {
			// 로그인 실패 로그인 페이지로 재 이동
			request.setAttribute("errorMessage", "id,password 확인해주세요");

			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
