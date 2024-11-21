package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamExamples {
    public static void main(String[] args) {
        //示例 1：查找最长的字符串并将其转换为大写
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        Optional<String> maxName = names.stream()
                .max((a, b) -> Integer.compare(a.length(), b.length()))
                .map((e) -> e.toUpperCase());
        System.out.println(maxName);
        maxName.ifPresent(System.out::println);

        Optional<String> longestName = names.stream()
                .max((name1, name2) -> Integer.compare(name1.length(), name2.length()))
                .map(String::toUpperCase);

        List<String> filteredNames = names.stream()
                .filter(element -> element.length() > 4)
                .collect(Collectors.toList());
        filteredNames.forEach(e -> System.out.println(e));

        Optional<String> longestName2 = names.stream()
                .max((name1, name2) -> Integer.compare(name1.length(), name2.length()));
        longestName.ifPresent(name -> System.out.println(name));  // 输出: CHARLIE
    }
}
