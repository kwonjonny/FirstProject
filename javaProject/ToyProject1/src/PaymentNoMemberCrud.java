
// paymentNoMember interface 
public interface PaymentNoMemberCrud {

	// 비회원 상품 주문
	public void orderProductNoMember();

	// 비회원 상품 환불
	public void refundProductNoMember();

	// 비회원 상품 교환
	public void changeProductNoMember();
}