package Chapter02;

public class ByteOverflow012 {

	public static void main(String[] args) {
		
		// 다루어야 하는 데이터의 범위에 따라 타입설정이 달라져야한다
		// 0~270까지
		
		
		byte b = 0;
		int i = 0;
		// 0 에서 1씩 더해서 270까지 증가
		
		// for(초기식)
		for(int x=0; x<=270; x++) {
			// System.out.println(1);
			
			// b = b + 1;
			System.out.println(b+ "\t" + i);
			b++;
			i++;
		}
		
		
		
	}
}
