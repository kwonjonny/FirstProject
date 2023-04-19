package Main;

import controller.EmployeesController;
import controller.JobsController;
import dao.EmployeesDAO;
import dao.JobsDAO;
import dbConnection.DBConnection;
import service.EmployeeJobService;
import view.ServcieConsoleView;

import java.sql.Connection;
import java.sql.SQLException;

public class ServiceViewMain {
    public static void main(String[] args) {
        try {
            // DB 연결
            Connection conn = DBConnection.getInstance().getConnection();

            EmployeesController employeesController = new EmployeesController();
            JobsController jobsController = new JobsController();

            EmployeesDAO employeesDAO = new EmployeesDAO(conn);
            JobsDAO jobsDAO = JobsDAO.getInstance(conn);

            EmployeeJobService employeeJobService = new EmployeeJobService(conn, employeesDAO, jobsDAO);

            ServcieConsoleView view = new ServcieConsoleView(employeeJobService);
            view.EmployeeJobStart();
        } catch (SQLException e) {
            System.out.println("Failed to connect to database: " + e.getMessage());
        }
    }
}
