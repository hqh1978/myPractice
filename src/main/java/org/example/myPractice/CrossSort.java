package org.example.myPractice;

import java.util.Arrays;

public class CrossSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};
        crossSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
    public static void crossSort(int[] arr) {
        /**
         * 交叉排序（或称交替排序）是一种排序算法，
         * 它的思想是将数组中的元素按照奇偶位置分成两部分，分别进行排序，
         * 然后合并成一个有序数组。
         * 我们对数组中的偶数索引位置的元素进行排序，然后再对奇数索引位置的元素进行排序。
         */
        int n = arr.length;

        // Sort elements at even indices
        for (int i = 0; i < n; i += 2) {
            int minIndex = i;
            for (int j = i + 2; j < n; j += 2) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                // Swap elements at even indices
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        // Sort elements at odd indices
        for (int i = 1; i < n; i += 2) {
            int minIndex = i;
            for (int j = i + 2; j < n; j += 2) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                // Swap elements at odd indices
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
