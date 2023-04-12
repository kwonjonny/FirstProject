//import java.util.Scanner;
//public class SmartPhone implements CurdOperation,ShowData {
//	// 인스턴스 변수 선언 [] 배열을이용 	
//	private Contact[] contacts;
//	// 인스턴스 변수 선언 int형으로 정의 
//    private int numOfContacts;
//    
//    // smartPhone contacts는 배열로 10개를 담을수 있게 정의
//    // numOfContacts = 0; 으로 초기화 
//    public SmartPhone() {
//        this.contacts = new Contact[10];
//        this.numOfContacts = 0;
//    }
//    // CurdOperation에 있는 create 메소드 오버라이딩
//    // if numOfContacts < 배열 10개보다 작을시 if 문을 타게 구현 Contact를 매개변수로 newContact 객체 정의 
//    // 만약 newContact.getName.isEmpty newContact.getPhoneNumber.isEmpty newContact.getEmail.isEmpty
//    // 입력이 안되면 이름 전화번호 이메일은 입력 필수사항이에요 메소드를 타며 처음으로 return
//    // if 0부터9까지의 숫자가 매치가 안될시 전화번호는 숫자만 입력 가능하세요 메소드를 타며 처음으로 return
//    // 연락처가 추가될시 numOfContacts++ 1씩 추가가되며 
//    // 만약 10개가 넘을시 더 이상 추가할수 없게 구현 
//    @Override
//    public void create(Contact newContact) {
//        if (numOfContacts < 10) {
//        	if(newContact.getName().isEmpty() || newContact.getPhoneNumber().isEmpty()|| newContact.getEmail().isEmpty()) {
//        		System.out.println("이름, 전화번호, 이메일은 필수 입력사항이에요!.");
//        		return;
//        	} 
//        	if(!newContact.getPhoneNumber().matches("[0-9]+")) {
//        		System.out.println("전화번호는 숫자만 입력 가능하세요...");
//        		return;
//        	}
//        	contacts[numOfContacts] = newContact;
//        	numOfContacts++;
//        	System.out.println("연락처가 추가되었사와요.");
//        } else {
//        	System.out.println("연락처를 더 이상 추가할 수 없습니다 배열이 그래요...");
//        }
//        }
//    
//    // CurdOperation 에 있는 update 메소드 오버라이딩
//    // 연락처를 업데이트 하는 메소드며 매개변수로 index와 다른 추가 사항들을 받아준다
//    // 만약 index의 값이 0과 같거나 작고 and index의 값이 numOfContacts보다 작으면
//    // 수정 메소드를 탄다 Contacts[index] 배열로 setName(name)을 불러주며 설정의 변경이 가능 
//    // name,phoneNumber등의 매개변수를  입력받은 정보로 변경해준다
//    @Override
//	public void update(int index, String name, String phoneNumber, String email, String address, String birthday, String group) {
//		if(index >= 0 && index < numOfContacts) {
//			contacts[index].setName(name);
//			contacts[index].setPhoneNumber(phoneNumber);
//			contacts[index].setEmail(email);
//			contacts[index].setAddress(address);
//			contacts[index].setBirthday(birthday);
//			contacts[index].setGroup(group);
//			System.out.println("연락처가 수정되었습니다.");
//		} else {
//			System.out.println("유효하지 않은 접근입니다."); 
//		}
//	}
//	
//    // CurdOperation에 있는 delete메소드 오버라이딩
//    // if(index >= 0 && index < numOfContacts) 는 삭제하려는 연락처의 인덱스 값이 맞는지 확인하는 조건문
//    // 맞다면 for을 타며 맞지않을시 else를 탄다 
//    // for문은 numOfContacts 보다 작은 index 값으로 받은 인덱스부터 numOfContacts - 1 까지 반복하면서 
//    // contacts 배열에서 삭제하려는 연락처의 인덱스를 비워주기 위해 해당 인덱스 이후의 연락처들을 앞으로 한 칸씩 이동 
//    // numOfContacts 값을 감소시켜서 현재 연락처의 개수를 업데이트 
//    @Override
//	public void delete(int index) {
//		if(index >= 0 && index < numOfContacts) {
//			for(int i=index; i<numOfContacts -1; i++) {
//				contacts[i] = contacts[i + 1];
//			}
//			numOfContacts--;
//			System.out.println("연락처가 삭제되었습니다.");
//		} else {
//			System.out.println("유효하지 않은 접근입니다.");
//		}
//	}
//	
//    // CurdOperation 에 있는 ShowData메소드 오버라이딩 
//    // foreach문을 활용해 contact = null이 아닐시 모든 정보 출력 
//    @Override
//    public void ShowData() {
//        for (Contact contact : contacts) {
//            if (contact != null) {
//                System.out.println(contact.toString());
//            }
//        }
//    }
//    
//    // curdOperation 에 있는 searchcontacts 메소드 
//    // 매개변수 String 으로의 매개변수 keyword 정의
//    // for문에서는 numOfContacts 만큼 반복하며 입력받은 keyword와 같은지 대조한다
//    // boolean을 통해 실패 결과를 찾으며 만약 입력값이 매개변수 와 같다면 
//    // true문을 타며 이름,전화번호,이메일,주소,생일,그룹 을 보여준다 
//    // 만약 찾지 못했다면 in(!found) 문을 탄다 
//	@Override
//	public void searchcontacts(String keyword) {
//		boolean found = false;
//		for(int i=0; i<numOfContacts; i++) {
//			if(contacts[i].getName().contains(keyword)) {
//	            System.out.println("이름: " + contacts[i].getName());
//	            System.out.println("전화번호: " + contacts[i].getPhoneNumber());
//	            System.out.println("이메일: " + contacts[i].getEmail());
//	            System.out.println("주소: " + contacts[i].getAddress());
//	            System.out.println("생일: " + contacts[i].getBirthday());
//	            System.out.println("그룹: " + contacts[i].getGroup());
//	            System.out.println();
//	            found = true;
//	        }
//		}
//		if(!found) {
//			System.out.println("검색 결과가 없는데요?..."); 
//		}
//	}
//}
//class Main3 {
//    public static void main(String[] args) {
//    	// Scanner를 입력하며 사용자의 입력값을 받을 준비를한다 
//        Scanner scanner = new Scanner(System.in);
//        // SmartPhone을 참조변수로 하며 smartphone객체의 생성 
//        SmartPhone smartPhone = new SmartPhone();
//        // while(true) 사용자가 종료를 선택하기 까지 무한반복 
//        while (true) {
//            System.out.println("===== 연락처 관리 프로그램 =====");
//            System.out.println("1. 연락처 추가");
//            System.out.println("2. 연락처 수정");
//            System.out.println("3. 연락처 삭제");
//            System.out.println("4. 연락처 검색");
//            System.out.println("5. 연락처 전체보기");
//            System.out.println("6. 프로그램 종료");
//            System.out.print("메뉴를 선택하세요: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // 입력 버퍼 비우기
//            
//            		// 1번을 탔다면 연락처와 그룹까지 정보를 입력후 newContcat로 매개변수를 저장한다 
//            		// -> create 메소드 설명을 참고 
//            		// -> Contact객체 생성후 저장 
//            switch (choice) {
//                case 1:
//                    System.out.println("새로운 연락처 정보를 입력하세요.");
//                    System.out.print("이름: ");
//                    String name = scanner.nextLine();
//                    System.out.print("전화번호: ");
//                    String phoneNumber = scanner.nextLine();
//                    System.out.print("이메일: ");
//                    String email = scanner.nextLine();
//                    System.out.print("주소: ");
//                    String address = scanner.nextLine();
//                    System.out.print("생일: ");
//                    String birthday = scanner.nextLine();
//                    System.out.print("그룹: ");
//                    String group = scanner.nextLine();
//                    Contact newContact = new Contact(name, phoneNumber, email, address, birthday, group);
//                    smartPhone.create(newContact);
//                    break;
//                    
//                    // 2번 케이스를 탓다면 
//                    // 인덱스를 입력받아 -> 수정할 연락처의 정보를 입력 받아 매개변수로 전달
//                    // -> update메소드 호출 
//                case 2:
//                    System.out.print("수정할 연락처 번호를 입력하세요: ");
//                    int updateIndex = scanner.nextInt();
//                    scanner.nextLine(); // 입력 버퍼 비우기
//                    System.out.println("수정할 연락처 정보를 입력하세요.");
//                    System.out.print("이름: ");
//                    name = scanner.nextLine();
//                    System.out.print("전화번호: ");
//                    phoneNumber = scanner.nextLine();
//                    System.out.print("이메일: ");
//                    email = scanner.nextLine();
//                    System.out.print("주소: ");
//                    address = scanner.nextLine();
//                    System.out.print("생일: ");
//                    birthday = scanner.nextLine();
//                    System.out.print("그룹: ");
//                    group = scanner.nextLine();
//                    smartPhone.update(updateIndex, name, phoneNumber, email, address, birthday, group);
//                    break;
//                    
//                    // case3번을 탈 시 
//                    // 삭제할 연락처의 인덱스를 입력받고 
//                    // delete -> 메소드를 타며 delete메소드 참고 삭제 지시 
//                case 3:
//                    System.out.print("삭제할 연락처 번호를 입력하세요: ");
//                    int deleteIndex = scanner.nextInt();
//                    scanner.nextLine(); // 입력 버퍼 비우기
//                    smartPhone.delete(deleteIndex);
//                    break;
//                    
//                    // case4번을 탈 시 
//                    // 검색할 이름을 물어보며
//                    // keyword와 대조함 -> searchcontacts 참고
//                case 4:
//                    System.out.print("검색할 이름을 입력하세요: ");
//                    String keyword = scanner.nextLine();
//                    smartPhone.searchcontacts(keyword);
//                    break;
//                    
//                    // case5번을 탈 시 
//                    // ShowData -> 메소드를 타며 showData메소드 참고 
//                case 5:
//                    smartPhone.ShowData();
//                    break;
//                    
//                    // case6번을 탈 시 
//                    // 프로그램 종료 후 scanner.close로 메모리 낭비를 방지               
//                case 6:
//                    System.out.println("프로그램을 종료합니다.");
//                    scanner.close();
//                    System.exit(0);
//                    
//                    // default 값은 잘못된 입력 
//                default:
//                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
//            }
//        }
//    }
//}
