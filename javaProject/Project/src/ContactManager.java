
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// ContactManager ArrayList를 활용한 curd시스템
// ShowData와 CurdOperation메소드를 구현 
public class ContactManager implements ShowData, CurdOperation {
    
	// Contact라는 클래스를 참조변수로 List안에 재정의 
	// 후 contacts라는 인스턴스변수 정의 
    private List<Contact> contacts; // List 인터페이스를 구현한 ArrayList 인스턴스
    
    // ContactManager라는 메소드를 pulbic으로 선언 후 
    // contacts의 인스턴스 변수는 new ArrayList 
    public ContactManager() {
        contacts = new ArrayList<>();
    }
    
    // 연락처 추가 메서드
    // CurdOperation의 create 메소드 오버라이딩
    // Contact를 참조변수로 contact라는 매개변수를 정의
    // .add를 통해 매개변수에 새로운 값을 저장 
    @Override
    public void create(Contact contact) {
        contacts.add(contact);
        System.out.println("연락처가 추가되었습니다.");
    }
    
    // 연락처 목록 출력 메서드
    // CurdOperation의 ShowData 메소드 오버라이딩
    // foreach문을 활용해 contacts의 인스턴스 변수를 대조후 
    // True일시 모든 정보 출력 
    @Override
    public void ShowData() {
        System.out.println("=== 연락처 목록 ===");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
        System.out.println("===================");
    }
    
    // 연락처 검색 메서드
    // CurdOperation의 searchcontacts메소드 오버라이딩
    // 사용자의 입력값을 keyword contact안에 있는 객체와 비교하며
    // Ex -> 권성준 01030990648 이 저장 되어있다면
    // 권성준만 입력시 
    // contcat.getName().contains(keyword)안에 있는 contact.getPhoneNumber().contains(keyword) 
    // 를 타며 권성준 01030990648이 출력된다. 
    @Override
    public void searchcontacts(String keyword) {
        System.out.println("=== 검색 결과 ===");
        for (Contact contact : contacts) {
            if (contact.getName().contains(keyword) || contact.getPhoneNumber().contains(keyword)) {
                System.out.println(contact);
            }
        }
        System.out.println("=================");
    }
    
    // CurdOperation의 update메소드 오버라이딩
    // contacts 리스트에서 인덱스에 위치한 Contact객체를 가져와 
    // 매개변수로 전달받은 값으로 해당 객체를 수정 
    // 수정을 해야 하기때문에 contacts객체 안에 있는 매개변수를 set으로 변경함과 동시에 인스턴스 변수도 입력받은 값으로 
    // 변경해준다 
    @Override
    public void update(int index, String name, String phoneNumber, String email, String address, String birthday, String group) {
        Contact contact = contacts.get(index);
        contact.setName(name);
        contact.setPhoneNumber(phoneNumber);
        contact.setEmail(email);
        contact.setAddress(address);
        contact.setBirthday(birthday);
        contact.setGroup(group);
        System.out.println("연락처가 수정되었습니다.");
    } 
    
    // CurdOperation의 delete메소드 오버라이딩 
    // int형의 index값을 입력받으며 
    // contacts 인스턴스 변수안에 index값을 삭제한다
    // index의 값을 String으로 하는 이유는 Contact클래스 내에서 인스턴스 변수를 모두 String으로 선언했기때문 
    @Override
    public void delete(String index) {
    	try {
            int intIndex = Integer.parseInt(index);
            if (intIndex < 0 || intIndex >= contacts.size()) {
                System.out.println("잘못된 입력입니다.");
                return;
            }
            contacts.remove(intIndex);
            System.out.println("연락처가 삭제되었습니다.");
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다.");
            return;
        }
    }
    
    
    // 메인 메소드 
    // Scanner를 이용해 사용자의 값을 입력받는다 contactManager라는 새로운 객체를 생해주고 
    // isRunning이 true일시 while문을 무한반복하며 사용자의 입력을 기다린다 
    // 메뉴의 입력은 1,2,3,4로 출력되며 
    // int 형으로의 입력을 받아야 하기 때문에 nextInt를 쓴다 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();
        boolean isRunning = true;
        while (isRunning) {
        	try {
            System.out.println("===== 연락처 관리 프로그램 =====");
            System.out.println("1. 연락처 추가");
            System.out.println("2. 연락처 목록 출력");
            System.out.println("3. 연락처 검색");
            System.out.println("4. 종료");
            System.out.print("메뉴를 선택하세요: ");
            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    System.out.print("이름을 입력하세요: ");
                    String name = scanner.next();
                    System.out.print("전화번호를 입력하세요: ");
                    String phoneNumber = scanner.next();
                    System.out.println("이메일을 입력하세요.");
                    String email = scanner.next();
                    System.out.println("주소를 입력하세요.");
                    String address = scanner.next();
                    System.out.println("생일을 입력하세요.");
                    String birthday = scanner.next();
                    System.out.println("그룹을 입력하세요.");
                    String group = scanner.next();
                    // contactManager.create안에 new Contact객체에 새로운 정보 매개변수를 입력받는다 
                    contactManager.create(new Contact(name, phoneNumber, email,address,birthday,group));
                    break;
                case 2:
                    contactManager.ShowData();
                    break;
                case 3:
                    System.out.print("검색할 키워드를 입력하세요: ");
                    String keyword = scanner.next();
                    contactManager.searchcontacts(keyword);
                    break;
                case 4:
                	// isRunning의 입력값이 4일시 false를 나타내며 
                	// System.out으로 프로그램을 종료하며 while문의 break; 가 걸린다 
                	// default는 사용자가 1,2,3,4가 아닌 다른 번호나 문자를 입력시 
                	// System.out 잘못된 메뉴입니다 출력 
                    isRunning = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴입니다.");
            }
            // try-catch를  이용해 사용자가 사용중 올바른 값을 입력하지 않았을때 
            // System.out 올바른 값을 입력해주세요 구분이 나온다 
        	} catch (Exception e) {
                System.out.println("올바른 값을 입력해주세요.");
                scanner.nextLine(); // 입력 버퍼 비우기
            }
        }
        scanner.close();
    }
}

