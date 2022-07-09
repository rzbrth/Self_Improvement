package ds.Array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DeleteElementFromArray {


    private static void deleteElement(int[] arr, int num) {

        int position = findElementIndex(arr, num);
        if (position == -1) {
            throw new RuntimeException("Element not found");
        }
        // Deleting element i.e shifting
        for (int i = position; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    private static int findElementIndex(int[] arr, int num) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }

        return -1;
    }

    private static int[] deleteElement2(int[] arr, int num) {

        int[] copyArray = new int[arr.length - 1];

        // Deleting element i.e shifting
        for (int i = 0, j = 0; i < arr.length; i++) {

            if (arr[i] == num) {
                continue;
            }
            copyArray[j++] = arr[i];
        }
        return copyArray;
    }

    private static int[] deleteElement3(int[] arr, int num) {
        int index = findElementIndex(arr, num);
        return IntStream.range(0, arr.length)
                .filter(x -> x !=index)
                .map(x -> arr[x]).toArray();

    }
    public static void main(String[] args) {

        int arr[] = {10, 50, 30, 40, 20};
       // System.out.println("\n\nArray after deletion");
        //System.out.println(Arrays.toString(deleteElement2(arr, 30)));
        System.out.println(Arrays.toString(deleteElement3(arr, 30)));

    }
}
