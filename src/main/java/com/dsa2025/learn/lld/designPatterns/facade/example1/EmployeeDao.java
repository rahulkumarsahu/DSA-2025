package com.dsa2025.learn.lld.designPatterns.facade.example1;

public class EmployeeDao {
    public void insert() {
        System.out.println("Inserting into Employee Table");
    }

    public Employee getEmployeeDetails(int empID) {
        // Simulate fetch from DB
        System.out.println("Fetching Employee Details for ID: " + empID);
        return new Employee(); // returning dummy employee
    }

}
