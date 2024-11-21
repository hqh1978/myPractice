package org.example.myPractice.MaxValue;

import java.util.*;
import java.util.stream.Collectors;

public class Employee2 {
    private int id;
    private String depName;
    private int salary;

    public Employee2(int id, String depName, int salary) {
        this.id = id;
        this.depName = depName;
        this.salary = salary;
    }

    public static HashMap<String, Integer> getMaxSalaryForEveryDP(HashMap<String, List<Employee2>> employeeMap) {

        HashMap<String, Integer> maxSalaryMap=new HashMap<>();
        employeeMap.entrySet().stream()
                .forEach(element -> System.out.println(("key is ") + element));
        for(Map.Entry<String,List<Employee2>> setElement:employeeMap.entrySet()){
           List<Employee2> employee2List=setElement.getValue();
           int maxsalaryDept=0;
           for(Employee2 em:employee2List){
               if(em.getSalary()>maxsalaryDept){
                   maxsalaryDept=em.getSalary();
               }
           }
            maxSalaryMap.put(setElement.getKey(),maxsalaryDept);
           maxsalaryDept=0;
        }




//        employeeMap.entrySet().stream()
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,  // 部门名称
//                        entry -> entry.getValue().stream()
//                                .mapToInt(Employee2::getSalary)  // 转换为工资的流
//                                .max()  // 获取最高工资
//                                .orElse(0),  // 如果没有员工，则返回0
//                        (e1, e2) -> e1,  // 合并函数，这里不会发生冲突所以直接返回其中一个即可
//                        HashMap::new  // 收集到一个新的HashMap中
//                ));
        return maxSalaryMap;
    }

    public static void main(String[] args) {
        HashMap<String, List<Employee2>> employeeMap = new HashMap<String, List<Employee2>>();
        Employee2 e1 = new Employee2(1, "dept1", 1000);
        Employee2 e2 = new Employee2(2, "dept1", 2000);
        List<Employee2> EmplyeeList1 = new ArrayList<Employee2>();
        EmplyeeList1.add(e1);
        EmplyeeList1.add(e2);
        Employee2 e3 = new Employee2(3, "dept2", 3000);
        Employee2 e4 = new Employee2(4, "dept2", 4000);
        List<Employee2> EmplyeeList2 = new ArrayList<Employee2>();
        EmplyeeList2.add(e3);
        EmplyeeList2.add(e4);

        employeeMap.put("dept1", EmplyeeList1);
        employeeMap.put("dept2", EmplyeeList2);
        HashMap<String, Integer> maxSalaryMap = getMaxSalaryForEveryDP(employeeMap);

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
