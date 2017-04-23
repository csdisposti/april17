package org.example;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.util.ArrayList;
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
    private boolean resStatus;
    private int resApprovedBy;
    private String resCom;

    //constructor
    public Reservations(int resId, int resBy, String resType, String resourcesRes, Date resDate, Time outTime, Time inTime, String dest, int instNo, Boolean resStatus, int resApprovedBy, String resCom) {
        this.resId = resId;
        this.resBy = resBy;
        this.resType = resType;
        this.resourcesRes = resourcesRes;
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
                    this.resStatus = rs.getBoolean("ReservationStatus");
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

    //member add reservation to database as pending
    protected void addNewReservation(int resBy, String resType, String resourcesRes, String resDate, String outTime, int instNo) throws Exception {
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
            String newRes = "INSERT INTO tblReservations(ReservedBy, ReservationType, ResourcesReserved, ReservationDate, OutTime, InstructorNo) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(newRes);
            ps.setInt(1, resBy);
            ps.setString(2, resType);
            ps.setString(3, resourcesRes);
            ps.setDate(4, java.sql.Date.valueOf(resDate));
            ps.setTime(5, java.sql.Time.valueOf(outTime));
            ps.setInt(6, instNo);
            ps.executeUpdate();

            java.sql.ResultSet rs = statement.executeQuery("SELECT ReservationID FROM tblReservations ORDER BY ReservationID DESC LIMIT 1");
            rs.next();
            this.resId = rs.getInt("ReservationID");

            //String updateRes = "UPDATE tblReservations SET ResourcesReserved = ?,  WHERE ReservationID =" + resId + ";";

            //PreparedStatement pstmt = connection.prepareStatement(updateRes);


            //pstmt.executeUpdate();

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

    //check the availability of the member requested reservation
    protected String checkAvailability(String reres) throws Exception {
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

       // ArrayList<ReservationsList> availableReservations = new ArrayList<>();
        try {
            java.sql.Statement statement = connection.createStatement();

            java.sql.ResultSet rs = statement.executeQuery("SELECT ResourcesReserved, ReservationDate, OutTime FROM tblReservations WHERE ResourcesReserved ='" + reres + "'AND ReservationDate > CurDate() ORDER BY ReservationDate, OutTime");
            if (rs != null) {
                //makes sure the resultSet isn't in the header info
                while (rs.next()) {
                    return this.resourcesRes = rs.getString("ResourceReserved");
                    //this.resDate = rs.getDate("ReservationDate");
                    //this.outTime = rs.getTime("OutTime");

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
        return this.resourcesRes;
    }



    @Override
    public String toString() {
        return "<p>Reservation ID: "+this.resId +"</p><p>Reserved by: "+this.resBy+"</p><p>Reservation Type: "+
                this.resType+"</p><p>Resources Reserved: "+this.resourcesRes+"</p><p>Reservation Date: "+this.resDate+"</p><p>Reservation Out Time: "+
                this.outTime+"</p><p>Reservation In Time: "+this.inTime+"</p><p>Destination: "+this.dest+"</p><p>Instrcutor Number: "+
                this.instNo+"</p><p>Reservation Satus: "+this.resStatus+"</p><p>Reservation Approved By: "+this.resApprovedBy+"</p><p>Reservation Comments: " + this.resCom;
    }
}
