package dao;

import DBConnection.DBConnection;
import domain.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao {
	// Singleton pattern
	private static EmployeeDao dao = new EmployeeDao();

	public static EmployeeDao getInstance() {
		return dao;
	}

	// Search employee by employee_id
	public Employee searchEmployee(String employee_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employee employee = null;

		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT * FROM employee WHERE employee_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employee_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				employee = new Employee(rs.getString("employee_id"), rs.getString("name"), rs.getString("email"),
						rs.getString("phone_number"), rs.getDate("hire_date").toLocalDate(), rs.getInt("salary"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return employee;
	}

	// Update employee information
	public int updateEmployee(Employee employee) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = DBConnection.getConnection();
			String sql = "UPDATE employee SET name=?, email=?, phone_number=?, hire_date=?, salary=? WHERE employee_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employee.getName());
			pstmt.setString(2, employee.getEmail());
			pstmt.setString(3, employee.getPhone_number());
			pstmt.setDate(4, java.sql.Date.valueOf(employee.getHire_date()));
			pstmt.setInt(5, employee.getSalary());
			pstmt.setString(6, employee.getEmployee_id());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
