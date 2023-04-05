package AddSicle;

import java.util.Scanner;

// 다음은 배열을 사용한 브론즈 난이도의 자바 문제입니다.
//
//문제: 배열에 저장된 숫자들의 평균을 계산하는 프로그램을 작성하세요.
//
//요구사항:
//
//배열에 저장된 숫자들의 개수는 5개 이상입니다.
//사용자로부터 숫자를 입력받아 배열에 저장합니다.
//배열에 저장된 숫자들의 평균을 계산하여 출력합니다.
public class Array {
	public static void main(String [] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int count = 5;
		int [] numbers = new int[count];		
		
		for(int i=0; i<count; i++) {
			System.out.println("숫자를 입력하세요.");
			numbers[i] = scan.nextInt();
		}
		
		int sum = 0;
		for(int number : numbers) {
			sum = sum + number;
		}
		double average = sum/count;
		
		System.out.println("수 다섯개의 평균은"+ average);
	}
}
