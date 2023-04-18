//문제: 학생(Student) 클래스와 학교(School) 클래스를 구현하려고 합니다. 학생 클래스는 이름(name), 학년(grade), 전공(major) 변수를 가지며, 
//이 변수들에 대한 게터(getter)와 세터(setter) 메소드를 가지고 있습니다. 학생 클래스에 대한 생성자도 구현해야 합니다.
//
//학교 클래스는 학생 클래스의 리스트를 가지고 있으며, 이 리스트에 대한 게터(getter)와 세터(setter) 메소드를 가지고 있습니다.
//학교 클래스에 대한 생성자도 구현해야 합니다.
//
//위 요구사항을 바탕으로 학생 클래스와 학교 클래스를 구현하고, 학교 클래스에 3명의 학생을 추가하고, 
//추가한 학생들의 이름을 출력하는 코드를 작성하십시오.

// ArrayList import
import java.util.ArrayList;

// 학생 클래스 정의 
public class Student{
	
	// 인스턴스 변수 정의
	private String name;
	private String age;
	private String major;
	
	// 생성자 정의
	public Student(String name, String age, String major) {
		this.name = name;
		this.age = age;
		this.major = major;
	}
	
	// Getter Setter 정의 캡슐화,정보은닉,보수용이
	public String getName() {
		return name;
	}
	public void setName() {
		this.name = name;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge() {
		this.age = age;
	}
	
	public String getMajor() {
		return major;
	}
	public void setMajor() {
		this.major = major;
	}
	
	// toString객체 생성 
	@Override
	public String toString() {
		return "이름:" + this.name + "24:" + this.age + "전공:" + this.major;
	}
	
}

// 학교 클래스 정의 
class School {
	// 학생 리스트 인스턴스변수 정의 
	private ArrayList<Student> studentList;
	
	// 생성자 생성
	public School(ArrayList<Student> studnetList) {
		this.studentList = studentList;
	}
	
	// Getter Setter정의 캡슐화,정보은닉,보수용이
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	public void setStudnetList() {
		this.studentList = studentList;
	}
	
}

// 출석부 클래스 정의 
class Attendance {
	// 출력을 위한 메인 메소드 생성
	public static void main(String [] args) {
		
		// 출셕부 객체 생성
		Student student = new Student("Alice", "24", "economic");
		Student student2 = new Student("Jane", "25", "economic");
		Student student3 = new Student("Jone", "26", "economic");
		
		// 추가한 학생의 출력
		ArrayList<Student> studentList = new ArrayList<>();
		studentList.add(student);
		studentList.add(student2);
		studentList.add(student3);
		
		// School객체 생성
		School school = new School(studentList);
		
		// 추가한 학생의 이름 출력 
		for(Student student1: school.getStudentList()) {
		System.out.println(student1.toString()); 
		}
	}
}