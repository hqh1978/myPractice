package org.example.myPractice.KadanesAlgorithm;

public class SolutionNew {
    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] result1 = maxSubArrayWithIndices(nums1);
        System.out.println("Max subarray sum for nums1: " + result1[2] + ", Start index: " + result1[0] + ", End index: " + result1[1]);
        // Output: Max subarray sum for nums1: 6, Start index: 3, End index: 6
    }

    public static int[] maxSubArrayWithIndices(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Array should not be empty");
        }

        int totalMax = nums[0];  //记录到目前为止找到的最大子数组和
        int CurrMax = nums[0];  //记录以当前元素结尾的最大子数组和。
        int start = 0;      //记录最大子数组的起始和结束下标。
        int end = 0;
        int tempStart = 0;    //记录当前子数组的起始下标。

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > CurrMax + nums[i]) {
                CurrMax = nums[i];
                tempStart = i;
            } else {
                CurrMax += nums[i];
            }

            if (CurrMax > totalMax) {
                totalMax = CurrMax;
                start = tempStart;
                end = i;
            }
        }

        return new int[]{start, end, totalMax};
    }
}
