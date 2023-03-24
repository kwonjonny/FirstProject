import java.util.Scanner;

// 문제: BankAccount 클래스를 만들어서 은행 계좌 정보를 저장하고, 입금과 출금 메소드를 구현하세요. 그리고 
// Main 클래스에서는 사용자로부터 은행 계좌 정보를 입력받아 BankAccount 객체를 생성하고, 
// 입금과 출금을 수행한 후 최종 잔액을 출력하세요.


public class CreateAnInstanceGetterSetter2 {
	
	// 인스턴스 변수 선언
	private String accountNumber;
    private String accountHolderName;
    private int balance;
    
    // 생성자 호출
    // this를 이용한 매개변수 인스턴스 변수에게 전달
    public CreateAnInstanceGetterSetter2(String accountNumber, String accountHolderName, int balance) {
    	this.accountNumber = accountNumber;
    	this.accountHolderName = accountHolderName;
    	this.balance = balance;
    }
    
   

	// getter setter 캡슐화
    public String getAccountNumber() {
    	return accountNumber;
    }
    public void setAccountNumber() {
    	this.accountNumber = accountNumber;
    }
    
    
    public String getaccountHolderName() {
    	return accountHolderName;
    }
    public void setAccountHolderName() {
    	this.accountHolderName = accountHolderName;
    }
    
    
    public int getBalance() {
    	return balance;
    }
    public void setBalance(int balance) {
    	this.balance = balance;
    }
    
 // 입금과 출금 메소드를 구현하세요
    // 입금
    public void deposit(int amount) {
    	balance = balance + amount;
    }
    // 출금
    public void withdraw(int amount) {
    	balance = balance - amount;
    }
    
}

//Main 클래스에서는 사용자로부터 은행 계좌 정보를 입력받아 BankAccount 객체를 생성하고, 
//입금과 출금을 수행한 후 최종 잔액을 출력하세요.
class Main {
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("계좌번호");
		String accountNumber = scan.nextLine();
		System.out.println("예금주명");
		String accountHolderName = scan.nextLine();
		System.out.println("잔액");
		int balance = scan.nextInt();
		
		
		CreateAnInstanceGetterSetter2 BankAccount = new CreateAnInstanceGetterSetter2(accountNumber, accountHolderName, balance);
		
		
		System.out.println("입금액:");
		int depositAmount = scan.nextInt();
		BankAccount.deposit(depositAmount);
		
		System.out.println("출금액:");
		int withdrawAmount = scan.nextInt();
		BankAccount.withdraw(withdrawAmount);
		
		System.out.println("최종잔액"+BankAccount.getBalance());
		
		
	}
}








