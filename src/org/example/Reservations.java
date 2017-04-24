package org.example;

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
    private String makemodel;
    private Date resDate;
    private Time outTime;
    private Time inTime;
    private String dest;
    private int instNo;
    private String resStatus;
    private int resApprovedBy;
    private String resCom;


    //constructor
    public Reservations(int resId, int resBy, String resType, String resourcesRes, String makemodel, Date resDate, Time outTime, Time inTime, String dest, int instNo, String resStatus, int resApprovedBy, String resCom) {
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
    public Reservations() {
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
        this.resStatus = "PENDING";
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
    public String getResStatus() {
        return resStatus;
    }

    //set Reservation Status
    public void setResStatus(String resStatus) {
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


    //read reservations from database
    public void readFromDatabase(int ReservationID)throws Exception
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
                    this.resStatus = rs.getString("ReservationStatus");
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

    //member add flying lesson reservation to database as pending
    protected void addNewFlyingLessonReservation(int resBy, String resType, String resourcesRes, String resDate, String outTime, String inTime, int instNo) throws Exception {
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
            String newRes = "INSERT INTO tblReservations(ReservedBy, ReservationType, ResourcesReserved, ReservationDate, OutTime, InTime, InstructorNo) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(newRes);
            ps.setInt(1, resBy);
            ps.setString(2, resType);
            ps.setString(3, resourcesRes);
            ps.setDate(4, java.sql.Date.valueOf(resDate));
            ps.setTime(5, java.sql.Time.valueOf(outTime));
            ps.setTime(6, java.sql.Time.valueOf(inTime));
            ps.setInt(7, instNo);
            ps.executeUpdate();

            java.sql.ResultSet rs = statement.executeQuery("SELECT ReservationID FROM tblReservations ORDER BY ReservationID DESC LIMIT 1");
            rs.next();
            this.resId = rs.getInt("ReservationID");

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

    //member add flight reservation to database as pending
    protected void addNewFlightReservation(int resBy, String resType, String resourcesRes, String resDate, String outTime, String inTime) throws Exception {
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
            String newRes = "INSERT INTO tblReservations(ReservedBy, ReservationType, ResourcesReserved, ReservationDate, OutTime, InTime) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(newRes);
            ps.setInt(1, resBy);
            ps.setString(2, resType);
            ps.setString(3, resourcesRes);
            ps.setDate(4, java.sql.Date.valueOf(resDate));
            ps.setTime(5, java.sql.Time.valueOf(outTime));
            ps.setTime(6, java.sql.Time.valueOf(inTime));
            ps.executeUpdate();

            java.sql.ResultSet rs = statement.executeQuery("SELECT ReservationID FROM tblReservations ORDER BY ReservationID DESC LIMIT 1");
            rs.next();
            this.resId = rs.getInt("ReservationID");


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

    //admin set reservation status
    protected void updateReservationStatus(int resid, String reserstat, int adminid) throws Exception {
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

            String updateMember = "UPDATE AscendDB.tblReservations SET ReservationStatus = ?, ReservationApprovedBy = ? WHERE ReservationID=" + resid + ";";
            PreparedStatement pstmt = connection.prepareStatement(updateMember);
            pstmt.setString(1, reserstat);
            pstmt.setInt(2, adminid);
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.err.println("err");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "<p>Reservation ID: "+this.resId +"</p><p>Reserved by: "+this.resBy+"</p><p>Reservation Type: "+
                this.resType+"</p><p>Resources Reserved: "+this.resourcesRes+"</p><p>Reservation Date: "+this.resDate+"</p><p>Reservation Out Time: "+
                this.outTime+"</p><p>Reservation In Time: "+this.inTime+"</p><p>Destination: "+this.dest+"</p><p>Instructor Number: "+
                this.instNo+"</p><p>Reservation Satus: "+this.resStatus+"</p><p>Reservation Approved By: "+this.resApprovedBy+"</p><p>Reservation Comments: " + this.resCom;
    }
}
