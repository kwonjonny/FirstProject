package AddSicle;

import java.util.Scanner;

// 다음은 배열 실버 문제입니다.
// 길이가 10인 배열에 1~100 사이의 난수를 발생시켜 저장한 후, 1~100은 사용자 입력 
// 사용자로부터 10개의 정수를 입력받아 배열에 저장합니다.
// 배열에 저장된 값 중 50 이상인 값들만 골라 더한 결과를 출력합니다.
// 배열에 저장된 숫자들 중에서 50 이상인 숫자들의 합을 구하는 코드를 작성해보세요.


public class Array5 {
	public static void main(String [] args) {
		
		
		// 배열을 10로 지정
		int [] arr = new int[10];
		
		Scanner scan = new Scanner(System.in);
		// 1~100 사용자 입력
		for(int i=0; i<arr.length; i++) {
			System.out.println("정수 입력:");
			int num = scan.nextInt();
			arr[i] = num;
		}
		
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > 50) {
				count = count + arr[i];
			}
		}
		System.out.println(count);
	} 
}