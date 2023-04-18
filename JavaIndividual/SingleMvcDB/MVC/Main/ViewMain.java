package Main;

import View.UserConsoleView;
import Controller.UserController;

// viewMain class 
// 사용자가 실행시 console 실행 
public class ViewMain {
	public static void main(String[] args) {

		// UserController에 scanner 로직이 있으므로 객체 선언
		UserController controller = new UserController();

		// UserConsoleView에 scanner 로 입력받는 로직이 있으므로 객체 선언 후 controller객체 담아줌
		UserConsoleView view = new UserConsoleView(controller);

		// view.start()로직 선언
		view.start();
	}
}
