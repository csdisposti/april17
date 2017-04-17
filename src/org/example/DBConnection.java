package org.example;

import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.*;


public class DBConnection  {

    static Connection conn;

    public static void main(String[] args) throws Exception {

    String username = "MasterAscend";
    String password = "AscendMasterKey";
    InputStream inputStream = DBConnection.class.getClassLoader().getResourceAsStream("database.properties");
    Properties prop = new Properties();
        prop.load(inputStream);
    String url = prop.getProperty("jdbc.url");
    String driver = prop.getProperty("jdbc.driver");
        Class.forName(driver);
    conn = DriverManager.getConnection(url, username, password);
    }
    }


