package Member;

import java.util.ArrayList;

//국어, 영어, 수학 점수 10개씩을 저장하는 배열을 정의하고 점수를 모두 출력하고 
//평균 점수를 출력하는 프로그램을 작성해봅시다.

//2. Student 클래스를 정의해봅시다.
// 학생이름, 국어점수, 영어점수, 수학점수를 저장하는 변수를 정의 합니다.
// 변수는 캡슐화를 합니다. getter/setter 메소드를 정의합니다.
// 총점과 평균을 구해 결과를 반환하는 메소드를 정의합니다.

//3. main()메소드에 아래 내용을 정의해봅시다.
// Student 타입의 배열을 선언하고, 요소 10개를 저장할 수 있는 배열 인스턴스를 생성해 봅시다.
// Student 타입의 인스턴스를 생성하고 배열에 저장하는 코드를 정의해봅시다.
// 배열에 저장된 Student 타입의 인스턴스의 메소드를 이용해서 모든 데이터를 출력해봅시다

public class StudentChap01 {
	
	// 인스턴스 변수 정의
	private String name;
	private int korean;
	private int english;
	private int math;
	
	// 사용자 정의 
	public StudentChap01(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	
	// getter/setter정의 정보은닉,캡슐화,보수용이
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	// 총점 선언 메소드
	public int getTotalScore() {
		return korean + english + math ;
	}
	
	// 평균 선언 메소드
	public double getAverageScore() {
		return getTotalScore() / 3;
	}
}


//3. main()메소드에 아래 내용을 정의해봅시다.
//Student 타입의 배열을 선언하고, 요소 10개를 저장할 수 있는 배열 인스턴스를 생성해 봅시다.
//Student 타입의 인스턴스를 생성하고 배열에 저장하는 코드를 정의해봅시다.
//배열에 저장된 Student 타입의 인스턴스의 메소드를 이용해서 모든 데이터를 출력해봅시다
class Main2 {
	public static void main(String [] args) {
		
		// 총점 선언 객체 선언
		StudentChap01 student1 = new StudentChap01("권성준",80,60,70);
		student1.getTotalScore();
		System.out.println(student1.getTotalScore()); //80+60+70
		
		student1.getAverageScore();
		System.out.println(student1.getAverageScore());
		
		// ArrayList<integer> 사용
		// 국어, 영어, 수학 점수를 저장하는 어레이리스트 정의
		ArrayList<Integer> koreanScores = new ArrayList<>();
		koreanScores.add(90);
		koreanScores.add(85);
	    koreanScores.add(95);
	    koreanScores.add(80);
	    koreanScores.add(75);
	    koreanScores.add(85);
	    koreanScores.add(90);
	    koreanScores.add(80);
	    koreanScores.add(85);
	    koreanScores.add(90);
	    
	    
	    // 학생 정보를 저장하는 어레이리스트 정의
        ArrayList<StudentChap01> students = new ArrayList<StudentChap01>();
        students.add(new StudentChap01("홍길동", koreanScores.get(0), 85, 90));
        students.add(new StudentChap01("이순신", koreanScores.get(1), 90, 85));
        students.add(new StudentChap01("강감찬", koreanScores.get(2), 95, 80));
        students.add(new StudentChap01("푸틴", koreanScores.get(3), 80, 75));
        students.add(new StudentChap01("세종대왕", koreanScores.get(4), 85, 90));
        students.add(new StudentChap01("권선제", koreanScores.get(5), 90, 85));
        students.add(new StudentChap01("퇴계", koreanScores.get(6), 80, 95));
        students.add(new StudentChap01("신사", koreanScores.get(7), 85, 90));
        students.add(new StudentChap01("처칠", koreanScores.get(8), 90, 85));
        students.add(new StudentChap01("히틀러", koreanScores.get(9), 85, 90));
        
        
        // 모든 학생 정보 출력
        for (StudentChap01 student : students) {
            System.out.println(student.getName() + "의 국어 점수: " + student.getKorean());
            System.out.println(student.getName() + "의 영어 점수: " + student.getEnglish());
            System.out.println(student.getName() + "의 수학 점수: " + student.getMath());
            System.out.println(student.getName() + "의 총점: " + student.getTotalScore());
            System.out.println(student.getName() + "의 평균 점수: " + student.getAverageScore());
            System.out.println();
        }
    }
}


	
