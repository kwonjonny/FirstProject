package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberLoginController {
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpUtil.forward(req, res, "/WEB-INF/views/member/login.jsp");

	}
}
