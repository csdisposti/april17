package org.example;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * Created by cdisp on 3/15/2017.
 */
public class Member {

    private int memId;         //MemberID
    private int acctNo;        //AccountNo
    private String emailUsNa;   //Email_UserName
    private String fName;       //Fname
    private String lName;       //Lname
    private String phone1;      //Phone1
    private String phone2;      //Phone2
    private String emerCoNa;    //EmergencyContactName
    private String emerCoNo;     //Emergency ContactNumber
    private String memCom;      //MemberComments

    //constructor
    public Member(int memId, int acctNo, String emailUsNa, String fName, String lName, String phone1, String phone2, String emerCoNa, String emerCoNo, String memCom) {
        this.memId = memId;
        this.acctNo = acctNo;
        this.emailUsNa = emailUsNa;
        this.fName = fName;
        this.lName = lName;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.emerCoNa = emerCoNa;
        this.emerCoNo = emerCoNo;
        this.memCom = memCom;
    }

    //empty constructor
    public Member() {
        this.memId = 0;
        this.acctNo = 0;
        this.emailUsNa = null;
        this.fName = null;
        this.lName = null;
        this.phone1 = null;
        this.phone2 = null;
        this.emerCoNa = null;
        this.emerCoNo = null;
        this.memCom = null;
    }

    //get Member's ID
    public int getMemId() {
        return memId;
    }

    //set Member's ID
    public void setMemId(int memId) {
        this.memId = memId;
    }

    //get Member's Account Number
    public int getAcctNo() {
        return acctNo;
    }

    //set Member's Account Number
    public void setAcctNo(int acctNo) {
        this.acctNo = acctNo;
    }

    //get Member's Email/User Name
    public String getEmailUsNa() {
        return emailUsNa;
    }

    //set Member's Email/User Name
    public void setEmailUsNa(String emailUsNa) {
        this.emailUsNa = emailUsNa;
    }

    //get Member's First Name
    public String getfName() {
        return fName;
    }

    //set Member's First Name
    public void setfName(String fName) {
        this.fName = fName;
    }

    //get Member's Last Name
    public String getlName() {
        return lName;
    }

    //set Member's Last Name
    public void setlName(String lName) {
        this.lName = lName;
    }

    //get Member's Phone 1
    public String getPhone1() {
        return phone1;
    }

    //set Member's Phone 1
    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    //get Member's Phone 2
    public String getPhone2() {
        return phone2;
    }

    //set Member's Phone 2
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    //get Member's Emergency Contact Name
    public String getEmerCoNa() {
        return emerCoNa;
    }

    //set Member's Emergency Contact Name
    public void setEmerCoNa(String emerCoNa) {
        this.emerCoNa = emerCoNa;
    }

    //get Member's Emergency Contact Nunmber
    public String getEmerCoNo() {
        return emerCoNo;
    }

    //set Member's Emergency Contact Number
    public void setEmerCoNo(String emerCoNo) {
        this.emerCoNo = emerCoNo;
    }

    //get Member's Comments
    public String getMemCom() {
        return memCom;
    }

    //set Member's Comments
    public void setMemCom(String memCom) {
        this.memCom = memCom;
    }

