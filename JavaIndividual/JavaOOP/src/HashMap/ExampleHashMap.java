package HashMap;

import java.util.HashMap;

//문제: HashMap을 이용하여 다음의 요구사항을 구현해보세요.
//
//1 HashMap 생성
//2 key-value 쌍 추가
//map.put("apple", "사과");
//map.put("banana", "바나나");
//map.put("cherry", "체리");

//3 특정 key가 존재하는지 확인
//4 특정 value가 존재하는지 확인
//5 특정 key-value 쌍 삭제
//6 삭제된 key-value 쌍 조회

public class ExampleHashMap {
	public static void main(String [] args) {
		
		// 1 HashMap 생성
		HashMap<String, Integer> map = new HashMap<>();
		
		
		// 2 Key-Value 쌍추가
		map.put("apple", 1000);
		map.put("banana", 2000);
		map.put("durian", 3000);
		
		
		//3 특정 key가 존재하는지 확인
		if(map.containsKey("apple")) {
			System.out.println("apple이라는 key가 존재합니다.");
		} else {
			System.out.println("apple이라는 key가 존재하지않습니다.");
		}
		
		//3 특정 key가 존재하는지 확인
		if(map.containsKey("banana")) {
			System.out.println("banana라는 key가 존재합니다.");
		} else {
			System.out.println("banana라는 key가 존재하지않습니다.");
		}
		
		//3 특정 key가 존재하는지 확인
		if(map.containsKey("durian")) {
			System.out.println("durain이라는 key가 존재합니다.");
		} else {
			System.out.println("durian이라는 key가 존재하지않습니다.");
		}
		
		//4 특정 value가 존재하는지 확인
		if(map.containsValue(1000)) {
			System.out.println(1000+"이라는 value가 존재합니다.");
		} else {
			System.out.println(1000+"이라는 value가 존재하지않습니다.");
		}
		
		//4 특정 value가 존재하는지 확인
		if(map.containsValue(2000)) {
			System.out.println(2000+"이라는 value가 존재합니다.");
		} else {
			System.out.println(2000+"이라는 value가 존재하지않습니다.");
		}
		
		//4 특정 value가 존재하는지 확인
		if(map.containsValue(3000)) {
			System.out.println(3000+"이라는 value가 존재합니다.");
		} else {
			System.out.println(3000+"이라는 value가 존재하지않습니다.");
		}
		
		
		//5 특정 key-value 쌍 삭제
		Integer removeValue = map.remove("apple");
		System.out.println("삭제된 key-value쌍"+ "apple" + removeValue);
		
		//6 삭제된 key-value 쌍 조회
		if(!map.containsKey("apple") && !map.containsValue(1000)) {
			System.out.println("삭제된 key-Value쌍은 존재하지 않습니다.");
			
			
			
		//5 특정 key-value 쌍 삭제
		Integer removeValue2 = map.remove("banana");
		System.out.println("삭제된 key-value쌍" + "banana" + removeValue2);
		}
		
		// 6삭제된 key-value쌍 조회
		if(!map.containsKey("banana") && !map.containsValue(2000));
		System.out.println("삭제된 key-value쌍은 존재하지 않습니다.");
		
		
		
		// 5 특정 key-value 쌍 삭제
		Integer removeValue3 = map.remove("durian");
		System.out.println("삭제된 key-value쌍"+"durian"+removeValue3);
		
		//6 삭제된 key-value 쌍 조회
		if(!map.containsKey("durian") && !map.containsValue(3000));
		System.out.println("삭제된 key-value쌍은 존재하지 않습니다.");
	}
}
