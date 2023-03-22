package Chapter03;

public class Operator09 {

	public static void main(String[] args) {
		
		int num1 =30;
		int num2 = 2;
		
		
		// 관계연산의 결과 값은 언제나 논리값 T & F
		System.out.println(num1 == num2);
		System.out.println(num1 > 10 && num1 < 50); // true && true -> true
		System.out.println(num1 < 10 && num1 < 50); // false && true -> false
		System.out.println(num1 > 10 || num2 > 10); // true || false -> true
		System.out.println(num1 < 10 || num2 > 10); // false || false -> false

	}

}
