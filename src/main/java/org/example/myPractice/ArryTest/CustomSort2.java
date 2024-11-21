package org.example.myPractice.ArryTest;

import java.util.*;

public class CustomSort2 {
    public static void main(String[] args) {
        //List<String> systems = Arrays.asList("scb", "hkse", "sse", "lse", "sabre");
        List<String> systems = Arrays.asList("scb", "hkse", "sse", "lsea","lse", "sabre");
        String order = "shlabcdefgijkmnopqrtuvwxyz";

        List<String> sortedSystems = customSort(systems, order);
        sortedSystems.forEach(System.out::println);
        System.out.println(sortedSystems);
    }

    public static List<String> customSort(List<String> systems, String order) {
        // 创建字符到索引的映射
        Map<Character, Integer> standMap = new HashMap<>();

        for(int i=0; i<order.length();i++){
            standMap.put(order.charAt(i),i);
        }

        // 定义排序比较器
        Comparator<String> comparator = (s1, s2) -> {
            int len1 = s1.length();
            int len2 = s2.length();
            int minLength = Math.min(len1, len2);

            for (int i = 0; i < minLength; i++) {
                int index1 = standMap.get(s1.charAt(i));
                int index2 = standMap.get(s2.charAt(i));
                //一样则比较下一个字母
                if (index1 != index2) {
                    return Integer.compare(index1,index2);
                }
            }
            //如果最小长度部分都一样,则短的部分靠前
            return Integer.compare(len1,len2);
        };

        // 对 systems 列表进行排序
        List<String> sortedSystems = new ArrayList<>(systems);
        sortedSystems.sort(comparator);

        return sortedSystems;
    }
}
