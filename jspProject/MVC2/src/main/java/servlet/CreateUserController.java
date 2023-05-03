package servlet;

import java.io.IOException;
import java.sql.Date;

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
		// createUser는 사용자의 입력을 받아야 하므로 UTF-8로 설정
		request.setCharacterEncoding("UTF-8");

		boolean isAgree = request.getParameter("agree") != null;
		if (!isAgree) {
			// 동의하지 않은 경우 에러 메시지를 반환하고 회원 가입을 중단합니다.
			request.setAttribute("error", "이용 약관 및 개인정보 처리방침에 동의해주세요.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		// 설정하려는 기본 passwordChangeInterval 값
		int passwordChangeInterval = 30;
		java.util.Date currentDate = new java.util.Date();
		Date last_password_change = new Date(currentDate.getTime());

		User user = new User(username, email, id, password, passwordChangeInterval, last_password_change);

		// user의 정보를 service에게 전달
//		userService.createUser(user);

		// 로그인 3개월 password변경 권고 test용 로직
		userService.createTestUser(user);

		request.setAttribute("message", "회원가입완료");
		// main 페이지로 redirect
		response.sendRedirect("main.jsp");
	}
}
