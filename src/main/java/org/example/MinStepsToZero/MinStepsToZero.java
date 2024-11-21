package org.example.MinStepsToZero;

public class MinStepsToZero {
    //一个数组，每步操作是其中一个数字减p其他数字减q，直到数组所有元素为0，求需要多少步操作
    public static void main(String[] args) {
        int[] nums = {5, 8, 3, 6};
        int p = 2;
        int q = 1;

        int steps = minStepsToZero(nums, p, q);
        System.out.println("需要的步骤数为: " + steps);
    }

    public static int minStepsToZero(int[] nums, int p, int q) {

        int maxSteps = 0;

        // 计算每个元素从当前值减少到0所需的步骤数，并找出最大值
        for (int num : nums) {
            int steps = num / p; // 第一个数字减去P的次数
            int othersSteps = 0;  //其他数字减q 的次数
            for (int other : nums) {
                if (other != num) {
                    othersSteps += other / q;
                }
            }
            int totalSteps = Math.max(steps, othersSteps); // 最小操作次数
            maxSteps = Math.max(maxSteps, totalSteps);
        }

        return maxSteps;
    }
}
