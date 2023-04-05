import java.util.Arrays;

//다음과 같이 정수 배열이 주어졌을 때, 배열 내의 숫자들 중 가장 큰 수와 가장 작은 수의 차이를 반환하는 함수 getMaxDifference를 구현해보세요.
//
//public static int getMaxDifference(int[] arr) {
//    // 코드 구현
//}
//예를 들어, 다음과 같은 배열이 있다면,
//
//java
//Copy code
//int[] arr = {1, 5, 2, 9, 7};
//getMaxDifference 함수를 호출하면 8이 반환되어야 합니다.

public class Array2 {
	public static int getMaxDifference(int[] arr) {
		Arrays.sort(arr); // 정렬 
		int Max = arr[arr.length-1];// 제일 큰수 
		int Min = arr[0];
		
		return Max = Max - Min;
	}
	
class Main2 {	
	
		public static void main(String[] args) {
		int[] arr = {1,5,2,7,9};
		int MaxMinDiff = getMaxDifference(arr);
		System.out.println(MaxMinDiff);
		}
		
	}
}