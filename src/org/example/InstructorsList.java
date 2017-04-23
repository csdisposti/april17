package org.example;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by cdisp on 3/17/2017.
 */
public class InstructorsList extends Member{
    private int memid;
    private String level;
    private String fname;
    private String lname;



    //constructor
    public InstructorsList(int memid, String level, String fname, String lname) {
        this.memid = memid;
        this.level = level;
        this.fname = fname;
        this.lname = lname;
    }

    //empty constructor
    public InstructorsList() {
        this.memid = 0;
        this.level = null;
        this.fname = null;
        this.lname = null;
    }

    //get Instructor id
    public int getMemId() {
        return memid;
    }

    //set instructor id
    public void setMemId(int memid) {
        this.memid = memid;
    }

    //get InstructorList level
    public String getLevel() {
        return level;
    }

    //set InsructorList level
    public void setLevel(String reg) {
        this.level = level;
    }

    //get InstructorList fname
    public String getFName() {
        return fname;
    }

    //set InstructorList fname
    public void setFName(String fname) {
        this.fname = fname;
    }

    //get InstructorList lname
    public String getLName() {
        return lname;
    }

    //set InstructorList fname
    public void setLName(String lname) {
        this.lname = lname;
    }



    public ArrayList<InstructorsList> populateResourcesReserved() throws Exception {

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

        ArrayList<InstructorsList> instructors = new ArrayList<InstructorsList>();

       // String I = "I";
        try {
            java.sql.Statement statement = connection.createStatement();
            java.sql.ResultSet rs = statement.executeQuery("SELECT MemberID, LName, Fname FROM tblMember INNER JOIN tblAdmin ON tblMember.MemberID = tblAdmin.MemberNo WHERE tblAdmin.AdminLevel='I'");

            if (rs != null) {
                //makes sure the resultSet isn't in the header info
                while (rs.next()) {
                    InstructorsList instructor = new InstructorsList();
                   // instructor.setLevel(rs.getString(3));
                    instructor.setMemId(rs.getInt("MemberID"));
                    instructor.setFName(rs.getString("FName"));
                    instructor.setLName(rs.getString("LName"));
                    instructors.add(instructor);
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
        return instructors;
    }
    @Override
    public String toString() {
        return this.fname + " " + this.lname;
    }
}