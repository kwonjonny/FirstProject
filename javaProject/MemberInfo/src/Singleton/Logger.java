package Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//문제: Logger 클래스를 싱글톤 패턴으로 구현해보세요.
//
//요구 사항:
//
//Logger 클래스의 인스턴스는 하나만 생성되어야 합니다.
//Logger 클래스는 log(String message) 메서드를 포함해야 합니다. 이 메서드는 전달된 메시지를 콘솔에 출력합니다.
//외부에서 Logger 인스턴스를 가져올 수 있는 메서드를 구현해야 합니다.
//힌트: 생성자를 private으로 선언하고, 정적 메서드를 사용하여 인스턴스를 반환하거나 생성하세요.
public class Logger {
	private static Logger instance;

	private Logger() {
	}

	public static Logger getInstance() {
		if (instance == null) {
			instance = new Logger();
		}
		return instance;
	}

	public void log(String message) {
		System.out.println(message);
	}

}

class Main {
	public static void main(String[] args) {
		Logger logger = Logger.getInstance();
		logger.log("Hello, Singleton pattern!");
	}
}
