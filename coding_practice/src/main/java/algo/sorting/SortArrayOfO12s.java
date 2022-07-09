package algo.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortArrayOfO12s {

    private static void sortArrayOfO12s(int[] array) {

        Objects.nonNull(array);
        int i=0, c0 = 0, c1 = 0, c2 = 0;
        // Count the number of 0s, 1s and 2s in the array
        for (i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                c0++;
            } else if (array[i] == 1) {
                c1++;
            } else if (array[i] == 2) {
                c2++;
            }
        }
        // Update the array
        i = 0;
        // Store all the 0s in the beginning
        while (c0 > 0){
            array[i++] = 0;
            c0 --;
        }
        // Store all the 1s in the beginning
        while (c1 > 0){
            array[i++] = 1;
            c1 --;
        }
        // Store all the 2s in the beginning
        while (c2 > 0){
            array[i++] = 2;
            c2 --;
        }
    }
    public static void main(String[] args) {
        int[] array2 = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        sortArrayOfO12s(array2);
        System.out.println(Arrays.toString(array2));
    }
}
