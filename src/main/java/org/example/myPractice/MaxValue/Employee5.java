package org.example.myPractice.MaxValue;

import java.util.*;
import java.util.stream.Collectors;

public class Employee5 {
    private int id;
    private String depName;
    private int salary;

    public Employee5(int id, String depName, int salary) {
        this.id = id;
        this.depName = depName;
        this.salary = salary;
    }

    public static HashMap<String, Integer> getMaxSalaryForEveryDP(HashMap<String, List<Employee5>> employeeMap) {
        employeeMap.entrySet().stream()
                .forEach(element -> System.out.println(("key is ") + element));

        employeeMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,  // 部门名称
                        entry -> entry.getValue().stream()
                                .mapToInt(Employee5::getSalary)  // 转换为工资的流
                                .max()  // 获取最高工资
                                .orElse(0),  // 如果没有员工，则返回0
                        (e1, e2) -> e1,  // 合并函数，这里不会发生冲突所以直接返回其中一个即可
                        HashMap::new  // 收集到一个新的HashMap中
                ));
        return null;
    }

    public static void main(String[] args) {
        HashMap<String, List<Employee5>> employeeMap = new HashMap<String, List<Employee5>>();
        Employee5 e1 = new Employee5(1, "dept1", 1000);
        Employee5 e2 = new Employee5(2, "dept1", 2000);
        List<Employee5> EmplyeeList1 = new ArrayList<Employee5>();
        EmplyeeList1.add(e1);
        EmplyeeList1.add(e2);
        Employee5 e3 = new Employee5(3, "dept2", 3000);
        Employee5 e4 = new Employee5(4, "dept2", 4000);
        List<Employee5> EmplyeeList2 = new ArrayList<Employee5>();
        EmplyeeList2.add(e3);
        EmplyeeList2.add(e4);

        employeeMap.put("dept1", EmplyeeList1);
        employeeMap.put("dept2", EmplyeeList2);
        HashMap<String, Integer> maxSalaryMap = getMaxSalaryForEveryDP(employeeMap);

        Optional<Employee5> oldestPerson = EmplyeeList2.stream()
                .max(Comparator.comparingInt(Employee5::getSalary));



    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
