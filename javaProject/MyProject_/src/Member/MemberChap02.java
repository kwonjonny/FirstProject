package Member;

// 앞서 생성 했던 Member 클래스에 main() 메소드 안에 아래 조건의 변수를 정의해봅시다.
// String 타입의 이름을 저장할 수 있는 변수 name을 정의해봅시다.
// int 타입의 나이를 저장할 수 있는 변수 age를 정의해봅시다.
// double 타입의 키를 저장할 수 있는 변수 height를 정의해봅시다.
// boolean 타입의 JAVA책의 보유 여부를 저장할 수 있는 변수 hasBook를 정의해봅시다.
// 이름과 나이, 키, 책의 보유 여부를 출력해봅시다.

public class MemberChap02 { // MemberChap02 에서는 직접 실행하지 않으므로 main메소드를 쓰지 않음

    // 변수 정의
	// 이 변수의 정의에 private 접근 제어자를 넣지 않는 이유는 
	// 생성자 정의 후 getter에서 인스턴스변수 접근과
	// setter에서 인스턴스변수의 값을 설정하지 않기 때문
    String name;
    int age;
    double height;
    boolean hasBook;
    
    // 생성자 정의
    public MemberChap02(String name, int age, double height, boolean hasBook) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.hasBook = hasBook;
        // 매개변수 public Member(String name, int age, double height, boolean hasBook)
        // this. -> 이용해 인스턴수 변수 -> name, age, height, hasBook -> this.name의 인스턴수 변수로 변환 
       
    }
    
    // 출력 메소드 정의
    public void printInfo() {
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("키: " + height);
        System.out.println("JAVA책 보유 여부: " + hasBook);
    }
    
    // main 메소드 정의
    public static void main(String[] args) {
        // Member 객체 생성 및 변수 초기화
        MemberChap02 member = new MemberChap02("홍길동", 20, 175.0, true);
        
        // 출력 메소드 호출
        member.printInfo();
  
    }
}