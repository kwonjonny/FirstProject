package AddSicle;

import java.util.Scanner;

//문제: 사용자로부터 정수 n을 입력받아서, 1부터 n까지의 합을 계산하는 프로그램을 작성하세요.

public class Problem3 {

	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		
		int sum = 0;
		
		System.out.println("수를 입력하세요!");
		int n = scan.nextInt();
		
		for(int i=0; i<=n; i++) {
			sum = sum+i;
		}
		System.out.println(sum);
	}
}
