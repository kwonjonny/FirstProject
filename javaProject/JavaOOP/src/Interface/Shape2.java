package Interface;

// 문제:
// 도형을 나타내는 인터페이스를 정의하시오
// 도형의 인터페이스 안에는 넓이를 구하는 getArea라는 메소드가 있습니다 메소드는 double형으로 구현

// 사각형을 나타내는 클래스 Rectangle을 정의하고 Shape의 상속을 받으세요 
// 사각형에는 width와 height의 높이와 넓이의 인스턴스 변수가 있습니다. (double)형
// 사각형의 넓이를 구현하는 메소드를 정의 높이 * 넓이

// 삼각형을 나타내는 클래스 Triangle을 정의하고 Shape의 상속을 받으세요 
// 삼각형에는 base와 height 밑변의 길이 와 높이 인스턴스 변수가 있습니다. (double)형
// 삼각형의 넓이를 구현하는 메소드를 정의 0.5 * 밑변의 길이 * 높이

// 직육면체를 나타내는 클래스 Cuboid를 정의하세요 또한 Interface에서 사용되는 Comparable을 이용하여
// Cuboid를 담아줍니다
// 직육면체에는 width넓이 height높이 depth깊이 인스턴스 변수가 있습니다 (double형)
// 도형의 넓이를 구하는 메소드를 구현하고 2*(width * height + height * depth + depth * width)
// 직육면체의 부피를 계산하는 메소드도 구현하세요 width * height * depth
// Comparable 인터페이스를 이용해서 compareTo 메소드를 구현하고 크기 비교를 합니다 int형
// EX: compareTo(Cuboid other) { return Dobule.compare (get객체), otehr.get객체()); }

// 인터페이스 Shape2 정의
public interface Shape2 {
	
	double getArea();
	
}


// Rectangle2 클래스 정의 Shape2 메소드 구현
class Rectangle2 implements Shape2 {
	
	// 인스턴스 변수 정의
	private double width;
	private double height;
	
	// 생성자 정의 
	public Rectangle2(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	// 사각형 넓이를 구하는 메소드 
	@Override
	public double getArea() {
		return width * height;
	}
}


// Triangle2 클래스 정의 Shape2 메소드 구현
class Triangle2 implements Shape2 {
	
	// 인스턴스 변수 정의 
	private double base;
	private double height;
	
	// 생성자 정의
	public Triangle2(double base, double height) {
		this.base = base;
		this.height = height;
	}
	
	// 삼각형의 넓이를 구하는 메소드
	@Override
	public double getArea() {
		return 0.5 * base * height;
	}
}


// Cuboid2 클래스 정의 Shape2 메소드 구현 , 객체 비교를 위한 Comoarable<> Cuboid2 클래스 담아줌 
//웹 페이지에서 Comparable을 사용하는 경우는 예를 들어 다음과 같습니다
//상품 리스트 페이지에서 가격순으로 상품을 정렬하는 경우
//게시글 목록 페이지에서 최신순으로 게시글을 정렬하는 경우
//사용자 목록 페이지에서 이름순으로 사용자를 정렬하는 경우
//위와 같은 경우, Comparable 인터페이스를 구현한 객체를 사용하여 객체들을 정렬할 수 있습니다.
//또한, 검색 기능을 구현할 때도 Comparable 인터페이스를 구현한 객체를 사용하여 정렬된 리스트에서 
//이진 검색 등을 수행할 수 있습니다.
class Cuboid2 implements Shape2, Comparable<Cuboid2> {
	
	// 인스턴스 변수 정의 
	private double width;
	private double height;
	private double depth;
	
	// 생성자 정의
	public Cuboid2(double width, double height, double depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}
	
	// 직육면체의 넓이를 구하는 메소드
	@Override
	public double getArea() {
		return 2*(width * height + height * depth + depth * width);
	}
	
	// 직육면체의 부피를 구하는 메소드 
	public double getVolume() {
		return width* height * depth;
	}
	
	// Comparable 인터페이스의 comparTo 메소드를 구현하여 크기 비교 
	public int compareTo(Cuboid2 other) {
		return Double.compare(getVolume(), other.getVolume());
	}
}


// 메인 메소드 정의
class Main2 {
	public static void main(String [] args) {
		
		// 객체 생성
		Rectangle2 rectangle = new Rectangle2(5,5);
		Triangle2 triangle = new Triangle2(5,5);
		Cuboid2 cuboid = new Cuboid2(5,5,3);
		Cuboid2 cuboid2 = new Cuboid2(4,6,8);
		
		// 넓이 출력
		System.out.println("사각형의 넓이: " + rectangle.getArea());
		System.out.println("삼각형의 넓이: " +triangle.getArea());
		System.out.println("직육면체의 넓이: " +cuboid.getArea());
		System.out.println("직육면체2의 넓이: " +cuboid2.getArea());
		
		// cuboid의 부피를 출력
		System.out.println("Cuboid volume:"+ cuboid.getVolume());
		System.out.println("Cuboid2 volume:"+cuboid2.getVolume());
		
		// cuboid의 부피를 비교하는 메소드
		if(cuboid.compareTo(cuboid2) < 0) {
			System.out.println("직육면체1이 더 큽니다.");
		} else if(cuboid2.compareTo(cuboid) < 0) {
			System.out.println("직육면체2가 더 큽니다.");
		} else {
			System.out.println("직육면체 두 개의 크기가 같습니다.");
		}
	}
}
