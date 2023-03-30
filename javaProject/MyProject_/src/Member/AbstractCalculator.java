package Member;

//객체지향_추상클래스와 인터페이스 
//아래 코드는 계산기 클래스를 정의할 때 가이드 역할을 하도록 정의해놓은 인터페이스입니다. 
//interface Calulator {
//	 long add(long n1, long n2);
//	 long substract(long n1, long n2 );
//	 long multiply(long n1, long n2 );
//	 double divide(double n1, double n2 );
//}
//1. Calulator 인터페이스를 상속하는 추상 클래스를 정의해봅시다. 
// 
//2. Calulator 인터페이스를 상속하는 인스턴스를 생성할 수 있는 클래스를 정의해봅시다. 
// 
//3. 다형성의 특징으로 상위 타입인 인터페이스 타입의 참조변수에 인터페이스를 구현한 클래스 
//타입의 인스턴스를 참조하는 코드를 작성해 봅시다


interface Calculator {
	
	 long add(long n1, long n2);
	 long substract(long n1, long n2 );
	 long multiply(long n1, long n2 );
	 double divide(double n1, double n2 );
	 
}

public abstract class AbstractCalculator implements Calculator {
	
	// 메소드 정의
	public long add(long n1, long n2) {
		return n1 + n2;
	}
	
	public abstract long substract(long n1, long n2);
	
	public abstract long multiply(long n1, long n2);
	
	public abstract double divide(double n1, double n2);
	
}

class BasicCalculator implements Calculator {
	
	// add 메소드는 추상클래스에서의 메소드가 완성 되있으므로 
	// @오버라이딩 하지 않는다.
	public long add(long n1, long n2) {
		return n1 + n2;
	}
	
	// 자식클래스에서의 메소드 재정의 @Override를 해준다.
	@Override
	public long substract(long n1, long n2) {
		return n1 - n2;
	}
	
	@Override
	public long multiply(long n1, long n2) {
		return n1 * n2;
	}
	
	@Override
	public double divide(double n1, double n2) {
		if(n2 == 0) {
			throw new IllegalArgumentException("0을 나눌순 없어용>");
		} return n1 / n2;
	} 
	
}


class Main4 {
	public static void mani(String [] args) {
		
		Calculator add = new BasicCalculator();
		long result1 = add.add(10, 20); // 30
		long result2 = add.substract(20, 20); // 0
		long result3 = add.multiply(20, 20); // 400
		double result4 = add.divide(10, 10); // 1.0
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);

	}
}
