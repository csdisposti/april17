package org.example;

import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by mrkirkland on 4/11/2017.
 */
public class CheckEmail {

    private String email = " ";

    protected String readFromDatabase(String email) throws Exception {
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
            java.sql.ResultSet rs = statement.executeQuery("SELECT * FROM tblCredentials WHERE Email_Username='" + email + "';");

            if (rs != null) {
                //makes sure the resultSet isn't in the header info
                rs.next();
               return this.email = rs.getString("Email_Username");

            }
        } catch (Exception e) {
            System.err.println("err");
            e.printStackTrace();
        }
        return "nr";
    }
}

  /*  public boolean checkCredential(String username, String password) {
        try {
            return password.equals(this.readFromDatabase(username));

        } catch (Exception e) {
            System.err.println("err");
            e.printStackTrace();
        }
        return password.equals(this.readFromDatabase(username));
    }
}

*/