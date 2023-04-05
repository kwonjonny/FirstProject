package AddSicle;
//문제: 두 수의 최대공약수 구하기
//두 개의 양의 정수를 입력 받아, 두 수의 최대공약수를 반환하는 함수를 작성하세요. 
//최대공약수란, 두 수가 공통으로 갖는 가장 큰 약수를 말합니다.
//
//예시:
//
//입력: 12, 18
//출력: 6


public class If {
	 public static void main(String [] args) {
	        int a = 12;
	        int b = 18;
	        int result = gcd(a, b);
	        System.out.println(result);
	    }
	 
	 public static int gcd(int a, int b) {
	        while (b != 0) {
	            int temp = a % b;  // 18/12 = 6
	            				   // 12/6 = 0
	            				   // 최대공약수는 6
	            a = b;
	            b = temp;
	        }
	        return a;
	    }
	}
