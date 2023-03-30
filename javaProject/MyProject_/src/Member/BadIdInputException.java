package Member;

import java.util.Scanner;

//1. 콘솔에서 사용자 아이디를 입력 받아 정상적인 영문자와 숫자로만 이루어진 값을 입력했는지 확인하는 프로그램을 만들어봅시다. 
//① 사용자 예외 클래스를 정의해서 예외를 발생 시켜 봅시다.
//② 예외 클래스 이름은 BadIdInputException이라고 정의합시다.
//
//2. Scanner 클래스로 태어난 년도를 입력 받을 때 int 타입으로 받도록 합시다. 
//이때 nextInt() 메소드를 사용하게 되는데 이때 발생하는 예외처리를 하도록 합시다

public class BadIdInputException extends Exception{

	public BadIdInputException(String message) {
		super(message);
	}
}

class main1 {
	public static void main(String [] args) {
		
		// Scanner를 정의해서 사용자가 태어난 년도를 입력하게 한다.
		Scanner scan = new Scanner(System.in);
		
		// try-catch를 이용해서 잘못된 입력이면 다시 입력하게 한다.
		try {
			System.out.println("태어난 년도를 입력하세요:");
			int birthday = scan.nextInt();
			System.out.println("태어난년도"+birthday);
		} catch(Exception e) {
			System.out.println("잘못된 입력입니다 다시 입력하세요..");
		} scan.close();	// scanner를 닫아줌으로써 메모리 낭비를 방지한다.
		
	} 
}

