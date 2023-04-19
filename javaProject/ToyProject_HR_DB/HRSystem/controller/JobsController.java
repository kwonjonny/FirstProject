package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import dao.JobsDAO;
import dbConnection.DBConnection;
import model.Jobs;

public class JobsController {

	private JobsDAO jobsDAO;

	public JobsController() {

		// 콘솔로 입력받고 -> DAO 클래스로 값을 전달 하기 때문에
		// Database 연결 정보 설정 해야한다.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "C##KwonDB2";
		String password = "tiger";

		// JobsDAO 객체를 생성
		try {
			Connection conn = DriverManager.getConnection(url, id, password);
			JobsDAO jobsDAO = JobsDAO.getInstance(conn);
			this.jobsDAO = jobsDAO;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JOBDAO 객체 생성 실패");
		}
	}

	// create jobs console
	public void createJobsConsole() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 직업 정보 생성 ===");
		System.out.println("직업id, 직업, 직업설명,연봉 생성");
		System.out.println("직업 id입력: ");
		String jobs_id = scan.nextLine().trim();
		System.out.println("직업 입력: ");
		String jobs_title = scan.nextLine().trim();
		System.out.println("직업설명 입력: ");
		String jobs_description = scan.nextLine().trim();
		System.out.println("연봉 입력 (숫자만): ");
		int salary = scan.nextInt();

		Jobs jobs = new Jobs(jobs_id, jobs_title, jobs_description, salary);
		try {
			jobsDAO.JobsCreate(jobs);
			System.out.println("=== 직업 정보 생성 완료! ===");
		} catch (SQLException e) {
			System.out.println("=== 직업 정보 생성 실패! ===");
		}
	}

	// read jobs console
	public void readJobsConsole() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 직업 정보 출력 ===");
		System.out.println("직업id, 직업, 직업설명,연봉 출력");
		System.out.println("직업 id입력: ");
		String jobs_id = scan.nextLine().trim();

		try {
			Jobs jobs = jobsDAO.JobsRead(jobs_id);
			if (jobs == null) {
				System.out.println("검색 결과가 없습니다.");
			} else {
				System.out.println("=============================");
				System.out.println("직업 ID: " + jobs.getJobs_id());
				System.out.println("직업: " + jobs.getJobs_title());
				System.out.println("직업설명: " + jobs.getJobs_description());
				System.out.println("연봉: " + jobs.getSalary());
				System.out.println("=============================");
			}
		} catch (SQLException e) {
			System.out.println("=== 직업 정보 조회 실패 ===");
		}
	}

	// update jobs console
	public void updateJobsConsole() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 직업 정보 업데이트 ===");
		System.out.println("직업id, 직업, 직업설명,연봉 업데이트");
		System.out.println("직업 id입력: ");
		String jobs_id = scan.nextLine().trim();

		try {
			Jobs jobs = jobsDAO.JobsRead(jobs_id);
			if (jobs == null) {
				System.out.println("검색 결과가 없습니다.");
			} else {
				System.out.println(jobs.getJobs_id() + "의 직업 정보 업데이트");
				System.out.println("new job id 입력: ");
				String newJobs_id = scan.nextLine().trim();
				System.out.println("new 직업 입력: ");
				String newJobs_title = scan.nextLine().trim();
				System.out.println("new 직업 설명 입력: ");
				String newJobs_description = scan.nextLine().trim();
				System.out.println("new 연봉 입력: ");
				int newSalary = scan.nextInt();

				Jobs newJobs = new Jobs(newJobs_id, newJobs_title, newJobs_description, newSalary);
				newJobs.setJobs_id(newJobs_id);
				newJobs.setJobs_title(newJobs_title);
				newJobs.setJobs_description(newJobs_description);
				newJobs.setSalary(newSalary);

				Jobs updateJobs = jobsDAO.JobsUpdate(newJobs_id, newJobs);
				if (updateJobs != null) {
					System.out.println("=== 직업 정보 업데이트 완료 ===");
				} else {
					System.out.println("=== 직업 정보 업데이트 실패 ===");
				}
			}
		} catch (SQLException e) {
			System.out.println("=== 직업 정보 업데이트 실패 ===");
		}
	}

	// delete jobs console
	public void deleteJobsConsole() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 직업 정보 삭제 ===");
		System.out.println("직업 id입력:");
		String jobs_id = scan.nextLine().trim();
		try {
			Jobs jobs = jobsDAO.JobsRead(jobs_id);
			if(jobs_id == null) {
				System.out.println("검색 결과가 없습니다.");
			} else {
				System.out.println(jobs.getJobs_id() + "의 직업 정보 삭제");
				jobsDAO.delete(jobs_id);
			}
		} catch (SQLException e) {
			System.out.println("=== 직업 정보 삭제 실패 ===");
		}
	}
}
