package org.example.myPractice.MaxValue;

import java.util.*;

public class Employee3 {
    private int id;
    private String depName;
    private int salary;

    public Employee3(int id, String depName, int salary) {
        this.id = id;
        this.depName = depName;
        this.salary = salary;
    }

    public static Map<String, Integer> getMaxSalaryForEveryDP(HashMap<String, List<Employee3>> employeeMap) {
        // 用于存储每个部门的最高工资
        Map<String, Integer> maxMap = new HashMap<>();
        Set<String> keys = employeeMap.keySet();
        for (String key : keys) {
            int maxSalary = 0;
            List<Employee3> employee3List = employeeMap.get(key);
            for (Employee3 e3 : employee3List) {
                int salary = e3.getSalary();
                if (salary > maxSalary) {
                    maxSalary = salary;
                }
            }
            maxMap.put(key, maxSalary);
        }

        maxMap.forEach((x, y) -> {
            System.out.println("deptnameis " + x);
            System.out.println("maxSalryis" + y);

        });
        return maxMap;
    }

    public static void main(String[] args) {
        HashMap<String, List<Employee3>> employeeMap = new HashMap<String, List<Employee3>>();
        Employee3 e1 = new Employee3(1, "dept1", 1000);
        Employee3 e2 = new Employee3(2, "dept1", 2000);
        List<Employee3> EmplyeeList1 = new ArrayList<Employee3>();
        EmplyeeList1.add(e1);
        EmplyeeList1.add(e2);
        Employee3 e3 = new Employee3(3, "dept2", 3000);
        Employee3 e4 = new Employee3(4, "dept2", 4000);
        List<Employee3> EmplyeeList2 = new ArrayList<Employee3>();
        EmplyeeList2.add(e3);
        EmplyeeList2.add(e4);

        employeeMap.put("dept1", EmplyeeList1);
        employeeMap.put("dept2", EmplyeeList2);
        Map<String, Integer> maxSalaryMap = getMaxSalaryForEveryDP(employeeMap);
//        maxSalaryMap.forEach((x,y)->{
//            System.out.println("deptnameis "+x);
//            System.out.println("maxSalryis" +y);
//
//        });

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
