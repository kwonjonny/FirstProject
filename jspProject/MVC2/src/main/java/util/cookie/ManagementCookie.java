package util.cookie;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ManagementCookie {

	// default 생성자 private 으로 정의
	private ManagementCookie() {
	}

	// 쿠키 생성
	public static void createCookie(HttpServletResponse response, String key, String value, int maxAge) {
		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(60 * 60 * 24 * 30 * 5); // 쿠키 생명 주기 5개월
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	// 쿠키 삭제
	public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String name,
			String path) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					cookie.setMaxAge(0);
					cookie.setPath(path);
					response.addCookie(cookie);
					break;
				}
			}
		}
	}
}
