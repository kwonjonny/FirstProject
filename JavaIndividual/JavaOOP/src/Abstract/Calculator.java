package Abstract;


// 추상 클래스 Calculator를 정의하세요. 이 클래스는 다음 메소드를 가지고 있어야 합니다.
//add: 두 개의 정수를 더한 결과를 반환하는 추상 메소드
//subtract: 두 개의 정수를 뺀 결과를 반환하는 추상 메소드
//multiply: 두 개의 정수를 곱한 결과를 반환하는 추상 메소드
//divide: 두 개의 정수를 나눈 결과를 반환하는 추상 메소드

// Calculator 클래스를 상속받아 BasicCalculator 클래스를 정의하세요. 
// 이 클래스는 Calculator 클래스의 추상 메소드를 모두 구현해야 합니다.

// BasicCalculator 클래스의 인스턴스를 생성하고, 다음 값을 이용하여 연산을 수행하세요.
//10과 20을 더한 결과를 출력하세요.
//20에서 10을 뺀 결과를 출력하세요.
//10과 20을 곱한 결과를 출력하세요.
//20을 10으로 나눈 결과를 출력하세요

// 정수를 더하고 뺄 때는 int 타입을 사용하세요.
//정수를 곱하고 나눌 때는 long 타입을 사용하세요.
//나누기 연산은 소수점 이하를 버리고 정수부분만 결과로 출력합니다.

// 힌트:
//추상 클래스를 이용하여 다양한 하위 클래스를 만들 수 있습니다. 
//추상 클래스는 일반 클래스와 마찬가지로 필드와 메소드를 가질 수 있습니다.
//추상 클래스의 하위 클래스는 반드시 추상 메소드를 오버라이딩하여 구현해야 합니다.

public abstract class Calculator {
	public abstract int add(int a, int b);
	public abstract int substract(int a, int b);
	public abstract int multiply(int a, int b);
	public abstract int divide(int a,int b);
	
}

class BasicCalculator extends Calculator {
	
	@Override
	public int add(int a, int b) {
		return  a + b;
	}
	
	@Override
	public int substract(int a, int b) {
		return a - b;
	}
	
	@Override
	public int multiply(int a, int b) {
		return a * b;
	}
	
	@Override
	public int divide(int a, int b) {
		return a / b;
	}

}


//BasicCalculator 클래스의 인스턴스를 생성하고, 다음 값을 이용하여 연산을 수행하세요.
//10과 20을 더한 결과를 출력하세요.
//20에서 10을 뺀 결과를 출력하세요.
//10과 20을 곱한 결과를 출력하세요.
//20을 10으로 나눈 결과를 출력하세요
class Ddxd {
	public static void main(String [] args) {
		
		BasicCalculator operations = new BasicCalculator();
		
		int a = 10;
		int b = 20;
		
		operations.add(10, 20);
		operations.substract(10, 20);
		operations.multiply(10, 20);
		operations.divide(10, 20);
		
		
		
		
	}
}