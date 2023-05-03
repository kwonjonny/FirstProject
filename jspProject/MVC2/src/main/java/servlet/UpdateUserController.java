package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;
import domain.User;

@WebServlet("/updateUser")
public class UpdateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	public UpdateUserController() {
		userService = new UserService();
	}

	private static UpdateUserController controller = new UpdateUserController();

	public static UpdateUserController getInstance() {
		return controller;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// userUpdate는 사용자의 입력을 받아야 하므로 UTF-8로 설정
		request.setCharacterEncoding("UTF-8");

		boolean isAgree = request.getParameter("agree") != null;
		if (!isAgree) {
			// 동의하지 않은 경우 에러 메시지를 반환하고 회원 가입을 중단합니다.
			request.setAttribute("error", "이용 약관 및 개인정보 처리방침에 동의해주세요.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		// 세션에 있는 사용자 정보 가져옴
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");

		if (user != null) {
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			// 설정하려는 기본 passwordChangeInterval 값
			int passwordChangeInterval = 30;
			java.util.Date currentDate = new java.util.Date();
			Date last_password_change = new Date(currentDate.getTime());

			User updateUser = new User(username, email, user.getId(), password, passwordChangeInterval,
					last_password_change);
			userService.updateUser(updateUser);

			// 세션의 사용자 정보를 업데이트한 사용자 정보로 변경
			session.setAttribute("user", updateUser);
			
			request.setAttribute("mesaage", "회원 업데이트 완료");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} else {
			// 세션 connect 실패시
			request.setAttribute("errorMesaage", "로그인 후 이용 바랍니다");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
