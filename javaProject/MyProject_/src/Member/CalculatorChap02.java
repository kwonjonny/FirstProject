package Member;
import java.util.Scanner;

//JAVA에서 제공하는 연산자 

//Calculator 클래스를 정의해봅시다.
// 정수 두 개를 매개변수의 인자로 전달받아 더하기연산 후 출력하는 메소드를 정의
// 정수 두 개를 매개변수의 인자로 전달받아 빼기연산 후 출력하는 메소드를 정의
// 정수 두 개를 매개변수의 인자로 전달받아 곱하기연산 후 출력하는 메소드를 정의
// 정수 두 개를 매개변수의 인자로 전달받아 나누기연산 후 출력하는 메소드를 정의
// 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 둘레를 구해 반환하는 메소드를 반환하는 메소드를 정의
// 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 넓이를 구해 반환하는 메소드를 반환하는 메소드를 정의
// 원의 둘레 : 2 x π x r , 월의 넓이 : π x r x r
// main() 메소드를 정의하고 각각의 메소드를 호출해서 결과를 콘솔에 출력해봅시다.
// 콘솔에서 사용자에게 데이터를 받아 메소드를 호출할 때 사용자에게 받은 데이터를 메소드의 매개변수의 인자로 전달하는 코드를 main() 메소드
// 에 추가해봅시다.

public class CalculatorChap02 {
	
// 정수 두 개를 매개변수의 인자로 전달받아 더하기연산 후 출력하는 메소드를 정의
	public static int add(int num1, int num2) {
		return num1 + num2;
	}
	
// 정수 두 개를 매개변수의 인자로 전달받아 빼기연산 후 출력하는 메소드를 정의
	public static int minus(int num1, int num2) {
		return num1 - num2;
	}
	
// 정수 두 개를 매개변수의 인자로 전달받아 곱하기연산 후 출력하는 메소드를 정의
	public static int multiply(int num1, int num2) {
		return num1 * num2;
	}
	
// 정수 두 개를 매개변수의 인자로 전달받아 나누기연산 후 출력하는 메소드를 정의
	public static int divide(int num1, int num2) {
		return num1 / num2;
	}
	// 사칙연산은 소수점 표현 생략을 위해 int
	
// 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 둘레를 구해 반환하는 메소드를 반환하는 메소드를 정의
// getCirclePerimeter의 매개변수는 double형으로 하는 이유는 반지름을 구하기위해 소수점 표현을위한 double형	
	public static double getCirclePerimeter(double radius) {
		return 2 * Math.PI * radius;
	}
	// getCirclePerimeter 원의 반지름을 매개변수로 받아 원의 둘레를 계산
	// 원의 둘레 : 2 x π x r 
	
// 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 넓이를 구해 반환하는 메소드를 반환하는 메소드를 정의	
	 public static double getCircleArea(double radius) {
	        return Math.PI * radius * radius;
	    }
	 // getCircleArea 는 원의 반지름을 매개변수 radius로 받아 원의 넓이 계산
	 // 원의 넓이 : π x r x r
	 
	 
	 // RUN을 위한 메인메소드 호출
	 public static void main(String [] args) {
		 Scanner scan = new Scanner(System.in); // 입력받을 정수와,반지름을 위해 스캐너 호출
		 int num1, num2; // 매개변수 num1 , num2 호출
		 double radius; // 매개변수 radius 호출
		 // 호출하는 이유는 메인메소드 안에서 매개변수를 호출해 쓰기위해
		 
		 
		 System.out.print("첫번째 정수를 입력하세요: ");
	     num1 = scan.nextInt();

	     System.out.print("두번째 정수를 입력하세요: ");
	     num2 = scan.nextInt();

	     System.out.print("사칙연산을 선택하세요 (+, -, *, /): ");
	     String operator = scan.next();

	        
	        int result = 0;
	        switch (operator) {
	            case "+":
	                result = add(num1, num2);
	                break;
	            case "-":
	                result = minus(num1, num2);
	                break;
	            case "*":
	                result = multiply(num1, num2);
	                break;
	            case "/":
	                result = divide(num1, num2);
	                break;
	            default: // 사칙연산과 다른 것을 입력했을경우 뜨는 창
	                System.out.println("잘못된 연산자입니다.");
	        }
	        System.out.println("결과 :" +result);
	        
	        // 원의 반지름을 받는 프린트
	        System.out.print("반지름을 입력하세요: ");
	        radius = scan.nextDouble();
	        
	        double circlePerimeter = getCirclePerimeter(radius);
	        System.out.println("원의 둘레: " + circlePerimeter);

	        double circleArea = getCircleArea(radius);
	        System.out.println("원의 넓이: " + circleArea);

	        scan.close(); // 스캐너를 종료
	    }
	 
	 }
