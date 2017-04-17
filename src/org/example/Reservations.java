package org.example;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.Time;
import java.util.Date;
import java.util.Properties;

/**
 * Created by cdisp on 3/15/2017.
 */
public class Reservations {

    private long resId;
    private long resBy;
    private String resType;
    private String resourcesRes;
    private Date rseDate;
    private Time outTime;
    private Time inTime;
    private String dest;
    private long instNo;
    private String resCom;

    //constructor
    public Reservations(long resId, long resBy, String resType, String resourcesRes, Date rseDate, Time outTime, Time inTime, String dest, long instNo, String resCom) {
        this.resId = resId;
        this.resBy = resBy;
        this.resType = resType;
        this.resourcesRes = resourcesRes;
        this.rseDate = rseDate;
        this.outTime = outTime;
        this.inTime = inTime;
        this.dest = dest;
        this.instNo = instNo;
        this.resCom = resCom;
    }

    //get Reservation id
    public long getResId() {
        return resId;
    }

    //set Reservation id
    public void setResId(long resId) {
        this.resId = resId;
    }

    //get Reservation By
    public long getResBy() {
        return resBy;
    }

    //set Reservation By
    public void setResBy(long resBy) {
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
        return rseDate;
    }

    //set Reservation Date
    public void setRseDate(Date rseDate) {
        this.rseDate = rseDate;
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
    public long getInstNo() {
        return instNo;
    }

    //set Instructor Number
    public void setInstNo(long instNo) {
        this.instNo = instNo;
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

                this.resId = rs.getLong("ReservationID");
                this.resBy = rs.getLong("ReservedBy");
                this.resType = rs.getString("ReservationType");
                this.resourcesRes = rs.getString("ResourceReserved");
                this.rseDate = rs.getDate("ReservationDate");
                this.outTime = rs.getTime("OutTime");
                this.inTime = rs.getTime("InTime");
                this.dest = rs.getString("Destination");
                this.instNo = rs.getLong("InstructorNo");
                this.resCom = rs.getString("ReservationComments");
            }
        } catch (Exception e)
        {
            System.err.println("err");
            e.printStackTrace();
        }
    }
    public void writeToDatabase()
    {
        //java.sql.Connection c = AscendMain.conn;
    }
}
