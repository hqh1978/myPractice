package org.example.MinStepsToZero;

public class MinStepsToZeroNew {
    //一个数组，每步操作是使其中一个数字减p，同时其他数字减q，直到数组所有元素为0，求需要多少步操作
    public static void main(String[] args) {
        int[] nums = {5, 8, 3, 6};
        int p = 2;
        int q = 1;

        int steps = minStepsToZero(nums, p, q);
        System.out.println("需要的步骤数为: " + steps);
    }

    public static int minStepsToZero(int[] nums, int p, int q) {
        int maxSteps = 0;

        // 遍历每个元素，并计算使该元素变为零的操作次数
        for (int i = 0; i < nums.length; i++) {
            int stepsForCurrent = (nums[i] + p - 1) / p; // 使当前元素为零所需的步骤数
            int stepsForOthers = 0;

            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    //实际上这时候其他元素值也变了，先把新的值计算出来。有可能其他元素已经readch到0了
                    int effectiveValue = nums[j] - stepsForCurrent * q;
                    if (effectiveValue > 0) {
                        stepsForOthers = Math.max(stepsForOthers, (effectiveValue + p - 1) / p);
                    }
                }
            }
            // 计算总步骤数
            maxSteps = Math.max(maxSteps, stepsForCurrent + stepsForOthers);
        }

        return maxSteps;
    }

}
