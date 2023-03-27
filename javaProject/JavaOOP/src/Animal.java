
//문제: 동물(Animal) 클래스를 상속받아 고양이(Cat) 클래스를 구현하고, 새로운 인스턴스를 생성하려고 합니다. 
//Animal 클래스는 이름(name), 나이(age), 종(species) 변수를 가지며, 이 변수들에 대한 게터(getter)와 세터(setter) 메소드를 가지고 있습니다. 
//Animal 클래스에 대한 생성자도 구현해야 합니다.
//
//Cat 클래스는 Animal 클래스를 상속받으며, 추가적으로 색상(color) 변수를 가지고 있습니다. Cat 클래스에 대한 생성자도 구현해야 합니다.
//
//위 요구사항을 바탕으로 Animal 클래스와 Cat 클래스를 구현하고, Cat 클래스의 인스턴스를 생성하고 초기화하는 코드를 작성하십시오.


public class Animal {

	// 인스턴스 변수정의
	private String name;
	private int age;
	private String species;
	
	// 생성자 정의 
	public Animal(String name, int age, String sepcies) {
		this.name = name;
		this.age = age;
		this.species = species;
	}
	
	// Getter Setter 정의 캡슐화, 정보은닉, 보수용이
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
		
}



class Cat extends Animal {
	
	// 인스턴스 변수 정의 
	private String color;
	
	// 생성자 정의 
	public Cat(String color, int age, String name, String species) {
	super(name, age, species);
	this.color = color;
	}
	
	// Getter Setter 정의 캡슐화, 정보은닉, 보수용이
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}

class dain{
	public static void main(String [] args) {
	
		Cat cat = new Cat("권성준", 24, "페르시안", "black");
		System.out.println(cat);
		
}
}

