package ds.string;

public class ReverseString {
    public static void main(String args[]) {
        System.out.println(reverse("hello"));
    }

    public static String reverse(String text) {
        // Base case:
        // If the string is empty, we're done.
        if (text.length() == 0) {
            return "";
        } else {
            // reverse("hello") = reverse("ello") + "h"
            return reverse(text.substring(1)) + text.charAt(0);
        }
    }
}
