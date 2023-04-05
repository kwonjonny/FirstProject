package AddSicle;
// 문제: 문자열 뒤집기
//주어진 문자열을 뒤집어서 반환하는 함수를 작성하세요.
//
//예시:
//
//입력: "hello"
//출력: "olleh"
//제약 조건:
//
//문자열의 길이는 100 이하입니다.
//문자열에는 영문 알파벳 소문자만 포함됩니다.
//추가적인 데이터 구조나 라이브러리를 사용하지 마세요. (예: 파이썬에서 제공하는 문자열 뒤집기 함수)
public class Reverse {

	public static String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}
}

class Main11 {
	public static void mani(String [] args) {
		
	String str = "Hello world";
	String reserved = Reverse.reverse(str);
	System.out.println(reserved);
	
 }
}