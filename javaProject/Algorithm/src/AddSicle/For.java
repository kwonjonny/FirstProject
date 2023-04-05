package AddSicle;

import java.util.Scanner;

//다음은 포문을 활용한 실버 레벨 문제입니다.
//
//문제: 사용자로부터 자연수 n을 입력받아, 
//1부터 n까지의 자연수 중에서 3의 배수와 5의 배수를 모두 출력하는 프로그램을 작성하세요.

public class For {
	public static void main(String [] args) {
		
	Scanner scan = new Scanner(System.in);
	
	System.out.println("수를 입력하세요 3과5의배수 출력");
	int n = scan.nextInt();
	for(int i=0; i<=n; i++) {
		if(i%3==0 && i%5==0) {
			System.out.println(i);
		}
		
	}
	}
}