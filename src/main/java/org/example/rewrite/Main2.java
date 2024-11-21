package org.example.rewrite;
import java.util.*;

public class Main2 {

        public static void main(String[] args) {
            List<Dept> deptList = createSampleDeptData();
            Map<String, Long> maxSalaryPerDept = findMaxSalaryForEveryDept(deptList);
            System.out.println(maxSalaryPerDept.size());
            maxSalaryPerDept.forEach((key, value) -> System.out.println(key + ": " + value));
        }


        private static List<Dept> createSampleDeptData() {
            Employee e1 = new Employee("1", "Tom", 1000L);
            Employee e2 = new Employee("2", "Jerry", 2000L);
            Employee e3 = new Employee("3", "Mary", 3000L);
            Employee e4 = new Employee("4", "Clark", 4000L);

            Dept dept1 = new Dept("001", "Tech", createEmployeeList(e1, e2));
            Dept dept2 = new Dept("002", "Market", createEmployeeList(e3, e4));

            return Arrays.asList(dept1, dept2);
        }
        private static List<Employee> createEmployeeList(Employee... employees) {
            return Arrays.asList(employees);
        }

        private static Map<String, Long> findMaxSalaryForEveryDept(List<Dept> deptList) {
            Map<String, Long> maxSalaryPerDept = new HashMap<>();

            deptList.forEach(dept -> {
                long maxSalary = dept.getEmployeeList().stream()
                        .mapToLong(Employee::getSalary)
                        .max()
                        .orElse(0);
                maxSalaryPerDept.put(dept.getdId(), maxSalary);
            });

            return maxSalaryPerDept;
        }

        // Employee class with constructors, getters, and setters omitted for brevity

    }

