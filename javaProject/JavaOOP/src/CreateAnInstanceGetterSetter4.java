

//객체지향 프로그래밍과 클래스, 인스턴스 개념을 활용하여 학생 정보를 저장하고 출력하는 코드를 작성해보세요.
//학생 이름 나이 학번
//메인 메소드 안에서는
//학생 정보를 생성하는 객체를 만들고
//학생 정보를 출력해보세요오
public class CreateAnInstanceGetterSetter4 {
	
	// 인스턴스 변수 정의
	private String name;
	private String studentId;
	
	// 생성자 정의
	public CreateAnInstanceGetterSetter4(String name, String studentId) {
		this.name = name;
		this.studentId = studentId;
	}
	
	// Getter Setter정의 캡슐화,정보은닉,보수용이
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

}

class Dain {
	public static void main(String[] args) {
		CreateAnInstanceGetterSetter4 student1 = new CreateAnInstanceGetterSetter4("권성준", "230452");
		CreateAnInstanceGetterSetter4 student2 = new CreateAnInstanceGetterSetter4("김선제", "234532");
		
		System.out.println(student1.getName()+student1.getStudentId());
		System.out.println(student2.getName()+student1.getStudentId());
		
	}
}
