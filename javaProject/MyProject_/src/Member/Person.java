package Member;
// Person 클래스를 만들어 보고, 아래의 회원 정보를 저장하는 변수들을 선언해봅시다.
// 변수이름을 작성하는 규칙에 맞게 직접 변수 이름을 정의해 보세요.
// 회원이름을 저장하는 변수
// 회원 전화번호 ( 000-0000-0000 )를 저장하는 변수
// 회원 주민등록번호 ( 000000-0000000 또는 0000000000000 )를 저장하는 변수
public class Person {
	
		// 인스턴스 변수 정의
		// 접근제어자 public 이 아닌 private를 이용해 다른 클래스 접근 불가
		private String name;
	    private String phoneNumber;
	    private String residentNumber;
	    
	    
	    // 생성자 정의
	    // 생성자 안에서는 매개변수가 인스턴스변수를 초기화해 준다
	    public Person(String name, String phoneNumber, String residentNumber) {
	        this.name = name;
	        this.phoneNumber = phoneNumber;
	        this.residentNumber = residentNumber;
	    }   
      
	    // Getter & Setter = 캡슐화,정보은닉,타클래스에서의 private 인스턴스변수 호출 가능하게 해준다
	    public String getName() {
	        return name;
	    }

	    public void setName() {
	        this.name = name;
	    }
	  
	    
	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPhoneNumber() {
	        this.phoneNumber = phoneNumber;
	    }
	   
	    
	    public String getResidentNumber() {
	        return residentNumber;
	    }

	    public void setResidentNumber() {
	        this.residentNumber = residentNumber;
	    }
	    

class Name { 	
    public static void main(String[] args) {
        Person person = new Person("권성준", "010-1234-5678", "980626-1234567"); 
        //객체생성 person은 "권성준", "010-1234-5678", "980626-1234567" 의 정보를 가지고있다
        
        // 정보 출력
        System.out.println("회원 이름: " + person.getName());
        System.out.println("전화번호: " + person.getPhoneNumber());
        System.out.println("주민등록번호: " + person.getResidentNumber());
  
    	} 
	}

}

	
	
	
	
