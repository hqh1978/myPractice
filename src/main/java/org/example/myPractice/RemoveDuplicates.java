package org.example.myPractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String input = "programming";
        List<String> myList=new ArrayList<>();
        String result = removeDuplicates(input);
        System.out.println(result); // 输出: progamin
    }
    public static String removeDuplicates(String input) {
        Set<Character> seen = new HashSet<>();
        StringBuilder result = new StringBuilder();
        char[] chars=input.toCharArray();

        for (char c : chars) {
            if (seen.add(c)) { // 如果字符未存在于 Set 中，则添加到结果中
                result.append(c);
            }
        }

        return result.toString();
    }
}
