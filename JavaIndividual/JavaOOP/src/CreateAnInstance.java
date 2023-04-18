

//객체 생성과 관련된 문제를 하나 만들어봅시다.
//문제: 학생 객체를 생성하는  CreateAnInstance클래스 를 작성하세요. 
//학생 객체는 이름(name)과 나이(age)를 갖습니다!

public class CreateAnInstance {
	
	// 멤버 변수 선언 "name" , "age"
	private String name;	//인스턴스변수	
	private int age;		//인스턴스변수
	
	//(public "CreateAnInstance") "public"=접근제어자, "CreateAnInstance"=생성자의 메소드 이름 
	// 접근제어자 메소드(String name, int age) 중 name과 age는 매개변수
	// 이렇게 선언된 매개변수를 this.name = name;과 this.age=age;를 통해서 private String name;과 private String int age;
	// 인스턴스변수에 매개변수로 전달된다 
	public CreateAnInstance(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// CreateAnInstance student1은 클래스 내에서 선언된 인스턴스 변수이며 
	// new CreateAnInstance는 클래스 내의 생성자 public CreateAnInstance를 호출하여 "권성준", 24인스턴스 변수 생성
	// "권성준", 24이라는 인스턴스 변수는 student1이라는 변수에 할당되어 해당 클래스의 인스턴스 변수가 됨
	
	CreateAnInstance student1 = new CreateAnInstance("권성준", 24);
	
}