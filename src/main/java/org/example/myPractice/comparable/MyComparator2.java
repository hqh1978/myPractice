package org.example.myPractice.comparable;

import java.util.*;

public class MyComparator2 {
    public static void main(String[] args) {
        List<String> systems = Arrays.asList("scb", "hkse", "sse", "lsea","lse", "sabre");
        String order = "shlabcdefgijkmnopqrtuvwxyz";
        List<String> sortedSystem = customSort(systems, order);
        sortedSystem.forEach(System.out::println);
    }

    private static List<String> customSort(List<String> systems, String order) {
        char[] charArray = order.toCharArray();
        List<String> sortedSystemList = new ArrayList<>(systems);
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            orderMap.put(charArray[i], i);
        }
        Comparator<String> myComparator = (s1,s2) -> {
            int length1 = s1.length();
            int length2 = s2.length();
            int compareLength = Math.min(length1, length2);
            for (int i = 0; i < compareLength; i++) {
                int position1 = orderMap.get(s1.charAt(i));
                int position2 = orderMap.get(s2.charAt(i));
//                //如果不一样则直接出结果，如果一样一直到不一样为止
                if (position1 != position2) {
                    return Integer.compare(position1,position2);
                }
            }
            return Integer.compare(length1,length2);
        };
        sortedSystemList.sort(myComparator);
        return sortedSystemList;
    }
}
