package org.example.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Alice", 30));

        personList.add(new Person("Charlie", 35));
        personList.add(new Person("Bob", 25));

        personList.sort((a,b)->a.getName().compareTo(b.getName()));
        personList.sort((a,b)->Integer.compare(a.getAge(),b.getAge()));
        personList.forEach(System.out::println);

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        String namesStr=names.stream()
                .collect(Collectors.joining(","));
        System.out.println("----------");
        System.out.println("----------"+namesStr);
        // 使用 Stream 和 Lambda 表达式过滤和转换数据
        List<String> filteredNames = names.stream()
                .filter(x -> x.length()>3)
                .map(name->name.toUpperCase())
                .collect(Collectors.toList());

        // 输出结果
        filteredNames.forEach(name->System.out.println(name));
        System.out.println("----------");
        List<Integer> filteredByAge=personList.stream()
                .filter(person->person.getAge()>=30)
                .map(person->person.getAge())
                .collect(Collectors.toList());
        filteredByAge.forEach(e->System.out.println(e));
    }
}
