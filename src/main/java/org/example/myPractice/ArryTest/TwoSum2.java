package org.example.myPractice.ArryTest;

import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 26;
        int[] result = findIndex(nums, target); 

        for (int e : result) {
            System.out.println(e);
        }
    }

    private static int[] findIndex(int[] nums, int target) {

        int[] result = new int[2];
        // 创建一个 HashMap 来存储数组中的数字及其索引
        // key: 数组中的数字, value: 数字对应的索引
        Map<Integer, Integer> map = new HashMap<>();
        int start=-99;
        int end=-99;
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            int differ = target - nums[i];
            // 检查差值是否在 HashMap 中
            if (map.containsKey(differ)) {
                start= map.get(differ);
                end = i;
                break;
            }
            // 将当前数字及其索引存入 HashMap
            map.put(nums[i], i);
        }
        result[0]=start;
        result[1]=end;
        return result;
    }
}
