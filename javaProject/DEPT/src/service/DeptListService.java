package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import dao.DeptDao;
import domain.Dept;
import util.ConnectionProvider;

public class DeptListService {

	DeptDao dao;

	private DeptListService() {
		this.dao = DeptDao.getInstance();
	}

	private static DeptListService service = new DeptListService();

	public static DeptListService getInstance() {
		return service;
	}

	public List<Dept> getDeptList() {
		Connection conn = null;
		List<Dept> list = null;
		try {
			// Connection 객체 구하기
			// String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			// conn = DriverManager.getConnection(dbUrl, "hr", "tiger");
			conn = ConnectionProvider.getConnection();
			// 트랜젝션 시작
			conn.setAutoCommit(false);
			// insert(conn)
			// update(conn)
			// select(conn)
			// update(conn)
			// insert(conn)

			list = dao.selectByAll(conn);

			// commit : 완료!
			conn.commit();

		} catch (SQLException e) {
			// 예외 발생 -> rollback
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return list;

	}

	public static void main(String[] args) {

		DeptListService listService = new DeptListService();
		List<Dept> list = listService.getDeptList();

		for (Dept d : list) {
			System.out.println(d);
		}
	}
}
