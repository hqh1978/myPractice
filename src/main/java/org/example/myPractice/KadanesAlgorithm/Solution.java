package org.example.myPractice.KadanesAlgorithm;

public class Solution {
    public static void main(String[] args) {

        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray sum for nums1: " + maxSubArray2(nums1)); // Output: 6

        int[] nums2 = {1};
        System.out.println("Maximum subarray sum for nums2: " + maxSubArray(nums2)); // Output: 1
    }

    public static int maxSubArray(int[] nums) {
        int totalMax = nums[0];   //算到的最大值
        int currentMax = nums[0]; //上一次算到的最大值de


        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            totalMax = Math.max(currentMax, totalMax);
        }
        return totalMax;
    }
    //int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    public static int maxSubArray2(int[] nums) {
        int toalMax = nums[0];
        int currentMax = nums[0];
        for (int i=1;i<nums.length;i++) {
            currentMax=Math.max(nums[i],currentMax+nums[i]);
            toalMax=Math.max(currentMax,toalMax);
        }
        return toalMax;
    }

}
