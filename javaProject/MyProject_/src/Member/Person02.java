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