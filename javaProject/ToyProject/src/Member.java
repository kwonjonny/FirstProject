import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Member {
	private String name;
	private String email;
	private String phoneNumber;
	private String id;
	private String password;

	public Member(String name, String email, String phoneNumber, String id, String password) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.id = id;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phonNumber) {
		this.phoneNumber = phonNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

class MemberController {
	private static MemberController instance = null;
	private MemberRepository repository;

	private MemberController() {
		repository = MemberRepository.getInstance();
	}

	public static synchronized MemberController getInstance() {
		if (instance == null) {
			instance = new MemberController();
		}
		return instance;
	}

	public void createMember(String name, String email, String phoneNumber, String id, String password) {
		Member member = new Member(name, email, phoneNumber, id, password);
		repository.save(member);
	}

	public void deleteMember(String id, String password) {
		if (repository.findByIdAndPassword(id, password) != null) {
			repository.deleteById(id);
		} else {
			System.out.println("Invalid ID or password");
		}
	}

	public void updateMember(String id, String password, String name, String email, String phoneNumber) {
		Member member = repository.findByIdAndPassword(id, password);
		if (member != null) {
			member.setName(name);
			member.setEmail(email);
			member.setPhoneNumber(phoneNumber);
			repository.update(member);
		} else {
			System.out.println("Invalid ID or password");
		}
	}

	public void printMember(String id, String password) {
		Member member = repository.findByIdAndPassword(id, password);
		if (member != null) {
			System.out.println("Name: " + member.getName());
			System.out.println("Email: " + member.getEmail());
			System.out.println("Phone number: " + member.getPhoneNumber());
			System.out.println("ID: " + member.getId());
			System.out.println("Password: " + member.getPassword());
		} else {
			System.out.println("Invalid ID or password");
		}
	}
}

class MemberRepository {
	private static MemberRepository instance = null;
	private List<Member> memberList;

	private MemberRepository() {
		memberList = new ArrayList<>();
	}

	public static synchronized MemberRepository getInstance() {
		if (instance == null) {
			instance = new MemberRepository();
		}
		return instance;
	}

	public void save(Member member) {
		memberList.add(member);
	}

	public Member findByIdAndPassword(String id, String password) {
		for (Member member : memberList) {
			if (member.getId().equals(id) && member.getPassword().equals(password)) {
				return member;
			}
		}
		return null;
	}

	public void update(Member member) {
	    ListIterator<Member> iterator = memberList.listIterator();
	    while (iterator.hasNext()) {
	        Member currentMember = iterator.next();
	        if (currentMember.getId().equals(member.getId())) {
	            iterator.set(member);
	            return;
	        }
	    }
	}

	public void deleteById(String id) {
	    ListIterator<Member> iterator = memberList.listIterator();
	    while (iterator.hasNext()) {
	        Member currentMember = iterator.next();
	        if (currentMember.getId().equals(id)) {
	            iterator.remove();
	            return;
	        }
	    }
	}

	public List<Member> getAllMembers() {
		return memberList;
	}
}

interface MemberInterface {
	
	void createMember(String name, String email, String phoneNumber, String id, String password);

	void deleteMember(String id, String password);

	void updateMember(String id, String password, String name, String email, String phoneNumber);

	void printMember(String id, String password);
}

class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static MemberController controller = MemberController.getInstance();

	public static void main(String[] args) {
		while (true) {
			System.out.println("1. Create member");
			System.out.println("2. Update member");
			System.out.println("3. Delete member");
			System.out.println("4. Print member details");
			System.out.println("5. Exit");
			System.out.print("Enter an option: ");
			int option = scanner.nextInt();
			scanner.nextLine(); // Consume newline character

			switch (option) {
			case 1:
				createMember();
				break;
			case 2:
				updateMember();
				break;
			case 3:
				deleteMember();
				break;
			case 4:
				printMemberDetails();
				break;
			case 5:
				System.out.println("Exiting...");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}

	}

	private static void createMember() {
		System.out.print("Enter name: ");
		String name = scanner.nextLine();

		System.out.print("Enter email: ");
		String email = scanner.nextLine();

		System.out.print("Enter phone number: ");
		String phoneNumber = scanner.nextLine();

		System.out.print("Enter ID: ");
		String id = scanner.nextLine();

		System.out.print("Enter password: ");
		String password = scanner.nextLine();

		controller.createMember(name, email, phoneNumber, id, password);
		System.out.println("Member created successfully.");
	}

	private static void updateMember() {
		System.out.print("Enter ID: ");
		String id = scanner.nextLine();

		System.out.print("Enter password: ");
		String password = scanner.nextLine();

		System.out.print("Enter new name: ");
		String name = scanner.nextLine();

		System.out.print("Enter new email: ");
		String email = scanner.nextLine();

		System.out.print("Enter new phone number: ");
		String phoneNumber = scanner.nextLine();

		controller.updateMember(id, password, name, email, phoneNumber);
		System.out.println("Member updated successfully.");
	}
	
	private static void deleteMember() {
	    System.out.print("Enter ID: ");
	    String id = scanner.nextLine();

	    System.out.print("Enter password: ");
	    String password = scanner.nextLine();

	    controller.deleteMember(id, password);
	    System.out.println("Member deleted successfully.");
	}
	
	private static void printMemberDetails() {
	    System.out.print("Enter ID: ");
	    String id = scanner.nextLine();

	    System.out.print("Enter password: ");
	    String password = scanner.nextLine();

	    controller.printMember(id, password);
	}
	
}