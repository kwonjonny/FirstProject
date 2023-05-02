package todo.util;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet("/Loader")
public class Loader extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("Loader...init()..");
		// DB 드라이버 로드 
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("jdbc driver load shoot");
		} catch (ClassNotFoundException e) {
			System.out.println("driver load failed");
			e.printStackTrace();
		}
		
	}


}
