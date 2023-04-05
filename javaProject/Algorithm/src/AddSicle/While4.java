package AddSicle;

import java.util.Scanner;

//문제: 정수 N을 입력받아 1부터 N까지의 합을 구하는 프로그램을 작성하세요. 
//다만, 반드시 while문을 사용하여 구현해야 합니다.
//
//골드 난이도 문제이기 때문에 while문을 사용하여 문제를 해결하는 것 외에도, 
//추가적인 요구사항이 있습니다. 다음 조건을 만족해야 합니다.
//프로그램은 사용자로부터 정수 N을 입력받습니다.
//입력받은 N이 1 이상의 자연수가 아니면, "잘못된 입력입니다.
//1 이상의 자연수를 입력하세요."라는 메시지를 출력하고 다시 N을 입력받아야 합니다.
//1부터 N까지의 합을 계산하여 결과를 출력합니다.
//프로그램이 종료될 때는 "프로그램을 종료합니다."라는 메시지를 출력합니다.
public class While4 {
	public static void main(String [] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("정수를 입력하세요");
		int n = scan.nextInt();
		while(n<=0) {
			System.out.println("0이상 입력하세요.");
			break;
		}
		
		int num = 0;
		int i = 1;
		while(i<=n) {
			num = num + i;
			i++;
			System.out.println("1부터" + n + "까지의 합은" + num);
			
		}
		System.out.println("프로그램 종료:");
		scan.close();
		
		
	}
}
