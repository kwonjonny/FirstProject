package AddSicle;

import java.util.Scanner;

// IfElse골드 문제 입니다
//문제: 사용자로부터 세 개의 정수를 입력받아, 가장 큰 수를 출력하는 프로그램을 작성하세요. 단, if-else if 구문을 사용하여야 합니다.
//
//예시:
//첫번째 수를 입력하세요: 5
//두번째 수를 입력하세요: 2
//세번째 수를 입력하세요: 9
//가장 큰 수는 9입니다.
public class IfElse3 {
	public static void main(String [] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("수를 입력하세요");
		int num1 = scan.nextInt();
		
		System.out.println("수를 입력하세요.");
		int num2 = scan.nextInt();
		
		System.out.println("수를 입력하세요.");
		int num3 = scan.nextInt();
		
		if(num1 > num2 && num1 > num3) {
			System.out.println(num1+"이 제일 큰수");
		} else if(num2 > num1 && num2 > num3) {
			System.out.println(num2+"이 제일 큰수");
		} else if(num3 > num1 && num3 > num2) {
			System.out.println(num3+"이 제일 큰수");
		}
		scan.close();
	}
}
