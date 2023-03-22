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
	
	// 생성자 정의
	public Student(String name, int age, int studentId, String department) {
		this.name = name;
		this.age = age;
		this.studentId = studentId;
		this.department = department;
	}
	
	// Getter Setter 정의
	
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
	
	public void print() {
		System.out.println(name);
		System.out.println(age);
		System.out.println(studentId);
		System.out.println(department);
	}
	
}

class school {
	public static void main(String [] args) {
		Student student = new Student ("권성준", 26, 20170483, "경제학과");
		student.print();
	}
}
