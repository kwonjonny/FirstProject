package AddSicle;

import java.util.Scanner;

//다음은 배열 실버 문제 입니다.
//학생들의 국어 성적을 입력받아 배열에 저장하고, 
//배열에 저장된 성적의 평균을 구하는 코드입니다. 코드를 완성하세요.

public class Array4 {
	public static void main(String [] args) {
		
		// 학생의 수 입력 받기 scanner
		Scanner scan = new Scanner(System.in);
		System.out.println("학생수 입력하세요");
		int student = scan.nextInt();
		
		
		// 배열로 정의 배열안에 학생수 정의
		int [] array = new int[student];
		
		
		// for문을 이용해 국어 성적을 학생의 수만큼 입력 받기
		// 배열 = scan.nextInt();
		for(int i=0; i<student; i++) {
			System.out.println("국어 성적을 입력해용.");
			array[i] = scan.nextInt();
		}
		
		
		// 학생의 평균 성적 객체 생성 int student = array[0];
		// for문을 이용해 학생의 수만큼 돌게하고 
		// 학생 = 학생 + array[i];
		int score = array[0];
		for(int i=0; i<student; i++) {
			score = score + array[i];
		}
		
		
		// 학생의 평균 구하기 메소드 
		double average = score / student;
		
		
		// 학생 평균 출력
		System.out.println("학생의 평균은?"+ average);
	}
}
