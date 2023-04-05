package AddSicle;
//다음은 배열을 사용한 브론즈 난이도의 자바 문제입니다.
//
//문제: 배열에 저장된 숫자들 중 가장 큰 수와 가장 작은 수를 출력하는 프로그램을 작성하세요.
//
//요구사항:
//
//배열에 저장된 숫자들의 개수는 5개 이상입니다.
//사용자로부터 숫자를 입력받아 배열에 저장합니다.
//배열에 저장된 숫자들 중 가장 큰 수와 가장 작은 수를 찾아 출력합니다.
import java.util.Scanner;

public class Array2 {
	public static void main(String [] args) {
		
		// 숫자 5개 입력
		int count = 5;
		
		// 배열 선언
		int [] arr = new int [count];
		
		// 가장 큰 수와 가장 작은 수 찾기
		
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<count; i++) {
			System.out.println("숫자 다섯개를 입력하세요.");
			arr[i] = scan.nextInt();
		}
		
		int max = arr[0];
		int min = arr[0];
		
		for(int i=0; i<count; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.println("최소값"+min);
		System.out.println("최대값"+max);
		
	}
}
