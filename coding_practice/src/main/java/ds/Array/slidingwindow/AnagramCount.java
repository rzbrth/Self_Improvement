package ds.Array.slidingwindow;

import java.util.Arrays;

public class AnagramCount {
    static boolean araAnagram(String s1, String s2) {
        // converting strings to char arrays
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        // sorting both char arrays
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        // Check for equality of strings
        if (Arrays.equals(ch1, ch2))
            return true;
        else
            return false;
    }

    static int countAnagrams(String text, String word) {
        int N = text.length();
        int n = word.length();

        // Initialize result
        int res = 0;

        for (int i = 0; i <= N - n; i++) {

            String s = text.substring(i, i + n);

            // Check if the word and substring are
            // anagram of each other.
            if (araAnagram(word, s))
                res++;
        }
        return res;
    }

    // Driver code
    public static void main(String args[]) {
        String text = "forxxorfxdofr";
        String word = "for";
        System.out.print(countAnagrams(text, word));
    }
}
