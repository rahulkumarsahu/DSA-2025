package com.dsa2025.learn.lld.designPatterns.proxy;

public class ProxyDesignPattern {

    public static void main(String[] args) {
        try {
            EmployeeDao employeeDao = new EmployeeDaoProxy();
            employeeDao.create("USER", new EmployeeDto());
            System.out.println("User Created");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