    //read member info from database
    protected void readFromDatabase(String user) throws Exception {
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
            java.sql.ResultSet rs = statement.executeQuery("SELECT * FROM tblMember WHERE Email_User='" + user + "';");

            if (rs != null) {
                //makes sure the resultSet isn't in the header info
                while (rs.next()) {

                    this.memId = rs.getInt("MemberID");
                    this.acctNo = rs.getInt(2);
                    this.emailUsNa = rs.getString(3);
                    this.fName = rs.getString(4);
                    this.lName = rs.getString(5);
                    this.phone1 = rs.getString(6);
                    this.phone2 = rs.getString(7);
                    this.emerCoNa = rs.getString(8);
                    this.emerCoNo = rs.getString(9);
                    this.memCom = rs.getString(10);
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

    //member sign up - create new basic member account
    protected void memberCreateNewMember(int accountID, String email, String fname, String lname, String phoneone, String phonetwo, String emrconname, String emrconphone) throws Exception {
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
            this.acctNo = accountID;
            this.emailUsNa = email;
            String newMem = "INSERT INTO tblMember (AccountNo, Email_User) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(newMem);
            ps.setInt(1, acctNo);
            ps.setString(2, emailUsNa);
            ps.executeUpdate();

            java.sql.ResultSet rs = statement.executeQuery("SELECT MemberID FROM tblMember ORDER BY MemberID DESC LIMIT 1");
            rs.next();
            this.memId = rs.getInt("MemberID");

            String updateMember = "UPDATE tblMember SET FName = ?, LName = ?, Phone1 = ?, Phone2 = ?, EmergencyContactName = ?, EmergencyContactPhone = ? WHERE MemberID =" + memId + ";";
            PreparedStatement pstmt = connection.prepareStatement(updateMember);
            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            pstmt.setString(3, phoneone);
            pstmt.setString(4, phonetwo);
            pstmt.setString(5, emrconname);
            pstmt.setString(6, emrconphone);
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.err.println("err");
            e.printStackTrace();
        }
    }


    //member update own info
    protected void updateMyInfo(int memid, String email, String fname, String lname, String phoneone, String phonetwo, String emrconname, String emrconphone) throws Exception {
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

            String updateMember = "UPDATE tblMember SET FName = ?, LName = ?, Phone1 = ?, Phone2 = ?, EmergencyContactName = ?, EmergencyContactPhone = ?, MemberComments = ? WHERE MemberID =" + memid + ";";
            PreparedStatement pstmt = connection.prepareStatement(updateMember);
            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            pstmt.setString(3, phoneone);
            pstmt.setString(4, phonetwo);
            pstmt.setString(5, emrconname);
            pstmt.setString(6, emrconphone);
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.err.println("err");
            e.printStackTrace();
        }
    }

    //ADMIN - create new basic member account
    protected void adminCreateNewMember(int accountID, String email, String fname, String lname, String phoneone, String phonetwo, String emrconname, String emrconphone,String memcomms) throws Exception {
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
            this.acctNo = accountID;
            this.emailUsNa = email;
            String newMem = "INSERT INTO tblMember (AccountNo, Email_User) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(newMem);
            ps.setInt(1, acctNo);
            ps.setString(2, emailUsNa);
            ps.executeUpdate();

            java.sql.ResultSet rs = statement.executeQuery("SELECT MemberID FROM tblMember ORDER BY MemberID DESC LIMIT 1");
            rs.next();
            this.memId = rs.getInt("MemberID");

            String updateMember = "UPDATE tblMember SET FName = ?, LName = ?, Phone1 = ?, Phone2 = ?, EmergencyContactName = ?, EmergencyContactPhone = ? MemberComments = ? WHERE MemberID =" + memId + ";";
            PreparedStatement pstmt = connection.prepareStatement(updateMember);
            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            pstmt.setString(3, phoneone);
            pstmt.setString(4, phonetwo);
            pstmt.setString(5, emrconname);
            pstmt.setString(6, emrconphone);
            pstmt.setString(7, memcomms);
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.err.println("err");
            e.printStackTrace();
        }
    }

    //admin update member info
    protected void updateMemberInfo(int memid, String email, String fname, String lname, String phoneone, String phonetwo, String emrconname, String emrconphone, String memcomms) throws Exception {
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

            String updateMember = "UPDATE tblMember SET FName = ?, LName = ?, Phone1 = ?, Phone2 = ?, EmergencyContactName = ?, EmergencyContactPhone = ?, MemberComments = ? WHERE MemberID =" + memid + ";";
            PreparedStatement pstmt = connection.prepareStatement(updateMember);
            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            pstmt.setString(3, phoneone);
            pstmt.setString(4, phonetwo);
            pstmt.setString(5, emrconname);
            pstmt.setString(6, emrconphone);
            pstmt.setString(7, memcomms);
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.err.println("err");
            e.printStackTrace();
        }
    }


    //read just member number
    protected int readJustMemNo(String user) throws Exception {
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
            java.sql.ResultSet rs = statement.executeQuery("SELECT * FROM tblMember WHERE Email_User='" + user + "';");

            if (rs != null) {
                //makes sure the resultSet isn't in the header info
                rs.next();

                return this.memId = rs.getInt("MemberID");

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
        return memId;
    }


    //get member by member id
    protected void getMemberByMemID(int memID) throws Exception {
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
            java.sql.ResultSet rs = statement.executeQuery("SELECT * FROM tblMember WHERE MemberID='" + memID + "';");

            if (rs != null) {
                //makes sure the resultSet isn't in the header info
                rs.next();

                this.memId = rs.getInt("MemberID");
                this.acctNo = rs.getInt(2);
                this.emailUsNa = rs.getString(3);
                this.fName = rs.getString(4);
                this.lName = rs.getString(5);
                this.phone1 = rs.getString(6);
                this.phone2 = rs.getString(7);
                this.emerCoNa = rs.getString(8);
                this.emerCoNo = rs.getString(9);
                this.memCom = rs.getString(10);
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

    @Override
    public String toString() {
        return "<p>Member ID: "+this.memId+"</p><p>Account Number: "+this.acctNo+"</p><p>Email: "+
                this.emailUsNa+"</p><p>First Name: "+this.fName+"</p><p>Last Name: "+this.lName+"</p><p>Phone 1: "+
                this.phone1+"</p><p>Phone 2: "+this.phone2+"</p><p>Emergency Contact Name: "+this.emerCoNa+"</p><p>Emergency Contact Number: "+this.emerCoNo+"</p><p>Member Comments: "+this.memCom+"</p>";
    }
}
