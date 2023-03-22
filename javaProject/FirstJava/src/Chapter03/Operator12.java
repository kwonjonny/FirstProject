package Chapter03;

public class Operator12 {

	public static void main(String[] args) {
		
		int num1 = 0;
		int num2 = 0;
		
		boolean result = false;
		
		result = (num1 += 10) <0 && (num2 += 10) >0;
		
		System.out.println(result);
		System.out.println("num1:" + num1 + ", num2 :" + num2);
		
		result = (num1 +=10) > 0 || (num2 += 10) > 0;
		System.out.println(result);
		System.out.println("num1 :" + num1 + ",num2 :" + num2);
		
		
		
		
	}

}
