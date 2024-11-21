package org.example.rewrite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        build();
        System.out.println("Hello world!");
    }

    private static void build() {
        Employee e1 = new Employee("1", "Tom", 1000L);
        Employee e2 = new Employee("2", "Jerry", 2000L);
        Employee e3 = new Employee("3", "Mary", 3000L);
        Employee e4 = new Employee("4", "Clark", 4000L);

        List<Employee> employeeList1 = new ArrayList<>();
        employeeList1.add(e1);
        employeeList1.add(e2);
        Dept dept1 = new Dept("001", "Tech", employeeList1);

        List<Employee> employeeList2 = new ArrayList<>();
        employeeList2.add(e3);
        employeeList2.add(e4);
        Dept dept2 = new Dept("002", "Market", employeeList2);

        List<Dept> deptList = new ArrayList<>();
        deptList.add(dept1);
        deptList.add(dept2);
        Map<String, Long> maxSalaryPerDept = findMaxSalaryForEveryDept(deptList);
        System.out.println(maxSalaryPerDept.size());
    }

    private static Map<String, Long> findMaxSalaryForEveryDept(List<Dept> deptList) {
        Map<String, Long> maxSalaryPerDept = new HashMap<>();

        for (Dept dept : deptList) {
            long maxSalary = 0;
            for (Employee e : dept.getEmployeeList()) {
                if (e.getSalary() > maxSalary) {
                    maxSalary = e.getSalary();
                }
            }
            maxSalaryPerDept.put(dept.getdId(), maxSalary);
        }
        return maxSalaryPerDept;
    }

    private static Employee fillEmployee(Employee employee, String id, String name, long salary) {
        employee.setId(id);
        employee.setName(name);
        employee.setSalary(salary);
        return employee;
    }

    private static Dept fillDept(Dept dept, String id, String name) {
        dept.setdId(id);
        dept.setdName(name);
        return dept;
    }
}
