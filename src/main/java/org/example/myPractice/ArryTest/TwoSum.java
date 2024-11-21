package org.example.myPractice.ArryTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = findIndex(nums, target);

        for (int e : result) {
            System.out.println(e);
        }
    }

    private static int[] findIndex(int[] nums, int target) {

        int[] result = {-1, -1};
        // 创建一个 HashMap 来存储数组中的数字及其索引
        // key: 数组中的数字, value: 数字对应的索引
        Map<Integer, Integer> map = new HashMap<>();
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            int differ = target - nums[i];
            // 检查差值是否在 HashMap 中
            if (map.containsKey(differ)) {
                result[0] = map.get(differ);
                result[1] = i;
                return result;
            }
            // 将当前数字及其索引存入 HashMap
            map.put(nums[i], i);
        }
        return result;
    }
}
