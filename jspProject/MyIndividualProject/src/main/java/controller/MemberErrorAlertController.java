package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberErrorAlertController {
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpUtil.forward(req, res, "/WEB-INF/views/member/error_alert.jsp");
		HttpSession session = req.getSession();
		session.invalidate();

		

	}
}
