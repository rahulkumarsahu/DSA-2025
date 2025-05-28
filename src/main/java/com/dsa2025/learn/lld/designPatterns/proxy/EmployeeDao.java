package com.dsa2025.learn.lld.designPatterns.proxy;

public interface EmployeeDao {

    void create(String client, EmployeeDto obj) throws Exception;
    void delete(String client, int employeeId) throws Exception;
    EmployeeDto get(String client, int employeeId) throws Exception;
}
