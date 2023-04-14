import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 1. JDBC 드라이버 로딩
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2. MySQL과 연결
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String user = "thistrik";
            String password = "thistrik";
            conn = DriverManager.getConnection(url, user, password);
            
            // 3. 쿼리 실행을 위한 Statement 객체 생성
            stmt = conn.createStatement();
            
            // 4. 쿼리 실행
            String sql = "SELECT * FROM employees";
            rs = stmt.executeQuery(sql);
            
            // 5. 결과 출력
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println(id + "\t" + name + "\t" + email);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. 자원 해제
            try {
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
