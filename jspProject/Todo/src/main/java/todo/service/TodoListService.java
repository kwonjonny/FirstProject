package todo.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import todo.dao.TodoDAO;
import todo.domain.TodoDTO;
import todo.util.DBConnection;

public class TodoListService {

	private TodoDAO dao;

	public TodoListService() {
		this.dao = TodoDAO.getInsatnce();
	}

	public List<TodoDTO> getList() {
		// 데이터 처리
		// 트렌젝션 처리
		Connection conn = null;
		List<TodoDTO> list = null;
		try {
			conn = DBConnection.getConnection();
			list = dao.selectByAll(conn);
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
		return list;
	}
}
