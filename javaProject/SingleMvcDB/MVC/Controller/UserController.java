package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import DAO.UserDao;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;
import java.sql.Date;

import DAO.UserDao;
import Model.User;

public class UserController {

	private UserDao userDao;

	public UserController() {
		// 콘솔로 입력받고 -> DAO 클래스로 값을 전달 하기 때문에
		// Database 연결 정보 설정 해야한다.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "C##KwonDB1";
		String pw = "tiger";

		// UserDao 객체를 생성
		try {
			Connection conn = DriverManager.getConnection(url, id, pw);
			UserDao userDao = UserDao.getInstance(conn); // UserDao 객체 생성
			this.userDao = userDao;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// create console
	public void createUserConsole() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 회원 가입===");
		System.out.println("id 입력: ");
		String id = scan.nextLine();
		System.out.println("user name 입력: ");
		String username = scan.nextLine();
		System.out.println("password 입력: ");
		String password = scan.nextLine();
		System.out.println("name 입력: ");
		String name = scan.nextLine();
		System.out.println("email 입력: ");
		String email = scan.nextLine();
		System.out.println("address 입력: ");
		String address = scan.nextLine();
		System.out.println("phone 입력: ");
		String phone = scan.nextLine();
		System.out.println("grade 입력: ");
		int grade = scan.nextInt();
		scan.nextLine();
		System.out.println("생성 날짜 입력 EX:1998-YY-MM : ");
		String createDateStr = scan.nextLine();
		Date createDate = Date.valueOf(createDateStr);
		System.out.println("권한 입력 user? admin? : ");
		String role = scan.nextLine();

		User user = new User(id, username, password, name, email, address, phone, grade, createDate, role);
		try {
			userDao.create(user);
			System.out.println("회원가입 성공!");
		} catch (SQLException e) {
			System.out.println("회원가입 실패!");
		}
	}

	// read console
	public void readUserConsole() {
		Scanner scan = new Scanner(System.in);
		System.out.println("===유저 정보 출력===");
		System.out.println("id 입력: ");
		String id = scan.nextLine();
		System.out.println("password 입력: ");
		String password = scan.nextLine();
		try {
			User user = userDao.read(id, password);
			if (user == null) {
				System.out.println("id,password 확인해주세요 로그인 실패");
			} else {
				System.out.println(user.getName() + "님 환영합니다.");
				System.out.println("이름: " + user.getName());
				System.out.println("id: " + user.getId());
				System.out.println("password: " + user.getPassword());
				System.out.println("email: " + user.getEmail());
				System.out.println("address: " + user.getAddress());
				System.out.println("phone: " + user.getPhone());
				System.out.println("grade: " + user.getGrade());
				System.out.println("createDate: " + user.getCreatDate());
				System.out.println("role: " + user.getRole());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// delete console
	public void deleteUserConsole() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 유저 정보 삭제===");
		System.out.println("id 입력: ");
		String id = scan.nextLine();
		System.out.println("password 입력: ");
		String password = scan.nextLine();
		try {
			User user = userDao.read(id, password);
			if (user == null) {
				System.out.println("id,password 확인해주세요 회원 정보 삭제 실패");
			} else {
				System.out.println(user.getName() + "님 의 회원정보 삭제");
				userDao.delete(id, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// update console
	public void updateUserConsole() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 유저 정보 수정===");
		System.out.println("id 입력: ");
		String id = scan.nextLine();
		System.out.println("password 입력: ");
		String password = scan.nextLine();
		try {
			User user = userDao.read(id, password);
			if (user == null) {
				System.out.println("id,password 확인해주세요 회원 정보 수정 실패");
			} else {
				System.out.println(user.getName() + "님 의 회원정보 수정");
				System.out.println("새로운 회원 정보를 입력하세요");
				System.out.println("id입력: ");
				String newId = scan.nextLine();
				System.out.println("username입력: ");
				String newUserName = scan.nextLine();
				System.out.println("password입력: ");
				String newPassword = scan.nextLine();
				System.out.println("name입력: ");
				String newName = scan.nextLine();
				System.out.println("email입력: ");
				String newEmail = scan.nextLine();
				System.out.println("address입력: ");
				String newAddress = scan.nextLine();
				System.out.println("phone입력: ");
				String newPhone = scan.nextLine();
				System.out.println("grade입력 (숫자): ");
				int newGrade = scan.nextInt();
				System.out.println("createDate입력 EX:1998-01-01): ");
				String newCreateDateStr = scan.next();
				LocalDate newCreateDate = LocalDate.parse(newCreateDateStr);
				System.out.println("권한 입력 user? admin? : ");
				String newRole = scan.next();
				User newUser = new User(newId, newUserName, newPassword, newName, newEmail, newAddress, newPhone,
						newGrade, Date.valueOf(newCreateDate), newRole);
				newUser.setId(newId);
				newUser.setUsername(newUserName);
				newUser.setPassword(newPassword);
				newUser.setName(newName);
				newUser.setEmail(newEmail);
				newUser.setAddress(newAddress);
				newUser.setPhone(newPhone);
				newUser.setGrade(newGrade);
				newUser.setCreatDate(Date.valueOf(newCreateDate));
				newUser.setRole(newRole);
				userDao.update(id, password, newUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
