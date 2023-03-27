import java.time.LocalDate;

//TripFirst 클래스를 상속받는 TripSecond 클래스를 만들어보세요. 
//TripSecond 클래스는 Trip 클래스와 동일한 인스턴스 변수(destination, startDate, endDate, budget)를 
//가지지만, 추가적으로 hotel 인스턴스 변수를 가지도록 정의합니다.
//
//또한 TripSecond 클래스에서는 toString() 메소드를 오버라이딩하여, Trip 클래스에서 정의한 
//문자열 형식에 hotel 정보도 추가하여 반환하도록 합니다.
//

//"여행 정보: 목적지 - 제주도, 기간 - 2023-04-10 ~ 2023-04-15, 예산 - 500000원"
//"여행 정보: 목적지 - 제주도, 기간 - 2023-04-10 ~ 2023-04-15, 예산 - 500000원, 그랜드하야트호텔"

//TripSecond 클래스를 구현하고, 메인 메소드에서 Trip2 객체를 생성하고 toString() 
//메소드를 호출하여 결과를 출력해보세요.

public class TripFirst {

	// 인스턴스 변수 정의
	private String destination;
	private LocalDate startDate;
	private LocalDate endDate;
	private int budget;
	
	// 생성자 정의
	public TripFirst(String destination, LocalDate startDate, LocalDate endDate, int budget) {
		this.destination = destination;
		this.startDate = startDate;
		this.endDate = endDate;
		this.budget = budget;
	}
	
	// Getter Setter정의 캡슐화,정보은닉,보수용이
	public String getDestination() {
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
		this.budget = budget;
	}
	
	
	//"여행 정보: 목적지 - 제주도, 기간 - 2023-04-10 ~ 2023-04-15, 예산 - 500000원"
	@Override
	public String toString() {
		return "여행 정보:" + destination + "기간 -" + startDate + "~" + endDate + ", 예산" + budget;
	}

}


class TripSecond extends TripFirst {
	
	// 인스턴스 변수 정의 
	private String hotel;
	
	// 생성자 정의
	public TripSecond(String destination, LocalDate startDate, LocalDate endDate, int budget, String city) {
		super(destination, startDate, endDate, budget);
		this.hotel = city;
	}
	
	// 자식클래스 Getter Setter정의 캡슐화,정보은닉,보수용이
	public String getCity() {
		return hotel;
	}
	public void setCit() {
		this.hotel = hotel;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", 호텔 - " + hotel;
	}
	
}


//"여행 정보: 목적지 - 제주도, 기간 - 2023-04-10 ~ 2023-04-15, 예산 - 500000원"
//"여행 정보: 목적지 - 제주도, 기간 - 2023-04-10 ~ 2023-04-15, 예산 - 500000원, 그랜드하야트호텔"

//Trip2 클래스를 구현하고, 메인 메소드에서 Trip2 객체를 생성하고 toString() 
//메소드를 호출하여 결과를 출력해보세요.
class TripFinal{
	public static void main(String [] args) {
		TripFirst trip1 = new TripFirst("제주도", LocalDate.of(2023,04,10),LocalDate.of(2023,04,15),500000);
		TripSecond trip2 = new TripSecond("제주도", LocalDate.of(2023,04,10),LocalDate.of(2023,04,15),500000,"그랜드하야트호텔");
		
		System.out.println(trip1);
		System.out.println(trip2);
	}
}

