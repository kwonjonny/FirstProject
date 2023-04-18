package AbstractInterface;

import java.util.ArrayList;

//문제: 동물 클래스와 이를 상속받는 각종 동물들의 클래스를 구현하고, 
//이들이 가지는 공통 속성과 메소드를 인터페이스와 추상 클래스를 이용해 구현해보세요.
//
//요구사항:
//
//Animal 클래스를 작성하고, 이를 상속받는 Dog, Cat, Bird, Fish 등의 클래스를 작성하세요.
//Animal 클래스는 name과 age라는 두 개의 속성을 가지며, 속성값은 생성자를 통해 초기화합니다.
//Animal 클래스는 getSound()라는 추상 메소드를 가지며, 모든 하위 클래스는 이 메소드를 구현해야합니다.
//Animal 클래스는 toString() 메소드를 구현하여 name과 age 정보를 출력합니다.
//Animal 인터페이스를 작성하고, Animal 클래스가 이를 구현하도록 합니다. move라는 메소드를가짐
//Animal 추상 클래스를 작성하고, 이 클래스가 name과 age 속성을 가지도록 하고, getSound() 메소드를 추상 메소드로 정의합니다.
//참고사항:
//
//Dog, Cat, Bird, Fish 클래스는 Animal 클래스를 상속받아 작성합니다.
//각 하위 클래스는 getSound() 메소드를 구현하여 해당 동물의 울음소리를 반환하도록 합니다.
//인터페이스와 추상 클래스를 이용하여 각 하위 클래스가 공통으로 가지는 속성과 메소드를 구현합니다.
public abstract class Animal implements AnimalInterface {
	private String name;
	private String age;
	
	public Animal(String name, String age) {
		this.name = name;
		this.age = age;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract String getSound();
		
	public String toString() {
		return "종이름" + name + "나이" + age;
	}
	
}

interface AnimalInterface {
	public void move();
}

class Dog extends Animal implements AnimalInterface {
	// 인스턴스 변수 정의
	private String breed;
	
	// 생성자 정의
	public Dog(String name, String age, String breed) {
		super(name, age);
		this.breed = breed;
	}
	
	// Getter Setter
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	// 추상 메소드 오버라이딩
	@Override
	public String getSound() {
		return "컹컹!";
	}
	
	// 인터페이스 메소드 오버라이딩
	@Override
	public void move() {
		System.out.println("달린다.");
	}
	
}


class Cat extends Animal implements AnimalInterface {
	// 인스턴스 변수 정의 
	private String color;
	
	// 생성자 정의
	public Cat(String name, String age, String color) {
		super(name,age);
		this.color = color;
	}

	// Getter Setter 정의 
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	// 추상 메소드 오버라이딩
	@Override
	public String getSound() {
		return "냐옹!";
	}
		
	// 인터페이스 메소드 오버라이딩
	@Override
	public void move() {
		System.out.println("캣휠탄다.");
	}
}


class Bird extends Animal implements AnimalInterface {
	// 인스턴스 변수 정의
	private String breed1;
	
	public Bird(String name, String age, String breed1) {
		super(name,age);
		this.breed1 = breed1;
	}

	// Getter Setter 
	public String getBreed1() {
		return breed1;
	}

	public void setBreed1(String breed1) {
		this.breed1 = breed1;
	}
	
	// 추상 메소드 오버라이딩
	@Override
	public String getSound() {
		return "딱딱!";
	}
			
	// 인터페이스 메소드 오버라이딩
	@Override
	public void move() {
		System.out.println("훨훨난다!.");
	}
}


class Fish extends Animal implements AnimalInterface {
	
	// 인스턴스변수 정의 
	private String breed2;
	
	public Fish(String name, String age, String breed2) {
		super(name,age);
		this.breed2 = breed2;
	}
	
	// Getter Setter
	public String getBreed2() {
		return breed2;
	}

	public void setBreed2(String breed2) {
		this.breed2 = breed2;
	}
	// 추상 메소드 오버라이딩
	@Override
	public String getSound() {
		return "파닥파닥!";
	}
				
	// 인터페이스 메소드 오버라이딩
	@Override
	public void move() {
		System.out.println("빠르게 헤엄친다!.");
	
	}
}


class main5 {
	public static void main(String [] args) {
		
		// ArrayList로 정의 
		ArrayList<Animal> animal = new ArrayList<>();
		animal.add(new Dog("똥개" , "3" , "골든리트리버"));
		animal.add(new Cat("고양이", "4" , "검정!"));
		animal.add(new Bird("새" , "3" , "딱따구리"));
		animal.add(new Fish("물고기" , "1" , "몰루나도"));
		
		// foreach
		for(Animal animal2 : animal) {
			System.out.println(animal2);
			animal2.move();
		}
		
		
		
	}
	
}



