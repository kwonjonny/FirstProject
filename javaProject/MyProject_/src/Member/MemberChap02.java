package Member;

// JAVA에서 데이터 다루기

// 앞서 생성 했던 Member 클래스에 main() 메소드 안에 아래 조건의 변수를 정의해봅시다.
// String 타입의 이름을 저장할 수 있는 변수 name을 정의해봅시다.
// int 타입의 나이를 저장할 수 있는 변수 age를 정의해봅시다.
// double 타입의 키를 저장할 수 있는 변수 height를 정의해봅시다.
// boolean 타입의 JAVA책의 보유 여부를 저장할 수 있는 변수 hasBook를 정의해봅시다.
// 이름과 나이, 키, 책의 보유 여부를 출력해봅시다.

public class MemberChap02 { // MemberChap02 에서는 직접 실행하지 않으므로 main메소드를 쓰지 않음

    // 인스턴스변수 정의
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
        // 매개변수의 초기화 값을 인스턴스변수에 전달 
       
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
        MemberChap02 member = new MemberChap02("성준", 26, 176.0, false);
        
        // 출력 메소드 호출
        member.printInfo();
  
    }
}