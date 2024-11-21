package org.example.myPractice;

import java.util.Arrays;

public class AscendingAndDescending {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        int k = 4;

        // Step 1: Split the array into two parts
        int[] firstPart = Arrays.copyOfRange(arr, 0, k);
        int[] secondPart = Arrays.copyOfRange(arr, k, arr.length);

        // Step 2: Sort first part in ascending order
        Arrays.sort(firstPart);

        // Step 3: Sort second part in descending order
        Integer[] IntArr = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        Arrays.sort(IntArr, (a, b) -> Integer.compare( b, a));
       // Arrays.sort(secondPart,(int a, int b)->Integer.compare(b,a));
        reverseArray(secondPart);

        // Step 4: Merge both parts
        int[] result = new int[arr.length];
        System.arraycopy(firstPart, 0, result, 0, firstPart.length);
        System.arraycopy(secondPart, 0, result, firstPart.length, secondPart.length);

        // Print the sorted array
        System.out.println("Sorted array: " + Arrays.toString(result));

    }
    // Helper method to reverse an array
    private static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            // Swap elements at left and right
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
