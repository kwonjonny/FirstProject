package controller.auth;

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

@WebServlet("/verifyCode")
public class VerifyCodeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	public VerifyCodeController() {
		this.userService = UserService.getInstance();
	}

	private static VerifyCodeController controller = new VerifyCodeController();

	public static VerifyCodeController getInstance() {
		return controller;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 사용자가 입력한 인증 코드와 회원가입 정보를 받아온다
		int inputAuthCode = Integer.parseInt(request.getParameter("authCode"));
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		// 설정하려는 기본 passwordChangeInterval 값 90
		// 90일 이후에 패스워드 변경 권장 로직 실행
		int passwordChangeInterval = 30;
		java.util.Date currentDate = new java.util.Date();
		Date last_password_change = new Date(currentDate.getTime());

		User user = new User(username, email, id, password, passwordChangeInterval, last_password_change);

		// 세션에서 저장된 인증 코드 가져온다
		int storedAuthCode = ManagementSession.getSessionAuthCode(request);

		// 인증 코드가 일치하면 userService.create로직에 user객체 전달
        if (inputAuthCode == storedAuthCode) {
            userService.createTestUser(user);
            ManagementSession.setSession(request, user);
            // 인증 코드 사용 후 세션에서 제거
            ManagementSession.removeAuthCode(request);
            response.sendRedirect("main.jsp");
        } else {
            request.setAttribute("error", "인증 코드가 일치하지 않습니다. 메일 재 발송 버튼을 눌러주세요.");
            request.getRequestDispatcher("waiting.jsp").forward(request, response);
        }
    }
}
