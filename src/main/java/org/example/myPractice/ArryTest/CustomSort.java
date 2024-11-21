package org.example.myPractice.ArryTest;

import java.util.*;

public class CustomSort {
    public static void main(String[] args) {
        List<String> inputList = Arrays.asList("scb", "hkse", "sse", "lse", "sabre");
        String orderStr = "shlabcdefgijkmnopqrtuvwxyz";

        List<String> sortedSystems = customSort(inputList, orderStr);

        System.out.println(sortedSystems);
    }

    public static List<String> customSort(List<String> inputList, String orderStr) {
        // 创建字符到索引的映射
        Map<Character, Integer> orderMap = new HashMap<>();

        for(int i=0; i<orderStr.length();i++){
            orderMap.put(orderStr.charAt(i),i);
        }

        // 定义排序比较器
        Comparator<String> comparator = (s1, s2) -> {
            int len1 = s1.length();
            int len2 = s2.length();
            int minLength = Math.min(len1, len2);

            for (int i = 0; i < minLength; i++) {
                int index1 = orderMap.get(s1.charAt(i));
                int index2 = orderMap.get(s2.charAt(i));
                //一样则比较下一个字母
                if (index1 != index2) {
                    return Integer.compare(index1, index2);
                }
            }
            //如果最小长度部分都一样,则长的部分靠前
            return Integer.compare(len1, len2);
        };

        // 对 systems 列表进行排序
        List<String> sortedList = new ArrayList<>(inputList);
        sortedList.sort(comparator);

        return sortedList;
    }
}
