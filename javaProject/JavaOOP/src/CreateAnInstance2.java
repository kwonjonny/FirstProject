//클래스와 인스턴스를 활용하여 다음 문제를 해결해보세요.
//
//문제: 자동차 객체를 생성하는 클래스 Car를 작성하세요. 자동차 객체는 다음 속성을 갖습니다.
//
//model: 자동차 모델명을 저장하는 문자열 변수
//color: 자동차 색상을 저장하는 문자열 변수
//price: 자동차 가격을 저장하는 정수형 변수
//또한 Car 클래스에는 start와 stop 메소드가 있으며, 각각 자동차를 출발시키거나 정지시키는 역할을 합니다. start 메소드를 호출하면 "자동차가 출발합니다"라는 메시지를 출력하고, stop 메소드를 호출하면 "자동차가 정지합니다"라는 메시지를 출력합니다.
//
//마지막으로 Car 클래스의 인스턴스를 생성하고, 이를 활용하여 자동차의 정보를 출력하고 출발과 정지 메소드를 호출해보세요.



public class CreateAnInstance2 {
	private String model;	// 인스턴스 변수
	private String color;	// 인스턴스 변수
	private int price;		// 인스턴스 변수
	
	// 생성자 호출
	// this.model = model;을 통해 매개변수값을 인스턴스변수로 전달
	public CreateAnInstance2(String model, String color, int price) {
		this.model = model;
		this.color = color;
		this.price = price;
	}
	
	// 자동차 출발 출력 메소드
	public void start() {
		System.out.println("자동차가 출발합니다");
	}
	// 자동차 정지 출력 메소드
	public void stop() {
		System.out.println("자동차가 정지합니다");
	}
	
	// 실행을 위한 메인 메소드 생성
	public static void main(String [] args) {
		
		// car 의 인스턴스 생성 
		// CreateAnInstance2 car클래스내에 생성된 인스턴스 변수이며 
		// new CreateAnInstance2는 클래스내의 생성자를 호출하여 인스턴스변수 "아반떼","회색",2500 생성
		// 그 이후로 "아반떼","회색",2500 의 값을 car변수로 전달하며 CreateAnInstance2클래스의 인스턴스변수가 된다 
		CreateAnInstance2 car = new CreateAnInstance2("아반떼","회색",2500);
		
		// 자동차의 정보 출력
		System.out.println(car.model);
		System.out.println(car.color);
		System.out.println(car.price);
		
		// CreateAnInstance2클래스의 인스턴스 변수가된 car을 호출하고 
		// .start(); .stop();을 이용해 출발,정지 메소드 출력
		car.start();
		car.stop();
		
	}
	
}
