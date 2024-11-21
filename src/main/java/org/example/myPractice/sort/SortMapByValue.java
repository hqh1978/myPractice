package org.example.myPractice.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortMapByValue {
    public static void main(String[] args) {
        // 创建一个 Map 并添加一些数据
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 10);
        map.put("banana", 5);
        map.put("cherry", 15);
        List<Map.Entry<String,Integer>>  aList=new ArrayList<>(map.entrySet());


        List<Map.Entry<String,Integer>> mylist=new ArrayList<>(map.entrySet());
        mylist.sort((a,b)->
                //Integer.compare(a.getValue(),b.getValue()));
                b.getValue().compareTo(a.getValue()));


        mylist.forEach(System.out::println);


    }
}
