
//    객체지향 고급 개념
//    - 상속
//    - 다형성
//    - 캡슐화 

public class Polymorphism_Abstraction_Inheritance_Encapsulation {
    private String type;
    private String color;
    private int size;

    public Polymorphism_Abstraction_Inheritance_Encapsulation(String type, String color, int size) {
        this.type = type;
        this.color = color;
        this.size = size;
    }

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

    public void displayInfo() {
        System.out.println("Type: " + type);
        System.out.println("Color: " + color);
        System.out.println("Size: " + size);
    }
}

class Shirt extends Polymorphism_Abstraction_Inheritance_Encapsulation {
    public Shirt(String color, int size) {
        super("Shirt", color, size);
    }
}

class Pants extends Polymorphism_Abstraction_Inheritance_Encapsulation {
    private String style;

    public Pants(String style, String color, int size) {
        super("Pants", color, size);
        this.style = style;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

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

        // 업데이트 스타일 출력
        // 업데이트된 style 출력
        myPants.setStyle("Skinny");
        System.out.println("Pants Style: " + myPants.getStyle());
    }
}

