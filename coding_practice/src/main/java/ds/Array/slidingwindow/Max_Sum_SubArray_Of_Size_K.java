package ds.Array.slidingwindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/*
 * Sliding window approach :
 * Array + SubString
 * SubArray | SubString
 * Window size given
 * Finding Max or Min
 */
public class Max_Sum_SubArray_Of_Size_K {

	public static void main(String[] args) {

		int[] arr = new int[] { 100, 200, 300, 400 };
		int max = maxSumSubArray(arr, 2);
		System.out.println("Max sum of a subarray-->" + max);

	}

	private static int maxSumSubArray(int[] arr, int k) {

		Objects.requireNonNull(arr, "Please make sure array is not null");

		int i = 0, j = 0, sum = 0;
		List<Integer> s = new ArrayList<>();

		while (j < arr.length) {
			sum = sum + arr[j];
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				s.add(sum);
				sum = sum - arr[i];
				i++;
				j++;

			}
		}
		return Collections.max(s);
	}
}
