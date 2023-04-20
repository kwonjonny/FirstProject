package controller;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import dao.JobHistoryDAO;
import domain.JobHistory;

// 앞서 Admin은 Service 에서 CRUD를 할 때에 
// employee_id 와 jobs_id를 확인하였으므로 컨트롤러에서는 따로 
// 확인하지않는 작업 
public class JobHistoryController {

	// 인스턴스 변수 정의
	private JobHistoryDAO jobHistoryDAO;

	// 생성자로 jobHistoryDAO 초기화
	public JobHistoryController() {
		this.jobHistoryDAO = jobHistoryDAO;
	}

	// create jobHistory console
	public void createJobHistoryConsole() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 입사일, 퇴사일 입력 ===");
		System.out.println("직원 ID 입력: ");
		String employeeId = scan.next();
		System.out.println("입사일 입력(YYYY-MM-DD): ");
		String startDateStr = scan.next();
		LocalDate startDate = LocalDate.parse(startDateStr);
		System.out.println("퇴사일 입력(YYYY-MM-DD): ");
		String endDateStr = scan.next();
		LocalDate endDate = LocalDate.parse(endDateStr);
		System.out.println("직업 ID 입력: ");
		String jobId = scan.next();

		JobHistory jobCreate = new JobHistory(employeeId, startDate, endDate, jobId);

		try {
			jobHistoryDAO.historyCreate(jobCreate);
			System.out.println("=== 입사,퇴사 정보 생성 완료! ===");
		} catch (SQLException e) {
			System.out.println("=== 입사,퇴사 정보 생성 실패! ===");
			e.printStackTrace();
		}
	}

	// read jobHistory console
	public void readJobHistoryConsole() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 입사, 퇴사 정보 조회 ===");
		System.out.println("직원 ID 입력: ");
		String employeeId = scan.next();
		System.out.println("직업 ID 입력: ");
		String jobId = scan.next();

		try {
			JobHistory jobHistory = jobHistoryDAO.historyReadById(employeeId, jobId);
			if (jobHistory == null) {
				System.out.println("검색 결과가 없습니다.");
			} else {
				System.out.println("=============================");
				System.out.println("직원 ID: " + jobHistory.getEmployee_id());
				System.out.println("시작일: " + jobHistory.getStart_date());
				System.out.println("종료일: " + jobHistory.getEnd_date());
				System.out.println("직업 ID: " + jobHistory.getJobs_id());
				System.out.println("=============================");
			}
		} catch (SQLException e) {
			System.out.println("=== 입사, 퇴사 정보 조회 실패! ===");
			e.printStackTrace();
		}
	}

	// update jobHistory console
	public void updateJobHistoryConsole() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 입사, 퇴사 정보 수정 ===");
		System.out.println("직원 ID 입력: ");
		String employeeId = scan.nextLine();
		System.out.println("직업 ID 입력: ");
		String jobId = scan.nextLine();

		try {
			JobHistory jobHistory = jobHistoryDAO.historyReadById(employeeId, jobId);
			if (jobHistory == null) {
				System.out.println("검색 결과가 없습니다.");
			} else {
				System.out.println(jobHistory.getEmployee_id() + " 의 직원id, 입사, 퇴사, 직업id 정보 수정");
				System.out.println("수정할 직원id 입력: ");
				String newEmployeeId = scan.nextLine();
				System.out.println("수정할 입사일 입력(YYYY-MM-DD): ");
				String newStartDateStr = scan.next();
				LocalDate newStartDate = LocalDate.parse(newStartDateStr);
				System.out.println("수정할 퇴사일 입력(YYYY-MM-DD): ");
				String newEndDateStr = scan.next();
				LocalDate newEndDate = LocalDate.parse(newEndDateStr);
				System.out.println("수정할 직업id 입력: ");
				String newJobid = scan.nextLine();

				JobHistory newJobHistory = new JobHistory(newEmployeeId, newEndDate, newEndDate, newJobid);
				newJobHistory.setEmployee_id(employeeId);
				newJobHistory.setStart_date(newEndDate);
				newJobHistory.setEnd_date(newEndDate);
				newJobHistory.setJobs_id(jobId);

				JobHistory updateJobs = jobHistoryDAO.historyUpdateById(newEmployeeId, jobId, newJobHistory);
				if (updateJobs != null) {
					System.out.println("=== job hisotry 정보 업데이트 완료 ===");
				} else {
					System.out.println("=== job hisotry 정보 업데이트 실패 ===");
				}
			}
		} catch (SQLException e) {
			System.out.println("=== job hisotry 정보 업데이트 실패 ===");
			e.printStackTrace();
		}
	}

	// delete jobHistory console
	public void deleteJobHistoryConsole() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 입사, 퇴사 정보 삭제 ===");
		System.out.println("삭제할 직원 ID 입력: ");
		String employeeId = scan.nextLine();
		System.out.println("삭제할 직업 ID 입력: ");
		String jobId = scan.nextLine();

		try {
			jobHistoryDAO.historyDeleteById(employeeId, jobId);
			System.out.println("=== 입사, 퇴사 정보 삭제 완료 ===");
		} catch (SQLException e) {
			System.out.println("=== 입사, 퇴사 정보 삭제 실패 ===");
			e.printStackTrace();
		}
	}
}