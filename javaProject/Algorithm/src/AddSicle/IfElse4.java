package AddSicle;

import java.util.Scanner;

//문제: 사용자로부터 나이를 입력받아 다음과 같이 출력하는 프로그램을 작성하세요.
//
//나이가 0 ~ 2살인 경우: "유아"
//나이가 3 ~ 12살인 경우: "어린이"
//나이가 13 ~ 18살인 경우: "청소년"
//나이가 19살 이상인 경우: "성인"


public class IfElse4 {
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("나이를 입력하세요!");
		int num1 = scan.nextInt();
		
		if(num1 <= 2 && num1 >=0) {
			System.out.println("유아");
		} else if(num1 >=3 && num1 <=12) {
			System.out.println("어린이");
		} else if(num1 >=13 && num1 <=18) {
			System.out.println("청소년");
		} else if(num1 >=19) {
			System.out.println("성인");
		}
		
		scan.close();
	}
}
