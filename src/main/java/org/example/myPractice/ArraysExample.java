package org.example.myPractice;

import java.util.Arrays;

public class ArraysExample{
    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 1, 3};

        // 排序
        Arrays.sort(numbers);
        System.out.println("排序后: " + Arrays.toString(numbers));

        // 二分查找
        int index = Arrays.binarySearch(numbers, 3);
        System.out.println("数字3的索引: " + index);

        // 填充
        int[] filledArray = new int[5];
        Arrays.fill(filledArray, 7);
        System.out.println("填充后的数组: " + Arrays.toString(filledArray));

        // 比较
        int[] numbers1 = {1, 2, 3};
        int[] numbers2 = {1, 2, 3};
        boolean isEqual = Arrays.equals(numbers1, numbers2);
        System.out.println("数组是否相等: " + isEqual);

        // 转换为字符串
        String arrayString = Arrays.toString(numbers);
        System.out.println("数组字符串: " + arrayString);

        // 复制
        int[] copy = Arrays.copyOf(numbers, 3);
        System.out.println("复制的数组: " + Arrays.toString(copy));

        // 数组流
        int sum = Arrays.stream(numbers).sum();
        System.out.println("数组元素和: " + sum);

        // 设置
        int[] setAllArray = new int[5];
        Arrays.setAll(setAllArray, i -> i * 2);
        System.out.println("设置后的数组: " + Arrays.toString(setAllArray));

        // 平行排序
        int[] parallelNumbers = {5, 2, 8, 1, 3};
        Arrays.parallelSort(parallelNumbers);
        System.out.println("平行排序后: " + Arrays.toString(parallelNumbers));

        String str = "abc";
        char a = str.charAt(0);
        char[] charry = str.toCharArray();
        Character character = new Character('A');
    }
}
