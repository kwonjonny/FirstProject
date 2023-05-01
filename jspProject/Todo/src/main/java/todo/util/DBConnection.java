package todo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// service : dao 메소드에 매개변수 전달 목적 
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "C##KwonDB2";
		String password = "tiger";
		return DriverManager.getConnection(url, id, password);
	}
	
	public static void main(String [] args) throws SQLException {
		DBConnection.getConnection();
		System.out.println("Connection complete");
	}
}
