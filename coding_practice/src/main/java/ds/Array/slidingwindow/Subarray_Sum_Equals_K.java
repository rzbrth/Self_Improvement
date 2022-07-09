package ds.Array.slidingwindow;

/*
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * https://www.youtube.com/watch?v=bqN9yB0vF08
 */

public class Subarray_Sum_Equals_K {

    public static void main(String[] args)
    {
        int arr[] = { 1,2,3};
        int k = 3;
        int n = arr.length;
        int res = 0;

        // calculate all subarrays
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                // calculate required sum
                sum += arr[j];
                // check if sum is equal to required sum
                if (sum == k)
                    res++;
            }
        }
        System.out.println(res);
    }
}