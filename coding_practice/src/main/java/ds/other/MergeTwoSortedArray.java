package ds.other;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MergeTwoSortedArray {

	static void mergeArrays(int a[], int b[]) {

		List<Integer> data = new LinkedList<>();

		for (int i = 0; i < a.length; i++) {
			data.add(a[i]);
		}
		for (int j = 0; j < b.length; j++) {
			data.add(b[j]);
		}

		data.stream().sorted().forEach(System.out::println);
	}

	static void mergeArrays2(int a[], int b[]) {
		Integer[] data = Stream.concat(Arrays.stream(a).boxed(), Arrays.stream(b).boxed()).sorted().distinct()
				.toArray(Integer[]::new);
		Arrays.asList(data).stream().forEach(System.out::println);
		Integer[] integers = Stream.concat(IntStream.of(a).boxed(), IntStream.of(b).boxed()).sorted().distinct().toArray(Integer[]::new);
	}
	public static void main(String[] args) {
		int a[] = { 1, 3, 5, 7 }, b[] = { 2, 4, 6, 8 };

		

		mergeArrays2(a, b);
	}
}
