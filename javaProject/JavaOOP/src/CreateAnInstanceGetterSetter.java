//문제: Student 클래스와 Main 클래스를 만들어, 학생의 이름, 학년, 국어/영어/수학 점수를 입력받아 계산한 평균과 총점을 출력하는 프로그램을 작성하세요.
//
//요구사항:Student 클래스에는 이름, 학년, 국어/영어/수학 점수를 저장하는 인스턴스 변수를 선언하세요.
//Student 클래스에는 Getter와 Setter 메소드를 구현하세요.
//Main 클래스에서는 사용자로부터 이름, 학년, 국어/영어/수학 점수를 입력받아 Student 객체를 생성하세요.
//생성된 Student 객체를 이용해 계산한 평균과 총점을 출력하세요!


public class CreateAnInstanceGetterSetter {
	
	// 인스턴스 변수 선언
	private String name;
	private String grade;
	private int korean;
	private int english;
	private int math;
	
	// 생성자 호출
	// 매개변수를 인스턴스 변수 선언한 곳에 전달해주는
	// this.name=name; 사용
	public CreateAnInstanceGetterSetter(String name, String grade, int korean, int english, int math) {
		this.name=name;
		this.grade=grade;
		this.korean=korean;
		this.english=english;
		this.math=math;
	}
	
	// Get Set을 이용한 캡슐화 정보은닉
	public String getName() {
		return name;
	}
	public void setName() {
		this.name = name;
	}
	
	
	public String getGrade() {
		return grade;
	}
	public void setGrade() {
		this.grade = grade;
	}
	
	
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	
	
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	
	
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	//Main 클래스에서는 사용자로부터 이름, 학년, 국어/영어/수학 점수를 입력받아 Student 객체를 생성하세요.
	public static void main(String [] args) {
		CreateAnInstanceGetterSetter student = new CreateAnInstanceGetterSetter("권성준", "2학년", 80, 50, 40);
		
		// 기대하는 출력값 권성준 2학년 80 50 40
		System.out.println("이름"+student.getName());
		System.out.println("학년"+student.getGrade());
		System.out.println("한국어"+student.getKorean());
		System.out.println("영어"+student.getEnglish());
		System.out.println("수학"+student.getMath());
		//생성된 Student 객체를 이용해 계산한 평균과 총점을 출력하세요.
		int totalScore = student.getKorean() + student.getEnglish() + student.getMath();
	
	}

}
