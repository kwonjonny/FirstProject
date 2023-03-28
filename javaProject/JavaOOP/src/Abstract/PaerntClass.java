package Abstract;

//문제: 추상 클래스를 상속받아 구현하는 자식 클래스를 만들고, 
//메인 메소드에서 자식 클래스의 인스턴스를 생성하여 출력하는 프로그램을 작성하세요.
//
//조건:
//parentClass에는 추상 메소드와 일반 메소드가 있어야하며 
//일반 메소드는 world라는 출력이 나오게 정의하세요 
//Child클래스는 PaerntClass의 상속을 받으며 PaerntClass에서 정의한 추상메소드를
//오버라이딩 하여서 hello를 출력받게 메인메소드에서 선언하세요 
public abstract class PaerntClass {
	
	// 추상메소드 선언
	public abstract void printHello();
	
	// 일반메소드 선언 
	public void printWorld() {
		System.out.println("World");
		
	}
}


class Child extends PaerntClass {
	
	@Override
	public void printHello() {
		System.out.println("Hello");
		
	}
}


class DDDD {
	public static void main() {
		
		PaerntClass hello = new Child();
		hello.printHello();	//Hello
		
		hello.printWorld(); //world
		
		
	}
}