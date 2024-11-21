package org.example.myPractice.Search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 7;

        int result = binarySearch(arr, target);

        if (result != -1) {
            System.out.println("目标元素 " + target + " 的索引为 " + result);
        } else {
            System.out.println("目标元素 " + target + " 不存在于数组中");
        }
    }
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // 找到目标元素，返回索引
            } else if (arr[mid] < target) {
                low = mid + 1; // 在右半部分继续搜索
            } else {
                high = mid - 1; // 在左半部分继续搜索
            }
        }
        return -1; // 目标元素不存在于数组中
    }
}
