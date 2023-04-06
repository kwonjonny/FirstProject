package Person;

import java.util.ArrayList;
import java.util.Scanner;

//문제:
//Person 클래스를 상속하는 Student 클래스와 Employee 클래스를 구현해보세요.
//Student 클래스는 Person 클래스의 속성(name, age, gender, height, weight)을 상속받고,
//학번과 전공 정보를 추가로 가지고 있어야 합니다.
//이 정보들을 출력하는 메서드를 추가로 가지고 있어야 합니다.
//
//Employee 클래스는 Person 클래스의 속성(name, age, gender, height, weight)을 상속받고,
//사번과 직급 정보를 추가로 가지고 있어야 합니다.
//이 정보들을 출력하는 메서드를 추가로 가지고 있어야 합니다.
//
//ArrayList를 활용하여 Student 객체들과 Employee 객체들을 저장하고,
//검색, 추가, 삭제 등의 다양한 컬렉션 메서드를 활용하여 객체들을 관리해보세요.
//메인 메서드에서는 while을 사용하여 간단한 메뉴를 구성하여 사용자가 입력한 메뉴에 따라
//객체를 추가, 삭제, 검색하거나, 현재 저장된 객체의 목록과 정보를 출력하는 기능을 구현해보세요.

//주석과 문서화: 클래스, 메서드, 필드 등에 주석을 추가하여 코드를 문서화해보세요.
//JavaDoc과 같은 문서화 도구를 활용하여 클래스와 관련된 API 문서를 자동으로 생성해보세요.

//위 문제에서는 Person 클래스를 상속하는 Student 클래스와 Employee 클래스를 구현해야 합니
//다. Student 클래스는 Person 클래스의 속성(name, age, gender, height, weight)을 
//상속받고, 학번(studentId)과 전공(major) 정보를 추가로 가지고 있어야 합니다. 
//Employee 클래스는 Person 클래스의 속성(name, age, gender, height, weight)을
//상속받고, 사번(employeeId)과 직급(position) 정보를 추가로 가지고 있어야 합니다.

public class Person {

	// 인스턴스 변수 정의
	private String name;
	private String age;
	private String gender;
	private String height;
	private String weight;

	// 생성자 정의
	public Person(String name, String age, String gender, String height, String weight) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
	}

	// Getter Setter정의
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	// 추상 메소드 정의
	public void printinfo() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		System.out.println("성별: " + gender);
		System.out.println("키: " + height);
		System.out.println("몸무게: " + weight);
	}

}

class Student extends Person {

	// 인스턴스 변수 정의
	private String studentNumber;
	private String major;

	// 생성자 정의
	public Student(String name, String age, String gender, String height, String weight, String studentNumber,
			String major) {
		super(name, age, gender, height, weight);
		this.studentNumber = studentNumber;
		this.major = major;
	}

	// Getter Setter 정의
	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	// 추상 메소드 오버라이딩
	public void StudentInfo() {
		super.printinfo();
		System.out.println("학번: " + studentNumber);
		System.out.println("전공: " + major);
	}
}

class Employee extends Person {

	// 인스턴스 변수 정의
	private String employeeNumber;
	private String position;

	// 생성자 정의
	public Employee(String name, String age, String gender, String height, String weight, String employeeNumber,
			String position) {
		super(name, age, gender, height, weight);
		this.employeeNumber = employeeNumber;
		this.position = position;
	}

	// Getter Setter
	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	// 추상 메소드 오버라이딩
	public void EmployeeInfo() {
		super.printinfo();
		System.out.println("사원번호: " + employeeNumber);
		System.out.println("직급: " + position);
	}
}

interface CurdOperation {

	// 학생 정보 생성
	public static void createStudent() {
	}

	// 학생 정보 삭제
	public static void deleteStudent() {
	}

	// 학생 정보 수정
	public static void modifyStudent() {
	}

	// 학생 정보 출력
	public static void ShowDataStudent() {
	}

