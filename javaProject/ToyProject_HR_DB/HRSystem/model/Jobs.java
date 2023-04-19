package model;

public class Jobs {

	// JOBS TABLE -> 인스턴스 변수 정의
	private String jobs_id;	// 직업_id --> PRIMARY KEY
	private String jobs_title;	// 직업_직함
	private String jobs_description;	// 직업_설명
	private int salary;		// 연봉
	
	// 생성자 정의 
	public Jobs(String jobs_id, String jobs_title, String jobs_description, int salary) {
		this.jobs_id = jobs_id;
		this.jobs_title = jobs_title;
		this.jobs_description = jobs_description;
		this.salary = salary;
	}

	// Getter Setter 정의 
	public String getJobs_id() {
		return jobs_id;
	}

	public void setJobs_id(String jobs_id) {
		this.jobs_id = jobs_id;
	}

	public String getJobs_title() {
		return jobs_title;
	}

	public void setJobs_title(String jobs_tilte) {
		this.jobs_title = jobs_tilte;
	}

	public String getJobs_description() {
		return jobs_description;
	}

	public void setJobs_description(String jobs_description) {
		this.jobs_description = jobs_description;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
