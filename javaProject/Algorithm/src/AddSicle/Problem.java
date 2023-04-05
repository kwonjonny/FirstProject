package AddSicle;

import java.util.Random;
import java.util.Scanner;

//"숫자 맞추기 게임을 구현하는 문제입니다.
//문제: 1부터 100까지의 숫자 중 하나를 임의로 선택하고, 
//사용자가 그 숫자를 맞추는 게임을 만드세요. 맞추는 숫자마다 "Up" 또는 "Down"을 
//표시하여 사용자가 추측할 수 있도록 합니다. 게임이 끝나면 몇 번 만에 맞췄는지 출력합니다."
public class Problem {
	public static void main(String [] args) {
	Random random = new Random();
	int answer = random.nextInt(100)+1;
	int count = 0;
	
	Scanner scan = new Scanner(System.in);
	
	while(true) {
		System.out.println("맞출 숫자를 입력하세요");
		int guess = scan.nextInt();
	 if(guess < answer) {
		System.out.println("Down");
		count ++;
	} else if(guess > answer) {
		System.out.println("up");
		count++;
	} else {
		System.out.println("맞췃습니다.!");
		break;
	}
	}
	System.out.println(count + "만에 맞췄어용!");
	
	
	}
	
}