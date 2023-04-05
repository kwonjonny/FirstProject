import java.util.ArrayList;
import java.util.List;

// 정수 배열과 정수 k가 주어졌을 때, 배열에서 k와 일치하는 요소를
// 모두 제거하고 남은 요소들로 새로운 배열을 만드는 함수를 작성하세요.

// 예시:
// 입력: [1, 2, 3, 4, 5], 3
// 출력: [1, 2, 4, 5]
//
// 입력: [1, 3, 5, 7, 3, 8, 3], 3
// 출력: [1, 5, 7, 8]


public class Stack2 {

	public static List<Integer> removeElements(int[] arr, int k) {
		ArrayList<Integer> results = new ArrayList<>();
		
		for(int elements : arr) {
			if(elements != k) {
				results.add(elements);
			}
		}
		return results;
	}
}


class Main9 {
	public static void main(String [] args) {
		
		int [] arr = {1,2,3,4,5,7,3,8,3};
		int k = 3;
		List<Integer> newArr = Stack2.removeElements(arr,k);
		System.out.println(newArr);
	}
}
