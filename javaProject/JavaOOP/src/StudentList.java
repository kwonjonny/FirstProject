import java.util.ArrayList;

//ArrayList를 사용하여 학생들의 정보를 관리하는 StudentList 클래스를 만들고자 합니다. 
//이 클래스는 다음과 같은 요구사항을 만족해야 합니다.
//
//Student 클래스는 이름(name)과 학번(id) 필드를 갖고 있으며, 
//생성자와 각 필드의 getter/setter 메서드를 포함합니다.

//StudentList 클래스는 ArrayList<Student> students 인스턴스 변수를 갖고 있으며, 
//생성자와 getter/setter 메서드를 포함합니다.
//StudentList 클래스에는 addStudent(Student student) 
//메서드가 있어서 students 리스트에 학생을 추가할 수 있습니다.
//
//StudentList 클래스에는 printStudents() 메서드가 있어서 students 
//리스트에 있는 모든 학생의 이름과 학번을 출력할 수 있습니다.
//
//StudentList 클래스를 상속받는 GraduateStudentList 클래스를 만들고 
//addStudent() 메서드를 오버라이딩하여 전공 필드(major)를 추가적으로 받도록 해주세요.
//
//GraduateStudentList 클래스의 생성자는 StudentList 클래스의 생성자를 
//호출하며, major 필드의 getter/setter 메서드도 포함해야 합니다.

class Ptudent {
	// 인스턴스 변수 정의
    private String name;
    private String id;

    // 생성자 정의
    public Ptudent(String name, String id) {
        this.name = name;
        this.id = id;
    }

    // Getter Setter정의 캡슐화,정보은닉,보수용이
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}

public class StudentList {
	
	// 인스턴스 변수 정의
	private ArrayList<Ptudent> students;
	
	// 생성자 정의
	public StudentList() {
		this.students = students;
	}
	
	// Getter Setter정의 캡슐화,정보은닉,보수용이
	public ArrayList<Ptudent> getStudents() {
		return students;
	}
	public void setStudents() {
		this.students = students;
	}
	
	
	//StudentList 클래스에는 addStudent(Student student) 
	//메서드가 있어서 students 리스트에 학생을 추가할 수 있습니다.
	public void addStudent(Ptudent student) {
		students.add(student);
	}
	
	//StudentList 클래스에는 printStudents() 메서드가 있어서 students 
	//리스트에 있는 모든 학생의 이름과 학번을 출력할 수 있습니다.
	public void printStudents() {
		for(Ptudent student : students) {
			System.out.println("이름"+student.getName() + "학번" + student.getId());
		}
	}
	
}




