package domain;

import java.time.LocalDate;

import oracle.sql.DATE;

public class JobHistory {

	// JOB_HISTORY TABLE -> 인스턴스 변수 정의
	private String employee_id; // 직원_id --> EMPLOYEES TABLE 의 PRIMARY_KEY
	private LocalDate start_date; // 시작 날짜
	private LocalDate end_date; // 퇴사 날짜
	private String jobs_id; // 직업_id --> JOBS TABLE 의 PRIIMARY_KEY
	
	// 생성자 정의 
	public JobHistory(String employee_id, LocalDate start_date, LocalDate end_date, String jobs_id) {
		this.employee_id = employee_id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.jobs_id = jobs_id;
	}

	// Getter Setter 정의 
	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	public LocalDate getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}

	public String getJobs_id() {
		return jobs_id;
	}

	public void setJobs_id(String jobs_id) {
		this.jobs_id = jobs_id;
	}

	@Override
	public String toString() {
	return "JobHistory [start_date=" + start_date + ", end_date=" + end_date + "]";
	}

}
