import java.util.Arrays;

// 다음과 같은 두 개의 정수 배열이 주어졌을 때, 두 배열의 요소를 
// 번갈아가면서 출력하는 프로그램을 작성하세요.

// 첫 번째 배열: [1, 3, 5]
// 두 번째 배열: [2, 4, 6]

// 예시 출력:
// 1 2 3 4 5 6

public class Array8 {
	public static void main(String [] args) {
	int arr1 [] = {1,3,5};
	int arr2 [] = {2,4,6};
	
	int k = 0;
	int t = 0;
	
	while(k< arr1.length && t < arr2.length) {
		if(k == t) {
			System.out.println(arr1[k] + " ");
			k++;
		} else {
			System.out.println(arr2[t] + " ");
			t++;
		}
	}
	while(k<arr1.length) {
		System.out.println(arr1[k] + " ");
		k++;
	}
	while(t<arr2.length) {
		System.out.println(arr2[t] + " ");
		t++;
	}

	}
}

