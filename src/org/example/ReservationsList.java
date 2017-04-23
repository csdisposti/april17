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
public class ReservationsList extends Reservations{

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
    public ReservationsList(int resId, int resBy, String resType, String resourcesRes, Date resDate, Time outTime, Time inTime, String dest, int instNo, Boolean resStatus, int resApprovedBy, String resCom) {
        super(resId, resBy, resType, resourcesRes, resDate, outTime, inTime, dest, instNo, resStatus, resApprovedBy, resCom);
    }

    //empty constructor
    public ReservationsList() {
        super();
    }


    public ArrayList<ReservationsList> populateReservations() throws Exception {
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

            ArrayList<ReservationsList> reservationsL = new ArrayList<>();

            try {
                java.sql.Statement statement = connection.createStatement();
                java.sql.ResultSet rs = statement.executeQuery("SELECT ReservedBy, ReservationType, ResourcesReserved, ReservationDate, OutTime, InTime, Destination, InstructorNo, ReservationStatus, ReservationApprovedBy FROM AscendDB.tblReservations");

                if (rs != null) {
                    //makes sure the resultSet isn't in the header info
                    while (rs.next()) {
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
        return "<p>Reservation ID: "+this.resId +"</p><p>Reserved by: "+this.resBy+"</p><p>Email: "+
                this.resType+"</p><p>First Name: "+this.resourcesRes+"</p><p>Last Name: "+this.resDate+"</p><p>Phone 1: "+
                this.outTime+"</p><p>Phone 2: "+this.inTime+"</p><p>Emergency Contact Name: "+this.dest+"</p><p>Emergency Contact Number: "+
                this.instNo+"</p><p>Member Comments: "+this.resApprovedBy+"</p><p>Reservation Comments: " + this.resCom;
    }
}
