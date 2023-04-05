import java.util.Arrays;

// 문제: 정수 배열에서 두 수의 합이 특정 값(target)이 되는 인덱스 두 개를 
// 반환하는 함수를 작성하세요. 
// 단, 배열 내에 중복되는 값이 있을 수 있으며, 정답은 반드시 입력 배열 내에 존재해야 합니다.

//input: [2, 7, 11, 15], target: 9
//output: [0, 1]
//
//input: [3, 2, 4], target: 6
//output: [1, 2]
//
//input: [3, 3], target: 6
//output: [0, 1]

//예를 들어, [1, 5, 2, 9, 7] 배열이 주어졌을 때, 
//인접한 두 수의 차이가 가장 큰 수는 7-2 = 5 이므로, 5를 반환합니다.
//
//해결 방법:
//
//배열을 오름차순으로 정렬합니다.
//인접한 두 수의 차이를 계산하여 최대 차이를 갱신합니다.
//최대 차이를 반환합니다.

public class Array {
	

	public static int getMaxDifference(int[] arr) {
	    int maxDiff = 0;
	    Arrays.sort(arr);  // 배열을 오름차순으로 정렬 Ex -> 1 2 5 7 9 
	    for (int i = 0; i < arr.length - 1; i++) {	// arr.length - 1 을 하는 이유는 for문을 돌때 1,2,3,4,5가 있다면 0부터 4까지 5번반복하기 때문 
	    	  int diff = arr[i+1] - arr[i];  // 인접한 두 수의 차이 계산
	          if (diff > maxDiff) {
	              maxDiff = diff;  // 최대 차이 갱신
	          }
	      }
	      return maxDiff;
	  }
	
	public static void main(String[] args) {
	int[] arr = {1, 5, 2, 9, 7};
	int maxDiff = getMaxDifference(arr);
	System.out.println("가장 큰 수의 차이: " + maxDiff);  // 출력 결과: 5
}
}
