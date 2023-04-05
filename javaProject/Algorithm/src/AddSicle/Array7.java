package AddSicle;

import java.util.Scanner;

// 배열 실버 문제 입니다.
//문제 내용:
//
//두 자연수 A와 B가 있을 때, A%B는 A를 B로 나눈 나머지이다. 
//예를 들어, 7, 14, 27, 38에서 7로 나눈 나머지는 0, 0, 6, 3이다.
//
//수 10개를 입력받은 후, 이를 42로 나눈 나머지 중 서로 다른 값의 
//개수를 출력하는 프로그램을 작성하시오.
//
//입력
//
//첫째 줄부터 열번째 줄까지 자연수가 주어진다. 
//이 자연수는 1,000보다 작거나 같고, 음이 아닌 정수이다.
//출력
//
//첫째 줄에 42로 나누었을 때, 서로 다른 나머지의 개수를 출력한다.



public class Array7 {
	public static void main(String [] args) {
	// 메인 메소드 정의
	
	// 나머지를 담아줄 배열 을 선언 10개를 입력하니 10개
	int [] array = new int[42];	
	Scanner scan = new Scanner(System.in);
	
	for(int i=0; i<10; i++) {
		System.out.println("정수 입력");
		int n = scan.nextInt();
		array[n % 42]++;
	}
	
	
	}
}