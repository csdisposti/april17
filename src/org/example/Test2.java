package org.example;

import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Date;
import java.util.Properties;

/**
 * Created by cdisp on 3/15/2017.
 */
public class Test2  {
    private String eu;
    private String pw;

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
                rs.next();
                this.eu = rs.getString("Email_Username");
                this.pw = rs.getString("MemberPW");
            }



        } catch (Exception e) {
            System.err.println("err");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "<hr><p>User: "+this.eu+"</p><p>Password: "+this.pw+"</p><p>";
    }
}

