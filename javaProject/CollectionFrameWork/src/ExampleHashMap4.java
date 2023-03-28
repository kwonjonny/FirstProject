//Person 클래스와 Student 클래스를 정의하고,
//Student 클래스가 Person 클래스를 상속받도록 하였습니다.
//그리고 HashMap을 이용하여 학번을 Key로 하고 Student 객체를 Value로 하는 studentMap을 정의하고
//Student 객체를 생성하여 studentMap에 추가하였습니다. 그리고 studentMap에서 데이터를 가져오기
//수정하기, 삭제하기, 출력하기를 하는 코드를 작성하시오
// Person 클래스는 name과 age의 인스턴스 변수가 있습니다 
 
// Person 클래스에선 인스턴스 변수를 선언하고
// 생성자를 정의합니다
// 또한 Getter와 Setter도 정의합니다 
import java.util.HashMap;

class Person {
	
	// 인스턴스 변수 정의
	private String name;
	private String age;
	
	// 생성자 정의 
	public Person(String name, String age) {
		this.name = name;
		this.age = age;
	}
	
	// Getter 와 Setter 정의 캡슐화,정보은닉,차후 보수 용이
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}


// Student클래스에서는 Person클래스의 상속을 받으며 
// Student id 라는 인스턴스를 새로 선언합니다 
// Getter와 Setter도 정의합니다
class Student extends Person {
	
	// 인스턴스 변수 정의
	private String id;
	
	// 생성자 정의 super을 통한 Person클래스 상속
	public Student(String name, String age, String id) {
		super(name,age);
		this.id = id;
	}
	
	// Getter 와 Setter 정의 캡슐화 정보은닉,차후 보수 용이
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}

// ExampleHashMap4클래스에서는
// HashMap을 이용해 <integer, Student> 로의 Student클래스를 포함하고 
// 객체는 = studentMap으로 선언합니다

// 또한 StudentMap에 데이터를 추가합니다 String String String 형

// 또한 studnetMap.put으로 데이터를 추가할때 생성된 객체에 
// Student클래스의 id를 가져오고 student1,2객체에 넣어줍니다

// id를 가져왔으면 student객체에 id를 String형으로 넣어줍니다
// 그리고 출력을 해야 됨으로 if를통해 student객체를 확인하고 이름 나이 학번을 출력해줍니다

// 또한 HashMap은 studentMap에서 데이터를 수정할수 있으므로 수정도 해줍니다
// 또한 HashMap은 studemtMap에서 데이터를 삭제할수도 있으므로 삭제도 해줍니다
// 마지막으로 for-each문을 통한 모든 데이터를 key-value확인을 통해 출력해줍니다.
public class ExampleHashMap4 {
	
	// HashMap사용과 출력을 위한 메인메소드 정의
	public static void main(String [] args) {
	
	// HashMap정의
	HashMap<String, Student> studentMap = new HashMap<>();
	
	// StudentMap에 데이터를 추가합니다 
	// student1과2의 객체는 Student클래스의 상속을 받으며 이름,나이,학번 입력
	Student student1 = new Student("권성준","25","17035");
	Student student2 = new Student("김선제", "26", "23456");
	
	studentMap.put(student1.getId(), student1);
	studentMap.put(student2.getId(), student2);
	
	
	}
	
}
