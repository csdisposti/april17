package org.example;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.util.Date;
import java.util.Properties;

/**
 * Created by cdisp on 3/15/2017.
 */

/*Testing pages*/

public class Test2  {
    private String eu;
    private String pw;
    private int memNo;
    private int adminID;
    private String adminLev;
    //constructor
    public Test2(String eu, String pw) {

        this.eu = eu;
        this.pw = pw;

    }

    //empty constructor
    public Test2()
    {
        this.eu = null;
        this.pw = null;
    }



    public String getEU() {
        return eu;
    }


    public void setEU(String eu) {
        this.eu = eu;
    }


    public String getPW() {
        return pw;
    }


    public void setPW(String pw) {
        this.pw = pw;
    }




    protected void test() throws Exception
    {
        String email = "kjackson6@psu.edc";
        int mn = 7;
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

        String I = "I";
            //java.sql.ResultSet rs = statement.executeQuery("SELECT * FROM tblCredentials WHERE Email_Username='" + email + "';");
            //java.sql.ResultSet rs = statement.executeQuery("SELECT * FROM tblMember WHERE Email_User='" + email + "';");
           // java.sql.ResultSet rs = statement.executeQuery("SELECT * FROM tblAdmin WHERE MemberNo=" + mn + ";");
            java.sql.ResultSet rs = statement.executeQuery("SELECT * FROM tblAdmin ");
            if (rs != null) {
                rs.next();
                //this.eu = rs.getString("Email_Username");
                //this.pw = rs.getString("MemberPW");
                //this.adminID = rs.getInt("AdministratorID");
                this.adminLev = rs.getString("AdminLevel");
                ResultSetMetaData rsMetaData = rs.getMetaData();
                System.out.print(rsMetaData);
            }



        } catch (Exception e) {
            System.err.println("err");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        //return "<hr><p>User: "+this.eu+"</p><p>Password: "+this.pw+"</p><p>";
        return "<p>Admin Level:" + this.adminLev+"</p>";
    }
}

