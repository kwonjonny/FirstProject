package AddSicle;

import java.util.Scanner;

//다음은 if-else문을 활용한 실버 레벨 문제입니다.
//
//문제: 사용자로부터 세 개의 정수를 입력받아, 이 중 최댓값과 최솟값을 구하는 프로그램을 작성하세요.
//
//예시 출력)
//첫 번째 숫자를 입력하세요: 10
//두 번째 숫자를 입력하세요: 5
//세 번째 숫자를 입력하세요: 20
//최댓값: 20, 최솟값: 5
//
//참고사항)
//
//입력받은 숫자 중 최댓값과 최솟값을 구해야 합니다.
//입력받은 숫자는 모두 다를 수 있습니다.
//if-else문을 사용하여 문제를 해결합니다.
//출력 시 "최댓값: "과 "최솟값: "의 형식을 따릅니다.

public class IfElse {
	public static void main(String [] args) {
		
	
	Scanner scan = new Scanner(System.in);
	System.out.println("숫자를 입력해주세요");
	int num1 = scan.nextInt();
	
	System.out.println("숫자를 입력해주세요.");
	int num2 = scan.nextInt();
	
	System.out.println("숫자를 입력해주세요.");
	int num3 = scan.nextInt();
	
	int max = num1;
	int min = num1;
	
	  if (num2 > max) {
          max = num2;
      } else if (num2 < min) {
          min = num2;
      }
      
      if (num3 > max) {
          max = num3;
      } else if (num3 < min) {
          min = num3;
      }
	System.out.println("최대값"+max+"최소값"+min);
	
	
	
	}
}