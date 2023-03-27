
//부모 클래스인 Military 클래스가 있습니다. Military 클래스는 군대를 나타내며, 
//군인의 이름과 나이를 가지고 있습니다. Military 클래스에는 이름과 나이를 출력하는 toString 
//메서드가 정의되어 있습니다.
//
//Military 클래스를 상속하는 자식 클래스로 FighterJet 클래스와 Tank 클래스를 만들어 보려고 합니다. 
//FighterJet 클래스에는 전투기를 나타내며, 속도와 무기를 추가적으로 가지고 있습니다. 
//Tank 클래스에는 탱크를 나타내며, 속도와 무기를 추가적으로 가지고 있습니다.
//
//각 클래스는 인스턴스 변수를 private으로 선언하고, 
//각 변수에 접근할 수 있는 public인 getter와 setter를 작성해야 합니다. 
//또한, 각 클래스는 toString 메서드를 오버라이딩하여 인스턴스 변수를 출력해야 합니다.
//
//마지막으로, 메인 메서드에서 FighterJet과 Tank 인스턴스를 생성하고, 각 객체의 속성을 출력해야 합니다.
//
//요구사항:
//Military 클래스에는 String name과 int age라는 인스턴스 변수가 있으며, 
//이름과 나이를 출력하는 toString 메서드가 있습니다.
//FighterJet 클래스는 Military 클래스를 상속하며, 
//double speed와 String weapon이라는 인스턴스 변수를 추가로 가지고 있습니다. 
//FighterJet 클래스에는 각 인스턴스 변수에 접근할 수 있는 getter와 setter가 정의되어 있으며,
//toString 메서드가 오버라이딩되어 각 인스턴스 변수를 출력합니다.
//Tank 클래스는 Military 클래스를 상속하며, 
//double speed와 String weapon이라는 인스턴스 변수를 추가로 가지고 있습니다. 
//Tank 클래스에는 각 인스턴스 변수에 접근할 수 있는 getter와 setter가 정의되어 있으며,
//toString 메서드가 오버라이딩되어 각 인스턴스 변수를 출력합니다.
//메인 메서드에서 FighterJet과 Tank 인스턴스를 생성하고, 각 객체의 속성을 출력합니다.

public class Military {
	
	// 인스턴스 변수 정의
	private String name;
	private String age;
	
	// 사용자 정의
	public Military(String name, String age) {
		this.name = name;
		this.age = age;
	}
	
	// Getter Setter정의 캡슐화 정보은닉 보수용이
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	// toString정의
	@Override
	public String toString() {
		return "name" + name + "age" + age;
	}
	
}


class FighterJet extends Military {
	
	// 인스턴스 변수 정의
	private String speed;
	private String weapon;
	
	// 사용자 정의 
	public FighterJet(String name, String age, String speed, String weapon) {
		super(name,age);
		this.speed = speed;
		this.weapon = weapon;
	}
	
	// Getter Setter정의 캡슐화,정보은닉,보수용이
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	
	public String getWeapon() {
		return weapon;
	}
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	
	@Override
	public String toString() {
		return super.toString() + "speed" + speed + "weapon" + weapon;
	}
}


class Tank extends Military{
	
	// 인스턴스 변수 정의
	private String speed;
	private String weapon;
	
	// 사용자 정의
	public Tank(String name, String age, String speed, String weapon) {
		super(name, age);
		this.speed = speed;
		this.weapon = weapon;
	}
	
	// Getter Setter 정의 캡슐화,정보은닉,보수용이
	public String getSpeed() {
		return speed;
	}
	public void setSpeed() {
		this.speed = speed;
	}
	
	public String getWeapon() {
		return weapon;
	}
	public void setWeapon() {
		this.weapon = weapon;
	}
	
	@Override
	public String toString() {
		return super.toString() + "speed" + speed + "weapon" + weapon;
	}
}

class Fire {
	public static void main(String [] args) {
		
		// 객체의 생성
		Military soldier = new Military("권성준", "24");
		System.out.println(soldier);
		
		// 전투기 객체의 생성
		FighterJet Officer = new FighterJet("권성준", "24", "Maha7", "sideWinderMissile");
		System.out.println(Officer);
		
		// 탱크 객체의 생성
		Tank Corporal = new Tank("권성준", "26", "60KM", "ApShell");
		System.out.println(Corporal);
		
		
	}
}