import java.util.ArrayList;
import java.util.List;

// 회원 클래스 
public class Member {
	// 인스턴스 변수 정의
	private String name; // 회원 이름
	private String phoneNumber; // 회원 전화번호
	private String email; // 회원 이메일
	private String address; // 회원 주소
	private String id; // 회원 아이디
	private String password; // 회원 비밀번호
	private String nickName; // 회원 닉네임
	private String memberAccount; // 회원 계좌번호
	private List<String> inventory;
	private int balance;

	// 생성자 정의
	public Member(String name, String phoneNumber, String email, String address, String id, String password,
			String nickName, String memberAccount, List<String> inventory, int balance) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.id = id;
		this.password = password;
		this.nickName = nickName;
		this.inventory = inventory;
		this.balance = balance;
	}

	public Member(String noMemberPassword, String noMemberId, int balance) {
		this.balance = balance;
		this.inventory = new ArrayList<>();
	}

	// Getter Setter
	public String getName() {
		return name;
	}

	public String getMemberAccount() {
		return memberAccount;
	}

	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getNickName() {
		return nickName;
	}

	public List<String> getInventory() {
		return inventory;
	}

	public int getBalance() { // added getBalance method
		return balance;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setInventory(List<String> inventory) {
		this.inventory = inventory;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
