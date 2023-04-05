import java.util.Arrays;

public class Array3 {
	public static int getTotalLength(int [] arr) {
		
		int currentMax = arr[0];
		int globalMax = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			currentMax = Math.max(arr[i], currentMax+arr[i]);
			globalMax = Math.max(globalMax, currentMax);
		}
		return globalMax;
	}
}
