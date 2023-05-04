package controller.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.user.UserService;
import util.session.ManagementSession;

@WebServlet("/resendCode")
public class ResendCodeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	public ResendCodeController() {
	        this.userService = UserService.getInstance();
	    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 세션에서 User 정보를 가져온다
		User user = ManagementSession.getSessionUser(request);

		// 인증 코드 불일치 시 다시 이메일 발송 로직 호출
		int newAuthCode = userService.EmailVerifyCode(user);
		ManagementSession.setSessionAuthCode(request, newAuthCode); // 세션에 새로운 인증 코드 저장

		request.setAttribute("success", "인증 코드가 재발송되었습니다. 메일을 확인해주세요.");
		request.getRequestDispatcher("waiting.jsp").forward(request, response);
	}
}
