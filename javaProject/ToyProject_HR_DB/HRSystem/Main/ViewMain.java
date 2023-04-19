package Main;

import controller.EmployeesController;
import controller.JobsController;
import view.ConsoleView;

public class ViewMain {
	public static void main(String[] args) {

		EmployeesController controller = new EmployeesController();
		JobsController jobsController = new JobsController();
		ConsoleView view = new ConsoleView(controller,jobsController);
		
		view.start();
		
	}
}
