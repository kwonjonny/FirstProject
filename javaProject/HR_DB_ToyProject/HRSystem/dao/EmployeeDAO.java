package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import domain.Employee;

public class EmployeeDAO {

	// SQL Employee create
	public void createEmployee(Connection conn, Employee employee) throws SQLException {
		PreparedStatement ps = null;
		try {
			String query = "INSERT INTO EMPLOYEE(employee_id, name, email, phone_number, hire_date, salary) VALUES (?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, employee.getEmployee_id());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getEmail());
			ps.setString(4, employee.getPhone_number());
			ps.setDate(5, java.sql.Date.valueOf(employee.getHire_date()));
			ps.setInt(6, employee.getSalary());
			ps.executeUpdate();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}

	}

	// SQL Employee read
	public List<Employee> readAllEmployees(Connection conn) throws SQLException {
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    List<Employee> employees = new ArrayList<>();
	    try {
	        String query = "SELECT * FROM EMPLOYEE";
	        ps = conn.prepareStatement(query);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            Employee employee = new Employee(rs.getString("employee_id"), rs.getString("name"), rs.getString("email"),
	                    rs.getString("phone_number"), rs.getDate("hire_date").toLocalDate(), rs.getInt("salary"));
	            employees.add(employee);
	        }
	    } finally {
	        if(rs != null) {
	            rs.close();
	        }
	        if (ps != null) {
	            ps.close();
	        }
	    }
	    return employees;
	}

	// SQL Employee update
	public void updateEmployee(Connection conn, Employee employee) throws SQLException {
	    PreparedStatement ps = null;
	    try {
	        String query = "UPDATE EMPLOYEE SET name=?, email=?, phone_number=?, hire_date=?, salary=? WHERE employee_id =?";
	        ps = conn.prepareStatement(query);
	        ps.setString(1, employee.getName());
	        ps.setString(2, employee.getEmail());
	        ps.setString(3, employee.getPhone_number());
	        ps.setDate(4, java.sql.Date.valueOf(employee.getHire_date()));
	        ps.setInt(5, employee.getSalary());
	        ps.executeUpdate();
	    } finally {
	        if (ps != null) {
	            ps.close();
	        }
	    }
	}

	// SQL Employee delete
	public void deleteEmployee(Connection conn, String employee_id) throws SQLException {
		PreparedStatement ps = null;
		try {
			String queryDelete = "DELETE FROM EMPLOYEES WHERE employee_id =?";
			ps = conn.prepareStatement(queryDelete);
			ps.setString(1, employee_id);
			
			int deleteRows = ps.executeUpdate();
			if(deleteRows > 0) {
				System.out.println("delete successFully");
			} else {
				throw new SQLException("falie delete");
			}
		} finally {
			if(ps != null) {
				ps.close();
			}
		}
	}


	
}