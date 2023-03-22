package JavaProblem;
import java.util.Scanner;
public class forTest {
	
	public static void main(String[] args) {
		
		// chatGPT가 내준 명령어 for문 문제 20제 도전
		
		// 1: 1부터 10까지의 숫자를 출력하는 for문을 작성하세요.

		// 2: 구구단 2단을 출력하는 for문을 작성하세요.

		// 3: 100까지의 숫자 중 짝수만 출력하는 for문을 작성하세요.

		// 4: 배열 arr의 모든 요소를 더한 값을 출력하는 for문을 작성하세요.

		// 5: 1부터 10까지의 숫자 중 홀수만 더한 값을 출력하는 for문을 작성하세요.

		// 6: 1부터 10까지의 숫자를 거꾸로 출력하는 for문을 작성하세요.

		// 7: 문자열 배열 strArr의 모든 요소를 출력하는 for문을 작성하세요.

		// 8: 1부터 100까지의 홀수를 출력하는 for문을 작성하세요.

		// 9: 1부터 100까지의 합을 구하는 for문을 작성하세요.

		// 10: 1부터 50까지의 수 중 3의 배수이면서 4의 배수인 수를 출력하는 for문을 작성하세요.

		// 11: 5의 배수만 출력하는 for문을 작성하세요.
		
		// 12: 1부터 20까지의 숫자 중 3의 배수를 출력하는 for문을 작성하세요.

		// 13: 구구단 3단을 출력하는 for문을 작성하세요.

		// 14: 1부터 100까지의 숫자 중 3의 배수의 합을 구하는 for문을 작성하세요.

		// 15: 1부터 10까지의 숫자를 입력받아 각 숫자의 제곱을 출력하는 for문을 작성하세요.

		// 16: 정수 n을 입력받아 1부터 n까지의 숫자 중 3과 5의 공배수를 출력하는 for문을 작성하세요.
		
		// 17: 1부터 100까지의 숫자 중 3의 배수와 5의 배수를 출력하는 for문을 작성하세요.

		// 18: 2부터 100까지의 소수(prime number)를 출력하는 for문을 작성하세요.

		// 19: 1부터 10까지의 숫자를 입력받아 입력받은 숫자보다 작은 모든 소수를 출력하는 for문을 작성하세요.

		// 20: 1부터 100까지의 숫자 중 3과 4의 공배수를 출력하는 for문을 작성하세요.

		// 21: 1부터 10까지의 숫자를 입력받아 해당 숫자의 팩토리얼을 출력하는 for문을 작성하세요.




		
	// 1: 1부터 10까지의 숫자를 출력하는 for문을 작성하세요.
		for(int i=1; i<10; i++) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		
	// 2: 구구단 2단을 출력하는 for문을 작성하세요.
		for(int i=1; i<10; i++) {
			if(i%2==0) {
				System.out.print(i+" ");
			}
		}
		
		System.out.println();
		
	// 3: 100까지의 숫자 중 짝수만 출력하는 for문을 작성하세요.
		for(int i=1; i<100; i++) {
			if(i%2==0) {
				System.out.print(i+" ");
			}
		}
		
		System.out.println();
			
	// 4: 배열 arr의 모든 요소를 더한 값을 출력하는 for문을 작성하세요.
		int[] arr = {1,2,3,4,5};
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum = sum + arr[i];
		}
		System.out.print(sum+" ");
		
		System.out.println();
		
	// 5: 1부터 10까지의 숫자 중 홀수만 더한 값을 출력하는 for문을 작성하세요.
		int b = 0;
		for(int i=0; i<10; i++) {
			if(i%2 != 0);
			b= b+i;
		} System.out.print(b+" ");
		
		System.out.println();
		
	// 6: 1부터 10까지의 숫자를 거꾸로 출력하는 for문을 작성하세요.
		for(int i=10; i>0; i--) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		
	// 7: 문자열 배열 strArr의 모든 요소를 출력하는 for문을 작성하세요.
		String strArr [] = {"HELLO" , "WORLD" , "JAVA" , "AND" , "JOON"};
		for(int i=0; i<strArr.length; i++) {
			System.out.print(strArr[i]+" ");
		}
		
