package controller;

import domain.Employee;

import service.EmployeeSearchService;
import service.EmployeeUpdateService;

import java.util.Scanner;

public class EmployeeUpdateController {
    private EmployeeSearchService searchService;
    private EmployeeUpdateService updateService;

    public EmployeeUpdateController() {
        this.searchService = EmployeeSearchService.getInstance();
        this.updateService = EmployeeUpdateService.getInstance();
    }

    public void process() {
        Scanner scanner = new Scanner(System.in);
        
        // Get employee_id from user input
        System.out.println("수정하고자 하는 직원 ID를 입력하세요: ");
        String employee_id = scanner.nextLine();

        // Search for employee using the provided employee_id
        Employee employee = searchService.searchEmployee(employee_id);

        if (employee != null) {
            System.out.println("찾은 직원 정보: " + employee);

            // Update employee information with user input
            System.out.println("새로운 직원 이름을 입력하세요: ");
            employee.setName(scanner.nextLine());

            System.out.println("새로운 이메일을 입력하세요: ");
            employee.setEmail(scanner.nextLine());

            System.out.println("새로운 전화번호를 입력하세요: ");
            employee.setPhone_number(scanner.nextLine());

            // Omitting hire_date as it typically wouldn't be updated

            System.out.println("새로운 급여를 입력하세요: ");
            employee.setSalary(Integer.parseInt(scanner.nextLine()));

            int result = updateService.updateEmployee(employee);
            if (result > 0) {
                System.out.println("성공적으로 업데이트되었습니다.");
            } else {
                System.out.println("업데이트에 실패하였습니다. 입력 데이터를 확인해주세요.");
            }
        } else {
            System.out.println("해당 직원을 찾을 수 없습니다.");
        }
    }
}
