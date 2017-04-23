package org.example;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.Properties;

/**
 * Created by cdisp on 3/15/2017.
 */
public class Admin {
    private int adminId;
    private int memNo;
    private String adminLev;
    private String adminCom;


    //constructor
    public Admin(int adminId, int memNo, String adminLev, String adminCom) {
        this.adminId = adminId;
        this.memNo = memNo;
        this.adminLev = adminLev;
        this.adminCom = adminCom;
    }

    //empty constructor
    public Admin()
    {
        this.adminId = 0;
        this.memNo = 0;
        this.adminLev = null;
        this.adminCom = null;
    }

    //get Admin Id
    public int getAdminId() {
        return adminId;
    }

    //set Admin Id
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    //get Admin Member Number
    public int getMemNo() {
        return memNo;
    }

    //set Admin Member Number
    public void setMemNo(int memNo) {
        this.memNo = memNo;
    }

    //get Admin Level
    public String getAdminLev() {
        return adminLev;
    }

    //set Admin Level
    public void setAdminLev(String adminLev) {
        this.adminLev = adminLev;
    }

    //get Admin Comments
    public String getAdminCom() {
        return adminCom;
    }

    //set Admin Comments
    public void setAdminCom(String adminCom) {
        this.adminCom = adminCom;
    }

    //read from database by member id
    public void readFromDatabase(int mn) throws Exception
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


            java.sql.ResultSet rs2 = statement.executeQuery("SELECT * FROM tblAdmin WHERE MemberNo="+mn+";");
            //java.sql.ResultSet rs2 = statement.executeQuery("SELECT * FROM AscendDB.tblAdmin INNER JOIN AscendDB.tblMmeber ON tblAdmin.MemberNo = tblMember.MemberID WHERE MemberNo="+mn+";");
            if (rs2 != null) {
                //makes sure the resultSet isn't in the header info
                while (rs2.next()) {

                    this.adminId = rs2.getInt("AdministratorID");
                    this.memNo = rs2.getInt("MemberNo");
                    this.adminLev = rs2.getString("AdminLevel");
                    this.adminCom = rs2.getString("AdminComments");
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
        }
    }

    //add member to admin table
    protected void addToDatabase(int memNo, String adminLev, String adminCom) throws Exception {
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
            String newAdmin = "INSERT INTO AscendDB.tblAdmin (MemberNo, AdminLevel, AdminComments) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(newAdmin);
            ps.setInt(1, memNo);
            ps.setString(2, adminLev);
            ps.setString(3, adminCom);
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

    //update member entry in admin table
    protected void updateAdminInfo(int memNo, String adminLev, String adminCom) throws Exception {
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
            java.sql.ResultSet rs = statement.executeQuery("SELECT * FROM AscendDB.tblAdmin WHERE MemberNo=" + memNo + ";");
            if (rs != null) {
                //makes sure the resultSet isn't in the header info
                while (rs.next()) {
                    this.memNo = rs.getInt("MemberNo");
                }
                String updateMember = "UPDATE AscendDB.tblAdmin SET AdminLevel = ?, AdminComments = ? WHERE MemberNo =" + memNo + ";";
                PreparedStatement pstmt = connection.prepareStatement(updateMember);
                pstmt.setString(1, adminLev);
                pstmt.setString(2, adminCom);
                pstmt.executeUpdate();
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
        }
    }

    //remove member as having "special admin status" as either, admin, mechanic, or instructor
    protected void removeAdminStatus(int adminID, String adminLev, String adminCom) throws Exception {
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
            java.sql.ResultSet rs = statement.executeQuery("SELECT AdministratorID FROM AscendDB.tblAdmin WHERE AdministratorID=" + adminID);
            rs.next();
            this.adminId = rs.getInt("AdministratorID");

            String updateMember = "UPDATE AscendDB.tblAdmin SET AdminLevel = ?, AdminComments = ? WHERE AdministratorID=" + adminId + ";";
            PreparedStatement pstmt = connection.prepareStatement(updateMember);
            pstmt.setString(1, adminLev);
            pstmt.setString(2, adminCom);
            pstmt.executeUpdate();

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

    //get instructor number
    public int getInstructorNumber(String fn, String ln) throws Exception
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

            java.sql.ResultSet rs1 = statement.executeQuery("SELECT * FROM tblMember WHERE tblMember.FName='" + fn +"'AND tblMember.LName='" + ln +"'");
            if (rs1 != null) {
                //makes sure the resultSet isn't in the header info
                while (rs1.next()) {

                    this.memNo = rs1.getInt("MemberID");
                }

            }
            java.sql.ResultSet rs2 = statement.executeQuery("SELECT AdministratorID FROM AscendDB.tblAdmin WHERE tblAdmin.MemberNo='" + memNo +"'");
            if (rs2 != null) {
                //makes sure the resultSet isn't in the header info
                while (rs2.next()) {

                    return this.adminId = rs2.getInt("AdministratorID");
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
        }
            return this.adminId;
    }

    @Override
    public String toString() {

            return "<p>Admin ID: " + this.adminId + "</p><p>Admin Level: " + this.adminLev + "</p><p>Date Set As Admin: " +
                     "</p><p>Admin Comments: " + this.adminCom + "</p>";
        }
    }
