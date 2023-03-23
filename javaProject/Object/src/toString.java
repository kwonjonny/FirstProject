
public class toString {
	
	private String name;
    private int age;

    public toString(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

class Employee extends toString {
    private String department;

    public Employee(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{department='" + department + "', " + super.toString() + "}";
    }
}

class Main {
    public static void main(String[] args) {
        toString toString = new toString("John", 30);
        System.out.println(toString); 
        // Person{name='John', age=30}

        Employee employee = new Employee("Mary", 25, "Sales");
        System.out.println(employee); 
        // Employee{department='Sales', Person{name='Mary', age=25}}
    }
}




// toString을 설명하기전에 오버라이딩을 먼저보자
//부모 클래스에서 정의된 메서드를 자식 클래스에서 오버라이딩하는 이유는 다형성(polymorphism)을 구현하기 위해서이다
//다형성이란 하나의 객체가 여러 가지 타입을 가질 수 있는 것을 의미
//부모 클래스에서 정의된 메서드를 자식 클래스에서 오버라이딩하면 
//부모 클래스와 자식 클래스 모두에서 동일한 이름을 가진 메서드를 호출할 수 있게 되어
//코드의 재사용성이 높아지고 유지보수가 쉬워짐
//웹 페이지를 구성하는 예시로 들어보면 예를 들어 여러 개의 페이지가 있을 때
//각 페이지마다 공통된 기능을 수행하는 메서드가 있다면
//이 메서드를 부모 클래스에서 정의하고
//각 페이지에서는 이 메서드를 오버라이딩하여 필요한 기능을 구현할 수 있다
//코드의 중복을 방지하고 유지보수성을 높일 수 있다

//그럼 굳이 부모클래스에서의 정의된 메소드에도 @Override의 어노테이션을 달아줘야 하나 달아줘도 좋다
//왜냐면 부모 클래스에 있는 메소드를 자식 클래스에서 오버라이딩할 때 
//부모 클래스의 메소드 시그니처가 변경되면 컴파일러가 오류를 발생시킨다
//하지만 부모 클래스에 @Override 어노테이션을 추가하면 자식 클래스에서 오버라이딩할 때 
//메소드 시그니처가 부모 클래스와 일치하지 않으면 컴파일러가 오류를 발생시킨다
//이를 통해 개발자가 오버라이딩을 제대로 구현하도록 도와준다
//따라서 부모 클래스에서도 @Override 어노테이션을 사용하는 것이 좋다
//메소드 시그니처는 메소드의 이름과 매개변수의 타입, 개수 그리고 반환 타입을 모두 포함

//toString에 대하여 =
//접근제어자를 생성해 name과 age를 만들었고 
//매개변수를 public toString 를이용해 매개변수(name과 age)를 초기화함
//name과 age라는 매개변수로 전환하고 this를 사용해 인스턴스 변수로의 전환 후 @Override를 이용해 
//후에 자식클래스에서 시그니처가같은 메소드를 대비하기위해 부모클래스에서도 달아줌 부모클래스의 toString메소드에서는 
//name과 age의 인스턴스변수를 출력하게 도와줌

//employee클래스는 toString 클래스를 상속받고 employee 클래스에서만 접근 가능한 private String department 
//함수를 생성해 public employee메소드에서 추가해주고 super을 이용해 toString클래스의 매개변수를 끌어와 초기화해준다 
//또한 this.department = department를 해줌으로써 departmet는 인스턴수변수가된다 
//그 뒤에 코드는 오버라이딩을 함으로써 부모클래스와 시그니처가 같음을 확인하고 메소드를 똑같이 씀으로써 부모클래스에서 정의된 
//return값을 쓸수있다  부모클래스와 다른 부분을 출력하기위해 "Employee{department='" + department + "', "  의 
//코드를 달아주었고 그 뒤에 super.toString()을 달아줌으로써 새로운문장과 + 부모클래스의 문장이 합쳐져 나옴 

// 이 코드의 핵심은  
//@Override
//public String toString() {
//return "Employee{department='" + department + "', " + super.toString() + "}";} 를 사용하기 위함 

