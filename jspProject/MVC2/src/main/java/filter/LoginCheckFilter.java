package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({ "/updateUser", "/deleteUser", "/readUser" })
public class LoginCheckFilter extends HttpFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(false);

		if (session != null && session.getAttribute("user") != null) {
			// 로그인한 사용자일 경우 요청을 처리합니다.
			chain.doFilter(request, response);
		} else {
			// 로그인하지 않은 사용자일 경우 로그인 페이지로 이동합니다.
			// 이전 페이지의 URL을 저장해두고 로그인 성공 후 해당 페이지로 이동하도록 구현합니다.
			String redirectUrl = httpRequest.getRequestURI();
			if (httpRequest.getQueryString() != null) {
				redirectUrl += "?" + httpRequest.getQueryString();
			}
			httpRequest.getSession().setAttribute("redirectUrl", redirectUrl);
			httpResponse.sendRedirect("login.jsp");
		}
	}
}