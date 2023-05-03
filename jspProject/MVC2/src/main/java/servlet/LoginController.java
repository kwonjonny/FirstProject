package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

//import dao.LogDao;
import domain.User;
import service.PasswordRequiredService;
import service.UserService;

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
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			// 패스워드 변경 권고 로직 
			if(passwordRequiredService.isPasswordChangeRequired(user.getId())) {
				request.setAttribute("passwordChangeMessage", "패스워드 변경 권고: 패스워드를 변경한 지 3개월이 지났습니다.");
			}
			
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

