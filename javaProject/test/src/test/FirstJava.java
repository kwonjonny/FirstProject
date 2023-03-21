package test;

public class FirstJava {
	
	// 주석은 파일 정보, 목적, 작성자, 수정일 등을 포함할 수 있다.
	
	// 클래스 내에는 변수들을 정의할 수 있다.
	// 클래스 내에는 함수(메소드)들을 정의할 수 있다.
	
	// 메인메소드 - > 클래스 실행시 시작의 시점이 된다.
	public static void main(String []args) {
		
		// System.out.println에서 "ln"은 줄 바꿈의 특성을 지닌다.
		
		System.out.println("First_Java1");
		// "//" 주석은 컴파일 시에 코드로 인식하지 않는다.
		// System.out.println("First_Java2");
		System.out.println("First_Java3");
		System.out.println("First_Java4");
		
		// class_의 name_은 식별자: 클래스 이름 (관례) 대문자 시작 (예: class "FirstJava")
		// main_은 method_이름 (관례) 소문자 시작 (예: public static void "main")
		// 변수의 이름도 (관례) 소문자 시작
		
		// 예:
		// 정수형 변수 선언과 초기화
		// int num = 10;
		//
		// 실수형 변수 선언과 초기화
		// double pi = 3.14;
		//
		// 문자열 변수 선언과 초기화
		// String name = "John Doe";
		//
		// 논리형 변수 선언과 초기화
		// boolean isTrue = true;
		
/////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		// 변수 선언과 초기화
		int age = 20; // 나이를 저장하는 변수
		double pi = 3.141592; // 원주율을 저장하는 변수

		// 변수 출력
		System.out.println(age);
		System.out.println(pi);
		
/////////////////////////////////////////////////////////////////////////////////////////////////////	
		
		// 메소드 정의 방법
		// 1반환 데이터 타입 2 메소드 이름 (3데이터 타입 변수 명, 데이터 타입 변수 명)
		// { 처리할 문장들 }
		
		// 밑에 add의 메소드를 호출하면 다음과 같이 사용할 수 있습니다.
		// 밑에 hello라는 메소드를 호출하면 다음과 같이 사용할 수 있습니다.
		int resultValue = add(10,20);
		System.out.println(resultValue);
		hello();
		hello2("손흥민");
	}
	
	// 정수 두개를 받아 -> 매개변수 선언
	// 더하기 연산한 결과를 -> 내부 처리
	// 반환하는 메소드를 만들어보자 -> return 결과값
	public static int add(int a, int b) {  // 매개변수 a, b는 더할 정수
	    int result = a + b;  // a와 b를 더한 값을 result 변수에 저장
	    return result;  // result 값을 반환
	}
	
	// 기능 : 인사말을 출력하는 기능을 가지는 메소드
	// 매개변수 : 데이터 받는 정의 
	// 결과 반환 : 반환이 없다
	// 반환타입 메소드이름(매개변수) {}
	// void : 반환 값이 없을때 쓴다 ->return이 없다 
	static void hello() {
		System.out.println("안녕하세요.");
		System.out.println("반갑습니다.");
	}
	
	// 기능 : 이름을 전달 받아 이름과 인사말을 출력하는 메소드
	// 매개변수 : 이름 (문자열)
	// 결과 반환 : 반환이 없다
	// 반환타입 
	static void hello2(String name) {
		System.out.println(name);
		System.out.println("안녕하세요2.");
	}


}
