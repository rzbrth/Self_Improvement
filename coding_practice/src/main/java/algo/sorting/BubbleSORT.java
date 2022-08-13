package algo.sorting;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class BubbleSORT {

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 4, 5, 3, 4, 2, 34, 2, 56, 98, 32, 54};

        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
