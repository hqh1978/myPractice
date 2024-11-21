package org.example.myPractice.Search;

public class BinarySearch2 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target =7;

        int result = binarySearch(arr, target);

        if (result != -1) {
            System.out.println("目标元素 " + target + " 的索引为 " + result);
        } else {
            System.out.println("目标元素 " + target + " 不存在于数组中");
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {  //以确保在数组的最后一个元素被检查时也能够找到目标值
            int mid = low+(high - low) / 2;
//            int mid = low +(high - low) / 2;  //以避免可能的整数溢出
            System.out.println("arr["+mid+"]="+arr[mid]);
            if (target == arr[mid]) {
                return mid;
            }
            if (target < arr[mid]) {
                high = mid-1;
            }
            if (target > arr[mid]) {
                low = mid+1;
            }

        }
        return -1;
    }

}
