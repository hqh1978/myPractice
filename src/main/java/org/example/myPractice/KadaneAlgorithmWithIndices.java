package org.example.myPractice;

public class KadaneAlgorithmWithIndices {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] result = maxSubArray(nums);
        System.out.println("最大子序列起始索引: " + result[0]);
        System.out.println("最大子序列结束索引: " + result[1]);
        System.out.println("最大子序列和: " + result[2]);
    }
    public static int[] maxSubArray(int[] nums) {
        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];
        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxEndingHere + nums[i]) { //越加越小当前元素
                maxEndingHere = nums[i];
                tempStart = i;
            } else {
                //如果比当前的大,则加上这个值。
                maxEndingHere += nums[i];
            }

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = tempStart;
                end = i;
            }
        }

        return new int[]{start, end, maxSoFar}; // 返回起始索引、结束索引和最大和
    }
}
