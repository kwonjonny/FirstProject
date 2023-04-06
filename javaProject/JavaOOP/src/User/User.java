package User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//문제:
//사용자 정보를 관리하는 클래스들을 구현해보세요.
//
//사용자(User) 클래스: 사용자 정보를 나타내는 클래스로, 사용자의 이름, 
//나이, 이메일 등의 속성을 가지고 있어야 합니다. 또한, 사용자 정보를 출력하는 
//메서드를 가지고 있어야 합니다.
//
//관리자(Admin) 클래스: 사용자 클래스를 상속받는 관리자 클래스로, 사용자 클래스에 
//추가적인 속성(예: 직책, 권한 등)을 가지고 있어야 합니다. 또한, 관리자 정보를 출력하는 
//메서드를 추가적으로 가지고 있어야 합니다.
//
//고객(Customer) 클래스: 사용자 클래스를 상속받는 고객 클래스로, 
//사용자 클래스에 추가적인 속성(예: 멤버십 등급, 포인트 등)을 가지고 있어야 합니다. 
//또한, 고객 정보를 출력하는 메서드를 추가적으로 가지고 있어야 합니다.
//
//컬렉션 프레임워크 활용: 사용자, 관리자, 고객 객체들을 ArrayList를 활용하여 
//저장하고, 검색, 추가, 삭제 등의 다양한 컬렉션 메서드를 활용하여 객체들을 관리해보세요.
//메인 메소드에서는 while 을 사용 
//
//다형성 활용: 사용자, 관리자, 고객 클래스들을 이용하여 다양한 사용자 객체를 생성하고, 
//이들을 사용자 배열에 저장하고 관리해보세요. 사용자 배열에 저장된 사용자 객체들의 정보를 
//출력하는 메서드를 구현하여 출력해보세요.
//
//주석과 문서화: 클래스, 메서드, 필드 등에 주석을 추가하여 코드를 문서화해보세요.
//JavaDoc과 같은 문서화 도구를 활용하여 사용자 클래스와 관련된 API 문서를 자동으로 생성해보세요. 풀어보세요!

// User 추상클래스 CurdOperation 인터페이스 구현 
public class User implements CurdOperation {

	// 인스턴스 변수 정의
	private String name;
	private String age;
	private String email;

	// 생성자 정의
	public User(String name, String age, String email) {
		this.name = name;
		this.age = age;
		this.email = email;
	}

	// Getter Setter 정의
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// 추상 메소드 정의
	public void printinfo() {
		System.out.println("이름: " + getName());
		System.out.println("나이: " + getAge());
		System.out.println("이메일: " + getEmail());
	}
}

class Admin extends User {

	// 인스턴스 변수 정의
	private String position;
	private String power;

	// 사용자 정의
	public Admin(String name, String age, String email, String position, String power) {
		super(name, age, email);
		this.position = position;
		this.power = power;
	}

	// Getter Setter 정의
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	// 추상 메소드 + 관리자 정보
	public void ShowDataAdmin() {
		super.printinfo();
		System.out.println("직급: " + position);
		System.out.println("직책 파워: " + power);
	}
}

class Customer extends User {

	// 인스턴스 변수 정의
	private String membershipRank;
	private String point;

	// 사용자 정의
	public Customer(String name, String age, String email, String membershipRank, String point) {
		super(name, age, email);
		this.membershipRank = membershipRank;
		this.point = point;
	}

	// Getter Setter 정의
	public String getMembershipRank() {
		return membershipRank;
	}

	public void setMembershipRank(String membershipRank) {
		this.membershipRank = membershipRank;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	// 추상 메소드 + 고객 정보
	public void ShowDataAdmin() {
		super.printinfo();
		System.out.println("멤버십 랭크: " + membershipRank);
		System.out.println("멤버 포인트:" + point);
	}
}

interface CurdOperation {

	// 고객 정보 생성
	public static void createAdmin() {
	}

	// 고객 정보 수정
	public static void modifyAdmin() {

	}

