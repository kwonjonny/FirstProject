package AddSicle;

import java.util.Scanner;

//문제: 정수를 입력받아 해당 정수의 각 자리 숫자들의 합을 구하는 프로그램을 작성하세요.
//
//예시:
//입력: 123
//출력: 6

//입력: 9876
//출력: 30

//입력: 32167
//출력: 19
//입력받은 정수는 항상 자연수이며, 입력 범위는 1 이상 1,000,000 이하입니다.

public class Add2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);	
		System.out.println("정수를 입력하세요>");
		int num = scan.nextInt();
		int sum = 0;
		
		String numstr = Integer.toString(num);
		for(int i=0; i<numstr.length(); i++) {
			char c = numstr.charAt(i);
			int digit = Character.getNumericValue(c);
			sum = sum + digit;
		}
	}
}