	// 사원 정보 생성
	public static void createEmployee() {
	}

	// 사원 정보 삭제
	public static void deleteEmployee() {
	}

	// 사원 정보 수정
	public static void modifyEmployee() {
	}

	// 사원 정보 출력
	public static void ShowDayaEmployee() {
	}

}

// 예외 클래스 정의 
class ExceptionHelper1 {
	public static void handleException(Exception e) {
		System.out.println("잘못된 입력입니다 관리자에게 문의하세요>" + e.getMessage());
	}
}

class Main implements CurdOperation {

	// 어레이 리스트 정의
	private static ArrayList<Student> studentList = new ArrayList<>();
	private static ArrayList<Employee> employeeList = new ArrayList<>();
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			try {
				System.out.println("==== 학생, 직원 관리 프로그램 ====");
				System.out.println("1. 학생 정보 생성");
				System.out.println("2. 학생 정보 삭제");
				System.out.println("3. 학생 정보 수정");
				System.out.println("4. 학생 정보 출력");
				System.out.println("5. 직원 정보 생성");
				System.out.println("6. 직원 정보 삭제");
				System.out.println("7. 직원 정보 수정");
				System.out.println("8. 직원 정보 출력");
				System.out.println("9. 종료");
				System.out.println("원하는 번호를 선택하세요 (1~9)");
				int choice = scan.nextInt();
				scan.nextLine();

				switch (choice) {
				case 1:
					createStudent();
					break;
				case 2:
					deleteStudent();
					break;
				case 3:
					modifyStudent();
					break;
				case 4:
					showDataStudent();
					break;
				case 5:
					createEmployee();
					break;
				case 6:
					deleteEmployee();
					break;
				case 7:
					modifyEmployee();
					break;
				case 8:
					showDataEmployee();
					break;
				case 9:
					System.out.println("======종료=======");
					return;
				default:
					System.out.println("잘못된 입력이에요.");
				}

			} catch (Exception e) {
				ExceptionHelper1.handleException(e);
			}
		}
	}

	// 학생 정보 생성
	private static void createStudent() {
		System.out.println("학생 이름을 입력해주세요: ");
		System.out.println("이름: ");
		String name = scan.nextLine();
		System.out.println("나이: ");
		String age = scan.nextLine();
		System.out.println("성별: ");
		String gender = scan.nextLine();
		System.out.println("키: ");
		String height = scan.nextLine();
		System.out.println("몸무게: ");
		String weight = scan.nextLine();
		System.out.println("학번: ");
		String studentNumber = scan.nextLine();
		System.out.println("전공: ");
		String major = scan.nextLine();

		Student student = new Student(name, age, gender, height, weight, studentNumber, major);
		student.setName(name);
		student.setAge(age);
		student.setGender(gender);
		student.setHeight(height);
		student.setWeight(weight);
		student.setStudentNumber(studentNumber);
		student.setMajor(major);

		studentList.add(student);
		System.out.println("학생 정보가 추가되었습니다.");
	}

	// 학생 정보 삭제
	private static void deleteStudent() {
		System.out.println("삭제할 학생 이름 입력: ");
		String name = scan.nextLine();

		boolean isDelete = false;
		for (Student students : studentList) {
			if (students.getName().equals(name)) {
				studentList.remove(students);
				{
					System.out.println("학생 정보가 삭제되었습니다.");
					break;
				}
			}
			if (!isDelete) {
				System.out.println("해당 학생 이름이 없습니다.");
			}
		}
	}

	// 학생 정보 수정
	private static void modifyStudent() {
		System.out.println("수정할 학생 이름 입력: ");
		String name = scan.nextLine();

		boolean isModify = false;
		Student updateStudent = null;
		for (Student students : studentList) {
			if (students.getName().endsWith(name))
				;
			{
				updateStudent = students;
				isModify = true;
				System.out.println("학생 정보가 수정되었습니다.");
				break;
			}
		}
		if (!isModify) {
			System.out.println("해당 학생 이름이 없습니다.");
		}
	}

	// name age gender height weight studentNumber major
	// 학생 정보 출력
	private static void showDataStudent() {
		System.out.println("정보 출력할 학생 이름 입력: ");
		String name = scan.nextLine();

		boolean isShowData = false;
		Student ShowData = null;
		for (Student students : studentList) {
			if (students.getName().equals(name)) {
				System.out.println("이름: " + students.getName());
				System.out.println("나이: " + students.getAge());
				System.out.println("성별: " + students.getGender());
				System.out.println("키: " + students.getHeight());
				System.out.println("몸무게: " + students.getWeight());
				System.out.println("학생 학번: " + students.getStudentNumber());
				System.out.println("학생 전공: " + students.getMajor());
				System.out.println("관리자 정보가 출력되었습니다.");
				isShowData = true;
				break;
			}
		}
		if (!isShowData) {
			System.out.println("해당 학생 이름이 없습니다.");
		}
	}

	// 사원 정보 추가
	private static void createEmployee() {
		System.out.println("사원 이름을 입력해주세요: ");
		System.out.println("이름: ");
		String name = scan.nextLine();
		System.out.println("나이: ");
		String age = scan.nextLine();
		System.out.println("성별: ");
		String gender = scan.nextLine();
		System.out.println("키: ");
		String height = scan.nextLine();
		System.out.println("몸무게: ");
		String weight = scan.nextLine();
		System.out.println("사원번호: ");
		String employeeNumber = scan.nextLine();
		System.out.println("직급: ");
		String position = scan.nextLine();
		// 사원 객체 생성
		Employee employee = new Employee(name, age, gender, height, weight, employeeNumber, position);
		// employeeList 에 사원 정보 추가
		employeeList.add(employee);
		System.out.println("사원 정보가 생성되었습니다.");
	}

	// 사원 정보 삭제
	private static void deleteEmployee() {
		System.out.println("삭제할 사원의 이름 입력: ");
		String name = scan.nextLine();

		// employeeList에 해당하는 사원 정보 삭제
		boolean isDeleted = false;
		for (Employee employees : employeeList) {
			if (employees.getName().equals(name)) {
				employeeList.remove(employees);
				{
					isDeleted = true;
					System.out.println("사원의 정보가 삭제되었습니다.");
					break;
				}
			}
		}
		if (!isDeleted) {
			System.out.println("해당하는 사원의 이름이 없습니다.");
		}
	}

	// 사원 정보 수정
	private static void modifyEmployee() {
		System.out.println("수정할 사원의 이름 입력: ");
		String name = scan.nextLine();

		// employeList for-each로 비교후 수정
		boolean isModify = false;
		Employee updateEmployee = null;
		for (Employee employees : employeeList) {
			if (employees.getName().equals(name)) {
				updateEmployee = employees;
				isModify = true;
				System.out.println("사원 정보가 수정되었습니다.");
				break;
			}
		}
		if (!isModify) {
			System.out.println("해당 사원의 이름이 없습니다.");
		}
	}

	// 사원 정보 출력
	private static void showDataEmployee() {
		System.out.println("정보 출력할 사원 이릅 입력: ");
		String name = scan.nextLine();
		boolean isFound = false;
		Employee showData = null;
		for (Employee employees : employeeList) {
			if (employees.getName().equals(name)) {
				System.out.println("이름 " + employees.getName());
				System.out.println("이름 " + employees.getAge());
				System.out.println("이름 " + employees.getGender());
				System.out.println("이름 " + employees.getHeight());
				System.out.println("이름 " + employees.getWeight());
				System.out.println("이름 " + employees.getEmployeeNumber());
				System.out.println("직급 " + employees.getPosition());
				System.out.println("사원 정보가 출력되었습니다.");
				isFound = true;
				break;
			}
		}
		if (!isFound) {
			System.out.println("해당하는 사원 이름이 없습니다.");
		}
	}
}