package Member;

import java.util.ArrayList;

// 객체지향_상속 

// Person 이라는 클래스를 정의해봅시다.
// 이름을 저장하는 변수, 주민등록번호를 저장하는 변수를 정의해봅시다.
// 인사하는 메소드를 정의해봅시다.
// “안녕하세요. 저는 OOO입니다. 00살 입니다.”라는 문자열이 출력하도록 정의합시다.

// 2. Person 클래스를 상속해서 확장하는 새로운 클래스 Male 클래스와 Female 클래스를 정의 해봅시다.
// 각 클래스는 상속 받은 멤버 외에 추가적인 변수와 메소드를 추가해서 새로운 클래스를 정의해봅시다.
// 각 클래스는 상속 받은 멤버 외에 추가적인 변수와 메소드를 추가해서 새로운 클래스를 정의해봅시다.
// Person 클래스에서 정의된 인사하는 메소드를 오버라이딩 해봅시다.
// Person 클래스에 생성자를 정의해서 인스턴스 변수들을 초기화 해봅시다.

// 3. main()메소드를 정의해봅시다.
// Person 클래스를 상속받은 Male클래스와 Female클래스를 이용해서 인스턴스를 생성해 봅시다
// 생성된 인스턴스들을 이용해서 메소드를 호출해봅시다

public class Person02 {
	// 인스턴스 변수 정의
	private String name;
	private String number;
	
	// 생성자 정의
	public Person02(String name, String number) {
		this.name = name;
		this.number = number;
	}

	// Getter Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public String toStirng() {
		return "안녕하세요"+name +"입니다 주민번호는" +number+"입니다.";
	}
	
	// 주민번호를 통해서 나이를 계산해서 반환하는 메소드
	public int getAge() {
		int age = 0;
		
		// Ex : 980626-1212324 -> 98과 뒷자리 앞1자리를 뽑음
		String year = number.substring(0,2);
		char gender = number.charAt(7);
		
		System.out.println(year + ":" + gender);
		
		
		if(gender<'3') {
			// 1990 + year
			age = 2023 - (1900 + Integer.parseInt(year)) + 1;
		} else {
			// 2000 + year
			age = 2023 - (1900 - Integer.parseInt(year)) + 1;
		}
		
		return age;
	}
}

class Male extends Person02 {
	
	// 인스턴스 변수 정의
	private String military;
	
	// 생성자 정의
	public Male(String name, String number, String military) {
		super(name,number);
		this.military = military;
	}
	
	// Getter Setter
	public String getMilitary() {
		return military;
	}

	public void setMilitary(String military) {
		this.military = military;
	}
	
	@Override
	public String toString() {
		return super.toStirng() + military;
	}
	
}

class Female extends Person02{
	
	// 인스턴스 변수 정의 
	private String married;
	
	// 생성자 정의
	public Female(String name, String number, String married) {
		super(name,number);
		this.married = married;
	}

	// Getter Setter
	public String getMarried() {
		return married;
	}

	public void setMarried(String married) {
		this.married = married;
	}
	
	@Override
	public String toString() {
		return super.toStirng() + married;
	}
}


class Main3 {
	public static void main(String [] args) {

//		// 일반 출력 예시
//		Person02 person02 = new Person02("권성준", "980626-1231234");
//		System.out.println(person02);
//	
//		Male male2 = new Male("권성준", "980523-1231432", "미필입니다.");
//		System.out.println(male2);
//
//		Female female2 = new Female("김선제", "962342-9325324", "미혼입니다.");
//		System.out.println(female2);
	
//		// 배열 출력 예시 
//		Person02[] people = new Person02[3];
//		people[1] = new Person02("권성준", "980626-1231234");
//		people[1] = new Male("권성준", "980523-1231432", "미필입니다.");
//		people[2] = new Female("김선제", "962342-9325324", "미혼입니다.");
//        
//         for(Person02 person : people) {
//        	System.out.println(person);
//        }
		
		// 어레이 리스트 출력 예시 
		ArrayList<Person02> people = new ArrayList<>();
		people.add(new Person02("권성준", "980626-1231234"));
	    people.add(new Male("권성준", "980523-1231432", "미필입니다."));
	    people.add(new Female("김선제", "962342-9325324", "미혼입니다."));

	      	for(Person02 person: people) {
	      	 System.out.println(person);
	      	}
	     
	    // 나이를 계산하는 정보 출력 !
	    Person02 people1 = new Person02("권성준","980626-1231234");
	    System.out.println( people1.getAge());
        
	    Male people2 = new Male("권성준","980523-1231432", "미필입니다.");
	    System.out.println(people2.getAge());
	    
	    Female people3 = new Female("김선제","962342-2325324", "미혼입니다.");
	    System.out.println(people3.getAge());
	}
}



