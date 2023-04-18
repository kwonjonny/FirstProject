package AbstractInterface;

//Q. 다음 요구사항을 인터페이스를 활용해 구현하세요.
//1. Tank 클래스를 생성해 다음의 기능을 제공합니다.
//- 이동하는 기능의 move() 메소드를 제공합니다.
//- 공격하는 기능의 attack() 메소드를 제공합니다.
//- 방어하는 기능의 defend() 메소드를 제공합니다.
//2. Airplane 클래스를 생성해 다음의 기능을 제공합니다.
//- 이동하는 기능의 move() 메소드를 제공합니다.
//- 공격하는 기능의 attack() 메소드를 제공합니다.
//- 비행하는 기능의 fly() 메소드를 제공합니다.
//3. Tank과 Airplane 클래스가 모두 구현할 수 있는 기능을 추상화하여 Interface로 작성하세요.
//4. Interface에서 추상화한 기능을 구현해 Tank과 Airplane 클래스를 수정하세요.

interface Move{
	void move();
}

interface Attack{
	void attack();
}

interface Defend{
	void defend();
}

interface Retreat{
	void retreat();
}


public class Tank implements Move,Attack,Defend,Retreat {

	@Override
	public void defend() {
		System.out.println("탱크가 AT탄을 방어합니다.");
	}

	@Override
	public void attack() {
		System.out.println("탱크가 AT탄을 발사합니다.");
	}

	@Override
	public void move() {
		System.out.println("탱크가 50KM로 전진합니다.");
	}
	
	@Override
	public void retreat() {
		System.out.println("탱크가 후퇴 합니다.");
	}
}

class Airplane implements Move,Attack,Retreat {

	@Override
	public void attack() {
		System.out.println("비행기가 sidWidner미사일을 발사합니다.");
	}

	@Override
	public void move() {
		System.out.println("전투기가 Maha 10으로 비행합니다");
	}
	
	@Override
	public void retreat() {
		System.out.println("비행기가 선회합니다.");
	}
	
}


class Main12 {
	public static void main(String [] args) {
		Tank tank = new Tank();
		tank.defend();
		tank.attack();
		tank.move();
		tank.retreat();
	
		Airplane airplane = new Airplane();
		airplane.attack();
		airplane.move();
		airplane.retreat();
	}
}