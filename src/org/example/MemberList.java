package org.example;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by cdisp on 3/17/2017.
 */
public class MemberList extends Member{
    private int memId;         //MemberID
    private String emailUsNa;   //Email_UserName
    private String fName;       //Fname
    private String lName;       //Lname

    //constructor
    public MemberList(int memId, String email, String lname, String fname) {
        this.memId = memId;
        this.emailUsNa = email;
        this.lName = lname;
        this.fName = fname;
    }

    //empty constructor
    public MemberList() {
        this.memId = 0;
        this.emailUsNa = null;
        this.lName = null;
        this.fName = null;
    }

    //get Member's ID
    public int getMemId() {
        return memId;
    }

    //set Member's ID
    public void setMemId(int memId) {
        this.memId = memId;
    }

    //get Member's Email/User Name
    public String getEmailUsNa() {
        return emailUsNa;
    }

    //set Member's Email/User Name
    public void setEmailUsNa(String emailUsNa) {
        this.emailUsNa = emailUsNa;
    }

    //get Member Last Name
    public String getLName() {
        return lName;
    }

    //set Member Last Name
    public void setLName(String lName) {
        this.lName = lName;
    }

    //get Member First Name
    public String getFName() {
        return fName;
    }

    //set Member First Name
    public void setFName(String fName) {
        this.fName = fName;
    }

    //get member lname, fname, and mem id for dropdown
    public ArrayList<MemberList> populateResources() throws Exception {

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

        ArrayList<MemberList> memberL = new ArrayList<MemberList>();

        try {
            java.sql.Statement statement = connection.createStatement();
            java.sql.ResultSet rs = statement.executeQuery("SELECT LName, FName, MemberID FROM AscendDB.tblMember");

            if (rs != null) {
                //makes sure the resultSet isn't in the header info
                while (rs.next()) {
                    MemberList member = new MemberList();
                    member.setLName(rs.getString("LName"));
                    member.setFName(rs.getString("Fname"));
                    member.setMemId(rs.getInt("MemberID"));
                    memberL.add(member);
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
        return memberL;
    }


    public ArrayList<MemberList> getMemberByUsername(String user) throws Exception {

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

        ArrayList<MemberList> memberL = new ArrayList<MemberList>();

        try {
            java.sql.Statement statement = connection.createStatement();
            java.sql.ResultSet rs = statement.executeQuery(" SELECT tblMember.Email_User, tblMember.MemberID, " +
                    "concat_ws(', ', tblMember.Lname, tblMember.Fname) AS Member FROM tblMember WHERE tblMember.Email_User LIKE 'a%' LIMIT 1)");

            if (rs != null) {
                //makes sure the resultSet isn't in the header info
                while (rs.next()) {
                    MemberList member = new MemberList();
                    member.setEmailUsNa(rs.getString("Email_User"));
                    memberL.add(member);
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
        return memberL;
    }

    @Override
    public String toString() {
        return this.lName + ", " + this.fName + " - Member Id: " + this.memId;
    }
}