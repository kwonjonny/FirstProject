import java.util.ArrayList;
import java.util.List;

// 배열 → 정수 배열과 정수 k가 주어졌을 때, 
// 배열에서 k 이하인 모든 요소를 제거하고 남은 요소들로 새로운 배열을 만드는 문제
// EX -> 1,3,5,7,9,11의 배열 중 6이상의 배열만 남기고 
// 이하 삭제 
public class Array4 {
	public static List<Integer> remove(int[] arr , int k) {
		
		List<Integer> result = new ArrayList<>();
		
		for(int element : arr) {
			if(element > k) {
				result.add(element);
			}
		}
		return result;
	}
	
}

class Main4 {
	public static void main(String[] args) {
		
		int [] arr = {1,3,5,7,9,11};
		int k = 6;
		
		List<Integer> newArr = Array4.remove(arr, k);
		
		System.out.println(newArr);
	}
}