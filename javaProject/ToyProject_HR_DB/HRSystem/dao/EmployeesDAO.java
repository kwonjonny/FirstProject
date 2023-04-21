package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Employees;
import domain.EmployeeJobJobHistory;
import service.EmployeeJobService;

public class EmployeesDAO {


	// SQL Employee create
	public void create(Connection conn,Employees employees) throws SQLException {
		PreparedStatement ps = null;
		try {
			String query = "INSERT INTO EMPLOYEES(employee_id, name, email, phone_number, hiredate) VALUES (?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, employees.getEmployee_id());
			ps.setString(2, employees.getName());
			ps.setString(3, employees.getEmail());
			ps.setString(4, employees.getPhone_number());
			ps.setString(5, employees.getHiredate());
			ps.executeUpdate();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
	}

	// SQL Employee read
	public Employees read(Connection conn,String name) throws SQLException {
		Employees employees = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM EMPLOYEES WHERE name = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new SQLException("NO reocord found for " + name);
			}
			employees = new Employees(rs.getString("employee_id"), rs.getString("name"), rs.getString("email"),
					rs.getString("phone_number"), rs.getString("hiredate"));
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		}
		return employees;
	}
	
	// SQL Employee update
	public Employees update(Connection conn, String name, Employees newEmployees) throws SQLException {
	    PreparedStatement psSelect = null;
	    PreparedStatement psUpdate = null;
	    ResultSet rs = null;
	    try {
	        // 기존 정보를 조회합니다.
	        String selectQuery = "SELECT * FROM EMPLOYEES WHERE name = ?";
	        psSelect = conn.prepareStatement(selectQuery);
	        psSelect.setString(1, name);
	        rs = psSelect.executeQuery();
	        if (!rs.next()) {
	            throw new SQLException("No record found for employee_id: " + name);
	        }
	        
	        // 기존 정보를 업데이트합니다.
	        String updateQuery = "UPDATE EMPLOYEES SET employee_id = ?, name = ?, email = ?, phone_number = ?, hiredate = ? WHERE name = ?";
	        psUpdate = conn.prepareStatement(updateQuery);
	        psUpdate.setString(1, newEmployees.getEmployee_id());
	        psUpdate.setString(2, newEmployees.getName());
	        psUpdate.setString(3, newEmployees.getEmail());
	        psUpdate.setString(4, newEmployees.getPhone_number());
	        psUpdate.setString(5, newEmployees.getHiredate());
	        psUpdate.setString(6, name);
	        int updateRows = psUpdate.executeUpdate();
	        if (updateRows > 0) {
	        	throw new SQLException("NO reocord found for " + name , newEmployees.getEmployee_id());
	        } else {
	            return null;
	        }
	    } finally {
	        if (rs != null) {
	            rs.close();
	        }
	        if (psSelect != null) {
	            psSelect.close();
	        }
	        if (psUpdate != null) {
	            psUpdate.close();
	        }
	    }
	}


	// SQL Employee delete
	public Employees delete(Connection conn,String name) throws SQLException {
		Employees employees = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM EMPLOYEES WHERE name = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new SQLException("No record found for " + name);
			}
			employees = new Employees(rs.getString("employee_id"), rs.getString("name"), rs.getString("email"),
					rs.getString("phone_number"), rs.getString("hiredate"));

			String queryDelete = "DELETE FROM EMPLOYEES WHERE name = ?";
			ps = conn.prepareStatement(queryDelete);
			ps.setString(1, name);
			int deleteRows = ps.executeUpdate();
			if (deleteRows > 0) {
				return employees;
			} else {
				return null;
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		}
	}
}