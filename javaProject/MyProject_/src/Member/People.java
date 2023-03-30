package Member;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

//API 
//class Person {
//	 String name;
//	 String personNumber;
//	}

//1. 위 Person 클래스의 equals() 메소드를 오버라이딩해서 주민등록번호가 같으면 
//인스턴스로 판별하는 프로그램을 만들어봅시다. 
//2. 1~100,000,000까지 더하기하는 연산의 실행 시간을 측정하는 프로그램을 만들어봅시다. 
//3. 사용자에게 이름을 입력 받아 입력 받은 문자열을 정상적인 문자열의 이름으로 
//표현하는지 판별하고, 공백으로 입력되었는지도 판별하는 프로그램을 만들어봅시다. 
//4. 자신의 생일을 기준으로 오늘까지 몇 일을 살았는지 출력하는 프로그램을 만들어봅시다. 

// Important!-> 작성자 뇌피셜: 이 문제의 의도는 아직 웹페이지를 구현하는데에 필요한 API를 사용해보고 다뤄보지 않았으므로
// Java안에 있는 Library API를 받아와 문제를 풀라는 의도같다
// EX: equals Object, currenTimeMillies, trim.().length .matches, LocalDate.of(2222,05,22)
// LocalDate.now, Period 등 자바내의 API를 받아오는 명령어 문법들이다 

// People정보의 class
public class People {
	
	// 인스턴스 변수
	private String name;
	private String personNumber;
	
	// 생성자 정의
	public People(String name, String personNumber) {
		this.name = name;
		this.personNumber = personNumber;
	}

	// Getter Setter 정의 캡슐화 정보은닉 보수용이
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonNumber() {
		return personNumber;
	}

	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}
	
	// equals 오버라이딩 메소드
	// equals 는 Object를 꼭 매개변수로 담아줘야 하며 
	// instanceof를 이용해 People을 비교하고 맞다면 People객체로의 형 변환 
	// people객체에 obj를 담아준다 그후 인스턴스 변수를 비교하고 People의 객체면 True
	public boolean equals(Object obj) {
	if(obj instanceof People) {
		People person = (People) obj;
		return this.personNumber.equals(person.personNumber);
	} return false;
	}
	
}


// People에 있는 메소드를 출력하기 위한 클래스
class main5 {
	public static void main(String [] args) {
		
		// person1,person2의 객체를 다르게 선언 
		People person1 = new People("권성준","980626-1023424");
		People person2 = new People("김선제","234234-2342434");
		
		// 같은 사람인지 비교 -> False
		System.out.println("person1과 person2는 같은 사람인가?"+person1.equals(person2));
		
	}
}


// 더하기 시간측정 Class
class PlusMeasurementTime {
	public static void main(String[] args) {
		
	// 시작 시간 측정
	long startTime = System.currentTimeMillis(); 
	
	// for문을 이용해 1~100,000,000까지 더하기 연산 실행
	long sum = 0;
	for(int i=1; i <= 1000000000; i++) {
		sum = sum + i;
	}
	
	// 종료 시간 측정
	long endTime = System.currentTimeMillis(); 
	System.out.println("sum의 값:" + sum);
	System.out.println("실행 시간 은?:"+(endTime - startTime));
	
	}
}


// 사용자에게 이름을 입력받아 T와 F를 판별하는 class
class TextInput {
	public static void main(String [] args) {
		
		// Scanner를 이용한 입력정의
		Scanner scan = new Scanner(System.in);
		System.out.println("이름을 입력하세요>>");
		String name = scan.nextLine();
		
		
		if(name.length() ==0) {					// 공백으로 입력되도 판별하는 메소드 정의
			System.out.println("(공백)잘못된 입력입니다.");
		} else if(name.matches("^[가-힣]*$")) {	// 입력받은 이름의 형태 확인
			System.out.println("올바른 이름 입력입니다."); 
		} else {
			System.out.println("잘못된 입력입니다.");
		}
		scan.close();	// scan.close를 사용한 메모리 낭비 방지 
	}
}



// LocalDate를 이용하여 몇 일을 살았는지 출력하는 class
class HowLongLived {
	public static void main(String [] args) {
		
		LocalDate birthday = LocalDate.of(1998,06,26); // 나의 생일을 입력
		LocalDate currentDay = LocalDate.now(); 	  // 현재의 날짜 
		
		// Period는 birthday와of currentDay의now 시간 간격을 나타낸다
		Period period = Period.between(birthday, currentDay);
		
		System.out.println("난 오늘까지"+period.getYears()+"년"+period.getMonths()+"개월"+period.getDays()+"살았어!");
		
	}
}
