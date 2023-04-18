package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static DBConnection instance;
	private Connection conn;

	private DBConnection() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "C##KwonDB1";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("Connected to database");
		} catch (ClassNotFoundException e) {
			throw new SQLException("Oracle JDBC Driver not found");
		}
	}
	
	public static synchronized DBConnection getInstance() throws SQLException {
		if(instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return conn;
	}

	// 메인 메소드로 JDBC Driver 확인
	public static void main(String [] args) {
		try {
			DBConnection dbConn = DBConnection.getInstance();
			dbConn.getInstance();
		} catch (SQLException e) {
			System.out.println("Failed to connect to database");
			e.printStackTrace();
		}
	}
}
