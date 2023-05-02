
package servlet;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserService;

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
		User user = userService.sendEmail(email);

		if (user != null) {
			request.setAttribute("message", "계정 정보가 이메일로 전송되었습니다.");
		} else {
			request.setAttribute("message", "가입된 이메일이 없습니다. 다시 시도해 주세요.");
		}
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}
}
