package Main;

import controller.EmployeesController;
import controller.JobsController;
import controller.JobHistoryController;
import dao.EmployeesDAO;
import dao.JobsDAO;
import dao.JobHistoryDAO;
import dbConnection.DBConnection;
import service.EmployeeJobService;
import view.ServcieConsoleView;
import java.sql.Connection;
import java.sql.SQLException;

public class ServiceViewMain {
    public static void main(String[] args) {
        try {
            // DB 연결
            Connection conn = DBConnection.getConnection();

//            EmployeesController employeesController = new EmployeesController();
//            JobsController jobsController = new JobsController();
//            JobHistoryController jobHistoryController = new JobHistoryController();

            EmployeesDAO employeesDAO = new EmployeesDAO();
            JobsDAO jobsDAO = new JobsDAO();
            JobHistoryDAO jobHistoryDAO = new JobHistoryDAO();

            EmployeeJobService employeeJobService = new EmployeeJobService(employeesDAO, jobsDAO, jobHistoryDAO);

            ServcieConsoleView view = new ServcieConsoleView(employeeJobService);
            
            view.EmployeeJobStart();
        } catch (SQLException e) {
            System.out.println("Failed to connect to database: " + e.getMessage());
        }
    }
}
