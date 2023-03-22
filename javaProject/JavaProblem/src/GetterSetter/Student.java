package GetterSetter;

public class Student {

	// 문제: 학생 정보를 저장하는 Student 클래스를 구현하시오. 학생 정보에는 이름(name), 
	//나이(age), 학번(studentId), 학과(department)가 있다.
	
	//Student 클래스는 적절한 변수를 정의해야 한다.
	
	//Student 클래스는 이름, 나이, 학번, 학과 정보를 받아서 초기화하는 생성자를 가진다.
	
	//Student 클래스는 getter/setter 메소드를 가지며, 모든 변수에 대해 getter/setter가 제공되어야 한다.
	
	//Student 클래스는 학생 정보를 출력하는 print() 메소드를 가진다. 출력 형식은 다음과 같다.
	
	//"이름: <이름>, 나이: <나이>, 학번: <학번>, 학과: <학과>"
	
	//Student 클래스를 다른 클래스에서 호출하여 학생 정보를 입력하고, print() 메소드를 호출하여 
	//출력하는 코드를 작성하시오.

	// 변수 정의
	private String name;
	private int age;
	private int studentId;
	private String department;
	// 변수 정의 에서는 다른 클래스에서의 호출을 막기위해 접근제어자 private를 쓴다
	
	// 생성자 정의
	public Student(String name, int age, int studentId, String department) {
		this.name = name;
		this.age = age;
		this.studentId = studentId;
		this.department = department;
	}
	// 생성자 정의 에서는 매개변수 name, age, studentId, department를 생성하고
	// 매개변수를 인스턴스변수로 바꿔줄수있는 this.name = name; 을 써서 인스턴스 변수로 변환해준다
	
	// Getter Setter 정의
	// Getter는 Student 매개변수에서 인스턴스로 변환된 변수 접근
	// Setter는 Student 매개변수에서 인스턴스로 변환된 변수에 값을 설정하기위해 접근 
	
	//get
	public String getName() {
		return name;
	}
	//set
	public void setName(String name) {
		this.name = name;
	}
	
	
	//get
	public int getAge() {
		return age;
	}
	//set
	public void setAge(int age) {
		this.age = age;
	}
	

	//get
	public int getStudnetId() {
		return studentId;
	}
	//set
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	
	//get
	public String getDepartment() {
		return department;
	}
	//set
	public void setDepartment(String department) {
		this.department = department;
	}
	
	// 출력메소드
	public void print() {
		System.out.println(name);
		System.out.println(age);
		System.out.println(studentId);
		System.out.println(department);
	}
	
}

class school {
	// 호출
	public static void main(String [] args) {
		Student student = new Student("권성준", 26, 20170483, "경제학과");
		student.print();
	}
}
	// 소문자 student는 대문자 Student 위쪽 클래스의 인스턴스를 사용하기 위한 변수 이름
	// 이 변수를 통해 인스턴스의 호출 가능

	// new Student("권성준", 26, 20170483, "경제학과");는
	// Student 클래스의 생성자를 호출하여 Person클래스의 인스턴스를 생성
	// 인스턴스 변수 name, age, studentID, department의 값을 초기화하고 있다
	// 즉 생성자의 매개변수로 전달된 값들이 setName, setAge, setStudentId, setDepartment
	// 메서드를 호출하여 각각의 인스턴스 변수에 저장된다
	// 이후 student.print();을 호출하면 인스턴스 변수들의 값이 출력된다
	       
