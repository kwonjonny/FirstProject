package todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import todo.domain.TodoDTO;
import todo.util.DBConnection;

public class TodoDAO {

	// 싱글톤
	// 1. 생성자 - private
	private TodoDAO() {
	}

	// 2. 내부에서 todoDAO 인스턴스 생성 -> private static
	private static TodoDAO dao = new TodoDAO();

	// 3. 외부에서 요청에 대한 처리는 TodoDAO의 참조값을 얻어갈 수 있는 메소드 -> public static
	public static TodoDAO getInsatnce() {
		return dao;
	}

	// TodoDTO 리스트를 반환하는 메소드
	public List<TodoDTO> selectByAll(Connection conn) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<TodoDTO> List = null;
		try {
			// query / sql
			String query = "select * from tbl_todo";
			// PreparedStatement
			ps = conn.prepareStatement(query);
			// 결과 받기
			rs = ps.executeQuery();
			List = new ArrayList<TodoDTO>();
			while (rs.next()) {
				int tno = rs.getInt("tno");
				String todo = rs.getString("todo");
				String duedate = rs.getString("duedate");
				boolean finished = rs.getBoolean("finished");

				TodoDTO dto = new TodoDTO(tno, todo, duedate, finished);
				List.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} return List;
	}

	public static void main(String [] args) throws SQLException {
		TodoDAO dao = TodoDAO.getInsatnce();
		Connection conn = DBConnection.getConnection();
		
		List<TodoDTO> List = dao.selectByAll(conn);
		for(TodoDTO todo : List) {
			System.out.println(todo);
		}
	}
	
}
