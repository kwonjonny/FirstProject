package AbstractInterface;


// 문제
// 추상클래스와 인터페이스 
// 추상 클래스 Product클래스 안에는 name,price,discount의 인스턴스 변수가 있습니다
// 생성자와 , get set 정의 
// getDiscountedPrice(); 메소드 정의 int
// (price * (1 - discount)) 로 할인율을 정합니다 

// Book클래스 Product를 상속 
// 인스턴스 저자(author) 출판사(publisher)
// 메소드 없음

// Clothing Product를 상속
// 인스턴스 소재(material) 색상(color) 사이즈(size)
// 메소드 없음

// Delivery(인터페이스)
// 메소드 : 배송비 계산 (calculateDeliveryFee) int 형 

// RegularDelivery (Delivery를 구현)
// 인스턴스 배송비(deliveryFee)
// 메소드 : 배송비 계산(calculateDeliveryFee= delvieryFee를 받음)

//ExpressDelivery (Delivery를 구현)
//인스턴스 배송비(deliveryFee), 추가 배송비(extraFee)
//메소드: 배송비 계산(calculateDeliveryFee)

// 메인 메소드
// 객체의 생성
// Book3,Clothing3 객체 생성
// RegularDelivery,ExpressDelivery 객체 생성
// Book3 객체의 할인된 계산 가격
// Clothing 객체의 할이된 계산 가격
// RegularDelivery 객체의 배송비 계산
// ExpressDelivery 객체의 배송비 계산

public abstract class Product {
	
	// 인스턴스 변수 정의 
	private String name;
	private int price;
	private double discount;
	
	// 생성자 정의
	public Product(String name, int price, double discount) {
		this.name = name;
		this.price = price;
		this.discount = discount;
	}

	// Getter Setter 정의 캡슐화,정보은닉,보수용이
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	// 추상 메소드 정의
	public int getDiscountedPrice() {
	 return (int)(price * (1 - discount));
	}
	
}


//Book클래스 Product를 상속 
//인스턴스 저자(author) 출판사(publisher)
//메소드 없음
class Book3 extends Product {
	
	// 인스턴스 변수 정의
	private String author;
	private String publisher;
	
	// 생성자 정의
	public Book3(String name, int price, double discount, String author, String publisher) {
		super(name, price, discount);
		this.author = author;
		this.publisher = publisher;
	}
	
	// Getter Setter정의 캡슐화,정보은닉,보수용이
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

}


//Clothing Product를 상속
//인스턴스 소재(material) 색상(color) 사이즈(size)
//메소드 없음
class Clothing3 extends Product {
	
	// 인스턴스 변수 정의
	private String material;
	private String color;
	private String size;
	
	// 생성자 정의
	public Clothing3(String name, int price, double discount, String material, String color, String size) {
		super(name, price, discount);
		this.material = material;
		this.color = color;
		this.size = size;
	}
	
	// Getter Setter정의 캡슐화,정보은닉,보수용이
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}


//Delivery(인터페이스)
//메소드 : 배송비 계산 (calculateDeliveryFee) int 형 
interface Delivery {
	int calculateDeliveryFee();
}


//RegularDelivery (Delivery를 구현)
//인스턴스 배송비(deliveryFee)
//메소드 : 배송비 계산 calculateDeliveryFee return delvieryFee
class RegularDelivery implements Delivery {
	
	// 인스턴스 변수 정의
	private int deliveryFee;
	
	// 생성자 정의
	public RegularDelivery(int deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
	
	// 인터페이스 메소드 오버라이딩
	@Override 
	public int calculateDeliveryFee() {
		return deliveryFee;
	}
}


//ExpressDelivery (Delivery를 구현)
//인스턴스 배송비(deliveryFee), 추가 배송비(extraFee)
//메소드: 배송비 계산 calculateDeliveryFee = deliveryFee + extraFee
class ExpressDelivery implements Delivery {
	
	// 인스턴스 변수 정의 
	private int deliveryFee;
	private int extraFee;
	
	// 생성자 정의
	public ExpressDelivery(int deliveryFee, int extraFee) {
		this.deliveryFee = deliveryFee;
		this.extraFee = extraFee;
	}
	
	// 인터페이스 메소드 오버라이딩
	@Override 
	public int calculateDeliveryFee() {
		return deliveryFee + extraFee;
	}
}

		//객체의 생성
		// Book3,Clothing3 객체 생성
		// RegularDelivery,ExpressDelivery 객체 생성
		
		// Book3 객체의 할인된 계산 가격
		// Clothing 객체의 할인된 계산 가격
		
		// RegularDelivery 객체의 배송비 계산
		// ExpressDelivery 객체의 배송비 계산
class Maiin {
	public static void main(String[] args) {
		
		// Book3,Clothing3 객체 생성
		Book3 book1 = new Book3("Java Programming", 30000, 0.1, "James Gosling", "Oracle");
		Clothing3 clothing1 = new Clothing3("T-Shirt", 10000, 0.2, "Cotton", "Blue", "L");
		
		// book1, clothing1 객체 출력
		System.out.println(book1);
		System.out.println(clothing1);
		
		// Book3 객체의 할인된 계산 가격, Clothing 객체의 할인된 계산 가격 객체 생성
		int bookDiscountedPrice = book1.getDiscountedPrice();
		int ClothingDiscountedPrice = clothing1.getDiscountedPrice();
		
		// book1,Clothing1 할인된 객체의 출력
		System.out.println(bookDiscountedPrice);
		System.out.println(ClothingDiscountedPrice);
		
		// RegularDelivery의 배송비 객체 생성
		RegularDelivery regularDelivery1 = new RegularDelivery(2000);
		// ExpressDelivery의 배송비 객체 생성
		ExpressDelivery expressDelivery1 = new ExpressDelivery(3000, 5000);
		
		// RegularDelivery의 배송비 계산
		int RegularDeliveryFee = regularDelivery1.calculateDeliveryFee();
		int ExpressDeliveryFee = expressDelivery1.calculateDeliveryFee()
	}
}