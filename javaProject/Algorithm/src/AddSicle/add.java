package AddSicle;

import java.util.Scanner;

//아래는 단순구현 문제 중 하나인 "1부터 N까지의 합" 문제입니다.

//문제: 자연수 N이 주어졌을 때, 1부터 N까지의 합을 구하는 프로그램을 작성하세요.
//
//예시 입력1: 5
//예시 출력1: 15
//
//예시 입력2: 10
//예시 출력2: 55
public class add {
	public static void main(String [] args) {
		
		System.out.println("숫자를 입력해주세요");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a = 0;
		for(int i=1; i<=n; i++) {
			a = a + i;
		}
		System.out.println(a);
	}
}
