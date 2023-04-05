package AddSicle;

import java.util.Scanner;

// 배열 실버 문제 입니다
// 여기 한번 풀어보세요!
// 정수형 배열에 10개의 수를 저장한 후, 배열에서 짝수인 수들의 합을 출력하는 코드를 작성해보세요.
// 배열 { 3, 5, 8, 10, 12, 15, 18, 20, 21, 25 }
public class Array6 {
	public static void main(String[] args) {
	
		// 메인 메소드 정의
		
		// 배열 선언 
		int arr [] =  { 3, 5, 8, 10, 12, 15, 18, 20, 21, 25 };
		
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] % 2==0) {
				count = count + arr[i];
			}
		} System.out.println(count);
		
		
		
	}
}