		System.out.println();
		
	// 8: 1부터 100까지의 홀수를 출력하는 for문을 작성하세요.
		for(int i=0; i<100; i++) {
			if(i%2 != 0) {
				System.out.print(i+" ");
			}
		}
	
		System.out.println();
		
	// 9: 1부터 100까지의 합을 구하는 for문을 작성하세요.
		int c=0;
		for(int i=0; i<100; i++) {
			c = c+i;
		}
		System.out.print(c+" ");
		
		System.out.println();
		
	// 10: 1부터 50까지의 수 중 3의 배수이면서 4의 배수인 수를 출력하는 for문을 작성하세요.
		for(int i=0; i<50; i++) {
			if(i%3==0 && i%4==0) {
				System.out.print(i+" ");
			}
		}
		
		System.out.println();
		
	// 11: 5의 배수만 출력하는 for문을 작성하세요.
		for(int i=0; i<100; i++) {
			if(i%5==0) {
				System.out.print(i+" ");
			}
		}
		
		System.out.println();
		
	// 12: 1부터 20까지의 숫자 중 3의 배수를 출력하는 for문을 작성하세요.
		for(int i=0; i<20; i++) {
			if(i%3==0) {
				System.out.print(i+" ");
			}
		}
		
		System.out.println();
		
	// 13: 구구단 3단을 출력하는 for문을 작성하세요.	
		for(int i=1; i<=9; i++) {
			System.out.print(3*i+" ");		
		}
		

		System.out.println();
		
	// 14: 1부터 100까지의 숫자 중 3의 배수의 합을 구하는 for문을 작성하세요.
		int d=0;
		for(int i=0; i<100; i++) {
			if(i%3==0) {
				d = d+i;
			}
		} System.out.println(d);
		
		System.out.println();
		
	// 15: 1부터 10까지의 숫자를 입력받아 각 숫자의 제곱을 출력하는 for문을 작성하세요.
		Scanner scan = new Scanner(System.in);
		System.out.println("1부터 10까지의 숫자를 하나 입력하세요");
		int e = scan.nextInt();
		for(int i=0; i<=e; i++) {
			System.out.println(i + "의 제곱: " + (i*i));
		}
		
		System.out.println();
		
	// 16: 정수 n을 입력받아 1부터 n까지의 숫자 중 3과 5의 공배수를 출력하는 for문을 작성하세요.	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<=n; i++) {
			if(i%3==0 && i%5==0) {
				System.out.print(i+" ");
			}	
		}
		
		System.out.println();
		
	// 17: 1부터 100까지의 숫자 중 3의 배수와 5의 배수를 출력하는 for문을 작성하세요.
		for(int i=0; i<100; i++) {
			if(i%3==0 && i%5==0) {
				System.out.print(i+" ");
			}
		}
		
		System.out.println();
		
	// 18: 2부터 100까지의 소수(prime number)를 출력하는 for문을 작성하세요.
		Scanner scn = new Scanner(System.in);
		int x = scan.nextInt();
		for(int i=0; i<=x; i++) {
			System.out.print(i+" ");
		}

		System.out.println();
		
	// 19: 1부터 10까지의 숫자를 입력받아 입력받은 숫자보다 작은 모든 소수를 출력하는 for문을 작성하세요.
		
		
	// 20: 1부터 100까지의 숫자 중 3과 4의 공배수를 출력하는 for문을 작성하세요.
		for(int i=0; i<100; i++) {
			if(i%3==0 && i%4==0) {
				System.out.print(i+" ");
			}
		}
	// 21: 1부터 10까지의 숫자를 입력받아 해당 숫자의 팩토리얼을 출력하는 for문을 작성하세요.
		

	

	}

	
	
	
}
