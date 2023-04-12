// Payment interface 
public interface PaymentCrud {

	// 회원 상품 주문
	public void orderProduct();

	// 회원 상품 환불
	public void refundProduct();

	// 회원 상품 교환
	public void changeProduct();

}