package controller.user;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import service.user.UserService;
import util.session.ManagementSession;

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

		// 설정하려는 기본 passwordChangeInterval 값 30
		// 90일 이후에 패스워드 변경 권장 로직 실행 
		int passwordChangeInterval = 30;	
		java.util.Date currentDate = new java.util.Date();
		Date last_password_change = new Date(currentDate.getTime());

		User user = new User(username, email, id, password, passwordChangeInterval, last_password_change);
		
		// userService.EmailVerifyCode -> user 객체 전달 난수 이메일 발송 
		int authCode = userService.EmailVerifyCode(user);
		
		// 세션에 인증 코드와 USER 정보 저장 -> waiting.jsp로 전달 
		ManagementSession.setSession(request, user);
		ManagementSession.setSessionAuthCode(request, authCode);
		
		// 인증 코드 입력 페이지로 이동 
		response.sendRedirect("waiting.jsp");
	}
}
