import java.util.ArrayList;

// 문제: 교수(Professor) 클래스와 대학(Univ) 클래스를 구현하려고 합니다.
// 교수 클래스는 이름(name), 전공(major), 연구실(room) 변수를 가지며,
// 이 변수들에 대한 게터(getter)와 세터(setter) 메소드를 가지고 있습니다.
// 교수 클래스에 대한 생성자도 구현해야 합니다.
//
// 대학 클래스는 교수 클래스의 리스트를 가지고 있으며, 
// 이 리스트에 대한 게터(getter)와 세터(setter) 메소드를 가지고 있습니다.
// 대학 클래스에 대한 생성자도 구현해야 합니다.
//
// 위 요구사항을 바탕으로 교수 클래스와 대학 클래스를 구현하고, 대학 클래스에 3명의 교수를 추가하고,
// 추가한 교수들의 이름을 출력하는 코드를 작성하십시오.
// ArrayList를 활용하여 교수 클래스를 추가하면됩니다

public class University {
	
	// 인스턴스 변수 정의 ArrayList
	private ArrayList<Professor> professor;
	
	// 생성자 정의
	public University() {
		this.professor = new ArrayList<>();
	}
	
	// Getter Setter 정의 캡슐화,정보은닉,보수용이
	public ArrayList<Professor> getProfessor() {
		return professor;
	}
	public void setProfessor(ArrayList<Professor> professor) {
		this.professor = professor;
	} 
	
	public void addProfessor(Professor professor) {
		this.professor.add(professor);
	}
	
}

class Professor {
	
	// 인스턴스 변수 정의
	String name;
	String major;
	String room;
	
	// 생성자 정의
	public Professor(String name, String major, String room) {
		this.name = name;
		this.major = major;
		this.room = room;
	}
	
	// Getter Setter 정의 캡슐화,정보은닉,보수용이
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
}

class wwee {
	public static void main(String [] args) {
		
		// 객체 생성
		University uni = new University();
		uni.addProfessor(new Professor("권성준","경제학","201호"));
		uni.addProfessor(new Professor("Jane Smith", "Mathematics", "Room 202"));
		uni.addProfessor(new Professor("Bob Johnson", "Physics", "Room 303"));
		
		// ArrayList 객체 생성
		ArrayList<Professor> professors = uni.getProfessor();
		for(Professor professor : professors) {
			System.out.println(professor.getName()+professor.getMajor()+professor.getRoom());
		}
		
	}
}