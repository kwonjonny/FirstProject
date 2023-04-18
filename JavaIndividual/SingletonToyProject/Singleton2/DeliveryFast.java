
//Delivery interface 
public interface DeliveryFast {

	// 회원 배송 상태 조회
	public void deliveryStatus();

	// 회원 배송 날짜 조회
	public void deliveryDate();

	// 회원 운송장 번호 조회
	public void deliveryTracking();

	// 비회원 배송 상태 조회
	public void deliveryStatusNoMember();

	// 비회원 배송 날짜 조회
	public void deliveryDateNoMember();

	// 비회원 운송장 번호 조회
	public void deliveryTrackingNoMember();

}