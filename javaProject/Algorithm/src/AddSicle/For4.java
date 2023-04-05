package AddSicle;

import java.util.Scanner;

//다음은 포문을 활용한 골드 레벨 문제입니다.
//
//문제: 사용자로부터 자연수 n을 입력받아서, 
//n까지의 모든 소수의 개수를 출력하는 프로그램을 작성하세요.
//
//소수(prime number)란 1과 자기 자신으로만 나누어지는 자연수를 말합니다.
//
//예시)
//입력: 10
//출력: 4 (2, 3, 5, 7)
//
//힌트)
//
//소수를 판별하는 함수를 따로 만들어서 사용하면 편리합니다.
//소수 판별 함수는 주어진 수를 2부터 그 수의 제곱근까지 
//나누어보면서 나누어 떨어지는 수가 있는지 확인하면 됩니다.
//이 문제를 풀어본다면, 소수 판별 함수를 먼저 작성하고, 
//그 함수를 이용하여 주어진 범위 내에서 소수의 개수를 찾아내는 것이 좋습니다.

public class For4 {
	public static void main(String [] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("소수의 개수와 소수 출력하고싶은 수 입력");
		int n = scan.nextInt();
		
		if(n % 2 == 0) {
		for(int i=1; i<=n; i=i+2) {
			System.out.println(i);
		}
		} else {
			for(int i=1; i<=n; i=i+2) {
				System.out.println(i);
			}
		}
		
	}
}
