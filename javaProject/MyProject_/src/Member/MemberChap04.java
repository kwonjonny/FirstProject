package Member;

//객체지향_인스턴스와 클래스

//Member 클래스에는 아래 요구사항에 맞는 변수와 메소드를 정의하고, main()메소드 에 해당 메소드를 호출해서 결과를 확인해보세요.
//단 인스턴스의 생성은 생성자를 이용해서 초기화하는 코드를 작성해 봅시다.
//아래의 데이터를 저장 이름, 전화번호, 전공, 학년, email, 생일, 주소
//위에서 정의한 정보를 출력하는 메소드 정의
//모든 정보를 저장하도록 하는 생성자와 생일과 주소는 저장하지 않을 수 있는 생성자를 정의
//main() 메소드에서 두 가지 생성자를 이용해서 인스턴스 생성하고 출력 메소드를 통해 저장된 데이터 출력.


public class MemberChap04 {

	// 인스턴스 변수 정의 
	// 아래의 데이터를 저장 이름, 전화번호, 전공, 학년, email, 생일, 주소
	private String name;	
	private String phoneNumber;
	private String major;
	private int grade;
	private String email;
	private String birthday;
	private String address;
	
	// 모든 정보를 저장하는 생성자 생성
	public MemberChap04(String name, String phoneNumber, String major, int grade, 
						String email, String birthday, String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.major = major;
		this.grade = grade;
		this.email = email;
		this.birthday = birthday;
		this.address = address;
	}
	
	// 모든 정보를 저장하지 않은 생성자 생성
	public MemberChap04(String name, String phoneNumber, String major, int grade, String email) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.major = major;
		this.grade = grade;
		this.email = email;
		this.birthday = null;
		this.address = null;
	}    
	// 생일과 주소는 null로 생성자 생성
        
	
	
	// Getter 와 Setter를 생성해준다
	// Getter 와 Setter는 정보은닉,캡슐화,차후에 보수 용이
	// 또한 인스턴스변수를 private으로 설정함으로써 get set을 이용해서만 접근할수있다.
	public String getName() { 
		return name;
	}
	public void setName() { 
		this.name=name;
	}
	
	
	public String getPhoneNumber() { 
		return phoneNumber;
	}
	public void setPhoneNumber() {   
		this.phoneNumber = phoneNumber;
	}
	
	
	public String getMajor() { 
		return major;
	}
	public void setMajor() {   
		this.major = major;
	}
	
	
	public int getGrade() { 
		return grade;
	}
	public void setGrade() { 
		this.grade = grade;
	}
	
	
	public String getEmail() { 
		return email;
	}
	public void setEmail() { 
		this.email = email;
	}
	
	
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday() {
		this.birthday = birthday;
	}
	
	
	public String getAddress() { 
		return address;
	}
	public void setAddress() { 	
		this.address=address;
	}
	
	
	
	// 위에서 정의한 정보를 출력하는 메소드 정의한다
	// 출력메소드 안에서는 인스턴수 변수를 호출해준다
	// 또한 모든 정보를 생성하지 않는 생성자에서는 birthday와 address가 없었으므로
	// if(birthday != null) 만약 birthday = null이 아닐시 생년월일 출력
	// if(address != null) 만약 address = null이 아닐시 주소 출력.
	public void print() {
		System.out.println("이름: " + name);
        System.out.println("전화번호: " + phoneNumber);
        System.out.println("전공: " + major);
        System.out.println("학년: " + grade);
        System.out.println("이메일: " + email);
        if(birthday != null) {
        	System.out.println("생년월일:" + birthday);
        }
        if(address != null) {
        	System.out.println("주소:" +address);
        }
	}
	
				// 실행을 하는 메인메소드 생성 같은 클래스 내에서도 호출할수있지만 
				// 웹 프로그램에서는 같은 클래스 내에서 호출하는 경우는 드물다
				// 다른 클래스를 생성해서 호출해본다.
class call {	// 한 클래스 내에 public class는 하나만 달아준다
	public static void main(String [] args) {
		MemberChap04 call1 = new MemberChap04("권성준", "010-1234-5678", "경제학과", 3, "kwon123@gmail.com", 
				"19980626", "서울시 강남구");
			call1.print();	
			
			System.out.println(); //줄바꿈 해준다
			
		MemberChap04 call2 = new MemberChap04("김무무", "010-1234-5678", "사회학과", 3, "kim123@gmail.com");
			call2.print();		
		}
	}	
}

