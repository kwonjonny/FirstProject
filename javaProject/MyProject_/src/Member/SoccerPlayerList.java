package Member;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

// 축구선수 클래스를 만들어 봅시다.
//	 class FootballPlayer {
//	 String name;
//	 int number;
//	 String team;
//	 int age
//}

//1. 축구선수 인스턴스를 저장할 수 있는 List<E> 컬렉션 인스턴스를 생성해서 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다. 
//
//2. 축구선수의 인스턴스가 팀과 이름 그리고 나이가 같으면 같은 선수라 판단하고 입력이 되지 않도록 Set<E> 컬렉션을 이용해서 축구선수 인
//스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다. 
// 
//3. TreeSet<E>을 이용해서 팀 이름순으로 정렬하고, 같은 팀의 선수들은 이름 순으로 정렬하고, 같은 이름의 선수는 번호 순으로 저장하는 프로
//그램을 만들어 봅시다. 
// 
//4. 축구선수의 번호를 key로 하고 축구선수 인스턴스를 저장하는 Map<K,V> 인스턴스를 이용해서 프로그램을 만들어봅시다
public class SoccerPlayerList implements Comparable<SoccerPlayerList> {

	// 인스턴스 변수 정의
	private String name;
	private int number;
	private String team;
	private int age;
	
	// 사용자 정의
	public SoccerPlayerList(String name, int number ,String team, int age) {
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}
	
	// Getter Setter정의 정보은닉,캡슐화,보수용이 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	// Override 메소드 정의 
	public String toString() {
		return "선수이름"+name + "선수번호"+number + "소속팀"+team + "선수나이"+age;
	}
	
	 // 3번문제 메소드 
	 // SoccerPlayerList 클래스를 등번호로 정렬
    @Override
    public int compareTo(SoccerPlayerList o) {
        return this.number - o.getNumber();
    }
    
}	


// 1. 축구선수 인스턴스를 저장할 수 있는 List<E> 컬렉션 인스턴스를 생성해서 인스턴스를 
// 저장하고 출력하는 프로그램을 만들어 봅시다. 
class main8 {
	public static void main(String [] args) {
	
	// ArrayList로 배열 출력
	ArrayList<SoccerPlayerList> soccerPlayer = new ArrayList<>();
	
	soccerPlayer.add(new SoccerPlayerList("메시",10,"바르셀로나",35));
	soccerPlayer.add(new SoccerPlayerList("호날두",07,"알나사르",38));
	soccerPlayer.add(new SoccerPlayerList("음바페",07,"파리생제르망",24));
	soccerPlayer.add(new SoccerPlayerList("손흥민",07,"레알마드리드",30));
	
	for(SoccerPlayerList player : soccerPlayer) {
		System.out.println(player);
	}
	
	 // HashSet으로 중복 체크 후 출력! 
	 Set<SoccerPlayerList> playerSet = new HashSet<>();

     playerSet.add(new SoccerPlayerList("메시", 10, "바르셀로나", 35));
     playerSet.add(new SoccerPlayerList("호날두",07,"알나사르",38));
     playerSet.add(new SoccerPlayerList("음바페",07,"파리생제르망",24));
     playerSet.add(new SoccerPlayerList("손흥민",07,"레알마드리드",30));
     playerSet.add(new SoccerPlayerList("메시", 10, "바르셀로나", 35)); // 중복이므로 추가되지않음
     
     // Set에 저장된 축구선수 인스턴스 출력
     for (SoccerPlayerList player : playerSet) {
         System.out.println(player);
     }
     
     // TreeSet으로 중복 체크 후 출력
     TreeSet<SoccerPlayerList> playerTreeSet = new TreeSet<>();

     playerTreeSet.add(new SoccerPlayerList("메시", 10, "바르셀로나", 35));
     playerTreeSet.add(new SoccerPlayerList("호날두", 07, "알나사르", 38));
     playerTreeSet.add(new SoccerPlayerList("음바페", 07, "파리생제르망", 24));
     playerTreeSet.add(new SoccerPlayerList("손흥민", 07, "레알마드리드", 30));
     playerTreeSet.add(new SoccerPlayerList("메시", 10, "바르셀로나", 35)); // 중복이므로 추가되지 않음

     // TreeSet에 저장된 축구선수 인스턴스 출력
     for (SoccerPlayerList player : playerTreeSet) {
         System.out.println(player);
     }
     
	}
}

