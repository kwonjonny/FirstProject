package AbstractInterface;

//주어진 Product 추상 클래스와 Delivery 인터페이스를 이용하여 온라인 상점의 배송 시스템을 구현하세요. 
//이 상점은 Book과 Clothing 클래스를 상속합니다.


//Product 클래스는 상품의 이름, 가격, 할인율 등의 정보를 포함하고 있으며, 
//Book과 Clothing 클래스는 각각 Product 클래스를 상속받아 구현합니다. 

//Delivery 인터페이스는 배송 비용을 계산하는 메서드를 선언하고 있습니다. 
//또한, Delivery 인터페이스를 구현하여 배송 비용을 계산하는 메서드를 정의합니다.
//
//RegularExpress 클래스는 Delivery 인터페이스를 구현하고, 
//일반 배송과 특급 배송의 비용을 계산하는 메서드를 구현합니다. 일반배송비 거리*200 특극배송비 거리*400
//
//main 메서드에서는 Book과 Clothing 객체를 생성하고, 할인된 가격과 배송비를 출력합니다.




public abstract class Product implements Delivery{
	private String name;
	private double price;
	private double discount;
	
	public Product(String name, double price , double discount) {
		this.name = name;
		this.price = price;
		this.discount = discount;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	
	public String toString() {
		return "안녕하세요 이름은 " + name + " 가격은 " + price + " 할인된 가격은! " + discount + " 입니다 ";
	}
	
	public double getDiscountedPrice() {
		 return price * (1 - discount);
	}
	
	public double getDeliveryFee(int distance) {
	    return 0; // 배송비는 상속받은 클래스에서 구현하도록 합니다.
	}

	public double getExpressFee(int distance) {
	    return 0; // 특송비는 상속받은 클래스에서 구현하도록 합니다.
	}
}

class Book extends Product{
	private String author;
	private String publisher;
	
	public Book(String name, double price , double discount, String author, String publisher) {
		super(name,price,discount);
		this.author = author;
		this.publisher = publisher;
	}
	
	@Override
	public String toString() {
		return super.toString() + " 저자는 " + author + " 입니다. " + " 출판사는 " + publisher + " 입니다. ";
	}
	
	@Override
	public double getDiscountedPrice() {
	    return super.getDiscountedPrice();
	}

	@Override
	public double getDeliveryFee(int distance) {
		RegularExpress regularDelivery = new RegularExpress();
	    return regularDelivery.getDeliveryFee(distance);
	}

	@Override
	public double getExpressFee(int distance) {
		RegularExpress expressDelivery = new RegularExpress();
	    return expressDelivery.getDeliveryFee(distance);
	}
	
}

class Clothing extends Product {
	private String material;
	private String color;
	private String size;
	
	public Clothing(String name, double price , double discount, String material, String color, String size) {
		super(name,price,discount);
		this.material = material;
		this.size = size;
		this.color = color;
	}
	
	@Override
	public String toString() {
		return super.toString() + " 소재는 " + material + " 입니다. " + " 색깔은 " + color + " 입니다. " + " 사이즈는 " + size + " 입니다 " ;
	}
	
	@Override
	public double getDiscountedPrice() {
	    return super.getDiscountedPrice();
	}

	@Override
	public double getDeliveryFee(int distance) {
		RegularExpress regularDelivery = new RegularExpress();
	    return regularDelivery.getDeliveryFee(distance);
	}

	@Override
	public double getExpressFee(int distance) {
		RegularExpress expressDelivery = new RegularExpress();
	    return expressDelivery.getDeliveryFee(distance);
	}
	
	
}

interface Delivery {
	  double getDeliveryFee(int distance);
	  
	  double getExpressFee(int distance);
}

class RegularExpress implements Delivery {
    public double getDeliveryFee(int distance) {
        return distance * 200;
    }
    public double  getExpressFee(int distance) {
    	 return distance * 400;
    }
    
}

 

class main14 {
	public static void main(String[]args) {
		
		Book book = new Book("권성준",20000,0.1,"권성준","권성준");
		double discountedPrice = book.getDiscountedPrice();
		double deliveryFee = book.getDeliveryFee(10); // 10Km
		double expressFee = book.getExpressFee(10);   // 10Km
		System.out.println(book.toString()+" 할인율은 "+discountedPrice+" 일반 배송비는 "+deliveryFee+" 특급 배송비는 "+expressFee);
		
		Clothing clothing = new Clothing("권성준" , 300000, 0.2, "울","사이즈100","블랙");
		double discountedPrice2 = clothing.getDiscountedPrice();
		double deliveryFee2 = clothing.getDeliveryFee(10);  // 10Km
		double expressFee2 = clothing.getExpressFee(20);	// 20Km
		System.out.println(clothing.toString()+" 할인율은 "+discountedPrice2+" 일반 배송비는 "+deliveryFee2+" 특급 배송비는 "+expressFee2);
		
		
	}
}




