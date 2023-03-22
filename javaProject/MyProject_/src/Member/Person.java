package Member;
// Person 클래스를 만들어 보고, 아래의 회원 정보를 저장하는 변수들을 선언해봅시다.
// 변수이름을 작성하는 규칙에 맞게 직접 변수 이름을 정의해 보세요.
// 회원이름을 저장하는 변수
// 회원 전화번호 ( 000-0000-0000 )를 저장하는 변수
// 회원 주민등록번호 ( 000000-0000000 또는 0000000000000 )를 저장하는 변수
public class Person {
	
		// 변수 정의
	 	private String name;
	    private String phoneNumber;
	    private String residentNumber;
	    // 접근제어자 private
	    // private 로 선언하는 이유는 
	    // 다른 클래스내에서의 호출을 방지하기위해 
	    // Person의 클래스 내에서만 사용할수있게 속박해두는것 
	    
	    // 생성자 정의
	    public Person(String name, String phoneNumber, String residentNumber) {
	        this.name = name;
	        this.phoneNumber = phoneNumber;
	        this.residentNumber = residentNumber;
	    }   
        // this.name = name 에서 this.name은 인스턴스 변수 this.name= "name" 을 가르키고 
        // name은 생성자의 매개변수 public Person(String "name") 을 가르킨다 생성자의 매개변수 public Person(String "name") 으로 전달된 값을
        // 인스턴수 변수 this.name = "name"에 대입하기 위해 this의 키워드 사용
	    // 즉 매개변수 String "name" 을 인스턴수 변수 this."name" 으로 변환시켜 get&set에서 쓰려고 하는 것

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }
	    // 인스턴스 변수로의 접근을 위해 get set 이라는 메소드를 쓴다 
	    // 예를 들어, Person 클래스의 인스턴스 변수인 name에 접근하고 싶다면, getName() 메서드를 사용하여 해당 변수의 값을 반환하고
	    // setName() 메서드를 사용하여 변수에 값을 설정할 수 있다
	    
	    // getName 메소드를 호출하여 인스턴수변수 name접근
	    // setName 메소드를 호출하여 변수에 값을 설정
	    
	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }
	    // getPhoneNumber 메소드를 호출하여 인스턴수변수 phoneNumber접근
	    // setPhoneNumber 메소드를 호출하여 변수에 값을 설정
	    
	    public String getResidentNumber() {
	        return residentNumber;
	    }

	    public void setResidentNumber(String residentNumber) {
	        this.residentNumber = residentNumber;
	    }
	    // getResidentNumber 메소드를 호출하여 인스턴스 변수 residentNumber접근
	    // setResidentNumber 메소드를 호출하여 변수에 값을 설정
	    
	    // 출력 메소드 정의
	    public void print() {
	        System.out.println("Name: " + name);
	        System.out.println("Phone number: " + phoneNumber);
	        System.out.println("Resident number: " + residentNumber);
	    }
}	
		// print의 메소드안에는 get의 인스턴수 변수를 호출중이고 
		// 출력시 가독성을 높이기 위해 "Name: " , "Phone number: " , "Resident number: " 을 사용

	class Name { // 클래스의 앞에 public이 안 붙는 이유는 public은 한 파일 내에서만 작성하는것이 정석
				 // 그럼 Name클래스 안에는 main 메소드를 쓰고 
				 // Person 클래스 안에는 main 메소드가 없는 이유는 
				 // 클래스에서 실행을 하기 위해선 main메소드가 필요하며 
				 // Person클래스 내 에서는 실행이 따로 필요없기 때문에 쓰지 않는다
    public static void main(String[] args) {
        Person person = new Person("권성준", "010-1234-5678", "980626-1234567");
        person.print();
    }
}
	// 소문자 person은 대문자 Person (위쪽)클래스의 인스턴스를 사용하기 위한 변수 이름
    // 이 변수를 통해 인스턴스에 접근하고 메소드 호출 가능
           
    // new Person("권성준", "010-1234-5678", "980626-1234567")은 
    // Person 클래스의 생성자를 호출하여 Person 클래스의 인스턴스를 생성하면서, 
    // 인스턴스 변수 name, phoneNumber, residentNumber의 값을 초기화하고 있다
    // 즉, 생성자의 매개변수로 전달된 값들이 setName, setPhoneNumber, setResidentNumber 
    // 메서드를 호출하여 각각의 인스턴스 변수에 저장된다
    // 이후 person.print()를 호출하면 인스턴스 변수들의 값이 출력된다
	
	
	
	
