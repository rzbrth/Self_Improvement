package ds.Array.slidingwindow;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Max_Number_Of_All_SubArray {
	public static void main(String[] args) {

		int[] in = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
		int[] result = maxOfAllSubArray(in, 3);
		for (int a : result) {
			System.out.println(a);
		}
	}

	private static int[] maxOfAllSubArray(final int[] a, int k) {

		Objects.requireNonNull(a, "Please make sure array is not null");
		int i = 0, j = 0;
		List<Integer> temp = new LinkedList<>();
		List<Integer> res = new LinkedList<>();

		// If windowSize > length of the array, return 1 element with the max of the
		// array.
		if (k > a.length) {

			return new int[] { Collections.max(Arrays.stream(a).boxed().collect(Collectors.toList())) };
		}
		while (j < a.length) {

			temp.add(a[j]);
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				res.add(Collections.max(temp));
				temp.remove(Integer.valueOf(a[i]));
				i++;
				j++;
			}
		}

		return res.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).toArray();
	}
}
