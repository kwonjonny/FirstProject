package Interface;


//인터페이스 이름: Shape
//메소드
//getArea() : 도형의 면적을 반환하는 메소드. 반환 타입은 double
//getPerimeter() : 도형의 둘레를 반환하는 메소드. 반환 타입은 double
//위의 인터페이스를 구현하는 클래스로 다음과 같은 도형 클래스들을 작성해보세요.
//
//Circle
//필드: 반지름(radius) double형
//생성자: 반지름을 입력받아 초기화하는 생성자
//메소드: getArea(), getPerimeter()를 구현
//원의크기는 Math.PI * radius * radius
//원의 반지름 2 * Math.PI * radius;

//Rectangle
//필드: 가로 길이(width), 세로 길이(height) double형 
//생성자: 가로 길이와 세로 길이를 입력받아 초기화하는 생성자
//메소드: getArea(), getPerimeter()를 구현

//Triangle
//필드: 밑변 길이(base), 높이(height), 삼각형의 두번째 변의 길이(side2)
//삼각형의 세번째 변의 길이(side3) base height side2 side3 전부다 double형 
//생성자: 밑변 길이와 높이, 두번째 변의 길이, 세번째 변의 길이를 입력받아 초기화하는 생성자
//메소드: getArea(), getPerimeter()를 구현
//위의 클래스들을 구현하고, 각 도형의 면적과 둘레를 출력하는 메소드를 작성해보세요.

public interface Shape {
	
	double getArea();
	double getPerimeter();
	
}

//메소드: getArea(), getPerimeter()를 구현
//원의크기는 Math.PI * radius * radius
//원의 반지름 2 * Math.PI * radius;
class Circle implements Shape {
	
	// 인스턴스 변수 정의
	private double radius;
	
	// 생성자 정의 
	public Circle(double radius) {
		this.radius = radius;
	}

	// Getter Setter 정의 캡슐화,정보은닉,보수용이
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	// 자식클래스 추상메소드 오버라이딩
	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}
	
	@Override
	public double getPerimeter() {
		return 2 * radius * radius;
	}
	
}


//Rectangle
//필드: 가로 길이(width), 세로 길이(height) double형 
//생성자: 가로 길이와 세로 길이를 입력받아 초기화하는 생성자
//메소드: getArea(), getPerimeter()를 구현
// width * height=넓이     2 * width * height= 반지름 
class Rectangle implements Shape {
	
	// 인스턴스 변수 정의
	private double width;
	private double height;
	
	// 생성자 정의
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	// Getter Setter정의 캡슐화,정보은닉,보수용이
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	// 자식클래스 추상메소드 오버라이딩
	@Override
	public double getArea() {
		return width * height;
	}
	
	@Override
	public double getPerimeter() {
		return 2 * width * height;
	}
	
}


//Triangle
//필드: 밑변 길이(base), 높이(height), 삼각형의 두번째 변의 길이(side2)
//삼각형의 세번째 변의 길이(side3) base height side2 side3 전부다 double형 
//생성자: 밑변 길이와 높이, 두번째 변의 길이, 세번째 변의 길이를 입력받아 초기화하는 생성자
//메소드: getArea(), getPerimeter()를 구현
class Triangle implements Shape {
	
	// 인스턴스 변수 정의
	private double base;
	private double height;
	private double side2;
	private double side3;
	
	// 생성자 정의
	public Triangle(double base, double height, double side2, double side3) {
		this.base = base;
		this.height = height;
		this.side2 = side2;
		this.side3 = side3;
	}

	// Getter와 Setter 정의 캡슐화,정보은닉,보수용이
	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}

	public double getSide3() {
		return side3;
	}

	public void setSide3(double side3) {
		this.side3 = side3;
	}
	
	// 자식클래스 추상메소드 오버라이딩 
	@Override
	public double getArea() {
		return base * height / 2;
	}

	@Override
	public double getPerimeter() {
		return base + side2 + side3;
	}
}


//위의 클래스들을 구현하고, 각 도형의 면적과 둘레를 출력하는 메소드를 작성해보세요.
class Main {
	public static void main(String [] args) {
		Circle circle = new Circle(5);
		Rectangle rectangle = new Rectangle(2,6);
		Triangle triangle = new Triangle(2,4,5,6);
		
		System.out.println("Circle area: " + circle.getArea());
	    System.out.println("Circle perimeter: " + circle.getPerimeter());

	    System.out.println("Rectangle area: " + rectangle.getArea());
	    System.out.println("Rectangle perimeter: " + rectangle.getPerimeter());
	    
	    System.out.println("Triangle area: " + triangle.getArea());
	    System.out.println("Triangle perimeter: " + triangle.getPerimeter());
		
	}
}