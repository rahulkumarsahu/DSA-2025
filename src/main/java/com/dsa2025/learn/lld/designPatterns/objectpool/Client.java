package com.dsa2025.learn.lld.designPatterns.objectpool;

public class Client {

    public static void main(String[] args) {
        DBConnectionPoolManager poolManager = DBConnectionPoolManager.getInstance();
        DBConnection db1 = poolManager.getDBConnection();
        DBConnection db2 = poolManager.getDBConnection();
        DBConnection db3 = poolManager.getDBConnection();
        DBConnection db4 = poolManager.getDBConnection();
        DBConnection db5 = poolManager.getDBConnection();
        DBConnection db6 = poolManager.getDBConnection();

        // Should fail, max limit reached
        DBConnection db7 = poolManager.getDBConnection();

        // Release one connection and try again
        poolManager.releaseDBConnection(db6);
        DBConnection db8 = poolManager.getDBConnection(); // Should succeed now

    }
}

// The problem here is if this is not a singleton class than it will create multiple pool manager
// DBConnectionPoolManagerTest and multiple stores will create with 3 thread capacity.