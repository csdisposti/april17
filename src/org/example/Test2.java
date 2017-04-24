package org.example;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.Time;
import java.util.Date;
import java.util.Properties;

/**
 * Created by cdisp on 3/15/2017.
 */

/*Testing pages*/
public class Test2{
/*public class Test2  {
    private String eu;
    private String pw;
    private int memNo;
    private int adminID;
    private String adminLev;
   // private String username;
   // private String password;

    private String E = "ZimaZima@aol.com";
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


*/
        private int resId;
        private int resBy;
        private String resType;
        private String resourcesRes;
        private String makemodel;
        private Date resDate;
        private Time outTime;
        private Time inTime;
        private String dest;
        private int instNo;
        private boolean resStatus;
        private int resApprovedBy;
        private String resCom;


//constructor
public Test2(int resId, int resBy, String resType, String resourcesRes, String makemodel, Date resDate, Time outTime, Time inTime, String dest, int instNo, Boolean resStatus, int resApprovedBy, String resCom) {
        this.resId = resId;
        this.resBy = resBy;
        this.resType = resType;
        this.resourcesRes = resourcesRes;
        this.makemodel = makemodel;
        this.resDate = resDate;
        this.outTime = outTime;
        this.inTime = inTime;
        this.dest = dest;
        this.instNo = instNo;
        this.resStatus = resStatus;
        this.resApprovedBy = resApprovedBy;
        this.resCom = resCom;
        }

//empty constructor
public  Test2() {
        this.resId = 0;
        this.resBy = 0;
        this.resType = null;
        this.resourcesRes = null;
        this.makemodel = null;
        this.resDate = null;
        this.outTime = null;
        this.inTime = null;
        this.dest = null;
        this.instNo = 0;
        this.resStatus = false;
        this.resApprovedBy = 0;
        this.resCom = null;

        }

//get Reservation id
public int getResId() {
        return resId;
        }

//set Reservation id
public void setResId(int resId) {
        this.resId = resId;
        }

//get Reservation By
public int getResBy() {
        return resBy;
        }

//set Reservation By
public void setResBy(int resBy) {
        this.resBy = resBy;
        }

//get Reservation Type
public String getResType() {
        return resType;
        }

//set Reservation Type
public void setResType(String resType) {
        this.resType = resType;
        }

//get Resources Reserved
public String getResourcesRes() {
        return resourcesRes;
        }

//set Resources Reserved
public void setResourcesRes(String resourcesRes) {
        this.resourcesRes = resourcesRes;
        }

//get Reservation Date
public Date getResDate() {
        return resDate;
        }

//set Reservation Date
public void setResDate(Date rseDate) {
        this.resDate = rseDate;
        }

//get Reservation Out Time
public Time getOutTime() {
        return outTime;
        }

//set Reservation Out Time
public void setOutTime(Time outTime) {
        this.outTime = outTime;
        }

//get Reservation In Time
public Time getInTime() {
        return inTime;
        }

//set Reservation In Time
public void setInTime(Time inTime) {
        this.inTime = inTime;
        }

//get Reservation Destination
public String getDest() {
        return dest;
        }

//set Reservation Destination
public void setDest(String dest) {
        this.dest = dest;
        }

//get Instructor Number
public int getInstNo() {
        return instNo;
        }

//set Instructor Number
public void setInstNo(int instNo) {
        this.instNo = instNo;
        }

//get Reservation Approved by
public int getResApprovedBy() {
        return resApprovedBy;
        }

//set Reservation Approved by
public void setResApprovedBy(int resApprovedBy) {
        this.resApprovedBy = resApprovedBy;
        }

//get Reservation Status
public Boolean getResStatus() {
        return resStatus;
        }

//set Reservation Status
public void setResStatus(Boolean resStatus) {
        this.resStatus = resStatus;
        }

//get Reservation Comments
public String getResCom() {
        return resCom;
        }

//get make model
public String getMakeModel() {
        return makemodel;
        }

//set Rmake model
public void setMakeModel(String makemodel) {
        this.makemodel = makemodel;
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
           // java.sql.ResultSet rs = statement.executeQuery("SELECT * FROM AscendDB.tblAirports ");
            java.sql.ResultSet rs = statement.executeQuery("SELECT * FROM AscendDB.tblAdmin ");

            /*if (rs != null) {
                //makes sure the resultSet isn't in the header info
                while(rs.next()) {
                    this.resId = rs.getInt("ReservationID");
                    this.resBy = rs.getInt("ReservedBy");
                    this.resType = rs.getString("ReservationType");
                    this.resourcesRes = rs.getString("ResourcesReserved");
                    this.resDate = rs.getDate("ReservationDate");
                    this.outTime = rs.getTime("OutTime");
                    this.inTime = rs.getTime("InTime");
                    this.dest = rs.getString("Destination");
                    this.instNo = rs.getInt("InstructorNo");
                    this.resStatus = rs.getBoolean("ReservationStatus");
                    this.resApprovedBy = rs.getInt("ReservationApprovedBy");
                    this.resCom = rs.getString("ReservationComments");
                    System.out.println(resBy + " " + resDate);
                }*/
            if (rs != null) {
                while (rs.next()) {
                    //this.eu = rs.getString("Email_Username");
                    //this.pw = rs.getString("MemberPW");
                    //this.adminID = rs.getInt("AdministratorID");
                    //this.adminLev = rs.getString("AdminLevel");*/
                    //ResultSetMetaData rsMetaData = rs.getMetaData();
                    //System.out.print(rsMetaData);
                    ResultSetMetaData rsMetaData = rs.getMetaData();
                    System.out.print(rsMetaData);
                   /* this.eu = rs.getString("Email_Username");
                    this.pw = rs.getString("MemberPW");
                    System.out.println(eu);
                    System.out.println(pw);
*/
                }
                   /* String updateMember = "UPDATE AscendDB.tblCredentials SET MemberPW = ? WHERE Email_Username ='" + E + "'";
                    PreparedStatement pstmt = connection.prepareStatement(updateMember);
                    pstmt.setString(1, "Zima19995");
                    pstmt.executeUpdate();*/
                }

        } catch (Exception e) {
            System.err.println("err");
            e.printStackTrace();
        }
    }



    @Override
    public String toString() {
        return "<p>Reservation ID: "+this.resId +"</p><p>Reserved by: "+this.resBy+"</p><p>Reservation Type: "+
                this.resType+"</p><p>Resources Reserved: "+this.resourcesRes+"</p><p>Reservation Date: "+this.resDate+"</p><p>Reservation Out Time: "+
                this.outTime+"</p><p>Reservation In Time: "+this.inTime+"</p><p>Destination: "+this.dest+"</p><p>Instrcutor Number: "+
                this.instNo+"</p><p>Reservation Satus: "+this.resStatus+"</p><p>Reservation Approved By: "+this.resApprovedBy+"</p><p>Reservation Comments: " + this.resCom;
    }
}