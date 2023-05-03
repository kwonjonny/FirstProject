package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import service.UserService;

@WebServlet("/deleteUser")
public class DeleteUserController extends HttpServlet {

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
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// 세션 connect 성공시
		if (user != null) {
			// 사용자의 세션 정보 삭제
			session.removeAttribute("user");
			// 사용자의 id 서비스에 전달
			userService.deleteUser(user.getId());

			request.setAttribute("mesaage", "회원 탈퇴 완료");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} else {
			// 세션 connect 실패시
			request.setAttribute("errorMesaage", "로그인 후 이용 바랍니다.");

			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}


