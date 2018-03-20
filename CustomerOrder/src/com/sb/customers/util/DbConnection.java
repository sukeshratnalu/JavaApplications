package com.sb.customers.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbConnection {
    public static Connection getDbConnection(){
        Connection connection = null;
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("/home/semanticbits/IdeaProjects/JavaApplications/CustomerOrder/config.properties");
            // load a properties file
            prop.load(input);
            String dbName = prop.getProperty("dbName");
            String connectionObj = prop.getProperty("connectionObg");
            String dbUserName = prop.getProperty("dbUserName");
            String dbPassword = prop.getProperty("dbPassword");
            Class.forName(dbName);
            connection = DriverManager.getConnection(connectionObj, dbUserName, dbPassword);
        }catch (Exception e){
            System.out.println("e"+e);
        }
        return connection;
    }
}
