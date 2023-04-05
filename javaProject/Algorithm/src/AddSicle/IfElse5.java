package AddSicle;

import java.util.Scanner;

//다이아몬드 레벨의 if-else 문제 하나 준비했습니다.
//
//문제: 학생의 국어, 영어, 수학 점수를 입력받아서, 각 과목별로 A, B, C, D, F 중 하나의 학점을 출력하는 프로그램을 작성하세요.
//
//각 과목의 점수는 0 ~ 100점 사이입니다.
//학점 기준은 다음과 같습니다:
//90점 이상: A
//80점 이상 90점 미만: B
//70점 이상 80점 미만: C
//60점 이상 70점 미만: D
//60점 미만: F
//학점은 국어, 영어, 수학 순으로 출력합니다.

public class IfElse5 {
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("국어 성적을 입력해요");
		int num1 = scan.nextInt();
		
		System.out.println("영어 성적을 입력해요:");
		int num2 = scan.nextInt();
	
		System.out.println("수학 성적을 입력해요:");
		int num3 = scan.nextInt();
		
		if(num1 >= 90) {
			System.out.println("A");
		} else if(num1 <90 && num1>=80) {
			System.out.println("B");
		} else if(num1 <80 && num1>=70) {
			System.out.println("C");
		} else if(num1 <70 && num1>=60) {
			System.out.println("D");
		} else if(num1 <60) {
			System.out.println("F");
		}
		
		if(num2 >= 90) {
			System.out.println("A");
		} else if(num2 <90 && num2>=80) {
			System.out.println("B");
		} else if(num2 <80 && num2>=70) {
			System.out.println("C");
		} else if(num2 <70 && num2>=60) {
			System.out.println("D");
		} else if(num2 <60) {
			System.out.println("F");
		}

		if(num3 >= 90) {
			System.out.println("A");
		} else if(num3 <90 && num3>=80) {
			System.out.println("B");
		} else if(num3 <80 && num3>=70) {
			System.out.println("C");
		} else if(num3 <70 && num3>=60) {
			System.out.println("D");
		} else if(num3 <60) {
			System.out.println("F");
		}
	}
}
