package org.example.myPractice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubstringCount {
    public static void main(String[] args) {
        String str = "ababcabcab";
        String subStr = "bc";
        int count = countRe(str, subStr);
        System.out.println("子字符串出现的次数: " + count); // 输出: 2
    }

    public static int countRepeat(String str, String subStr) {
        if (subStr.isEmpty()) {
            return 0;
        }
        int count = 0;         //出现的次数
        int position = 0;
        while ((position = str.indexOf(subStr, position)) != -1) {
            count++;
            position = position + subStr.length();
        }
        return count;
    }

    public static int countRe(String str, String subStr) {
        //String str = "ababcabcab";
        int count = 0;
        int position = 0;
        while ((position = str.indexOf(subStr, position)) != -1) {
            count++;
            position = position + subStr.length();
        }
        return count;
    }

    public static int countRe2(String str, String subStr) {
        //String str = "ababcabcab";
        if (subStr.isEmpty()) {
            return 0;
        }

        Pattern pattern = Pattern.compile(Pattern.quote(subStr));
        Matcher matcher = pattern.matcher(str);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;
    }


}
