
public class If {

	public static void main(String[] args) {
	//문제1.
	int num=120;
     if(num>0 &&(num%2)==0)
     System.out.println(num);
     } }
       
class if2 {
	public static void main(String[] args) {
	//문제2.
	// 다음과 같이 출력이 이루어지도록 작성해보자.
	//num < 0 이라면 “0 미만” 출력
	//0 ≤ num <100 이라면 “0이상 100 미만“ 출력
	//100 ≤ num < 200 이라면 “100이상 200 미만“ 출력
	//200 ≤ num < 300 이라면 “200이상 300 미만“ 출력
	//300 ≤ num 이라면 “300이상 “ 출력
	int num = 250;
	if(num < 0) {
		System.out.println("0미만");
	} else if(num < 100) {
		System.out.println("0이상 100미만");
	} else if(num < 200) {
		System.out.println("100이상 200미만");
	} else if(num < 300) {
		System.out.println("200이상 300미만");
	} else System.out.println("300이상");
}	
}

class if3 {
	public static void main(String[] args) {
	// 문제3.
	// 조건연산자(3항 연산자)를 사용하지 않고,
	// if~else를 사용하는 형태로 변경해 보자.
	int num1 = 50, num2 = 100;
	int big, diff;

	if(num1 > num2) {
	    big = num1;
	    diff = num1 - num2;
	} else {
	    big = num2;
	    diff = num2 - num1;
	}

	System.out.println(big);
	System.out.println(diff);
	
} }
		
class if4 {
	public static void main(String[] args) {
	// 문제 4.
	// SwitchBreak.java를 switch문이 아닌, 
	// if~else를 사용하는 형태로 변경해 보자.
	int n=3;
	if(n==1) {
		System.out.println("Simple Java");
	} else if(n==2) {
		System.out.println("Funny Java");
	} else if(n==3 ) {
		System.out.println("Fantastic Java");
	} else {
		System.out.println("The best programming language");
	}  System.out.println("Do you like coffee?");
	}	
}
		
class if5 {
	public static void main(String[] args) {
	// 문제 5.
	//문제 2의 답안 코드를 switch 문으로 변경하여 보자.
	//num < 0 이라면 “0 미만” 출력 부분은 if문을 사용하고 나머지 조건에 대해 변경하세요.
		int num = 250;
		if(num <0) {
			System.out.println("0미만");
		} else {
			switch(num / 100) {
			case 0:
				System.out.println("0이상 100미만");
				break;
			case 1:
				System.out.println("100이상 200미만");
				break;
			case 2: 
				System.out.println("200이상 300미만");
			default:
				System.out.println("300이상");
				break;
			}
		}
	}
}
		
class if6{
	public static void main(String[] args) {
	//문제 6.
	//while 문을 이용해서 1부터 99까지의 합을 구하는 프로그램을 작성.
		int num = 1;
		int sum = 0;
		while(num <= 99) {
			sum = sum +num;
			num++;
		}
		System.out.println(sum);
	}
}
		
class if7 {
	public static void main(String[] args) {
		
	}
}

class if8 {
	public static void main(String[] args) {
		int num = 1;
		int sum = 0;
		
		while(num <= 1000) {
			if(num%2==0 && num%7==0) {
				System.out.println(num); // 2와7의배수 14
				sum = sum + num; // 0 = 0 + 14
								 // 14 = 14 + 28
								 // 28 = 28 + 42
			}
			num++;
		}
		System.out.println(sum);
	}
}

class if9 {
public static void main(String[] args) {
	//for 문을 이용하여 1부터 10까지를 곱해서 그 결과를 출력하는 프로그램을 작성
	int result = 1;
	for(int i=1; i<10; i++) {
		result = result +i;
	}
	System.out.println(result);
	}
}

class if10 {
public static void main(String[] args) {
	for (int i = 1; i <= 9; i++) {
	    System.out.println( i  + (5 * i));
	}
}
}

class if11 {
	public static void main(String[] args) {
		//ContinueBasic.java의 내부에 존재하는 while 문을 for 문으로 변경하여 작성
		int count = 0;
		for(int num=1; num<=100; num++) {
			if(num !=0 || num % 7 != 0) {
				continue;
			}
			count++;
			System.out.println(num);
		}
		System.out.println(count);
	}
}

class if12{
	public static void main(String [] args) {
		
	}
}

class if13{
	public static void main(String [] args) {
		for(int i=2; i<=8; i=i*2) { // 2, 4, 8 단을 위한 반복문
			for(int j=1; j<=i; j++) { // 각 단의 곱을 위한 반복문
			if(j > i) break; // 조건에 맞지 않으면 반복문을 빠져나감
			if(i==2 && j==3) break; // 2단의 경우 2x3까지만 출력하고 빠져나감
			System.out.println(i + " x " + j + " = " + (i*j)); // 구구단 출력
			}
			}
	}
}

class if14{
	public static void main(String [] args) {
		
	}
}

class if15 {
	public static void main(String [] args) {
		int n=3;
		if(n==1) {
			System.out.println("1명");
		} else if(n==2) {
			System.out.println("2명");
		} else if(n==3) {
			System.out.println("3명");
		} else {
			System.out.println("현재 많은 사람들이 있습니다.");
		}
	}
}

class swtich15 {
	public static void main(String [] args) {
		int n=3;
		switch(n) {
		case 1: 
			System.out.println("1명");
		
		case 2: 
			System.out.println("2명");
		
		case 3: 
			System.out.println("3명");
		
		default : 
			System.out.println("현재 많은 사람들이 있습니다.");
		
		}
	}
}

class while16{
	public static void main(String [] args) {
		int sum = 0;
		int num = 1;
		while (num <= 99) {
			sum = sum + num;
			num++;
		}
		System.out.println(sum);
	}
}

class for16{
	public static void main(String [] args) {
		int sum = 0;
		for (int i = 1; i <= 99; i++) {
		    sum = sum + i;
		}
		System.out.println(sum);
	}
}

class doWhile16{
	public static void main(String [] args) {
		int sum = 0;
		int num = 1;
		do {
		    sum += num;
		    num++;
		} while (num <= 99);
		System.out.println(sum);
	}
}
