package todo.service;

import java.sql.Connection;
import java.sql.SQLException;

import todo.dao.TodoDAO;
import todo.util.DBConnection;

public class TodoDeleteService {

	private TodoDAO dao;
	
	private static TodoDeleteService service = new TodoDeleteService();
	
	private TodoDeleteService() {
		this.dao = TodoDAO.getInsatnce();
	}
	
	public static TodoDeleteService getInstance() {
		return service;
	}
	
	// tno 전달받고 
	// dao delete 메소드에 요청 
	public int delete(int tno) {
		Connection conn = null;
		int result = 0;
		try {
			conn = DBConnection.getConnection();
			result = dao.deleteByTno(conn, tno);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} return result;
	}
}
