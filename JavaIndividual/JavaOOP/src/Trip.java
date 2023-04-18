import java.time.LocalDate;

//여행을 계획하는 Trip 클래스를 만들어보고, toString() 메소드를 오버라이딩하여 객체 정보를 문자열로 반환해보세요.
//
//Trip 클래스는 다음과 같은 인스턴스 변수를 갖습니다.
//
//destination : 여행 목적지
//startDate : 여행 시작일
//endDate : 여행 종료일
//budget : 예산
//Trip 클래스는 다음과 같은 메소드를 갖습니다.
//
//생성자: Trip(String destination, LocalDate startDate, LocalDate endDate, int budget)
//toString(): 객체 정보를 문자열로 반환
//toString() 메소드에서 반환하는 문자열은 다음과 같은 형식을 갖습니다.
//"여행 정보: 목적지 - {destination}, 기간 - {startDate} ~ {endDate}, 예산 - {budget}원"
//예를 들어, Trip 객체의 destination이 "제주도", startDate가 2023년 4월 10일, 
//endDate가 2023년 4월 15일, budget이 500000원이라면, 
//toString() 메소드는 다음과 같은 문자열을 반환해야 합니다.
//"여행 정보: 목적지 - 제주도, 기간 - 2023-04-10 ~ 2023-04-15, 예산 - 500000원"
//위의 요구사항을 충족하는 Trip 클래스를 구현하고, toString() 메소드를 오버라이딩해보세요

public class Trip {
	
	// 인스턴스 변수 정의
	private String destination;
	private LocalDate startDate;
	private LocalDate endDate;
	private int budget;
	
	// 생성자 정의
	public Trip(String destination, LocalDate startDate, LocalDate endDate, int budget) {
		this.destination = destination;
		this.startDate = startDate;
		this.endDate = endDate;
		this.budget = budget;
	}
	
	// Getter Setter정의 캡슐화,정보은닉,보수용이
	public String getDestinaiton() {
		return destination;
	}
	public void setDestination() {
		this.destination = destination;
	}
	
	
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate() {
		this.startDate = startDate;
	}
	
	
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate() {
		this.endDate = endDate;
	}
	
	
	public int getBudget() {
		return budget;
	}
	public void setBudget() {
		this.budget =budget;
	}
	
	
	//toString() 메소드에서 반환하는 문자열은 다음과 같은 형식을 갖습니다.
	//"여행 정보: 목적지 - {destination}, 기간 - {startDate} ~ {endDate}, 예산 - {budget}원"
	public String toString() {
		return "여행 정보: 목적지 -" + destination +", 기간 -" + startDate + " ~ " + endDate + ", 예산 -" + budget + "원";
	}
	
}


//예를 들어, Trip 객체의 destination이 "제주도", startDate가 2023년 4월 10일, 
//endDate가 2023년 4월 15일, budget이 500000원이라면, 
//toString() 메소드는 다음과 같은 문자열을 반환해야 합니다.
//"여행 정보: 목적지 - 제주도, 기간 - 2023-04-10 ~ 2023-04-15, 예산 - 500000원"
//위의 요구사항을 충족하는 Trip 클래스를 구현하고, toString() 메소드를 오버라이딩해보세요.
class Oain {
	public static void main(String [] args) {
		
		// 객체 생성
		Trip trip = new Trip("제주도", LocalDate.of(2023,04,10),LocalDate.of(2023,04,15),500000);
		// toString출력 
		System.out.println(trip.toString());
	
	}
}
