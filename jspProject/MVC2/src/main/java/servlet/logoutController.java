package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class logoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 사용자가 요청을 했으므로 dooGet 메소드 정의
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션에 있는 사용자 정보 가져옴
		HttpSession session = request.getSession(false);
		// 세션 connect 성공 시
		if (session != null) {
			session.invalidate();
			request.setAttribute("message", "로그아웃 완료");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} else {
			// 세션 connect 실패시
			request.setAttribute("errorMesaage", "로그인 후 이용 바랍니다");

			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}


