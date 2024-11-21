package org.example.myPractice;

public class KMPAlgorithm {
    public static int countOccurrences(String str, String subStr) {
        int[] lps = computeLPSArray(subStr);
        int i = 0; // index for str
        int j = 0; // index for subStr
        int count = 0;

        while (i < str.length()) {
            if (subStr.charAt(j) == str.charAt(i)) {
                i++;
                j++;
            }

            if (j == subStr.length()) {
                count++;
                j = lps[j - 1];
            } else if (i < str.length() && subStr.charAt(j) != str.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return count;
    }

    private static int[] computeLPSArray(String pat) {
        int length = 0;
        int i = 1;
        int[] lps = new int[pat.length()];
        lps[0] = 0;

        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = length;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        String str = "ababcabcab";
        String subStr = "abc";
        int count = countOccurrences(str, subStr);
        System.out.println("子字符串出现的次数: " + count); // 输出: 2
    }
}
