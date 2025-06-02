package com.dsa2025.learn.lld.designPatterns.facade.example1;

public class EmployeeClient {

    public static void main(String[] args) {
        EmployeeFacade employeeFacade = new EmployeeFacade();

        // Using Facade to insert employee
        employeeFacade.insert();

        // Using Facade to get employee details
        Employee employee = employeeFacade.getEmployeeDetails(121222);
    }

}

/*
 * EmployeeClient doesn't interact directly with EmployeeDAO.
 * EmployeeFacade hides that complexity.
 */
