package Java;

import java.util.ArrayList;
import java.util.Scanner;

//문제:
//
//다양한 차량 종류를 나타내는 클래스들을 구현해보세요.
//
//차량(Vehicle) 클래스: 모든 차량의 공통 속성을 나타내는 추상 클래스입니다. 
//차량의 이름, 브랜드, 가격 등의 속성을 가지고 있어야 합니다. 또한, 차량의 기본 정보를 
//출력하는 메서드를 가지고 있어야 합니다.
//
//자동차(Car) 클래스: 차량 클래스를 상속받는 자동차 클래스입니다. 
//자동차에는 차량의 종류에 대한 추가적인 속성(예: 차종, 연료 종류, 최고 속도 등)이 
//있어야 합니다. 또한, 자동차의 정보를 출력하는 메서드를 추가적으로 가지고 있어야 합니다.
//
//오토바이(Motorcycle) 클래스: 차량 클래스를 상속받는 오토바이 클래스입니다.
//오토바이에는 차량의 종류에 대한 추가적인 속성(예: 배기량, 착용인원 등)이 있어야 합니다.
//또한, 오토바이의 정보를 출력하는 메서드를 추가적으로 가지고 있어야 합니다.
//
//배(Watercraft) 클래스: 차량 클래스를 상속받는 배 클래스입니다.
//배에는 차량의 종류에 대한 추가적인 속성(예: 탑승인원, 사용 용도 등)이 있어야 합니다. 
//또한, 배의 정보를 출력하는 메서드를 추가적으로 가지고 있어야 합니다.
//
//컬렉션 프레임워크 활용: 자동차, 오토바이, 배 객체들을 ArrayList를 활용하여 저장하고,
//검색, 추가, 삭제 등의 다양한 컬렉션 메서드를 활용하여 객체들을 관리해보세요.
//
//다형성 활용: 차량 클래스들을 이용하여 다양한 차량 객체를 생성하고,
//이들을 차량 배열에 저장하고 관리해보세요. 차량 배열에 저장된 차량 객체들의 정보를 
//출력하는 메서드를 구현하여 출력해보세요.
//
//주석과 문서화: 클래스, 메서드, 필드 등에 주석을 추가하여 코드를 문서화해보세요. 
//JavaDoc과 같은 문서화 도구를 활용하여 차량 클래스와 관련된 API 문서를 자동으로 생성해보세요. 풀어보세요!

public abstract class Vehicle {
	
	// 인스턴스 변수 정의
	private String name;	// 이름
	private String brand;	// 브랜드
	private String price;	// 가격
	
	// 사용자 정의 매개변수 초기화 -> 인스턴스변수 전달 
	public Vehicle(String name, String brand , String price) {
		this.name = name;
		this.brand = brand;
		this.price = price;
	}
	
	// Getter Setter 정의 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	// toString메소드 자식 클래스에서 상속
	public void printVehicleinfo() {
		System.out.println("이름: " + name);
	    System.out.println("브랜드: " + brand);
	    System.out.println("가격: " + price);
	    }
	
	// 추상 메소드 
	public abstract void printAddtionallinf();
	
}


class Car extends Vehicle{
	
	// 인스턴스 변수 정의
	private String kind;	// 차종
	private String fuel;	// 연료 종류
	private String speed;	// 최고 속력
	
	// 생성자 정의 매개변수 초기화 -> 인스턴스 변수 전달 
	// 부모클래스 인스턴스변수 super
	public Car(String name, String brand, String price, String kind , String fuel, String speed) {
		super(name, brand, price);
		this.kind = kind;
		this.fuel = fuel;
		this.speed = speed;
	}
	
	// Getter Setter 정의
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}

	@Override
	public void printAddtionallinf() {
		super.printVehicleinfo();
		System.out.println("차종: " +kind);
		System.out.println("연료 종류: " +fuel);
		System.out.println("최고 속력: " +speed);
	}
	
	
}

class Motorcycle extends Vehicle{
	
	// 인스턴스 변수 정의
	private String NumberUsers;	// 탑승 인원
	private String usage; 		// 사용 용도
	
	// 생성자 정의 매개변수 초기화 -> 인스턴스 변수 전달
	// 부모클래스 인스턴스 변수 super
	public Motorcycle(String name, String brand, String price, String NumberUsers, String usage) {
		super(name, brand, price);
		this.NumberUsers = NumberUsers;
		this.usage = usage;
	}
	
	// Getter Setter 정의
	public String getNumberUsers() {
		return NumberUsers;
	}
	public void setNumberUsers(String NumberUsers) {
		this.NumberUsers = NumberUsers;
	}
	
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}

	@Override
	public void printAddtionallinf() {
		super.printVehicleinfo();
		System.out.println("탑승 인원: " +NumberUsers);
		System.out.println("사용 용도: " +usage);
	}
	
	  
}

class WaterCraft extends Vehicle{
	
	//  인스턴스 변수 정의
	private String NumberUsers;  // 탑승 인원
	private String displacement; // 배기량
	