	// 고객 정보 삭제
	public static void deleteAdmin() {

	}

	// 고객 정보 출력
	public static void showDataAdmin() {

	}

	// 관리자 정보 생성
	public static void createCustomer() {

	}

	// 관리자 정보 수정
	public static void modifyCustomer() {

	}

	// 관리자 정보 삭제
	public static void deleteCustomer() {

	}

	// 관리자 정보 출력
	public static void showDataCustomer() {

	}
}

// 예외처리 클래스 
class ExceptionHelper {
	public static void handleException(Exception e) {
		// 예외 처리 로직을 작성합니다.
		System.out.println("잘못된 입력입니다 관리자에게 문의하세요. " + e.getMessage());
	}
}

class Main2 implements CurdOperation {

	// 사용자 정보를 저장할 ArrayList
	private static ArrayList<Admin> adminList = new ArrayList<>();
	private static ArrayList<Customer> customerList = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		boolean Istrue = true;
		while (Istrue) {
			try {
				System.out.println("=====관리자,고객 프로그램=====");
				System.out.println("1. 관리자 정보 생성");
				System.out.println("2. 관리자 정보 삭제");
				System.out.println("3. 관리자 정보 수정");
				System.out.println("4. 관리자 정보 출력");
				System.out.println("5. 고객 정보 생성");
				System.out.println("6. 고객 정보 삭제");
				System.out.println("7. 고객 정보 수정");
				System.out.println("8. 고객 정보 출력");
				System.out.println("9. 종료");
				System.out.print("원하는 동작을 선택하세요 (1-9): ");
				System.out.println("=========================");
				int choice = scanner.nextInt();
				scanner.nextLine(); // 버퍼 비우기

				switch (choice) {
				case 1:
					createAdmin();
					break;
				case 2:
					deleteAdmin();
					break;
				case 3:
					modifyAdmin();
					break;
				case 4:
					showDataAdmin();
					break;
				case 5:
					createCustomer();
					break;
				case 6:
					deleteCustomer();
					break;
				case 7:
					modifyCustomer();
					break;
				case 8:
					showDataCustomer();
					break;
				case 9:
					Istrue = false;
					System.out.println("======종료=======");
					return;
				default:
					System.out.println("잘못된 입력이에요.");
				}

			} catch (Exception e) {
				ExceptionHelper.handleException(e);
			}
		}
	}

	// 정보 추가
	private static void createAdmin() {
		System.out.println("이름을 입력해주세요: ");
		System.out.print("이름: ");
		String name = scanner.nextLine();
		System.out.print("나이: ");
		String age = scanner.nextLine();
		System.out.print("이메일: ");
		String email = scanner.nextLine();
		System.out.print("직급: ");
		String position = scanner.nextLine();
		System.out.print("직책 파워: ");
		String power = scanner.nextLine();

		// 관리자 정보 객체 생성
		Admin admin = new Admin(name, age, email, position, power);
		admin.setName(name);
		admin.setAge(age);
		admin.setEmail(email);
		admin.setPosition(position);
		admin.setPower(power);

		// UserList에 관리자 정보 추가
		adminList.add(admin);
		System.out.println("관리자 정보가 추가되었습니다.");
	}

	// 정보 삭제
	private static void deleteAdmin() {
		System.out.println("삭제할 관리자의 이름 입력: ");
		String name = scanner.nextLine();

		// adminList에서 이름에 해당하는 관리자 정보 삭제
		boolean isDeleted = false;
		for (Admin admins : adminList) {
			if (admins.getName().equals(name)) {
				adminList.remove(admins);
				{
					isDeleted = true;
					System.out.println("관리자 정보가 삭제되엇습니다.");
					break;
				}
			}
			if (!isDeleted) {
				System.out.println("해당 이름이 없습니다.");
			}
		}
	}

