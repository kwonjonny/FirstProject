package firstweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 사용자 요청 처리
		String userid = request.getParameter("userid");
		System.out.println("id : " + userid);

		String password = request.getParameter("password");
		System.out.println("pw : " + password);

		PrintWriter out = response.getWriter();
		out.println("id : " + userid);
		out.println("pw : " + password);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 사용자 요청 처리
		String userid = request.getParameter("userid");
		System.out.println("id : " + userid);

		String password = request.getParameter("password");
		System.out.println("pw : " + password);

		PrintWriter out = response.getWriter();
		out.println("id : " + userid);
		out.println("pw : " + password);
		out.close();

	}

}
