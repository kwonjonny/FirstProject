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
	public Employees update(Connection conn,String employee_id, Employees newEmployees) throws SQLException {
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    try {
	        String query = "SELECT * FROM EMPLOYEES WHERE employee_id = ?";
	        ps = conn.prepareStatement(query);
	        ps.setString(1, employee_id);
	        rs = ps.executeQuery();
	        if (!rs.next()) {
	            throw new SQLException("No record found for employee_id: " + employee_id);
	        }

	        String queryUpdate = "UPDATE EMPLOYEES SET name = ?, email = ?, phone_number = ?, hiredate = ? WHERE employee_id = ?";
	        ps = conn.prepareStatement(queryUpdate);
	        ps.setString(1, newEmployees.getName());
	        ps.setString(2, newEmployees.getEmail());
	        ps.setString(3, newEmployees.getPhone_number());
	        ps.setString(4, newEmployees.getHiredate());
	        ps.setString(5, employee_id);

	        int updateRows = ps.executeUpdate();
	        if (updateRows > 0) {
	            return newEmployees;
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