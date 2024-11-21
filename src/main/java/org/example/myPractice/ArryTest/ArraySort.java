package org.example.myPractice.ArryTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraySort {
    public static void main(String[] args) {
        Integer[] nums={1,3,7,9};
        Comparator<Integer> comparator = (a, b) -> {
            return Integer.compare(b, a);
        };
        Arrays.sort(nums,(a,b)->Integer.compare(b, a));
        Arrays.sort(nums,comparator);

        Person p1=new Person(2,"Zhang",10);
        Person p2=new Person(1,"lisi",20);
        Comparator<Person> idComparator= (person1,person2)->{
            return Integer.compare(person1.id,person2.id);
        };
        List<Person> personList=new ArrayList<>();
        personList.add(p1);
        personList.add(p2);

        List<Person> newPersonList1=new ArrayList<>(personList);
        newPersonList1.sort(idComparator);

        Comparator<Person> nameComparator=(a,b)->{
            return b.name.compareTo(a.name);
        };

        List<Person> newPersonList2=new ArrayList<>(personList);
        newPersonList2.sort(nameComparator);

    }
}
