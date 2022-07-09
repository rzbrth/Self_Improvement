package testcode;

import java.util.*;
import java.util.stream.IntStream;

public class Abc {

	public static void main(String[] args) {

//		String input = "aacdbbc";
//		String op = "";
//		Map<String, Integer> data = new HashMap<>();
//		Arrays.asList(input.split("")).stream().forEach(x -> data.put(x, data.getOrDefault(x, 0) + 1));
//
//		for (Map.Entry<String, Integer> mp : data.entrySet()) {
//			op = op.concat(mp.getKey()).concat(String.valueOf(mp.getValue()));
//		}
//		System.out.println(op);
//
//		int arr[] = { 12, 13, 3, 10, 34, 1 };
//		int res =IntStream.of(arr).sorted().skip(1).findFirst().orElse(Integer.MAX_VALUE);
//		System.out.println(res);
//
		Integer a = new Integer(1);
		Integer b = new Integer(1);

		System.out.println("a==b? " + (a==b));
		System.out.println("a==b? " + a.equals(b));


		int[] q=IntStream.range(0,10).map(x -> x*x).toArray();
		Integer c = Integer.valueOf(1);
		Integer d = Integer.valueOf(1);

		System.out.println("c==d? " + (c==a));
		System.out.println("a==b? " + c.equals(d));

		Set<Integer> s = new HashSet<>();
		s.add(a);
		s.add(b);
		System.out.println(s.size());

	}

}
