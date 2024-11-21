package org.example.myPractice.frequency;



import java.util.*;

public class Main {
    public static void main(String[] args) {
        String str1="hello";
        String str2="world";
        String str3="ai";
        Map<Character,Integer> frequencyMap=new HashMap<>();
        for(Character char1:str1.toCharArray()){
            if(frequencyMap.get(char1)!=null){
                frequencyMap.put(char1,frequencyMap.get(char1)+1);
            }else{
                frequencyMap.put(char1,1);
            }
        }
        for(Character char2:str2.toCharArray()){
            if(frequencyMap.get(char2)!=null){
                frequencyMap.put(char2,frequencyMap.get(char2)+1);
            }else{
                frequencyMap.put(char2,1);
            }
        }
        for(Character char3:str3.toCharArray()){
            if(frequencyMap.get(char3)!=null){
                frequencyMap.put(char3,frequencyMap.get(char3)+1);
            }else{
                frequencyMap.put(char3,1);
            }
        }
        List<Map.Entry<Character,Integer>> entryList= new ArrayList<> (frequencyMap.entrySet());
//        entryList.sort((a,b)->a.getValue().compareTo(b.getValue()));
//        entryList.sort((a,b)->b.getValue().compareTo(a.getValue()));
        entryList.sort((a,b)->{
            return b.getValue()-a.getValue();
        });
        for(Map.Entry<Character,Integer> e :entryList){
            System.out.println(e.getKey()+" frequency is "+e.getValue());
        }
    }
}
