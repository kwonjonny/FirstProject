import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//
//다음은 배열과 정수 k가 주어졌을 때, 배열에서 k 이하인 요소를 모두 제거하고,
//남은 요소들을 역순으로 정렬하여 새로운 배열을 만드는 문제입니다. 

//이 문제는 배열과 k를 매개변수로 받는 함수를 구현하고, 이 함수를 호출하는 main() 함수를 작성하면 
//됩니다.

//문제: 정수 배열 arr과 정수 k가 주어졌을 때, arr에서 k 이하인 모든 요소를 제거하고, 
//남은 요소들을 역순으로 정렬하여 새로운 배열을 만드는 함수 
//removeElementsLessThanKAndReverseSort(int[] arr, int k)를 구현하세요. 
//이 함수는 새로운 배열을 반환해야 합니다.

//입력 예시 : 
//int[] arr = {1, 7, 3, 9, 5, 6};
//int k = 5;
//int[] newArr = removeElementsLessThanKAndReverseSort(arr, k);
//System.out.println(Arrays.toString(newArr));
//예시 출력 [ 9 7 6 ]
public class Array5 {
	public static List<Integer> removeElementsLessThanKAndReverseSort(int [] arr, int k) {
		
		ArrayList<Integer> result = new ArrayList<>();
		for(int element : arr) {
			if(element > k) {
				result.add(element);
			}
		}
		Collections.sort(result);
		Collections.reverse(result);
		return result;
	}
	
}

class Main5 {
	public static void main(String [] args) {
		
		int[] arr = {1,7,3,9,5,7};
		int k = 5;
		List<Integer> newArr = Array5.removeElementsLessThanKAndReverseSort(arr, k);
	    System.out.println(newArr);
	}
}