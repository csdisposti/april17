package org.example;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

/**
 * Created by cdisp on 3/15/2017.
 */
public class AdminReservationsList extends Reservations {

    private int resId;
    private int resBy;
    private String resType;
    private String resourcesRes;
    private Date resDate;
    private Time outTime;
    private Time inTime;
    private String dest;
    private int instNo;
    private String resStatus;
    private int resApprovedBy;
    private String resCom;
    private String makemodel;

    //constructor
    public AdminReservationsList(int resId, int resBy, String resType, String resourcesRes, String makemodel, Date resDate, Time outTime, Time inTime, String dest, int instNo, String resStatus, int resApprovedBy, String resCom) {
        super(resId, resBy, resType, resourcesRes, makemodel, resDate, outTime, inTime, dest, instNo, resStatus, resApprovedBy, resCom);
    }

    //empty constructor
    public AdminReservationsList() {
        super();
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

    //set Reservation Comments
    public void setResCom(String resCom) {
        this.resCom = resCom;
    }
    //get make model
    public String getMakeModel() {
        return makemodel;
    }

    //set Rmake model
    public void setMakeModel(String makemodel) {
        this.makemodel = makemodel;
    }

    public ArrayList<AdminReservationsList> populateReservations() throws Exception {
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

            ArrayList<AdminReservationsList> reservationsL = new ArrayList<>();

            try {
                java.sql.Statement statement = connection.createStatement();
                java.sql.ResultSet rs = statement.executeQuery("SELECT * FROM AscendDB.tblReservations WHERE ReservationStatus=''");

                if (rs != null) {
                    //makes sure the resultSet isn't in the header info
                    while (rs.next()) {
                        AdminReservationsList reservation = new AdminReservationsList();
                        reservation.setResId(rs.getInt("ReservationID"));
                        reservation.setResBy(rs.getInt("ReservedBy"));
                        reservation.setResType(rs.getString("ReservationType"));
                        reservation.setResourcesRes(rs.getString("ResourcesReserved"));
                        reservation.setResDate(rs.getDate("ReservationDate"));
                        reservation.setOutTime(rs.getTime("OutTime"));
                        reservation.setInTime(rs.getTime("InTime"));
                        reservation.setInstNo(rs.getInt("InstructorNo"));
                        reservation.setResStatus(rs.getString("ReservationStatus"));
                        reservation.setResApprovedBy(rs.getInt("ReservationApprovedBy"));
                        reservationsL.add(reservation);
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
            return reservationsL;
        }
    }

    @Override
    public String toString() {

        return this.resId +" "+this.resBy+" "+ this.resType+" "+this.resourcesRes + " " + this.makemodel +" "+this.resDate+" "+
                this.outTime+" "+this.inTime+" "+ this.instNo+" " + this.resStatus + " "+this.resApprovedBy;

    }
}
