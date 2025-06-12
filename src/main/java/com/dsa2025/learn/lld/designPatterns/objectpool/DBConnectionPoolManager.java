package com.dsa2025.learn.lld.designPatterns.objectpool;

import java.util.ArrayList;
import java.util.List;

public class DBConnectionPoolManager {

    private List<DBConnection> freeConnectionsInPool = new ArrayList<>();
    private List<DBConnection> connectionsCurrentlyInUse = new ArrayList<>();

    private static final int INITIAL_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 6;

    // Volatile Singleton instance
    private static volatile DBConnectionPoolManager dbConnectionPoolManagerInstance = null;

    // Private constructor
    private DBConnectionPoolManager() {
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            freeConnectionsInPool.add(new DBConnection());
        }
    }

    // Double-checked locking for thread-safe Singleton
    public static DBConnectionPoolManager getInstance() {
        if (dbConnectionPoolManagerInstance == null) {
            synchronized (DBConnectionPoolManager.class) {
                if (dbConnectionPoolManagerInstance == null) {
                    dbConnectionPoolManagerInstance = new DBConnectionPoolManager();
                }
            }
        }
        return dbConnectionPoolManagerInstance;
    }

    // Synchronized method to get a DBConnection
    public synchronized DBConnection getDBConnection() {
        if (!freeConnectionsInPool.isEmpty()) {
            DBConnection dbConnection = freeConnectionsInPool.remove(0);
            connectionsCurrentlyInUse.add(dbConnection);
            System.out.println("Connection allocated. In use: " + connectionsCurrentlyInUse.size());
            return dbConnection;
        } else if (connectionsCurrentlyInUse.size() < MAX_POOL_SIZE) {
            DBConnection dbConnection = new DBConnection();
            connectionsCurrentlyInUse.add(dbConnection);
            System.out.println("New connection created. In use: " + connectionsCurrentlyInUse.size());
            return dbConnection;
        } else {
            System.out.println("Max limit reached. No connection available.");
            return null;
        }
    }

    // Synchronized method to release a DBConnection
    public synchronized void releaseDBConnection(DBConnection dbConnection) {
        if (dbConnection != null && connectionsCurrentlyInUse.remove(dbConnection)) {
            freeConnectionsInPool.add(dbConnection);
            System.out.println("Connection released. In use: " + connectionsCurrentlyInUse.size()
                    + ", Free: " + freeConnectionsInPool.size());
        }
    }
}
