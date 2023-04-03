package AbstractInterface;

import java.util.List;

import Abstract.Item;

// 주문 인터페이스
interface Order {
    void addItem(String item); // 상품을 장바구니에 추가
    void processPayment(int processPayment);
	void removeItem(String item); // 상품을 장바구니에서 제거
    void upadateItemQuantity(String item, int Quantity); // 상품 수량 업데이트 
    void placeOrder(); // 주문 완료 
}

// 결제 인터페이스
interface Payment {
    void inputPaymentInfo(String paymentInfo); //결제 정보 입력
    void calculateTotalPrice(); // 총 결제 금액 계산
    void processPayment(int processPayment); // 결제 처리
    void sendConfirmationEmail(); // 결제 완료 후 이메일 발송
}

class OrderPaymentImpl implements Order, Payment {
    private String cart;
    private String paymentInfo;
    private double totalPrice;
    
    
    @Override
    public void addItem(String item) {
        
    }

    @Override
    public void removeItem(String item) {
        
    }

    @Override
    public void upadateItemQuantity(String item, int Quantity) {
        
    }

    @Override
    public void placeOrder() {
        System.out.println("주문완료!");
    }

    @Override
    public void inputPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    @Override
    public void calculateTotalPrice() {
        
    }

    @Override
	public void processPayment(int processPayment) {
		// 결제 처리 로직
	}

    @Override
    public void sendConfirmationEmail() {
        // 이메일 발송 로직
    	System.out.println("귀하의 이메일로 전달메시지가 발송되었습니다.");
    }


	

	

	
}

class Main4 {
    public static void main(String[] args) {
    	// 상품 정보 생성
    	OrderPaymentImpl cart = new OrderPaymentImpl();
    	cart.addItem("아이폰");
    	cart.addItem("갤럭시");
    	
    	cart.upadateItemQuantity("아이폰11", 1);
    	cart.upadateItemQuantity("아이폰14프로", 1);
    	
    	cart.inputPaymentInfo("1234-5678-9012-3456");
    	cart.calculateTotalPrice();
    	cart.processPayment(5000);
    	cart.sendConfirmationEmail();
    	cart.placeOrder();
    }
}