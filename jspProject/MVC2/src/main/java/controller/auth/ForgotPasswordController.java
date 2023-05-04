
package controller.auth;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.user.UserService;
import util.session.ManagementSession;

@WebServlet("/shootInformaiton")
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	public ForgotPasswordController() {
		this.userService = UserService.getInstance();
	}

	private static ForgotPasswordController controller = new ForgotPasswordController();

	public static ForgotPasswordController getInstance() {
		return controller;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 클라이언트로부터 email 파라미터를 전송받음
		String email = request.getParameter("email");
		// userService.sendEmail -> 이메일 전송
		User user = userService.sendEmail(email);

		if (user != null) {
			// 유저의 정보가 있으면? -> main.jsp
			response.sendRedirect("login.jsp");
		} else {
			// 유저의 정보가 없으면? -> main.jsp
			response.sendRedirect("createUser.jsp");
		}
	}
}
