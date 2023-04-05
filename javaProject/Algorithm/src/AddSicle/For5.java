package AddSicle;
//제가 포문 골드 문제 한 문제를 드리겠습니다.
//
//문제: 1부터 100까지의 숫자 중에서 3의 배수는 
// "Fizz", 5의 배수는 "Buzz", 3과 5의 공배수는 "FizzBuzz"를 출력하는 프로그램을 작성하세요.
public class For5 {

	public static void main(String [] args) {
		
		for(int i=1; i<=100; i++) {
			if(i%15==0) {
				System.out.println("FizzBuzz");
			} else if(i%5==0) {
				System.out.println("Buzz");
			} else if(i%3==0) {
				System.out.println("Fizz");
			} else {
				System.out.println(i);
			}
		}
		
	}
}
