package org.example.myPractice.MaxValue;

import java.util.*;

public class Employee {
    private int id;
    private String depName;
    private int salary;

    public Employee(int id, String depName, int salary) {
        this.id = id;
        this.depName = depName;
        this.salary = salary;
    }

    public static HashMap<String, Integer> getMaxSalaryForEveryDP(HashMap<String, List<Employee>> employeeMap) {

        Set<String> deptSet = employeeMap.keySet();
        Iterator iterator = deptSet.iterator();
        //this is deptName
        String deptName = "";
        int maxS = 0;
        HashMap<String, Integer> maxSalaryMap = new HashMap<String, Integer>();
        while (iterator.hasNext()) {
            deptName = (String) iterator.next();
            List<Employee> employeeList = employeeMap.get(deptName);
            for (Employee e : employeeList) {
                if (e.getSalary() >= maxS) {
                    maxS = e.getSalary();
                }
            }
            maxSalaryMap.put(deptName, maxS);
        }
        return maxSalaryMap;
    }

    public static void main(String[] args) {
        HashMap<String, List<Employee>> employeeMap = new HashMap<String, List<Employee>>();
        Employee e1 = new Employee(1, "dept1", 1000);
        Employee e2 = new Employee(1, "dept1", 2000);
        List<Employee> employeeArrayList1 = new ArrayList<Employee>();
        employeeArrayList1.add(e1);
        employeeArrayList1.add(e2);
        Employee e3 = new Employee(1, "dept2", 3000);
        Employee e4 = new Employee(1, "dept2", 4000);
        List<Employee> employeeArrayList2 = new ArrayList<Employee>();
        employeeArrayList2.add(e3);
        employeeArrayList2.add(e4);

        employeeMap.put("dept1", employeeArrayList1);
        employeeMap.put("dept2", employeeArrayList2);
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
