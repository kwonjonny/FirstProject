package Member;

// 객체지향_상속 

// Person 이라는 클래스를 정의해봅시다.
// 이름을 저장하는 변수, 주민등록번호를 저장하는 변수를 정의해봅시다.
// 인사하는 메소드를 정의해봅시다.
// “안녕하세요. 저는 OOO입니다. 00살 입니다.”라는 문자열이 출력하도록 정의합시다.

// 2. Person 클래스를 상속해서 확장하는 새로운 클래스 Male 클래스와 Female 클래스를 정의 해봅시다.
// 각 클래스는 상속 받은 멤버 외에 추가적인 변수와 메소드를 추가해서 새로운 클래스를 정의해봅시다.
// 각 클래스는 상속 받은 멤버 외에 추가적인 변수와 메소드를 추가해서 새로운 클래스를 정의해봅시다.
// Person 클래스에서 정의된 인사하는 메소드를 오버라이딩 해봅시다.
// Person 클래스에 생성자를 정의해서 인스턴스 변수들을 초기화 해봅시다.

// 3. main()메소드를 정의해봅시다.
// Person 클래스를 상속받은 Male클래스와 Female클래스를 이용해서 인스턴스를 생성해 봅시다.
// 생성된 인스턴스들을 이용해서 메소드를 호출해봅시다.

public class Person02 {
    private String name;
    private String idNum;
    private int age;
	

    // 생성자 정의
    public Person02(String name, String idNum, int age) {
        this.name = name;
        this.idNum = idNum;
        this.age = age;
    }
    
    //Getter 와 Setter생성
    public String getName() {
    	return name;
    }
    public void setName() {
    	this.name = name;
    }

    
    public String getIdNume() {
    	return idNum;
    }
    public void setIdNum() {
    	this.idNum = idNum;
    }
    
    
    public int getAge() {
    	return age;
    }
    public void setAge() {
    	this.age = age;
    }
    
    
    public void hello() {
        System.out.println("안녕하세요. 저는 " + name + "입니다. " + age + "살 입니다.");
    }
}


class Male extends Person02{
	
	private boolean militaryService;

	// 각 클래스는 상속 받은 멤버 외에 추가적인 변수와 메소드를 추가해서 새로운 클래스를 정의해봅시다.
	// Male과 Female을 구분하는 변수 정의
	// 생성자 정의
	// 부모클래스의 생성자 매개변수를 호출함으로써 name idName age의 매개변수 사용 가능
	public Male(String name, String idNum, int age, boolean militaryService) {
        super(name, idNum, age);	// 부모 클래스의 생성자 매개변수 호출
        this.militaryService = militaryService;
    }

	@Override	// 부모 클래스의 hello() 메서드를 재정의함을 나타냄
    public void hello() {
        System.out.println("안녕하세요. 저는 " + getName() + "입니다. " + getAge() + "살이고, "
                + (militaryService ? "군필입니다." : "미필입니다."));
    }
	

    
	// 자식 클래스
	// Getter Setter 
    public boolean getMilitaryService() {
        return militaryService;
    }

    public void setMilitaryService(boolean militaryService) {
        this.militaryService = militaryService;
    }
}



class Female extends Person02 {
    private boolean married;

    // 생성자 정의
    // 부모클래스의 생성자 매개변수를 호출함으로써 name idName age의 매개변수 사용 가능
    public Female(String name, String idNum, int age, boolean married) {
        super(name, idNum, age);	// 부모 클래스의 생성자 매개변수 호출
        this.married = married;
    }

    @Override	// 부모 클래스의 hello() 메서드를 재정의함을 나타냄
    public void hello() {
        System.out.println("안녕하세요. 저는 " + getName() + "입니다. " + getAge() + "살이고, "
                + (married ? "기혼입니다." : "미혼입니다."));
    }
	
    
	// 자식 클래스
	// Getter Setter 
    public boolean getMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }
}

class main {
	public static void main(String [] args) {
		Male male = new Male("홍길동", "123456-1234567", 25, true);
        Female female = new Female("김영희", "123456-2345678", 23, false);

        male.hello();	// "안녕하세요. 저는 홍길동입니다. 25살이고, 군필입니다." 출력
        female.hello();	// "안녕하세요. 저는 김영희입니다. 23살이고, 미혼입니다." 출력

        male.setMilitaryService(false);	// setter를 이용해 군필 여부 변경
        female.setAge();	// setter를 이용해 나이 변경

        male.hello();	// "안녕하세요. 저는 홍길동입니다. 25살이고, 미필입니다." 출력
        female.hello();	// "안녕하세요. 저는 김영희입니다. 24살이고, 미혼입니다." 출력
    
	}
}

// 이 코드를 보면 굳이 부모클래스에서의 hello() 메소드를 만들지 않고 자식 클래스에서 따로 만들어 출력할수있다
// 하지만 문제에선 오버라이딩을 쓰라고 했으므로 부모클래스에서 hello()메소드를 만들고 자식클래스에선 
// hello()위에 오버라이딩을 달아 메소드를 재 정의하고 변경해준다 


// 부모 클래스에서 정의된 메서드를 자식 클래스에서 오버라이딩하는 이유는 다형성(polymorphism)을 구현하기 위해서이다
// 다형성이란, 하나의 객체가 여러 가지 타입을 가질 수 있는 것을 의미
// 부모 클래스에서 정의된 메서드를 자식 클래스에서 오버라이딩하면 부모 클래스와 자식 클래스 모두에서 동일한 이름을 가진 메서드를 호출할 수 있게 되어
// 코드의 재사용성이 높아지고 유지보수가 쉬워짐
// 웹 페이지를 구성하는 예시로 들어보면 예를 들어 여러 개의 페이지가 있을 때
// 각 페이지마다 공통된 기능을 수행하는 메서드가 있다면
// 이 메서드를 부모 클래스에서 정의하고
// 각 페이지에서는 이 메서드를 오버라이딩하여 필요한 기능을 구현할 수 있다
// 코드의 중복을 방지하고 유지보수성을 높일 수 있다



// 다음에 공부해볼것은 ? 
// Object최상위클래스 equals(), hashCode(), toString(), getClass()



