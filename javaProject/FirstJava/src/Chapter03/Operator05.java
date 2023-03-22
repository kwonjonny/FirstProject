package Chapter03;

public class Operator05 {

	public static void main(String[] args) {
		
		int num1 = 30;
		
		System.out.println(num1++); //30 num1에는 31이 들어가있음
		System.out.println(++num1); //++num 은 ++계산이 먼저 출력이 된다 32
		
		System.out.println(num1--); // 32
		System.out.println(--num1); // 30
		
		System.out.println(num1++ + ++num1); // 30+ ((31)+1) =61 
		

	}

}
