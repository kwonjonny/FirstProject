package AddSicle;

import java.util.Scanner;

// 아래와 같은 문제를 해결하는 while문을 작성해보세요:

//"1에서 10까지의 자연수 중에서 홀수만 출력하는 프로그램을 작성하세요."
//예시 출력:
//1
//3
//5
//7
//9

public class While2 {
	public static void main(String [] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1~10까지 입력해보세요");
		int num1 = scan.nextInt();
		
		System.out.println("홀수만 출력됩니다>");
		int i = 1;
		while(i <= num1) {
			if(i %2 !=0) {
			 System.out.println(i);
			}
			i++;
		}
	}
}
