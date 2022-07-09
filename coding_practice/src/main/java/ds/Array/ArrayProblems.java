package ds.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayProblems {

	public static void main(String[] args) {

		int[] a = { 1, 1, 2, 3, 5, 8, 13, 13 };

		countFrequency(a);
		int[] b = { 1, 1, 2, 3, 6, 6 };
		countMissingAndDuplicate(b);
	}

	public static void countFrequency(final int[] a) {

		Objects.requireNonNull(a, "Please make sure array is not null");

		Map<Integer, Integer> ds = new HashMap<>();

		for (int x : a) {
			if (ds.containsKey(x)) {
				ds.put(x, ds.get(x) + 1);
			} else {
				ds.put(x, 1);
			}
		}
		ds.forEach((k, v) -> System.out.println(v + " times " + k));

		List<Integer> dta = Arrays.stream(a).boxed().collect(Collectors.toList());
		Set<Integer> zz = new HashSet<>(dta);
		for (Integer x : zz) {
			System.out.println("Freqency of " + x + ":" + Collections.frequency(dta, x));
		}
		// OR
		Map<Integer, Integer> ds1 = new HashMap<>();

		Arrays.stream(a).boxed().forEach(x -> ds1.put(x, ds1.getOrDefault(x, 0) + 1));
		ds1.forEach((k, v) -> System.out.println(v + " times " + k));

	}
	/*
	 * Find Missing and Duplicate Number in an Array
	 */

	public static void countMissingAndDuplicate(final int[] a) {

		Objects.requireNonNull(a, "Please make sure array is not null");

		Map<Integer, Integer> data = new HashMap<>();
		Arrays.stream(a).boxed().forEach(x -> data.put(x, data.getOrDefault(x, 0) + 1));
		List<Integer> missing = new ArrayList<>();
		List<Integer> duplicate = new ArrayList<>();
		/*
		 * 
		 * // Create perfect array of size n IntStream.rangeClosed(1,
		 * a.length).boxed().forEach(x -> { if (data.containsKey(x) && data.get(x) > 1)
		 * { duplicate.add(x); } else if (!data.containsKey(x)) { missing.add(x); } });
		 * System.out.println("Missing-->"+missing);
		 * System.out.println("Duplicate -->"+duplicate);
		 * 
		 */
		for (int i = 1; i <= a.length; i++) {
			if (!data.containsKey(i)) {
				missing.add(i);
			} else if (data.containsKey(i) && data.get(i) > 1) {
				duplicate.add(i);
			}
		}
		System.out.println("Missing-->" + missing);
		System.out.println("Duplicate -->" + duplicate);

		// Without using Map and using temp array
		/*
		 * Create a temp array temp[] of size n with all initial values as 0. 
		 * Traverse the input array arr[], and do following for each arr[i] 
		 * if(temp[arr[i]] == 0) temp[arr[i]] = 1; 
		 * if(temp[arr[i]] == 1) output “arr[i]” //repeating 
		 * Traverse temp[] and output the array element having value as 0 (This is the missing element)
		 */
		List<Integer> missing1 = new ArrayList<>();
		List<Integer> duplicate1 = new ArrayList<>();
		int[] tempArr = new int[a.length+1];
		for (int i = 0; i < a.length; i++) {
			if (tempArr[a[i]] == 0) {
				tempArr[a[i]] = 1;
			} else if (tempArr[a[i]] == 1) {
				duplicate1.add(a[i]);
			}
		}
		for (int i = 1; i < tempArr.length; i++) {
			if (tempArr[i] == 0) {
				missing1.add(i);
			}
		}
		System.out.println("Duplicate -->" + duplicate1);
		System.out.println("Missing-->" + missing1);
	}

}
