
//    객체지향 고급 개념
//    - 상속
//    - 다형성
//    - 캡슐화 

public class Polymorphism_Abstraction_Inheritance_Encapsulation {
	
	// 인스턴트 변수
    private String type;
    private String color;
    private int size;
    
    
    // 생성자 정의
    public Polymorphism_Abstraction_Inheritance_Encapsulation(String type, String color, int size) {
        this.type = type;
        this.color = color;
        this.size = size;
    }
    
    // Getter Setter
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    // 출력문
    public void displayInfo() {
        System.out.println("Type: " + type);
        System.out.println("Color: " + color);
        System.out.println("Size: " + size);
    }
}




// shirt클래스 부모클래스의 상속
class Shirt extends Polymorphism_Abstraction_Inheritance_Encapsulation {
    public Shirt( String color, int size) {
        super("Shirt", color, size);
        // super로 인해 type의 변경
    }
}




// pants클래스 부모클래스의 상속
class Pants extends Polymorphism_Abstraction_Inheritance_Encapsulation {
    private String style;

    public Pants(String style, String color, int size) {
        super("Pants", color, size);
        this.style = style;
    }

    // Getter Setter
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
    
    // 오버라이딩 부모클래스의 출력문 super함으로써 출력문에 style을 추가 
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Style: " + style);
    }
}




class Main {
    public static void main(String[] args) {
        Polymorphism_Abstraction_Inheritance_Encapsulation myShirt = new Shirt("White", 10);
        Polymorphism_Abstraction_Inheritance_Encapsulation myPants = new Pants("Slim fit", "Black", 30);

        myShirt.displayInfo();
        System.out.println("----------");
        myPants.displayInfo();

        
        myPants.setStyle("Skinny");
        System.out.println("Pants Style: " + myPants.getStyle());
        
    }
}

