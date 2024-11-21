package org.example.rewrite;

import java.util.List;

public class Dept {
    private String dId;
    private String dName;
    private List<Employee> employeeList;

    public Dept (String dId,String dName,List<Employee> employeeList){
        this.dId=dId;
        this.dName=dName;
        this.employeeList=employeeList;

    };
    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
