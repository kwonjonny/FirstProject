import java.util.List;

// 비회원 클래스 
public class NoMember {

	private String noMemberId; // 비회원 아이디
	private String noMemberPassword; // 비회원 비밀번호
	private String noMemberName; // 비회원 이름
	private String noMemberAccount; // 비회원 계좌번호

	private String noMemberAddress; // 비회원 주소

	private List<String> noMemberInventory;
	private int noMemberBalance;

	public NoMember(String noMemberId, String noMemberPassword, String noMemberName, String noMemberAccount,
			String noMemberAddress, List<String> noMemberInventory, int noMemberBalance) {
		super();
		this.noMemberId = noMemberId;
		this.noMemberPassword = noMemberPassword;
		this.noMemberName = noMemberName;
		this.noMemberAccount = noMemberAccount;
		this.noMemberAddress = noMemberAddress;
		this.noMemberInventory = noMemberInventory;
		this.noMemberBalance = noMemberBalance;
	}

	public String getNoMemberId() {
		return noMemberId;
	}

	public void setNoMemberId(String noMemberId) {
		this.noMemberId = noMemberId;
	}

	public String getNoMemberPassword() {
		return noMemberPassword;
	}

	public void setNoMemberPassword(String noMemberPassword) {
		this.noMemberPassword = noMemberPassword;
	}

	public String getNoMemberName() {
		return noMemberName;
	}

	public void setNoMemberName(String noMemberName) {
		this.noMemberName = noMemberName;
	}

	public String getNoMemberAccount() {
		return noMemberAccount;
	}

	public void setNoMemberAccount(String noMemberAccount) {
		this.noMemberAccount = noMemberAccount;
	}

	public String getNoMemberAddress() {
		return noMemberAddress;
	}

	public void setNoMemberAddress(String noMemberAddress) {
		this.noMemberAddress = noMemberAddress;
	}

	public List<String> getNoMemberInventory() {
		return noMemberInventory;
	}

	public void setNoMemberInventory(List<String> noMemberInventory) {
		this.noMemberInventory = noMemberInventory;
	}

	public int getNoMemberBalance() {
		return noMemberBalance;
	}

	public void setNoMemberBalance(int noMemberBalance) {
		this.noMemberBalance = noMemberBalance;
	}

}