package listner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class W2AppListner implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed()...");
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized()...");

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
