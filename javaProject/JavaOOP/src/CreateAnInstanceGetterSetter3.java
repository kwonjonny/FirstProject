

//Person 클래스를 안에는 name age email이 있고 Main 클래스에서 
//Person 객체를 생성하고 각 속성에 값을 설정하고 출력하세요 객체의속성을 
//그대로 출력하고 속성을수정하고  수정된 객체를 출력하세요 



public class CreateAnInstanceGetterSetter3 {
	
	
	// 인스턴스 변수 생성
	private String name;
	private int age;
	private String email;
	
	
	// 생성자 정의
	public CreateAnInstanceGetterSetter3(String name, int age, String email) {
		this.name=name;
		this.age=age;
		this.email=email;
	}
	
	// Getter와 Setter 생성 캡슐화 정보은닉 private의 접근제어자를 다른 클래스에서의 호출 가능하게 해준다 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}

class Cain {
	public static void main(String [] args) {
		
		CreateAnInstanceGetterSetter3 person = new CreateAnInstanceGetterSetter3("권성준", 24, "thistrik@wer.com");
		
		// 객체의 속성 출력
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Email: " + person.getEmail());
        
        // set의 설정을 수정하고 
        // main메소드 안에서의 값 변경
        person.setName("김선제");
		person.setAge(24);
		person.setEmail("thistrik@naver.com");
		
		// 값 변경된 코드 출력 
		System.out.println(person.getAge());
		System.out.println(person.getAge());
		System.out.println(person.getEmail());
		
	}
}
