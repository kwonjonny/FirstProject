import java.util.ArrayList;
import java.util.List;

// 정수 배열과 정수 k가 주어졌을 때
// 배열에서 k와 일치하는 요소를 모두 제거하고 남은 요소들로 새로운 배열을 만드는 문제
// 		  출력 예시 : int[] arr = {1, 3, 5, 7, 5, 9, 5, 11};
//        int k = 5;
//        List<Integer> newArr = removeElementsEqualToK(arr, k);
//        System.out.println(newArr);
public class Array7 {
	public static List<Integer> removeElementsEqualToK(int[] arr,int k) {
		
		ArrayList<Integer> result = new ArrayList<>();
		for(int element : result) {
			if(element > k) {
				result.add(element);
			}
		}
		return result;
	}
}

class Main7 {
	public static void main(String [] args) {
		
		int[] arr = {1,3,5,7,9,5,11};
		int k = 5;
		List<Integer> newArr = Array7.removeElementsEqualToK(arr, k);
		System.out.println(newArr);
		
	}
}
