package controller.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.user.UserService;

@WebServlet("/verify")
public class VerifyCodeControllerUrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;

	public VerifyCodeControllerUrl() {
		this.userService = UserService.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String code = request.getParameter("code");

		User user = userService.findUserByEmail(email);
		if (user != null && user.getVerificationCode().equals(code)) {
			user.setVerified(true);
			userService.createTestUser(user);
			request.setAttribute("message", "이메일이 성공적으로 인증되었습니다. 이제 로그인하십시오.");
			response.sendRedirect("main.jsp");
		} else {
			request.setAttribute("message", "이메일 인증에 실패하였습니다. 다시 시도하십시오.");
		}

		request.getRequestDispatcher("login.jsp").forward(request, response);

	}


}
