package Member;

import java.time.LocalDate;

// 프로그램 흐름제어를 위한 조건문과 반복문

// 앞에서 만든 Member 클래스에는 아래 요구사항에 맞는 메소드를 정의하고, main()메소드에 해당 메소드를 호출해서 결과를 확인해보세요. 
// 메소드의 이름도 JAVA의 규칙에 맞게 정의해 봅시다.
// 독감예방 접종이 가능한지 여부를 확인하는 메소드를 정의합니다.
//- 매개변수로 태어난 해(년도)를 전달받습니다.
//- 15세 미만의 경우와 65세 이상의 경우 “무료예방접종이 가능합니다.” 메시지가 콘솔에 출력하도록 합니다.
//- 위에서 정의한 조건의 범위가 아닌 나머지의 경우 “무료접종 대상이 아닙니다.”라고 출력하도록 합니다.

//② 건강검진 대상 여부를 판별하고 어떤 검진이 가능한지 확인하는 메소드를 정의합니다.
//- 매개변수로 태어난 해(년도)를 전달받습니다.
//- 대한민국 성인( 20세 )의 경우 무료로 2년마다 건강검진을 받을 수 있습니다.
//- 짝수 해에 태어난 사람은 올해가 짝수년이라면 검사 대상이 됩니다.
//- 40 이상의 경우는 암 검사도 무료로 검사를 할 수 있습니다.



public class MemberChap03 {
	
	// 인스턴스 변수 정의 
	// 접근제어자 private 생성 다른클래스로의 직접 호출 막아줌
	private String name;
	private int birthYear;
	
	
	
	// 생성자 정의 
	// 매개변수 String name, int birthYear을
	// 인스턴스 변수로의 변환 this를 사용
	public MemberChap03(String name, int birhtYear) {
		this.name = name;
		this.birthYear = birthYear;
	}
	
	
	
	// Getter Setter 사용 캡슐화,정보은닉,보수용이
	// get
	public String getName() {
		return name;
	}
	// set
	public void setName() {
		this.name=name;
	}
	
	
	
	// get
	public int getBirthYear() {
		return birthYear;
	}
	// set
	public void setBirthYear() {
		this.birthYear = birthYear;
	}
   
	
	
	// 무료 예방접종 체크
	// 예방접종 여부 확인 checkVaccination
	 public void checkVaccination() {
	        int age = getAge();
	        if (age < 15 || age >= 65) {	
	            System.out.println("무료 예방접종이 가능합니다.");
	        } else {
	            System.out.println("무료접종 대상이 아닙니다.");
	        }
	    }
	 // if문을 활용하여 15세 미만이거나 65세이하이면 예방접종 코드를 타고
	 // 아니면 else문을 타서 무료접종 대상 코드를 탄다
	 
	 
	 // checkHealthExam 검강검진 대상 여부를 판별
	 public void checkHealthExam() {
	        int age = getAge();
	        if (age >= 20 && birthYear % 2 == 0) {
	            System.out.println("무료 건강검진 대상입니다.");
	            if (age >= 40) {
	                System.out.println("무료 암 검사도 가능합니다.");
	            }
	        } else {
	            System.out.println("무료 건강검진 대상이 아닙니다.");
	        }
	    }
	 // if문을 활용해서 age가 20보다 크거나 같고 생일이 2로나누었을때의 나머지가 0이면
	 // 무료 검강검진 대상
	 // if문 age가 40보다 크거나 같으면 무료 암 검사 가능
	 // else문 위의 모든것들이 포함이 안되면 무료 검강검진 대상이 아님
	 
	    private int getAge() {
	        return LocalDate.now().getYear() - birthYear + 1;
	    }
	}
	// age는 getAge() 메소드를 호출하여 반환된 결과값을 저장하기 위한 변수
	// getAge()는 앞에서 받은 인스턴수 변수 birthYear 받은 나이를 저장하고
	// import문을 이용한 localDate.now.getYear() - birthYear + 1;
	// +1은 만 나이를 계산하기 위함 
 	// EX: 98년생 현재 나이 26
	// Ex: LocalDate.now.getYear() - birthYear 2023 - 1998 = 25
	 
	 
class MemberChap03Main {	// public은 한 클래스 내에서 하나만 사용 가능
    public static void main(String[] args) { // 실행을 위한 메인메소드 호출
        MemberChap03 memberChap03 = new MemberChap03("권성준", 1998);
        memberChap03.checkVaccination();
        memberChap03.checkHealthExam();
    }
}

	// 인스턴스 memberChap03을 생성하고 new 새로운 객체를 위한 메모리 할당
	// 따라서 new MemberChap03은 MemberChap03의 클래스의 객체를 생성하고
	// 해당 객체의 메모리 할당
	// 이때 MemberChap03의 생성자가 호출되어 인스턴수의 초기화가 진행

	 // 풀어 설명하자면 
	 // MEmberChap03Main안에서 MemberChap03클래스의 인스턴스 변수를 초기화 하기위한 
	 // memberchap03을 생성하고 new MemberChap03은 MemberChap03클래스의 객체를 생성하고  
	 // MemberChap03의 생성자가 호출되어 인스턴수의 초기화가 진행되어 권성준과 1998을 넣어준것 
	 
	 