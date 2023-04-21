package domain;

import java.time.LocalDate;

public class JobHistory {

	private String job_history_id;
	private LocalDate start_date;
	private LocalDate end_date;
	
	public JobHistory(String job_history_id, LocalDate start_date, LocalDate end_date) {
		this.job_history_id = job_history_id;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public String getJob_history_id() {
		return job_history_id;
	}

	public void setJob_history_id(String job_history_id) {
		this.job_history_id = job_history_id;
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
	

	@Override
	public String toString() {
	    return "JobHistory [job_history_id=" + job_history_id + ", start_date=" + start_date + ", end_date=" + end_date
	            + "]";
	}

	

	

}
