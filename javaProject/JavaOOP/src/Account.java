//문제:
//은행 계좌 정보를 담는 Account 클래스를 작성하고, 
//이를 상속받아 입출금 기능이 있는 CheckingAccount와 SavingsAccount 클래스를 작성하세요.
//
//Account 클래스는 다음과 같은 인스턴스 변수를 가집니다.
//
//계좌번호(accountNumber, String)
//계좌주(owner, String)
//잔액(balance, int)
//Account 클래스는 다음과 같은 메소드를 가집니다.
//
//생성자: 계좌번호, 계좌주, 잔액을 입력받아 인스턴스 변수를 초기화합니다.
//deposit(int amount): 입금액을 입력받아 잔액에 더합니다.
//withdraw(int amount): 출금액을 입력받아 잔액에서 뺍니다. 
//만약 잔액이 출금액보다 작으면 출금을 수행하지 않고 "잔액이 부족합니다"라는 메시지를 출력합니다.
//getBalance(): 현재 잔액을 반환합니다.
//toString(): 현재 계좌의 정보를 문자열로 반환합니다. 
//(ex: "계좌번호: 123-456-789, 계좌주: 홍길동, 잔액: 10000원")
//CheckingAccount 클래스는 Account 클래스를 상속받아 다음과 같은 인스턴스 변수를 추가로 가집니다.
//
//수수료(commission, int)
//CheckingAccount 클래스는 다음과 같은 메소드를 추가로 가집니다.
//
//생성자: 계좌번호, 계좌주, 잔액, 수수료를 입력받아 인스턴스 변수를 초기화합니다.
//withdraw(int amount): 출금액과 수수료를 합산한 금액만큼 잔액에서 뺍니다.
//SavingsAccount 클래스는 Account 클래스를 상속받아 다음과 같은 인스턴스 변수를 추가로 가집니다.
//
//이자율(interestRate, double)
//SavingsAccount 클래스는 다음과 같은 메소드를 추가로 가집니다.
//
//생성자: 계좌번호, 계좌주, 잔액, 이자율을 입력받아 인스턴스 변수를 초기화합니다.
//addInterest(): 현재 잔액에 이자를 계산하여 더합니다. 이자율은 연간 단위이며, 
//잔액에 이자를 더한 값을 반환합니다.
//각 클래스를 작성하고, 메인 메소드에서 각 계좌 클래스 객체를 생성하여 
//입출금 기능과 이자 추가 기능을 테스트해보세요.
public class Account {

	// 인스턴스 변수 정의
	protected String accountNumber;
	protected String owner;
	protected int balance;
	
	// 생성자 정의
	public Account(String accountNumber, String owner, int balance) {
		this.accountNumber = accountNumber;
		this.owner = owner;
		this.balance = balance;
	}
	
	// Getter Setter정의 정보은닉,캡슐화,보수용이
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber() {
		this.accountNumber = accountNumber;
	}
	
	
	public String getOwner() {
		return owner;
	}
	public void setOwner() {
		this.owner = owner;
	}
	
	
	//getBalance(): 현재 잔액을 반환합니다.
	public int getBalance() {
		return balance;
	}
	public void setBalance() {
		this.balance = balance;
	}
	
	//deposit(int amount): 입금액을 입력받아 잔액에 더합니다.
	//withdraw(int amount): 출금액을 입력받아 잔액에서 뺍니다. 
	//만약 잔액이 출금액보다 작으면 출금을 수행하지 않고 "잔액이 부족합니다"라는 메시지를 출력합니다.
	
	// 입금 메소드
	public void desposit(int amount) {
		balance = balance + amount;
	}
	// 출금 메소드
	public void withDraw(int amount) {
		  if (balance >= amount) {
	            balance -= amount;
	        } else {
	            System.out.println("잔액이 부족합니다");
	        }
	}
	
	//toString(): 현재 계좌의 정보를 문자열로 반환합니다. 
	//(ex: "계좌번호: 123-456-789, 계좌주: 홍길동, 잔액: 10000원")
	public String toString() {
		return "계좌번호:" + accountNumber + ", 계좌주:" + owner + "잔액:" + balance;
	}

}


//수수료(commission, int)
//CheckingAccount 클래스는 다음과 같은 메소드를 추가로 가집니다.
//생성자: 계좌번호, 계좌주, 잔액, 수수료를 입력받아 인스턴스 변수를 초기화합니다.
//withdraw(int amount): 출금액과 수수료를 합산한 금액만큼 잔액에서 뺍니다.
class CheckingAccount extends Account {
	
	// 인스턴스 변수 정의
	protected int commission;
	
	// 생성자 정의
	public CheckingAccount(String accountNumber, String owner, int balance, int commission) {
		super(accountNumber, owner, balance);
		this.commission = commission;
	}

	 public void withdraw(int amount) {
	        int totalAmount = amount + commission;
	        if (balance >= totalAmount) {
	            balance = balance - totalAmount;
	        } else {
	            System.out.println("잔액이 부족합니다");
	        }
	    }
	}


//SavingsAccount 클래스는 Account 클래스를 상속받아 다음과 같은 인스턴스 변수를 추가로 가집니다.
//
//이자율(interestRate, double)
//SavingsAccount 클래스는 다음과 같은 메소드를 추가로 가집니다.
//생성자: 계좌번호, 계좌주, 잔액, 이자율을 입력받아 인스턴스 변수를 초기화합니다.
//addInterest(): 현재 잔액에 이자를 계산하여 더합니다. 이자율은 연간 단위이며, 
//잔액에 이자를 더한 값을 반환합니다.
class SavingAccount extends Account {
	// 인스턴스 변수 정의
    protected double interestRate;

    // 생성자 정의
    public SavingAccount(String accountNumber, String owner, int balance, double interestRate) {
        super(accountNumber, owner, balance);
        this.interestRate = interestRate;
    }
    
    public double getInterestRate() {
    	return interestRate;
    }
    public void setInterestRate(double interestRate) {
    	this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = balance * interestRate / 100;
        balance = balance + (int)interest;
    }
}


//각 클래스를 작성하고, 메인 메소드에서 각 계좌 클래스 객체를 생성하여 
//입출금 기능과 이자 추가 기능을 테스트해보세요.
class Tain{
	public static void main(String [] args) {
		Account account = new Account("1234-2354-2352","권성준",500000);
		System.out.println(account.toString());
		
		account.desposit(200000); // 700,000원
		System.out.println(account.toString());
		
		account.withDraw(100000); // 600,000원
		System.out.println(account.toString());
		
		account.withDraw(700000); // - 100,000원 잔액이 부족합니다 출력
		
		// CheckingAccount 객체 생성 및 입출금 및 수수료 기능 테스트
		CheckingAccount checkingAccount = new CheckingAccount("1234-2345-2345", "권성준",20000,1000);
		System.out.println(checkingAccount.toString()); 	// 잔액 21000원
		
		checkingAccount.withDraw(5000);	// 수수료 1000원 + 5000원 - 6000원 = 15000원
		System.out.println(checkingAccount.toString()); // 15000원
		
		checkingAccount.withdraw(15000); // 15000 - 15000 + 1000 = - 1000원 
		// 잔액이 부족합니다 출력 
		
		// SavingAccount 객체 생성 및 입출금 및 이자율 추가 테스트 
		SavingAccount savingAccount = new SavingAccount("1234-2345-235", "권성준", 20000, 10);
		System.out.println(savingAccount.toString()); // 잔액 20000원 이자율 10%
		
		account.addInterest();
		System.out.println("이자가 추가된 현재 잔액:" + savingAccount.getBalance()); // 21000원
	}
}

