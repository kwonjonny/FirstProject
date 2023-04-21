package service;

import dao.EmployeeDao;
import domain.Employee;

import dao.EmployeeDao;
import domain.Employee;

public class EmployeeUpdateService {
    private EmployeeDao dao;

    private EmployeeUpdateService() {
        dao = EmployeeDao.getInstance();
    }

    private static EmployeeUpdateService service = new EmployeeUpdateService();

    public static EmployeeUpdateService getInstance() {
        return service;
    }

    public int updateEmployee(Employee employee) {
        return dao.updateEmployee(employee);
    }
}
