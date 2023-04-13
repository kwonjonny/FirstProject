package HashMap;




import java.util.HashMap;
import java.util.Scanner;

//문제: HashMap을 이용하여 사전(Dictionary)을 구현하는 프로그램을 작성하세요.
//
//HashMap을 이용하여 단어(String)와 뜻(String)을 저장합니다.
public class ExampleHashMap3 {
	
	// 1. HashMap을 사용하기 위한 메인 메소드 정의
	public static void main(String [] args) {
	
	// 2. HashMap <String, String> Dictionary = new HashMap<>(); 정의
	HashMap <String, String> Dictionary = new HashMap<>();
	
	// 3. 입력받기 위한 스캐너 정의 Scanner scan = new Scanner(System.in);
	Scanner scan = new Scanner(System.in);
	
	// 4. HashMap을 정의한 String String 을 Key-value에 정보 입력 객체 Dictionary를 이용
	Dictionary.put("이순신사전", "권율책");
	Dictionary.put("나폴레옹사전","히틀러책");
	Dictionary.put("트럼프사전", "레옹책");
	
	// 5. 정보 확인을 위한System.out.println("Dictionary정보를 출력해주는 메소드 입력)
	System.out.println("현재 저장된 사전 정보" + Dictionary);
	
	// 6. Dictionary중 하나의 삭제할 사전을 선택
	System.out.println("삭제할 사전을 입력하세요 Ex:이순신사전");
	String name = scan.nextLine();
	if(Dictionary.containsKey(name)) {
		Dictionary.remove(name);
		System.out.println(name+"사전이 삭제되었습니다.");
	} else {
		System.out.println(name+"사전이 삭제되지않았습니다.");
	}
	
	// 7. 사전이 삭제 되었는지 key-value를 확인 
	System.out.println("확인할 사전을 입력하세요.");
	String name2 = scan.nextLine();
	if(Dictionary.containsKey(name2)) {
		System.out.println("사전의 이름은" + name2 + "입니다.");
	} else {
		System.out.println(name2 + "사전은 존재하지 않습니다.");
	}
	
	// 8. 현재 사전이 몇개 있는지 확인하는작업 size를 입력하면 확인 가능
	System.out.println("현재 존재하는 사전의 개수" +Dictionary.size());
	
	// 9. 현재 사전의 정보를 확인하는 작업 
	System.out.println("현재 존재하는 사전" +Dictionary);
	
	scan.close();
	}
}

