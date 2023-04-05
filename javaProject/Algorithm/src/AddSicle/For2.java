package AddSicle;

import java.util.Scanner;

//다음은 포문을 활용한 실버 레벨 문제입니다.
//
//문제: 사용자로부터 자연수 n을 입력받아,
//1부터 n까지의 자연수 중에서 소수를 모두 출력하는 프로그램을 작성하세요.

public class For2 {
	public static void main(String [] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("소수만 출력하고싶은 수 입력");
		int n = scan.nextInt();
		
		for(int i=1; i<n; i=i+2) {
			System.out.println(i);
		}
		
		
	}
}
