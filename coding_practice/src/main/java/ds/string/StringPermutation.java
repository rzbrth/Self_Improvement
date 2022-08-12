package ds.string;

import java.util.Arrays;

public class StringPermutation {
    public static void main(String[] args) {

        String ourword = "abc";
        String[] ourArray = ourword.split("");
        permute(ourArray, ourArray.length);

    }

    private static void swap(String[] ourarray, int right, int left) {
        String temp = ourarray[right];
        ourarray[right] = ourarray[left];
        ourarray[left] = temp;
    }

    public static void permute(String[] ourArray, int currentPosition) {
        if (currentPosition == 1) {
            System.out.println(Arrays.toString(ourArray));
        } else {
            for (int i = 0; i < currentPosition; i++) {
                // subtract one from the last position (here is where you are
                // selecting the next last item
                permute(ourArray, currentPosition - 1);

                // if it's odd position
                if (currentPosition % 2 == 1) {
                    swap(ourArray, 0, currentPosition - 1);
                } else {
                    swap(ourArray, i, currentPosition - 1);
                }
            }
        }
    }
}