	// 정보 수정
	private static void modifyAdmin() {
		System.out.println("수정할 관리자의 이름 입력: ");
		String name = scanner.nextLine();
		boolean isUpdate = false;

		// adminList에서 이름에 해당하는 관리자 정보 수정
		Admin updateAdmin = null;
		for (Admin admins : adminList) {
			if (admins.getName().equals(name)) {
				updateAdmin = admins;
				isUpdate = true;
				System.out.println("관리자 정보가 수정되었습니다.");
				break;
			}
		}
		if (!isUpdate) {
			System.out.println("해당 관리자의 이름이 없습니다.");
		}
	}

	// 정보 출력
	private static void showDataAdmin() {
		System.out.println("정보 출력할 관리자의 이름 입력");
		String name = scanner.nextLine();
		boolean isFound = false;

		Admin showData = null;
		for (Admin admins : adminList) {
			if (admins.getName().equals(name)) {
				System.out.println("이름: " + admins.getName());
				System.out.println("나이: " + admins.getAge());
				System.out.println("이메일: " + admins.getEmail());
				System.out.println("직급: " + admins.getPosition());
				System.out.println("직책 파워: " + admins.getPower());
				System.out.println("관리자 정보가 출력되었습니다.");
				isFound = true;
				break;
			}
		}
		if (!isFound) {
			System.out.println("해당하는 이름의 관리자가 없습니다.");
		}
	}

	// 정보 추가
	private static void createCustomer() {
		System.out.println("이름을 입력해주세요: ");
		System.out.print("이름: ");
		String name = scanner.nextLine();
		System.out.print("나이: ");
		String age = scanner.nextLine();
		System.out.print("이메일: ");
		String email = scanner.nextLine();
		System.out.print("멤버십 랭크: ");
		String membershipRank = scanner.nextLine();
		System.out.print("포인트: ");
		String point = scanner.nextLine();

		// 고객 정보 객체 생성
		Customer customer = new Customer(name, age, email, membershipRank, point);
		customer.setName(name);
		customer.setAge(age);
		customer.setEmail(email);
		customer.setMembershipRank(membershipRank);
		customer.setPoint(point);

		customerList.add(customer);
		System.out.println("고객 정보가 추가되었습니다.");
	}

	// 정보 삭제
	private static void deleteCustomer() {
		System.out.println("삭제할 고객의 이름 입력: ");
		String name = scanner.nextLine();

		// adminList에서 이름에 해당하는 관리자 정보 삭제
		boolean isDeleted = false;
		for (Customer customers : customerList) {
			if (customers.getName().equals(name)) {
				adminList.remove(customers);
				{
					isDeleted = true;
					System.out.println("관리자 정보가 삭제되엇습니다.");
					break;
				}
			}
			if (!isDeleted) {
				System.out.println("해당 이름이 없습니다.");
			}
		}
	}

	// 정보 수정
	private static void modifyCustomer() {
		System.out.println("수정할 고객의 이름 입력: ");
		String name = scanner.nextLine();
		boolean isModify = false;
		// adminList에서 이름에 해당하는 관리자 정보 수정
		Customer updateCustomer = null;
		for (Customer customers : customerList) {
			if (customers.getName().equals(name)) {
				updateCustomer = customers;
				isModify = true;
				System.out.println("고객 정보가 수정되었습니다.");
				break;
			}
		}
		if (!isModify) {
			System.out.println("해당 정보가 없습니다.");
		}
	}

	// 정보 출력
	private static void showDataCustomer() {
		System.out.println("정보 출력할 고객 이름 입력: ");
		String name = scanner.nextLine();
		boolean isFound = false;

		Customer showData = null;
		for (Customer customers : customerList) {
			if (customers.getName().equals(name)) {
				System.out.println("이름: " + customers.getName());
				System.out.println("나이: " + customers.getAge());
				System.out.println("이메일: " + customers.getEmail());
				System.out.println("멤버십 랭크: " + customers.getMembershipRank());
				System.out.println("포인트: " + customers.getPoint());
				System.out.println("고객 정보가 출력되었습니다.");
				isFound = true;
				break;
			}
		}
		if (!isFound) {
			System.out.println("해당하는 이름의 고객이 없습니다.");
		}
	}
}
