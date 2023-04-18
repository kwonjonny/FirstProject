package Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SingleTon {
	private String name;
	private String email;
	private String id;
	private String password;
	private String phoneNumber;

	public SingleTon(String name, String email, String id, String password, String phoneNumber) {
		this.name = name;
		this.email = email;
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

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

}


interface MemberCrud {
	void createMember(SingleTon member);

	void deleteMember(String id);

	void updateMember(String id, String name, String email, String phoneNumber);

	SingleTon findMemberById(String id);

	List<SingleTon> getAllMembers();
}


class MemberRepository2 implements MemberCrud {
	private static MemberRepository2 instance = null;
	private List<SingleTon> memberList;

	private MemberRepository2() {
		memberList = new ArrayList<>();
	}

	public static synchronized MemberRepository2 getInstance() {
		if (instance == null) {
			instance = new MemberRepository2();
		}
		return instance;
	}

	@Override
	public void createMember(SingleTon member) {
		memberList.add(member);
	}

	@Override
	public void deleteMember(String id) {
		SingleTon member = findMemberById(id);
		if (member != null) {
			memberList.remove(member);
		}
	}

	@Override
	public void updateMember(String id, String name, String email, String phoneNumber) {
		SingleTon member = findMemberById(id);
		if (member != null) {
			member.setName(name);
			member.setEmail(email);
			member.setPhoneNumber(phoneNumber);
		}
	}

	@Override
	public SingleTon findMemberById(String id) {
		for (SingleTon member : memberList) {
			if (member.getId().equals(id)) {
				return member;
			}
		}
		return null;
	}

	@Override
	public List<SingleTon> getAllMembers() {
		return memberList;
	}
}

class Main2 {
	private static final Scanner scanner = new Scanner(System.in);
	private static final MemberRepository2 repository = MemberRepository2.getInstance();

	public static void main(String[] args) {
		while (true) {
			System.out.println("==== Member Management System ====");
			System.out.println("1. Create member");
			System.out.println("2. Delete member");
			System.out.println("3. Update member");
			System.out.println("4. Print member");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			switch (choice) {
			case 1:
				createMember();
				break;
			case 2:
				deleteMember();
				break;
			case 3:
				updateMember();
				break;
			case 4:
				printMember();
				break;
			case 5:
				System.out.println("Goodbye!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
				break;
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

		SingleTon member = new SingleTon(name, email, phoneNumber, id, password);
		repository.createMember(member);
		System.out.println("Member created successfully.");
	}

	private static void deleteMember() {
		System.out.print("Enter ID: ");
		String id = scanner.nextLine();

		repository.deleteMember(id);
		System.out.println("Member deleted successfully.");
	}

	private static void updateMember() {
		System.out.print("Enter ID: ");
		String id = scanner.nextLine();

		System.out.print("Enter new name: ");
		String name = scanner.nextLine();

		System.out.print("Enter new email: ");
		String email = scanner.nextLine();

		System.out.print("Enter new phone number: ");
		String phoneNumber = scanner.nextLine();

		repository.updateMember(id, name, email, phoneNumber);
		System.out.println("Member updated successfully.");
	}

	private static void printMember() {
		System.out.print("Enter ID: ");
		String id = scanner.nextLine();

		SingleTon member = repository.findMemberById(id);

		if (member != null) {
			System.out.println("Name: " + member.getName());
			System.out.println("Email: " + member.getEmail());
			System.out.println("Phone number: " + member.getPhoneNumber());
			System.out.println("ID: " + member.getId());
			System.out.println("Password: " + member.getPassword());
		} else {
			System.out.println("Member not found.");
		}
	}
}