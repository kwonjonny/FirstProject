package Member;
import java.util.Scanner;

public class Contact {
	
	// 인스턴스 변수 정의
	// 이름,전화번호,이메일,주소,생일,그룹
	private String name;
	private String call;
	private String email;
	private String address;
	private String birthday;
	private String group;
	
	// 데이터를 초기화해주는 생성자 정의
	public Contact(String name, String call, String email, String address, String birthday, String group) {
		this.name = name;
		this.call = call;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
	}
	
	// Getter Setter정의 정보은닉,캡슐화,차후 보수 용이
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCall() {
		return call;
	}
	public void setCall(String call) {
		this.call = call;
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
	
	public String getBirhtday() {
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
	
	// 인스턴스 정보를 출력하는 메소드
	public void printer() {
		System.out.println("Name :" + name);
		System.out.println("Call :" + call);
		System.out.println("Email :" + email);
		System.out.println("Address :" + address);
		System.out.println("Birthday :" + birthday);
		System.out.println("Group :" + group);
	}
	
}

// 메인 메소드 정의
class Tain{
	public static void main(String [] args) {
		
		// 콘솔에서 사용자의 입력값으로 인스턴스 생성
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 이름: ");
        String name = scanner.nextLine();

        System.out.print("Enter 전화번호: ");
        String call = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter 주소: ");
        String address = scanner.nextLine();

        System.out.print("Enter 생일: ");
        String birthday = scanner.nextLine();

        System.out.print("Enter 그룹: ");
        String group = scanner.nextLine();
        
        // 객체 생성
        Contact contact = new Contact("name","call","email","address","birthday","group");
       
        // 객체 출력
        contact.printer();
        
        // 인스턴스의 변수에 값을 바꾸는 메소드를 이용해 데이터 수정
        System.out.println("전화번호 수정 :");
        String newCall = scanner.nextLine();
        
        contact.setCall(newCall);	// Getter Setter중 set으로 설정 수정 
        
        // 수정된 인스턴스의 정보 출력 메소드 재 호출
        System.out.println(contact.getCall());	// 수정된 정보를 get
        
	}
}