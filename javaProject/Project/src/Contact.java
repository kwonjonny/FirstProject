//아래 이미지는 우리가 흔히 볼 수 있는 스마트폰에 이름, 전화번호, 이메일 등과 같은 연락처 정보를 저장하는 애플리케이션 화면입니다. 
//아래 데이터들을 저장하고, 데이터를 출력하는 메소드를 가지는 클래스 Contact를 정의해봅시다.
//
//저장 정보 이름 전화번호 이메일 주소 생일 그룹
//위 데이터를 출력하는 기능 
//
//추가 요구 사항 
//변수들은 직접 참조를 막아 캡슐화 처리를 하도록 해봅시다. 
//변수의 직접 참조는 안되지만 변수의 값을 얻을 수 있는 메소드(getter)와
//변수에 값을 저장할 수 있는 메소드(setter)를 정의합니다.
//인스턴스 생성과 함께 데이터를 초기화 할 수 있도록 생성자를 정의해봅시다.
//저장할 데이터를 콘솔에서 사용자의 입력 값으로 인스턴스를 생성해봅시다.
//
//실행 과정 
// main()메소드를 정의합니다.
// 연락처 데이터를 저장하는 인스턴스를 생성합니다.
// 변수 값을 반환하는 각각의 메소드를 호출해서 각 데이터를 출력문으로 출력합니다.
// 생성된 인스턴스의 정보 출력 메소드를 호출합니다.
// 인스턴스의 각 변수에 값을 바꾸는 메소드를 이용해서 데이터를 수정합니다.
// 인스턴스의 출력메소드를 다시 실행합니다


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
	public String getContactInfo() {
	    return "Name : " + name + "\n" +
	           "Call : " + call + "\n" +
	           "Email : " + email + "\n" +
	           "Address : " + address + "\n" +
	           "Birthday : " + birthday + "\n" +
	           "Group : " + group + "\n";
	}
	
}

// 메인 메소드 정의
class TTain{
	public static void main(String [] args) {
		
		// private로 선언된 인스턴스 변수는 본래 다른 클래스에서는 호출하지 못하나
		// get set을 통해 인스턴스 변수의 호출이 가능하다
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
        Contact contact = new Contact(name, call, email, address, birthday, group);
       
        // 객체 출력
        contact.getContactInfo();
        
        // 인스턴스의 변수에 값을 바꾸는 메소드를 이용해 데이터 수정
        System.out.println("전화번호 수정 :");
        String newCall = scanner.nextLine();
        
        contact.setCall(newCall);	// Getter Setter중 set으로 설정 수정 
        
        // 수정된 인스턴스의 정보 출력 메소드 재 호출
        System.out.println(contact.getContactInfo());	// 수정된 정보를 get
        
	}
}