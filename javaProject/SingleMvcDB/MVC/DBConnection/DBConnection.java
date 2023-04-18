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

    //  synchronized 멀티 스레드 환경에 동시 메소드 접근 방지
    //  싱글톤 패턴으로 다른 클래스에서 인스턴스 정의 
    public static synchronized DBConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }

    // 메인 메소드로 JDBC Driver connect 확인 
    public static void main(String[] args) {
        try {
            DBConnection dbConn = DBConnection.getInstance();
            dbConn.getConnection();
        } catch (SQLException e) {
            System.out.println("Failed to connect to database");
            e.printStackTrace();
        }
    }
}
