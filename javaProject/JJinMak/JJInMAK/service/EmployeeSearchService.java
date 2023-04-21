package service;

import dao.EmployeeDao;
import domain.Employee;

public class EmployeeSearchService {
    private EmployeeDao dao;

    private EmployeeSearchService() {
        dao = EmployeeDao.getInstance();
    }

    private static EmployeeSearchService service = new EmployeeSearchService();

    public static EmployeeSearchService getInstance() {
        return service;
    }

    public Employee searchEmployee(String employee_id) {
        return dao.searchEmployee(employee_id);
    }
}
