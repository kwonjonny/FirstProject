package Member;

import java.util.ArrayList;

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
public class SoccerPlayerList {

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
	public void setName() {
		this.name = name;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber() {
		this.number = number;
	}
	
	public String getTeam() {
		return team;
	}
	public void setTeam() {
		this.team = team;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge() {
		this.age = age;
	}
	
	// Override 메소드 정의 
	public String toString() {
		return "선수이름"+name + "선수번호"+number + "소속팀"+team + "선수나이"+age;
	}
}	


// 1. 축구선수 인스턴스를 저장할 수 있는 List<E> 컬렉션 인스턴스를 생성해서 인스턴스를 
// 저장하고 출력하는 프로그램을 만들어 봅시다. 
class main8 {
	public static void main(String [] args) {
	
	ArrayList<SoccerPlayerList> soccerPlayer = new ArrayList<>();
	soccerPlayer.add(new SoccerPlayerList("메시",10,"바르셀로나",36));
	soccerPlayer.add(new SoccerPlayerList("호날두",07,"알나사르",38));
	soccerPlayer.add(new SoccerPlayerList("음바페",07,"파리생제르망",23));
	soccerPlayer.add(new SoccerPlayerList("손흥민",07,"레알마드리드",30));
	
	for(SoccerPlayerList player : soccerPlayer) {
		System.out.println(player);
	}
	}
}