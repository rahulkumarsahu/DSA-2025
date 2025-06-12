package com.dsa2025.learn.lld.designPatterns.objectpool;

import java.util.ArrayList;
import java.util.List;

// Resource Pool Manager
public class DBConnectionPoolManagerTest {

    private List<DBConnection> freeConnections = new ArrayList<>();
    private List<DBConnection> usedConnections = new ArrayList<>();

    private static final int INITIAL_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 6;

    public DBConnectionPoolManagerTest() {
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            freeConnections.add(new DBConnection());
        }
    }

    public DBConnection getDBConnection() {
        if (!freeConnections.isEmpty()) {
            DBConnection dbConnection = freeConnections.remove(0);
            usedConnections.add(dbConnection);
            System.out.println("Connection allocated. In use: " + usedConnections.size());
            return dbConnection;
        } else if (usedConnections.size() < MAX_POOL_SIZE) {
            DBConnection dbConnection = new DBConnection();
            usedConnections.add(dbConnection);
            System.out.println("New connection created. In use: " + usedConnections.size());
            return dbConnection;
        } else {
            System.out.println("Max limit reached. No connection available.");
            return null;
        }
    }

    public void releaseDBConnection(DBConnection dbConnection) {
        if (dbConnection != null && usedConnections.remove(dbConnection)) {
            freeConnections.add(dbConnection);
            System.out.println("Connection released. In use: " + usedConnections.size() + ", Free: " + freeConnections.size());
        }
    }
}
