package AddSicle;

import java.util.Scanner;

// else if 골드문제입니다
// 문제: 사용자로부터 입력받은 두 수를 비교하여 큰 수, 작은 수, 
// 같은 수를 출력하는 프로그램을 작성하세요.
public class IfElse2 {
	public static void main(String [] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요.");
		int num1 = scan.nextInt();
		
		System.out.println("숫자를 입력하세요.");
		int num2 = scan.nextInt();
		
		if(num1 > num2) {
			System.out.println(num1+"은"+num2+"보다 큽니다");
		} else if(num2 > num1) {
			System.out.println(num1+"은"+num2+"보다 작습니다.");
		} else if(num2 == num1) {
			System.out.println(num1+"은"+num2+"와 같습니다.");
		}
		scan.close();
	}
}
