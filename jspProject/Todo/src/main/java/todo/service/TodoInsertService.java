package todo.service;

import java.sql.Connection;
import java.sql.SQLException;

import todo.dao.TodoDAO;
import todo.domain.RequestTodo;
import todo.util.DBConnection;

public class TodoInsertService {

	private TodoDAO dao;

	private static TodoInsertService service = new TodoInsertService();

	private TodoInsertService() {
		this.dao = TodoDAO.getInsatnce();
	}

	public static TodoInsertService getInstance() {
		return service;
	}

	// 입력의 요청을 처리하는 메소드,
	// RequestTodo 전달받고 Dao 에 메소드에 요청
	public int register(RequestTodo todo) {
		Connection conn = null;
		int result = 0;
		try {
			conn = DBConnection.getConnection();
			result = dao.insertTodo(conn, todo);
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
		}
		return result;
	}
}