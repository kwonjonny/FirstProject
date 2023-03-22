package Member;

public class Member {
    // 변수 정의
    String name;
    int age;
    double height;
    boolean hasBook;
    
    // 생성자 정의
    public Member(String name, int age, double height, boolean hasBook) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.hasBook = hasBook;
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
        Member member = new Member("홍길동", 20, 175.0, true);
        
        // 출력 메소드 호출
        member.printInfo();
    }
}