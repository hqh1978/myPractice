package org.example.myPractice.sort;

import javax.swing.*;
import java.util.Arrays;

public class ArraySort {
    public static void main(String args[]){
        Integer[] arry1 = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        Arrays.sort(arry1,Integer::compare);
        Arrays.sort(arry1,(x,y)->Integer.compare(y,x));
        // 打印排序后的数组
        /**
         * 链式操作：Stream API 支持链式操作，可以轻松组合各种操作（如过滤、映射、排序等）。
         * 函数式编程风格：Stream API 提供了更高层次的抽象，使代码简洁且易于阅读，特别是在进行复杂的数据处理时。
         * 并行处理：在需要时可以通过 .parallelStream() 轻松并行化处理。
         * Arrays.stream(arry1)
         *       .map(e -> {
         *           System.out.println(e);
         *           return e;
         *       })
         *       .toArray();
         *
         * 使用 for 循环进行打印
         * for (int e : arry1) {
         *     System.out.println(e);
         * }
         *优点：
         * 简单直观：for 循环是最常见和直接的方式，适合简单的操作，代码易于理解。
         * 性能优越：for 循环在处理简单操作时，性能通常优于 Stream API，因为没有额外的抽象层。
         * 缺点：
         * 扩展性差：如果需要添加更多的数据处理步骤，for 循环的代码会变得繁琐。
         * 缺乏灵活性：不像 Stream API 那样可以轻松进行并行化处理或组合多种操作。
         *
         **/
        Arrays.stream(arry1)
                .map(e -> {
                    System.out.println(e);
                    return e; // map 操作需要返回一个值
                })
                .toArray();  // 将 Stream 终止操作（如 toArray），否则什么都不会发生

        Double[] arry2 = {3d, 1.2, 4.1, 1.0};
        Arrays.sort(arry2,Double::compare);
        Arrays.sort(arry2,(x,y)->Double.compare(y,x));
        for(double d:arry2){
            System.out.println(d);
        }
    }




}
