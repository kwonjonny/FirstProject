import java.util.Objects;

public class Equals {
    private String name;
    private int age;
    
    public Equals(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    @Override
    public boolean equals(Object o) {
        // 1. 객체가 자기 자신인지 확인
        if (this == o) return true;
        
        // 2. 객체가 null인지 확인
        if (o == null) return false;
        
        // 3. 객체의 클래스 타입이 같은지 확인
        if (getClass() != o.getClass()) return false;
        
        // 4. 객체의 필드값이 같은지 확인
        Equals other = (Equals) o;
        if (!Objects.equals(name, other.name)) return false;
        if (age != other.age) return false;
        
        // 모든 조건을 만족하면 true 반환
        return true;
    }
}


//  @Override
//  public boolean equals(Object o)
// 	오버라이딩을 하는 이유 
//	Object클래스는 모든 자바 객체의 부모 클래스이며 기본적으로 모든 객체가
//	가지고 있는 메소드들이 정의되어 있다 이 중 하나가 equals()메소드

// equals() 메소드는 두 객체가 서로 동일한지 비교하는 메소드
// Object 클래스내에서 구현된 equals()메소드는 객체의 레퍼런스(참조값)이
// 같은지 비교 즉 두 객체가 메모리상에 같은 위치를 참조하고있는지 비교하기 위함
// 따라서 이런 경우 equals() 메소드를 오버라이딩하여 두 객체가 내용적으로 같은지를 비교하도록 구현해야 한다
// 이를 위해 Equals 클래스에서는 equals() 메소드를 오버라이딩하였다

// equals() 메소드는 객체의 내용이 같은지를 판단하는데 사용되기도 한다 이 때에는 객체의 내용을 비교해야 한다
// this == o는 두 객체의 참조값이 같은지를 판단하는 방법 중 하나이며 객체가 자기 자신인지를 판단하기 위한 코드다
// if (o == null) return false; 객체가 null인지 확인하는 작업 
// if (getClass() != o.getClass()) return false; ->getClass()는 오브젝트.getclass와 같지않으면 return false














