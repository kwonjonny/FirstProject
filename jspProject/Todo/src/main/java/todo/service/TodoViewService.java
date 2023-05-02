package todo.service;

import java.sql.Connection;
import java.sql.SQLException;

import todo.dao.TodoDAO;
import todo.domain.TodoDTO;
import todo.util.DBConnection;

public class TodoViewService {

	private TodoDAO dao;

	private TodoViewService() {
		this.dao = TodoDAO.getInsatnce();
	}

	private static TodoViewService service = new TodoViewService();

	public static TodoViewService getInstance() {
		return service;
	}

	// tno 값을 전달 받아서
	// dao selectByTno 에 요청 => TodoDTO => 반환
	public TodoDTO getTodo(int tno) {
		Connection conn = null;
		TodoDTO todo = null;
		try {
			conn = DBConnection.getConnection();
			todo = dao.selectByTno(conn, tno);

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
		return todo;
	}

}
