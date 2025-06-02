package com.dsa2025.learn.lld.designPatterns.facade.example1;

public class EmployeeFacade {
    private EmployeeDao employeeDAO;

    public EmployeeFacade() {
        employeeDAO = new EmployeeDao();
    }

    public void insert() {
        employeeDAO.insert();
    }

    public Employee getEmployeeDetails(int empID) {
        return employeeDAO.getEmployeeDetails(empID);
    }

}
