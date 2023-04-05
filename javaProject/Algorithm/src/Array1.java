import java.util.Arrays;

//문제:
// 주어진 정수형 배열(arr)에서 인접한 두 수의 차이 중 가장 큰 값을 반환하는 함수를 작성하세요.
//함수명: getMaxDifference
//인자: int[] arr (길이는 2 이상)
//반환: int (가장 큰 차이)
//
//예시:
//int[] arr = {1, 5, 2, 9, 7};
//int maxDiff = getMaxDifference(arr);
//System.out.println("가장 큰 수의 차이: " + maxDiff); // 출력 결과: 5
//
//※ 주의사항
//
//배열의 길이는 2 이상이라 가정합니다.
//배열 내 정수의 범위는 int형의 범위를 벗어나지 않는다고 가정합니다.

public class Array1 {
	
	public static int getMinMaxDifference(int[] arr) {
		Arrays.sort(arr); // 배열을 오름차순으로 정렬 Ex-> 1 2 3 4 5
		int min = arr[0]; // 배열에서 가장 작은 수 
		int max = arr[arr.length -1]; // 배열에서 가장 큰 수 
		return max = max - min; //  가장 큰 수와 가장 작은 수의 차이 반환
	}
	
class Main2 {
	public static void main(String [] args) {

		int [] arr = {1,5,2,7,9};
		int minMaxDiff = getMinMaxDifference(arr);
		System.out.println("가장 큰 수와 작은 수 의 차이 =" + minMaxDiff);
		
	}
  }
}