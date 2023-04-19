package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	// 인스턴스 변수 정의
	// singleton pattern
	private static DBConnection instance;
	private Connection conn;

	// 생성자 정의
	// JDBC Driver connect
	private DBConnection() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "C##KwonDB2";
			String password = "tiger";
			conn = DriverManager.getConnection(url, id, password);
			System.out.println("Connected to database");
		} catch (ClassNotFoundException e) {
			throw new SQLException("Oracle JDBC Driver not found");
		} catch (SQLException e) {
			throw new SQLException("Failed to connect to database");
		}
	}

	public static synchronized DBConnection getInstance() throws SQLException {
		if (instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}

	// Connection 객체 반환
	// 타 클래스에서 DB information을 넘겨주기위한 메소드
	public Connection getConnection() {
		return conn;
	}

	// 메인 메소드로 JDBC Driver 확인
	public static void main(String[] args) {
		try {
			DBConnection dbConn = DBConnection.getInstance();
			dbConn.getInstance();
		} catch (SQLException e) {
			System.out.println("Failed to connect to database");
			e.printStackTrace();
		}
	}
}
