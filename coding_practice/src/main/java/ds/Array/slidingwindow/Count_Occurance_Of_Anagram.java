package ds.Array.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Count_Occurance_Of_Anagram {

    public static void main(String[] args) {
        int rs = countOccurrenceOfAnagram("aabaabaa", "aaba");
        System.out.println("Total anagrams are--->" + rs);
    }

    private static int countOccurrenceOfAnagram(String text, String matcher) {

        int windowSize = matcher.length();
        int i = 0, j = 0, ans = 0;
        List<String> temp = new ArrayList<>();
        List<String> res = new ArrayList<>();
        Map<String, Integer> history = new HashMap<>();

        String[] arr = text.split("");

        Arrays.stream(matcher.split("")).forEach(x -> history.put(x, history.getOrDefault(x, 0) + 1));
        int count = history.size();

        while (j < arr.length) {
            // start of calculations
            // decrease the character count if present in map
            if (history.containsKey(arr[j])) {
                history.put(arr[j], history.get(arr[j]) - 1);
                temp.add(arr[j]);
            }
            // Update count if value is 0
            if (history.get(arr[j]) != null && history.get(arr[j]) == 0) {
                count--;
            }
            // end of calculations
            if (j - i + 1 < windowSize) {
                j++;
            } else if (j - i + 1 == windowSize) {
                // calculate result
                if (count == 0) {
                    ans++;
                    res.add(String.join("", temp));
                }

                // handle case for first character of the window
                if (history.containsKey(arr[i])) {
                    history.put(arr[i], history.get(arr[i]) + 1);
                    if (count == 0) {
                        count++;
                    }
                    temp.remove(String.valueOf(arr[i]));
                }
                // Slide window
                i++;
                j++;
            }

        }

        System.out.println("anagram's are-->");
        res.forEach(System.out::println);
        return ans;
    }
}
