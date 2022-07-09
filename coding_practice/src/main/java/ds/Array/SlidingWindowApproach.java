package ds.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/*
 * Sliding window approach :
 * Array + SubString
 * SubArray | SubString
 * Window size given
 * Finding Max or Min
 */
public class SlidingWindowApproach {

	public static void main(String[] args) {

		int[] arr = new int[] { 100, 200, 300, 400 };
		int max = maxSumSubArray(arr, 2);
		System.out.println("Max sum of a subarray-->" + max);

		int[] arr2 = new int[] { -8, 2, 3, -6, 10 };
		List<Integer> res = firstNegativeNumInEveryWindowSizeK(arr2, 2);
		System.out.println("First negative integer for each window of size 2--->" + res);

		int rs = countOccuranceOfAnagram("aabaabaa", "aaba");
		System.out.println("Annagrams are--->" + rs);

		// System.out.println("+++"+slideWindowFindAnagrams("aabaabaa", "aaba"));

		List<Integer> ann = findAnagrams("aabaabaa", "aaba");
		System.out.println("No of annagram found--->" + ann.size());
		int[] in = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
		int[] result = maxOfAllSubArray(in, 30);
		for (int a : result) {
			System.out.println(a);
		}

	}

	/*
	 * Find maximum (or minimum) sum of a subarray of size k Input : arr[] = {100,
	 * 200, 300, 400} k = 2 Output : 700
	 */

	public static int maxSumSubArray(final int[] a, int windowSize) {

		Objects.requireNonNull(a, "Please make sure array is not null");

		int i = 0, j = 0;
		int sum = 0;
		List<Integer> s = new ArrayList<>();
		while (j < a.length) {
			sum = sum + a[j];
			if (j - i + 1 < windowSize) {
				j++;
			} else if (j - i + 1 == windowSize) {
				s.add(sum);
				sum = sum - a[i];
				i++;
				j++;
			}

		}
		return Collections.max(s);
		// return s.stream().reduce(Integer::max).get();

	}

	/*
	 * Input : arr[] = {-8, 2, 3, -6, 10}, k = 2 Output : -8 0 -6 -6 First negative
	 * integer for each window of size k {-8, 2} = -8 {2, 3} = 0 (does not contain a
	 * negative integer) {3, -6} = -6 {-6, 10} = -6
	 */
	public static List<Integer> firstNegativeNumInEveryWindowSizeK(final int[] a, int windowSize) {

		Objects.requireNonNull(a, "Please make sure array is not null");

		int i = 0, j = 0;
		List<Integer> s = new LinkedList<>();
		List<Integer> result = new LinkedList<>();
		while (j < a.length) {

			if (a[j] < 0) {
				s.add(a[j]);
			}
			if (j - i + 1 < windowSize) {
				j++;
			} else if (j - i + 1 == windowSize) {
				if (s.isEmpty()) {
					result.add(0);
				} else {
					result.add(s.get(0));
					s.remove(Integer.valueOf(a[i]));
				}
				i++;
				j++;

			}
		}

		return result;
	}
	/*
	 * Input: txt = forxxorfxdofr pat = for Output: 3 Explanation: for, orf and ofr
	 * appears in the txt, hence answer is 3.
	 */

	public static int countOccuranceOfAnagram(final String inp, String text) {
		Objects.requireNonNull(inp, "Please make sure input string is not null");
		String[] a = inp.split("");
		int k = text.length();
		int i = 0, j = 0;
		List<String> op = new LinkedList<>();
		List<String> res = new LinkedList<>();
		Map<String, Integer> hist = new HashMap<>();
		Arrays.asList(text.split("")).stream().forEach(x -> hist.put(x, hist.getOrDefault(x, 0) + 1));

		int count = hist.size();
		int ans = 0;
		while (j < a.length) {
			// start of calculations
			// decrease the character count if present in map
			if (hist.containsKey(a[j])) {
				hist.put(a[j], hist.get(a[j]) - 1);
				op.add(a[j]);
			}
			if (hist.get(a[j]) != null && hist.get(a[j]) == 0) {
				count--;
			}
			// end of calculations
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				// calculate result
				if (count == 0) {
					ans++;
					res.add(String.join("", op));

				}
				// handle case for first character of the window
				if (hist.containsKey(a[i])) {
					hist.put(a[i], hist.get(a[i]) + 1);
					if (count == 0) {
						count++;
					}
					op.remove(String.valueOf(a[i]));

				}
				// slide window
				i++;
				j++;
			}
		}

		System.out.println("anagram's are-->");
		res.stream().forEach(System.out::println);
		return ans;
	}

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> rst = new ArrayList<>();
		if (s == null || s.length() == 0 || s.length() < p.length())
			return rst;

		int n = s.length(), m = p.length();

		int[] hash = new int[256]; // prep p hash, tracks char #
		for (char c : p.toCharArray())
			hash[c]++;

		int left = 0, right = 0;
		int count = m; // count of anagram chars. after reducing == 0, found 1 anagram

		while (right < n) {
			// move right side of the window, if c exist in window, decrease count
			char c = s.charAt(right++);
			if (hash[c] > 0) {
				count--;
			}
			hash[c]--; // if not exist in anagram, it'll drop to negative

			// if anagram char count reduced to 0, an anagram in s is found, mark start pos
			if (count == 0) {
				rst.add(left);
			}

			// full range reached, so need to slide the window:
			// 1. get val on left pos
			// 2. add count back (when it is a anagram candidate)
			// 3. + count back to hash
			if (right - left == m) {
				c = s.charAt(left++); // pick up the left char that will be dropped in next step
				if (hash[c] >= 0) {
					count++; // anagram candidate can be == 0 when evenly used; but can also be > 0 when
								// there are extra
				}
				hash[c]++;
			}
		}
		return rst;
	}

	/*
	 * Maximum of all subarrays of size k
	 * https://www.interviewbit.com/problems/sliding-window-maximum/#
	 */
	public static int[] maxOfAllSubArray(final int[] a, int k) {

		Objects.requireNonNull(a, "Please make sure array is not null");
		int i = 0, j = 0;
		List<Integer> temp = new LinkedList<>();
		List<Integer> res = new LinkedList<>();

		// If windowSize > length of the array, return 1 element with the max of the
		// array.
		if (a.length < k) {
			return new int[] { Collections.max(Arrays.stream(a).boxed().collect(Collectors.toList())) };
		}

		while (j < a.length) {

			temp.add(a[j]);
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				res.add(Collections.max(temp));
				temp.remove(Integer.valueOf(a[i]));
				// slide window
				i++;
				j++;
			}

		}
		return res.stream().filter(Objects::nonNull).mapToInt(x -> x).toArray();
	}

}
