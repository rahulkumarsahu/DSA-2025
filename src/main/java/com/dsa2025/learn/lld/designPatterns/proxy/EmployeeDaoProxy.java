package com.dsa2025.learn.lld.designPatterns.proxy;

public class EmployeeDaoProxy implements EmployeeDao {

    EmployeeDao employeeDao;

    EmployeeDaoProxy() {
        this.employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public void create(String client, EmployeeDto obj) throws Exception {
        if (client.equals("ADMIN")) {
            employeeDao.create(client, obj);
            return;
        }
        throw new Exception("Access Denied");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        if (client.equals("ADMIN")) {
            employeeDao.delete(client, employeeId);
            return;
        }
        throw new Exception("Access Denied");

    }

    @Override
    public EmployeeDto get(String client, int employeeId) throws Exception {
        if (client.equals("ADMIN") || client.equals("USER")) {
            return employeeDao.get(client, employeeId);
        }
        throw new Exception("Access Denied");
    }
}
