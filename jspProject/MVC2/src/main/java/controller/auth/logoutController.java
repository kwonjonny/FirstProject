package controller.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import util.session.ManagementSession;

@WebServlet("/logout")
public class logoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 사용자가 요청을 했으므로 dooGet 메소드 정의
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// session 있는 사용자 정보 가져옴
		User user = ManagementSession.getSessionUser(request);

		if (user != null) {
			// session 삭제
			ManagementSession.removeSession(request);
			response.sendRedirect("main.jsp");
		} 
	}
}