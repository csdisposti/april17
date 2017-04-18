package org.example;

import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by cdisp on 4/11/2017.
 */
public class CheckMemberId {

    private int memID = 0;

    protected int readFromDatabase(int memID) throws Exception {
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
            java.sql.ResultSet rs = statement.executeQuery("SELECT * FROM tblMember WHERE MemberID=" + memID + ";");

            if (rs != null) {
                //makes sure the resultSet isn't in the header info
                rs.next();
                    this.memID = rs.getInt("MemberID");
                }

        } catch (Exception e) {
            System.err.println("err");
            e.printStackTrace();
        }
        return this.memID;
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