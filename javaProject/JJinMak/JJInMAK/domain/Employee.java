package domain;

import java.time.LocalDate;

public class Employee {
	private String employee_id;
	private String name;
	private String email;
	private String phone_number;
	private LocalDate hire_date;
	private int salary;

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", name=" + name + ", email=" + email + ", phone_number="
				+ phone_number + ", hire_date=" + hire_date + ", salary=" + salary + "]";
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public LocalDate getHire_date() {
		return hire_date;
	}

	public void setHire_date(LocalDate hire_date) {
		this.hire_date = hire_date;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employee(String employee_id, String name, String email, String phone_number, LocalDate hire_date,
			int salary) {
		this.employee_id = employee_id;
		this.name = name;
		this.email = email;
		this.phone_number = phone_number;
		this.hire_date = hire_date;
		this.salary = salary;
	}
}
