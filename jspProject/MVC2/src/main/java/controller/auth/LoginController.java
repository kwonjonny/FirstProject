package controller.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.password.PasswordRequiredService;
import service.user.UserService;
import util.cookie.ManagementCookie;
import util.session.ManagementSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;
	private PasswordRequiredService passwordRequiredService;

	public LoginController() {
		userService = new UserService();
		passwordRequiredService = new PasswordRequiredService();
	}

	private static LoginController controller = new LoginController();

	public static LoginController getInstance() {
		return controller;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// login 은 세션이 최초 생성 되는 곳이므로 getSession을 하지 않는다
		// id,password를 입력받고 DB에 있는 정보와 비교
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		User user = userService.login(id, password);

		// 로그인 성공 세션에 사용자 정보 저장
		if (user != null) {
			ManagementSession.setSession(request, user);

			// 패스워드 변경 권고 로직
			if (passwordRequiredService.isPasswordChangeRequired(user.getId())) {
				request.setAttribute("passwordChangeMessage", "패스워드 변경 권고: 패스워드를 변경한 지 3개월이 지났습니다.");
			}

			// 쿠키 생성 삭제 로직
			String rememberMe = request.getParameter("remember_me");
			if (rememberMe != null && rememberMe.equals("on")) {
				// 쿠키 생성 및 저장 (유효기간 5개월)
				ManagementCookie.createCookie(response, "loginCookie", user.getId(), 60 * 60 * 24 * 30 * 5); // 생명주기 5개월
			} else {
				// 체크박스가 client에 의해 해제 되어있으면 쿠키 삭제
				ManagementCookie.deleteCookie(request, response, "loginCookie", "/");
			}
			response.sendRedirect("main.jsp");
		}
	}
}
