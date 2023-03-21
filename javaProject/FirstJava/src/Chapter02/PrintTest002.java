package Chapter02;

public class PrintTest002 {

	public static void main(String[] args) {
	
		String name ="Ronaldo";
		int age = 37;
		String JAVA = "JAVA";
		
		
		System.out.print("안녕하세요! 저는");
		System.out.println();
		
		System.out.print(name+"입니다.");
		System.out.println();
		
		System.out.printf("안녕하세요! 저는 %s입니다.",name); // 안녕하세요 저는 Ronaldo입니다.
		System.out.println();
		
		System.out.printf("안녕하세요! 저는 %s입니다. 나이는 %d살 입니다.", name,age);
		System.out.println();
		
		System.out.printf("안녕하세요. 저는 %s입니다.",JAVA );
		System.out.println();
		
		System.out.printf("저는 /n살 입니다." , 20);
		System.out.println();
		
		System.out.printf("정수 :%d 실수 : %f" , 10 ,13.5);
		System.out.println();
		
		System.out.printf("문자: %c 문자열: %s" , 'Z',"KIng");
		System.out.println();
		
		System.out.println("나는 \"KING\" 이다");
		
		
		
	}

}
