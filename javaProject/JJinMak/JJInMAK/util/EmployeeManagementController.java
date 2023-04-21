package util;

import service.EmployeeSearchService;
import service.EmployeeUpdateService;
import java.util.Scanner;
import java.util.Scanner;
import controller.EmployeeUpdateController;
public class EmployeeManagementController {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        EmployeeUpdateController controller = new EmployeeUpdateController();

	        while (true) {
	            System.out.println("===== 직원 관리 시스템 =====");
	            System.out.println("1. 직원 정보 수정");
	            System.out.println("2. 종료");
	            System.out.println("===========================");

	            System.out.print("선택> ");
	            int choice = Integer.parseInt(scanner.nextLine());

	            switch (choice) {
	                case 1:
	                    controller.process();
	                    break;
	                case 2:
	                    System.out.println("프로그램을 종료합니다.");
	                    System.exit(0);
	                default:
	                    System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
	                    break;
	            }
	        }
	    }
	}


