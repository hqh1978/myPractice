package org.example.myPractice.frequency;

import java.util.HashMap;
import java.util.Map;

public class CountFrequency1 {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "world";
        String str3 = "ai";
        Map<Character,Integer> frequencyMap=new HashMap<>();
        fillMaps(str1,frequencyMap);
        fillMaps(str2,frequencyMap);
        fillMaps(str3,frequencyMap);
    }

    private  static  void fillMaps(String str1,Map<Character,Integer> frequencyMap) {
        for(int i=0;i<str1.length();i++){
            if(frequencyMap.containsKey(str1.charAt(i))){
                frequencyMap.put(str1.charAt(i), frequencyMap.get(str1.charAt(i))+1);
            }else{
                frequencyMap.put(str1.charAt(i), 1);
            }
        }
    }
}
