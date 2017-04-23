package org.example;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * Created by mrkirkland on 4/11/2017.
 */
public class Credentials {

    private String userName;
    private String pass;

    //constructor
    public Credentials(String userName, String pass) {
        this.userName = userName;
        this.pass = pass;
    }

    //empty constructor
    public Credentials() {
        this.userName = null;
        this.pass = null;
    }

    //get User Name
    public String getUserName() {
        return userName;
    }

    //set User Name
    public void setUserName(String UserName) {
        this.userName = UserName;
    }

    //get password
    public String getPassword() {
        return pass;
    }

    //set Account Type
    public void setPassword(String password) {
        this.pass = password;
    }

    //read credentials from database
    protected String readFromDatabase(String user, String pwd) throws Exception {
        java.sql.Connection connection;
        String username = "MasterAscend";
        String password = "AscendMasterKey";
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("database.properties");
        Properties prop = new Properties();
        prop.load(inputStream);
        String url = prop.getProperty("jdbc.url");
        String driver = prop.getProperty("jdbc.driver");
        Class.forName(driver);
        connection = DriverManager.getConnection(url, username, password);
        try {
            java.sql.Statement statement = connection.createStatement();
            java.sql.ResultSet rs = statement.executeQuery("SELECT * FROM AscendDB.tblCredentials WHERE Email_Username='" + user + "'AND MemberPW='" + pwd + "';");
            if (rs != null) {
                //makes sure the resultSet isn't in the header info
                while (rs.next()) {
                    this.userName = rs.getString("Email_Username");
                }
            }
        } catch (Exception e) {
            System.err.println("err");
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return this.userName;
        }
    }

    //add new user to database
    protected void addToDatabase(String user, String pwd) throws Exception {
        java.sql.Connection connection;
        String username = "MasterAscend";
        String password = "AscendMasterKey";
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("database.properties");
        Properties prop = new Properties();
        prop.load(inputStream);
        String url = prop.getProperty("jdbc.url");
        String driver = prop.getProperty("jdbc.driver");
        Class.forName(driver);
        connection = DriverManager.getConnection(url, username, password);
        try {
            java.sql.Statement statement = connection.createStatement();
            String newCred = "INSERT INTO AscendDB.tblCredentials (Email_Username, MemberPW) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(newCred);
            ps.setString(1, user);
            ps.setString(2, pwd);
            ps.executeUpdate();

        } catch (Exception e) {
            System.err.println("err");
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //member update credentials
    protected void updatePassword(String em, String pw) throws Exception
    {
        java.sql.Connection connection;

        String username = "MasterAscend";
        String password = "AscendMasterKey";
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("database.properties");
        Properties prop = new Properties();
        prop.load(inputStream);
        String url = prop.getProperty("jdbc.url");
        String driver = prop.getProperty("jdbc.driver");
        Class.forName(driver);
        connection = DriverManager.getConnection(url, username, password);

        try {
            java.sql.Statement statement = connection.createStatement();

            String updateMember = "UPDATE AscendDB.tblCredentials SET MemberPW = ? WHERE Email_Username ='" + em + "'";
            PreparedStatement pstmt = connection.prepareStatement(updateMember);
            pstmt.setString(1, pw);
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.err.println("err");
            e.printStackTrace();
        }
    }
}