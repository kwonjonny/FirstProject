package AddSicle;

import java.util.Scanner;

//다음은 포문을 활용한 실버 레벨 문제입니다.
//
//문제: 사용자로부터 자연수 n을 입력받아, 1부터 n까지의 홀수를 출력하는 프로그램을 작성하세요.

public class Problem4 {
	public static void main(String [] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("수를 입력하세요 EX:5입력시 1,5홀수 출력");
		int n = scan.nextInt();
		
		for(int i=1; i<=n; i= i+2) {
				System.out.println(i);	
		}
	}
}
