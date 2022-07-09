package ds.Array.slidingwindow;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/*
 * Input : arr[] = {-8, 2, 3, -6, 10}, k = 2 Output : -8 0 -6 -6 First negative
 * integer for each window of size k {-8, 2} = -8 {2, 3} = 0 (does not contain a
 * negative integer) {3, -6} = -6 {-6, 10} = -6
 */

public class First_Negative_Num_In_Every_Window_Size_K {

	public static void main(String[] args) {

		int[] arr2 = new int[] { -8, -2, 3, -6, 10 };
		List<Integer> res = firstNegativeNumInEveryWindowSizeK(arr2, 2);
		System.out.println("First negative integer for each window of size 2--->" + res);

		List<Integer> resp = maxNegativeNumInEveryWindowSizeK(arr2, 2);
		System.out.println("Max negative integer for each window of size 2--->" + resp);
	}

	private static List<Integer> firstNegativeNumInEveryWindowSizeK(int[] arr, int windowSize) {

		Objects.requireNonNull(arr, "Please make sure array is not null");

		int i = 0, j = 0;
		List<Integer> temp = new LinkedList<>();
		List<Integer> result = new LinkedList<>();

		while (j < arr.length) {

			if (arr[j] < 0) {
				temp.add(arr[j]);
			}

			if (j - i + 1 < windowSize) {
				j++;
			} else if (j - i + 1 == windowSize) {
				if (temp.isEmpty()) {
					result.add(0);
				} else {
					result.add(temp.get(0));
					temp.remove(Integer.valueOf(arr[i]));
				}
				i++;
				j++;
			}
		}

		return result;
	}

	private static List<Integer> maxNegativeNumInEveryWindowSizeK(int[] arr, int windowSize) {
		Objects.requireNonNull(arr, "Please make sure array is not null");

		int i = 0, j = 0;
		List<Integer> temp = new LinkedList<>();
		List<Integer> result = new LinkedList<>();

		while (j < arr.length) {

			if (arr[j] < 0) {
				temp.add(arr[j]);
			}

			if (j - i + 1 < windowSize) {
				j++;
			} else if (j - i + 1 == windowSize) {
				if (temp.isEmpty()) {
					result.add(0);
				} else {
					result.add(Collections.max(temp));
					temp.remove(Integer.valueOf(arr[i]));
				}
				i++;
				j++;
			}
		}

		return result;
	}
}
