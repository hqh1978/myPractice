package org.example.myPractice.ArryTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoSum3 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
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
            map.put(target-nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            int diff=target-nums[i];
            if(map.containsKey(diff)){
                start=map.get(diff);
                end=i;
                break;
            }
        }

        map.forEach((key,value)->{
            System.out.println("key="+key+",value="+value);
        });

        return result;
    }
}