	// 생성자 정의 매개변수 초기화 -> 인스턴스 변수 전달
	// 부모클래스 인스턴스 변수 super
	public WaterCraft(String name, String brand, String price, String NumberUsers, String displacement) {
		super(name, brand, price);
		this.NumberUsers = NumberUsers;
		this.displacement = displacement;
	}
	
	// Getter Setter 정의
	public String getNumberUsers() {
		return NumberUsers;
	}
	public void setNumberUsers(String NumberUsers) {
		this.NumberUsers = NumberUsers;
	}
	
	public String getDisplacement() {
		return displacement;
	}
	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}

	@Override
	public void printAddtionallinf() {
		super.printVehicleinfo();
		System.out.println("탑승 인원: " +NumberUsers);
		System.out.println("배기량: " +displacement);
	}
	
}

//컬렉션 프레임워크 활용: 자동차, 오토바이, 배 객체들을 ArrayList를 활용하여 저장하고
//검색, 추가, 삭제 등의 다양한 컬렉션 메서드를 활용하여 객체들을 관리해보세요.
class Main {
	public static void main(String [] args) {
		
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		
		while(choice != 4) {
			System.out.println("1. 자동차 생성");
	        System.out.println("2. 오토바이 생성");
	        System.out.println("3. 배 생성");
	        System.out.println("4. 종료");
	        System.out.print("선택: ");
	        choice = scan.nextInt();
	        

	        switch (choice) {
            case 1:
                // 자동차 객체 생성
            	System.out.println("=============================");
                Car car = createCar();
                vehicles.add(car); // 생성된 자동차 객체를 ArrayList에 추가
                System.out.println("자동차가 생성되었습니다.");
                System.out.println("=============================");
                break;
            case 2:
                // 오토바이 객체 생성
                Motorcycle motorcycle = createMotorcycle();
                vehicles.add(motorcycle); // 생성된 오토바이 객체를 ArrayList에 추가
                System.out.println("오토바이가 생성되었습니다.");
                System.out.println("=============================");
                break;
            case 3:
                // 배 객체 생성
            	WaterCraft watercraft = createWaterCraft();
                vehicles.add(watercraft); // 생성된 배 객체를 ArrayList에 추가
                System.out.println("배가 생성되었습니다.");
                System.out.println("=============================");
                break;
            case 4:
                System.out.println("프로그램을 종료합니다.");
                System.out.println("=============================");
                break;
            default:
                System.out.println("잘못된 입력입니다. 다시 선택하세요.");
                System.out.println("=============================");
                break;
	        }
		}	
	
				// 생성된 차량들의 정보 출력
				System.out.println("생성된 차량 정보:");
				System.out.println("=============================");
				for (Vehicle vehicle : vehicles) {
				vehicle.printVehicleinfo(); // 생성된 차량 객체들의 정보를 출력하는 메서드 호출
    }
}
        
        
        // 자동차 객체 생성 메소드
        public static Car createCar() {
            // 사용자로부터 자동차의 속성 입력 받아서 Car 객체 생성 후 반환
            // 예시로 입력받는 속성은 이름,브랜드,가격,종류,기름종류,최고속력
            Scanner scan = new Scanner(System.in);
            System.out.println("자동차 이름: ");
            String name = scan.next();
            System.out.print("자동차 브랜드: ");
            String brand = scan.next();
            System.out.print("자동차 가격: ");
            String price = scan.next();
            System.out.println("자동차 종류: ");
            String kind = scan.next();
            System.out.println("자동차 기름 종류: ");
            String fuel = scan.next();
            System.out.print("자동차 최고속력: ");
            String speed = scan.next();
            return new Car(name, brand, price, kind, fuel, speed);
        }
     
        public static Motorcycle createMotorcycle() {
        	// 사용자로부터 오토바이의 속성 입력 받아 Motorcycle 객체 생성 후 반환
        	// 예시로 입력받는 속성은 이름,브랜드,가격,탑승인원,탑승용도
        	Scanner scan = new Scanner(System.in);
        	System.out.println("오토바이 이름: ");
            String name = scan.next();
            System.out.print("오토바이 브랜드: ");
            String brand = scan.next();
            System.out.print("오토바이 가격: ");
            String price = scan.next();
            System.out.println("오토바이 탑승 인원: ");
            String NumberUsers = scan.next();
            System.out.println("오토바이 탑승 용도: ");
            String usage = scan.next();
            return new Motorcycle(name,brand,price,NumberUsers,usage);
        }
		
        public static WaterCraft createWaterCraft() {
        	// 사용자로부터 배의 속성 입력 받아 WaterCraft 객체 생성 후 반환
        	// 예시로 입력받는 속성은 이름,브랜드,가격,탑승인원,배기량
        	Scanner scan = new Scanner(System.in);
        	System.out.println("구축함 이름: ");
            String name = scan.next();
            System.out.print("구축함 브랜드: ");
            String brand = scan.next();
            System.out.print("구축함 가격: ");
            String price = scan.next();
            System.out.println("구축함 탑승 인원: ");
            String NumberUsers = scan.next();
            System.out.println("구축함 탑승 용도: ");
            String displacemnet = scan.next();
            return new WaterCraft(name,brand,price,NumberUsers,displacemnet);
        }
	}

