package controller.user;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.user.UserService;
import util.cookie.ManagementCookie;
import util.session.ManagementSession;

@WebServlet("/deleteUser")
public class DeleteUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;

	public DeleteUserController() {
		this.userService = UserService.getInstance();
	}

	private static DeleteUserController controller = new DeleteUserController();

	public static DeleteUserController getInstance() {
		return controller;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션에 있는 사용자 정보 가져옴
		User user = ManagementSession.getSessionUser(request);
			
		// 세션 connect 성공시
		if (user != null) {
			// 사용자의 세션 정보 삭제
			ManagementSession.removeSession(request);
			// 사용자의 cookie 저장 정보 삭제 	
			ManagementCookie.deleteCookie(request, response, "loginCookie", "/");
			// 사용자의 id 서비스에 전달
			userService.deleteUser(user.getId());
			
			request.setAttribute("mesaage", "회원 탈퇴 완료");
			response.sendRedirect("main.jsp");
		} 
	}
}