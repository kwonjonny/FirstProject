package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "C##KwonDB2";
		String password = "tiger";
		return DriverManager.getConnection(url, id, password);
	}
}
