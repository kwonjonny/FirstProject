package Chapter02;

public class Casting014 {

	public static void main(String[] args) {
		
		
		byte b = 10;
		int i = b;
		
		System.out.println("i =" + i); //10
		System.out.println("b =" + b); //10
		
		int i2 = 300;
		byte b2 = (byte)i2;
		
		System.out.println("i2 =" + i2); //300
		System.out.println("b2 =" + b2); //44
		
		
	}

}
