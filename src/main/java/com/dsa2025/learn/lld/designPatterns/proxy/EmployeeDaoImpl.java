package com.dsa2025.learn.lld.designPatterns.proxy;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void create(String client, EmployeeDto obj) throws Exception {
        System.out.println("User is created");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        System.out.println("User is deleted");
    }

    @Override
    public EmployeeDto get(String client, int employeeId) throws Exception {

        return new EmployeeDto();
    }
}
