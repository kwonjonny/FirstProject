public class Contact implements ShowData {
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private String birthday;
	private String group;
	
	public Contact(String name, String phoneNumber, String email, String address, String birthday, String group) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
	}
	
	
	// Getter Setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
	    this.birthday = birthday;
	}
	
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
	public String toString() {
		return "이름: "+name +"전화번호: "+phoneNumber +"Email: "+email;
	}
	
	public void ShowData() {
		System.out.println(super.toString());
	}
	
}
class CompanyContact extends Contact{
	
	private String companyName;
	private String department;
	private String position;
	
	public CompanyContact(String name, String phoneNumber, String email,
			String companyName, String department, String position) {
	super(name,phoneNumber,email,null,null,null);
	this.companyName = companyName;
	this.department = department;
	this.position = position;
	}
	
	@Override
	public String toString() {
		return super.toString() +" 회사이름: "+companyName+" 부서이름: "+department+" 포지션: "+position;
	}
	
	@Override
	public void ShowData() {
		System.out.println(super.toString()+" 회사이름: "+companyName+" 부서이름: "+department+" 포지션: "+position);
	}
	
}
class CustomerContact extends Contact {
	
	private String customerCompany;
    private String product;
    private String rank;
    
    public CustomerContact(String name, String phoneNumber, String email, 
			String customerCompany, String product, String rank) {
    	super(name,phoneNumber,email,null,null,null);
    	this.customerCompany = customerCompany;
    	this.product = product;
    	this.rank = rank;
    }
    
    @Override
    public String toString() {
    	return super.toString() +" 고객회사: "+ customerCompany +" 상품: "+product+" 직급: "+rank;
    }
    
    @Override
	public void ShowData() {
		System.out.println(super.toString()+" 고객회사: "+ customerCompany +" 상품: "+product+" 직급: "+rank);
	}
}

class Main {
	public static void main(String [] args) {
		
		
		CompanyContact company = new CompanyContact(" 권성준 "," 010-3099-0648 "," thistrik@naver.com "," 삼성  "," 개발부 "," 팀장 ");
		System.out.println(company.toString());
		//이름: 권성준 전화번호: 010-3099-0648 Email: thistrik@naver.com 
		//회사이름: 삼성 부서이름: 개발부 포지션: 팀장
		
		CustomerContact customer = new CustomerContact(" 권성준 " , " 010-3099-0648 ", " thistrik@naver.com ",  " 하이미디어 " , " 결제 웹 ", " 팀장 ");
		System.out.println(customer.toString());
		//이름: 권성준 전화번호: 010-30990648 Email: thistrik@naver.com 
		//고객회사: 하이미디어 상품: 결제 웹 직급: 팀장
	}
}
