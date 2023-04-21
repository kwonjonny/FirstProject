package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Dept;

public class DeptDao {
	
	// DAO : sql 실행하는 메소드만 가지는 클래스
	// => 여러개의 인스턴스가 생성될 필요가 없다!
	// => 싱글톤처리를 통해서 하나의 인스턴스만 사용!
	
	// 1. 인스턴스 생성 금지 : private 생성자
	private DeptDao(){	
	}
	// 2. 클래스 내부에서 인스턴스 생성 : private static
	private static DeptDao dao = new DeptDao();
	// 3. 다른클래스에서 인스턴스를 얻을 수 있는 메소드 : public static
	public static DeptDao getInstance() {
		return dao;
	}

	// 1. dept list : List<Dept>
	public List<Dept> selectByAll(Connection conn) {

		// Connection
		// 1. 메소드 내부에서 Connection을 구하는 방법 (X)
		// 2. Dao 클래스 내부의 인스턴스 변수로 Connection 구하는 방법
		// Dao 싱클톤 (X), Connection 구하기 위해서 인스턴스 계속 생성
		// 3. 매개변수로 Connection 구하는 방법
		// -> Service 클래스의 메소드에서 Connection 생성해서 전달
		// close()

		// Connection
		// PreparedStatement
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 반환하고자 하는 결과 데이터
		// Collection 클래스중 List => 입력 순서를 가진다, index, 반복문
		List<Dept> result = new ArrayList<Dept>();

		// sql
		String sql = "select * from dept";

		try {
			pstmt = conn.prepareStatement(sql);

			// executeQuery
			// ResultSet
			rs = pstmt.executeQuery();

			// while
			while (rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");

				Dept dept = new Dept(deptno, dname, loc);
				// List<Dept>에 Dept 객체를 추가
				result.add(dept);

			}

			// result : 4개의 객를 가지고 있다

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return result;
	}

	// 2. 부서번호로 검색 (Connection conn, int num)
	public Dept selectByDeptno(Connection conn, int deptno) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Dept result = null;
		
		// sql
		String sql = "select * from dept where deptno=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
			} 
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		
		return result;
		
	}

	// 3. 부서 정보 입력 : deptno, dname, loc
	public int insertDept(Connection conn, Dept dept) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		// Insert Sql
		String sql = "insert into dept values (?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			
			result = pstmt.executeUpdate();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}

	// 4. 부서 정보 수정 : deptno, dname, loc
	public int updateDeptByDeptno(Connection conn, Dept dept) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		// Update Sql
		String sql = "update dept set dname=?, loc=? where deptno=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
		
	}
	

	// 5. 부서 정보 삭제 : deptno => 삭제할 부서 번호
	public int deleteDeptByDeptno(Connection conn, int deptno) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		// delete Sql
		String sql = "delete from dept where deptno = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	
	
	
	
	public static void main(String[] args) throws SQLException {

		DeptDao dao = new DeptDao();

		String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = DriverManager.getConnection(dbUrl, "hr", "tiger");

		List<Dept> list = dao.selectByAll(conn);

		for (Dept dept : list) {
			System.out.println(dept);
		}
		
		Dept dept = dao.selectByDeptno(conn, 50);
		System.out.println("결과 : " + dept);
		
		//int insertResult = dao.insertDept(conn, new Dept(50, "Test", "Seoul"));
		//System.out.println("저장 결과 : " + insertResult);
		
		Dept d = new Dept (50, "TTT", "QQQ"); // 수정하고자하는 부서 정보
		int updateResult = dao.updateDeptByDeptno(conn, d);
		System.out.println(updateResult);

	}

}

