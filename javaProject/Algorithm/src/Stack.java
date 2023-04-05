import java.util.ArrayList;
import java.util.List;

// 정수 배열과 정수 k가 주어졌을 때, 배열에서 k와 일치하는 요소를 
//모두 삭제하고 삭제한 후의 배열을 반환하는 메소드를 구현하는 문제입니다.

//예를 들어, 주어진 배열이 [1, 2, 3, 4, 2, 5]이고, k가 2이면, 
//반환되는 배열은 [1, 3, 4, 5]입니다.

//여기서는 ArrayList를 사용하여 문제를 해결할 수 있습니다. 
//ArrayList에서는 요소를 삭제하기 위해 remove() 메소드를 사용할 수 있습니다.
public class Stack {
	public static List<Integer> removeEqualK(int [] arr, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		for(int elements : arr) {
			if(elements != k) {
				result.add(elements);
			}
		}
		return result;	
	}

}

class Main10 {
	public static void main(String [] args) {
	
		int [] arr = {1,2,3,4,2,5};
		int k = 2;
		List<Integer> newArr = Stack.removeEqualK(arr,k);
		System.out.println(newArr);
		
	}
}