package org.example.myPractice.MaxValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employee4 {
    private int id;
    private String depName;
    private int salary;

    public Employee4(int id, String depName, int salary) {
        this.id = id;
        this.depName = depName;
        this.salary = salary;
    }

    public static HashMap<String, Integer> getMaxSalaryForEveryDP(HashMap<String, List<Employee4>> employeeMap) {

        employeeMap.entrySet().stream()
                .forEach(element -> System.out.println(("key is ") + element));

        //emplyeemap:key deptid, value list<employee>  employee id,salary,deptName;
        employeeMap.forEach((x, y) -> {
            System.out.println("key is " + x);
            List<Employee4> Elist1 = y.stream()
                    .map(employee -> {
                        int salary = employee.getSalary();
                        if (salary <= 2000) {
                            employee.setSalary(salary + 100);
                            return employee;
                        } else {
                            return employee;
                        }
                    })
                    .collect(Collectors.toList());
            System.out.println("kkkkkkkkkk---------"+Elist1.getClass().getName());
            List<Integer> newy = y.stream()
                    .map(a -> {
                        int salary = a.getSalary();
                        if (salary <= 2000) {
                            return salary + 100;
                        } else {
                            return salary;
                        }
                    })
                    .collect(Collectors.toList());
            System.out.println("key is " + x);
            newy.forEach(newDeptName -> {
                System.out.println("-----" + newDeptName);
            });
        });

        employeeMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,  // 部门名称
                        entry -> entry.getValue().stream()
                                .mapToInt(Employee4::getSalary)  // 转换为工资的流
                                .max()  // 获取最高工资
                                .orElse(0),  // 如果没有员工，则返回0
                        (e1, e2) -> e1,  // 合并函数，这里不会发生冲突所以直接返回其中一个即可
                        HashMap::new  // 收集到一个新的HashMap中
                ));
        return null;
    }

    public static void main(String[] args) {
        HashMap<String, List<Employee4>> employeeMap = new HashMap<String, List<Employee4>>();
        Employee4 e1 = new Employee4(1, "dept1", 1000);
        Employee4 e2 = new Employee4(2, "dept1", 2000);
        List<Employee4> EmplyeeList1 = new ArrayList<Employee4>();
        EmplyeeList1.add(e1);
        EmplyeeList1.add(e2);
        Employee4 e3 = new Employee4(3, "dept2", 3000);
        Employee4 e4 = new Employee4(4, "dept2", 4000);
        List<Employee4> EmplyeeList2 = new ArrayList<Employee4>();
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
