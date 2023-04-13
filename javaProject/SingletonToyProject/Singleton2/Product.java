

// Product 클래스 
public class Product {
	// 인스턴스 변수 정의 상품이 있다고 가정
	private String product1;
	private String product2;
	private String product3;
	private String product4;

	// 생성자 정의
	public Product(String product1, String product2, String product3, String product4) {
		this.product1 = product1;
		this.product2 = product2;
		this.product3 = product3;
		this.product4 = product4;
	}

	// Getter Setter
	public String getProduct1() {
		return product1;
	}

	public String getProduct2() {
		return product2;
	}

	public String getProduct3() {
		return product3;
	}

	public String getProduct4() {
		return product4;
	}

	public void setProduct1(String product1) {
		this.product1 = product1;
	}

	public void setProduct2(String product2) {
		this.product2 = product2;
	}

	public void setProduct3(String product3) {
		this.product3 = product3;
	}

	public void setProduct4(String product4) {
		this.product4 = product4;
	}

}
