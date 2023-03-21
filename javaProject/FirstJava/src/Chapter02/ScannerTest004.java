package Chapter02;
import java.util.Scanner;

public class ScannerTest004 {

	public static void main(String[] args) {
	
		
		// 사용자 키보드 입력
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요 :");
		
		String name = scan.nextLine();
		
		System.out.println(name+"\t안녕하세요 성준님!");
		
		
	}

}
