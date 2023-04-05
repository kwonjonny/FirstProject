
//문제
//주어진 문자열에서 대소문자를 구분하지 않고 모든 알파벳을 거꾸로 뒤집은 문자열을 반환하는 함수를 작성하세요.
//
//예시:
//
//입력: "Hello World"
//출력: "dlroW olleH"
//제한사항:
//
//입력 문자열은 공백이 포함될 수 있습니다.
//반환하는 문자열은 대소문자를 구분하지 않으며, 모든 알파벳을 거꾸로 뒤집은 문자열입니다.

// String 형의 메소드 필요함
// StringBuilder() 안에 메소드의 인스턴스 변수를 넣어주고 
// 문자열을 뒤집는 것 이 필요하다 

public class Array6 {
	public static String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}
	
}

// Hello World 를 만드는 메소드 필요
// 뒤집어주는과정 필요 
class Main6 {
	public static void main(String [] args) {

		String str = "Hello World";
		String reversed = Array6.reverse(str);
		System.out.println(reversed);
	}
}