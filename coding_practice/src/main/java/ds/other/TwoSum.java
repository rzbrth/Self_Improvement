package ds.other;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/
public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {

		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					res[0] = nums[i];
					res[1] = nums[j];
					return res;
				}
			}

		}
		return res;
	}

	public int[] twoSums(int[] nums, int target) {
		Map<Integer, Integer> mp = new HashMap<>();
		int[] empty = {};
		for (int i = 0; i < nums.length; i++) {
			if (mp.containsKey(target - nums[i])) {
				int[] out = { mp.get(target - nums[i]) - 1, i };
				return out;
			}
			mp.put(nums[i], i + 1);
		}

		return empty;
	}

	public static void main(String args[]) {
		int A[] = {2,7,11,15};
        int sum = 13;
        int[] res=twoSum(A,sum);
        for(int x: res) {
        	System.out.println(x);
        }
	}
}
