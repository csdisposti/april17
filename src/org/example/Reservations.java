package org.example;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.util.Date;
import java.util.Properties;

/**
 * Created by cdisp on 3/15/2017.
 */
public class Reservations {

    private int resId;
    private int resBy;
    private String resType;
    private String resourcesRes;
    private Date resDate;
    private Time outTime;
    private Time inTime;
    private String dest;
    private int instNo;
    private int resApprovedBy;
    private String resCom;

    //constructor
    public Reservations(int resId, int resBy, String resType, String resourcesRes, Date resDate, Time outTime, Time inTime, String dest, int instNo, int resApprovedBy, String resCom) {
        this.resId = resId;
        this.resBy = resBy;
        this.resType = resType;
        this.resourcesRes = resourcesRes;
        this.resDate = resDate;
        this.outTime = outTime;
        this.inTime = inTime;
        this.dest = dest;
        this.instNo = instNo;
        this.resApprovedBy = resApprovedBy;
        this.resCom = resCom;
    }

    //empty constructor
    public Reservations() {
        this.resId = 0;
        this.resBy = 0;
        this.resType = null;
        this.resourcesRes = null;
        this.resDate = null;
        this.outTime = null;
        this.inTime = null;
        this.dest = null;
        this.instNo = 0;
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
    public Date getRseDate() {
        return resDate;
    }

    //set Reservation Date
    public void setRseDate(Date rseDate) {
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

    //get Reservation Comments
    public String getResCom() {
        return resCom;
    }

    //set Reservation Comments
    public void setResCom(String resCom) {
        this.resCom = resCom;
    }

    public void readFromDatabase(String ReservationID)throws Exception
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
            java.sql.ResultSet rs = statement.executeQuery("SELECT * FROM tblReservations WHERE ReservationID="+ReservationID+";");

            if (rs != null) {
                //makes sure the resultSet isn't in the header info
                rs.next();

                this.resId = rs.getInt("ReservationID");
                this.resBy = rs.getInt("ReservedBy");
                this.resType = rs.getString("ReservationType");
                this.resourcesRes = rs.getString("ResourcesReserved");
                this.resDate = rs.getDate("ReservationDate");
                this.outTime = rs.getTime("OutTime");
                this.inTime = rs.getTime("InTime");
                this.dest = rs.getString("Destination");
                this.instNo = rs.getInt("InstructorNo");
                this.resApprovedBy = rs.getInt("ReservationApprovedBy");
                this.resCom = rs.getString("ReservationComments");
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



    protected void addToDatabase(int resId, int resBy, String resType, String resourcesRes, Date rseDate, Time outTime, Time inTime, String dest, int instNo, int resApprovedBy, String resCom) throws Exception {
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

            String updateMember = "INSERT INTO AscendDB.tblReservation (ReservedBy, ReservationType, ResourcesReserved, ReservationDate, OutTime, InTime, Destination, InstructorNo, ReservationComments) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            PreparedStatement pstmt = connection.prepareStatement(updateMember);
            pstmt.setInt(1, resBy);
            pstmt.setString(2, resType);
            pstmt.setString(3, resourcesRes);
            pstmt.setDate(4, (java.sql.Date) resDate);
            pstmt.setTime(5, outTime);
            pstmt.setTime(6, inTime);
            pstmt.setString(7, dest);
            pstmt.setInt(1, instNo);
            pstmt.setInt(1, resApprovedBy);
            pstmt.setString(7, resCom);
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

    protected void checkAvailability(String reres) throws Exception {
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

            java.sql.ResultSet rs = statement.executeQuery("SELECT ResourcesReserved, ReservationDate, OutTime FROM tblReservations WHERE ResourcesReserved ='" + reres + "'AND ReservationDate > CurDate() ORDER BY ReservationDate, OutTime");
            if (rs != null) {
                //makes sure the resultSet isn't in the header info
                rs.next();

                this.resourcesRes = rs.getString("ResourceReserved");
                this.resDate = rs.getDate("ReservationDate");
                this.outTime = rs.getTime("OutTime");
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
        return "<p>Reservation ID: "+this.resId +"</p><p>Reserved by: "+this.resBy+"</p><p>Email: "+
                this.resType+"</p><p>First Name: "+this.resourcesRes+"</p><p>Last Name: "+this.resDate+"</p><p>Phone 1: "+
                this.outTime+"</p><p>Phone 2: "+this.inTime+"</p><p>Emergency Contact Name: "+this.dest+"</p><p>Emergency Contact Number: "+
                this.instNo+"</p><p>Member Comments: "+this.resApprovedBy+"</p><p>Reservation Comments: " + this.resCom;
    }
}


