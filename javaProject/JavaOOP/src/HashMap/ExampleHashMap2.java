package HashMap;
//당신은 학생들의 성적 정보를 저장하는 시스템을 개발하고 있습니다. 
//다음의 요구사항에 따라서 HashMap을 이용한 성적 저장 시스템을 구현해보세요.
//
//HashMap 생성
//Key-Value 쌍 추가
//Key는 학생의 이름(String), Value는 해당 학생의 성적(Integer)으로 저장합니다.
//예를 들어 "John" 학생의 성적이 85점이면, map.put("John", 85)와 같이 저장합니다.
//특정 key가 존재하는지 확인
//사용자로부터 입력받은 학생 이름이 HashMap에 저장되어 있는지 확인합니다.
//특정 value가 존재하는지 확인
//사용자로부터 입력받은 성적이 HashMap에 저장되어 있는지 확인합니다.
//HashMap 크기 조회
//HashMap에 저장되어 있는 key-value 쌍의 개수를 출력합니다.
//모든 key-value 쌍 출력
//HashMap에 저장되어 있는 모든 key-value 쌍을 출력합니다.
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExampleHashMap2 {
	public static void main(String [] args) {
		
		//HashMap 생성 socoreMap객체
		HashMap<String, Integer> scoreMap = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		//Key-Value 쌍 추가
		//예를 들어 "John" 학생의 성적이 85점이면, map.put("John", 85)와 같이 저장합니다.
		scoreMap.put("히틀러", 50);
		scoreMap.put("스탈린", 55);
		scoreMap.put("처칠", 60);
		scoreMap.put("롬멜", 70);
		
		//특정 key가 존재하는지 확인
		//사용자로부터 입력받은 학생 이름이 HashMap에 저장되어 있는지 확인합니다.
		System.out.println("이름을 입력:");
		String name = scanner.nextLine();
		if(scoreMap.containsKey(name)) {
			System.out.println(name+"의 성적은"+scoreMap.get(name)+"입니다");
		} else {
			System.out.println(name+"은(는) 시스템에 없습니다.");
		}
		
		 // 특정 value가 존재하는지 확인
        System.out.println("점수를 입력:");
        int score = scanner.nextInt();
        if(scoreMap.containsValue(score)) {
            for(Map.Entry<String, Integer> entry : scoreMap.entrySet()) {
                 if (entry.getValue() == score) {
                     System.out.println(entry.getKey() + "의 성적은 " + entry.getValue() + "점 입니다.");
                 }
            }
         } else {
             System.out.println(score + "점을 받은 학생은 시스템에 등록되어 있지 않습니다.");
         }
    

        // HashMap크기 조회
        System.out.println("시스템에 등록되어 있는 학생의 수는"+ scoreMap.size()+"임다.");
        
		// 모든 key-value쌍 출력
        System.out.println("시스템에 등록되 있는 모든 학생의 성적은 다음과 같다:");
        for(Map.Entry<String, Integer> entry : scoreMap.entrySet()) {
        	System.out.println(entry.getKey()+":" + entry.getValue()+"점");
        }
        scanner.close();
    }
}

