package AddSicle;

import java.util.Scanner;
//다음은 배열 실버 레벨의 문제입니다.
//
//문제: 길이가 5인 정수형 배열에 사용자가 
//입력한 5개의 숫자 중에서 짝수의 개수를 출력하는 프로그램을 작성하세요.
//예시 입력1: 1 2 3 4 5
//
//예시 출력1: 2
//
//예시 입력2: 0 11 20 33 40
//
//예시 출력2: 3
//힌트: 배열과 반복문을 이용하여 사용자가 입력한 5개의 숫자 중에서 짝수의 개수를 구할 수 있습니다.
public class Array3 {
	
	// 메인 메소드 정의
	public static void main(String [] args) {
	// 배열이 5개니까 int형 객체를 5개로 정의
	int num = 5;
		
	// 배열 생성후 int형 객체를 5개에 담아주기 
	int array [] = new int[num];
	
	// for 문에서 짝수의 개수를 출력해야 하니 나머지연산으로 
	// 2를 나눠준후
	// sum = 0 으로 선언한 객체에
	// sum = sum + array[i];로 선언해준다 
	Scanner scan = new Scanner(System.in);

	int sum = 0;
	for(int i=0; i<num; i++) {
		System.out.println("정수를 입력하세요 5개로");
		array[i] = scan.nextInt();
		if(array[i]%2==0) {
			sum++;
		}
	} System.out.println(sum);
	
	
	}
}
