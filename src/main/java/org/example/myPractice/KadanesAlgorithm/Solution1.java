package org.example.myPractice.KadanesAlgorithm;

public class Solution1 {
    public static void main(String[] args) {

        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray sum for nums1: " + maxSubArray(nums1)); // Output: 6

       }

    public static int maxSubArray(int[] nums) {
        int totalMax = nums[0];
        int currentMax = nums[0]; //二选一的max，是继续加还是重新开始

        for (int i = 1; i < nums.length; i++) {
            currentMax=Math.max(nums[i],nums[i]+currentMax);
            totalMax=Math.max(currentMax,totalMax);
        }
        return totalMax;
    }
}
