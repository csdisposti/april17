package org.example;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Array;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by cdisp on 3/17/2017.
 */
public class Aircraft {
    private String reg;
    private int ownId;
    private String makeModel;
    private String airType;
    private String airHome;
    private String airCurr;
    private int rentFee;
    private int airAge;
    private double flightHrs;
    private double flightDist;
    private String lastMaintType;
    private Date lastMaintDate;

    private ArrayList list;

    //constructor
    public Aircraft(String reg, int ownId, String makeModel, String airType, int rentFee,
                    int airAge, double flightHrs, double flightDist, String lastMaintType, Date lastMaintDate) {
        this.reg = reg;
        this.ownId = ownId;
        this.makeModel = makeModel;
        this.airType = airType;
        this.rentFee = rentFee;
        this.airAge = airAge;
        this.flightHrs = flightHrs;
        this.flightDist = flightDist;
        this.lastMaintType = lastMaintType;
        this.lastMaintDate = lastMaintDate;
    }

    //empty constructor
    public Aircraft() {
        this.reg = null;
        this.ownId = 0;
        this.makeModel = null;
        this.airType = null;
        this.rentFee = 0;
        this.airAge = 0;
        this.flightHrs = 0;
        this.flightDist = 0;
        this.lastMaintType = null;
        this.lastMaintDate = null;

    }

    public Aircraft(String reg, String makeModel) {
        this.reg = reg;
        this.makeModel = makeModel;
    }

    //get Aircraft Registration
    public String getReg() {
        return reg;
    }

    //set Aircraft Registration
    public void setReg(String reg) {
        this.reg = reg;
    }

    //get Aircraft Owner Id
    public int getOwnId() {
        return ownId;
    }

    //set Aircraft Owner Id
    public void setOwnId(int ownId) {
        this.ownId = ownId;
    }

    //get Aircraft Make Model
    public String getMakeModel() {
        return makeModel;
    }

    //set Aircraft Make Model
    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    //get Aircraft Type
    public String getAirType() {
        return airType;
    }

    //set Aircraft Type
    public void setAirType(String airType) {
        this.airType = airType;
    }

    //get Aircraft Home
    public String getAirHome() {
        return airHome;
    }

    //set Aircraft Home
    public void setAirHome(String airHome) {
        this.airHome = airHome;
    }

    //get Aircraft Current
    public String getAirCurr() {
        return airCurr;
    }

    //set Aircraft Current
    public void setAirCurr(String airCurr) {
        this.airCurr = airCurr;
    }

    //get Aircraft Rental fee
    public int getRentFee() {
        return rentFee;
    }

    //set Aircraft Rental fee
    public void setRentFee(int rentFee) {
        this.rentFee = rentFee;
    }

    //get Aircraft Age
    public int getAirAge() {
        return airAge;
    }

    //set Aircraft Age
    public void setAirAge(int airAge) {
        this.airAge = airAge;
    }

    //get Aircraft Flight Hours
    public double getFlightHrs() {
        return flightHrs;
    }

    //set Aircraft Flight Hours
    public void setFlightHrs(double flightHrs) {
        this.flightHrs = flightHrs;
    }

    //get Aircraft Flight Distance
    public double getFlightDist() {
        return flightDist;
    }

    //set Aircraft Flight Distance
    public void setFlightDist(double flightDist) {
        this.flightDist = flightDist;
    }

    //get Aircraft Last Maintenance Type
    public String getLastMaintType() {
        return lastMaintType;
    }

    //set Aircraft Last Maintenance Type
    public void setLastMaintType(String lastMaintType) {
        this.lastMaintType = lastMaintType;
    }

    //get Aircraft Last Maintenance Date
    public Date getLastMaintDate() {
        return lastMaintDate;
    }

    //set Aircraft Last Maintenance Date
    public void setLastMaintDate(Date lastMaintDate) {
        this.lastMaintDate = lastMaintDate;
    }


    public void readFromDatabase(String registration) throws Exception {

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
            java.sql.ResultSet rs = statement.executeQuery("SELECT * FROM tblAircraft WHERE Registration='" + registration + "';");

            if (rs != null) {
                //makes sure the resultSet isn't in the header info
                while (rs.next()) {
                    this.reg = rs.getString("Registration");
                    this.ownId = rs.getInt("OwnerID");
                    this.makeModel = rs.getString("Make_Model");
                    this.airType = rs.getString("AircraftType");
                    this.airHome = rs.getString("AirportHome");
                    this.airCurr = rs.getString("AirportCurrent");
                    this.rentFee = rs.getInt("RentalFee");
                    this.airAge = rs.getInt("AircraftAge");
                    this.flightHrs = rs.getDouble("FlightHours");
                    this.flightDist = rs.getDouble("FlightDistance");
                    this.lastMaintType = rs.getString("LastMaintenanceType");
                    this.lastMaintDate = rs.getDate("LastMaintenanceDate");
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

    //admin add aircraft
    protected void addAircraft(String registration, int ownID, String makemodel, String aircrafttype, String airhome, String aircurr, int rentfee, int aircraftage, double flighthours, double flightdistance,
                                  String lastmtype, String lastmdate, String aircomms) throws Exception {
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

            String addAircraft = "INSERT INTO AscendDB.tblAircraft (Registration, OwnerID, Make_Model, AircraftType, AirportHome, AirportCurrent, RentalFee, AircraftAge, FlightHours, FlightDistance, " +
                    "LastMaintenanceType, LastMaintenanceDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(addAircraft);
            pstmt.setString(1, registration);
            pstmt.setInt(2, ownID);
            pstmt.setString(3, makemodel);
            pstmt.setString(4, aircrafttype);
            pstmt.setString(5, airhome);
            pstmt.setString(6, aircurr);
            pstmt.setInt(7, rentfee);
            pstmt.setInt(8, aircraftage);
            pstmt.setDouble(9, flighthours);
            pstmt.setDouble(10, flightdistance);
            pstmt.setString(11, lastmtype);
            pstmt.setDate(12, java.sql.Date.valueOf(lastmdate));
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.err.println("err");
            e.printStackTrace();
        }
    }

    //admin update aircraft info
    protected void updateAircraft(String oldReg, String registration, int ownID, String makemodel, String aircrafttype, String airhome, String aircurr, int rentfee, int aircraftage, double flighthours, double flightdistance,
                                  String lastmtype, String lastmdate) throws Exception {
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

            String updateAircraft = "UPDATE AscendDB.tblAircraft SET Registration = ?, OwnerID = ?, Make_Model = ?, AircraftType = ?, AirportHome = ?, AirportCurrent = ?, " +
                    "RentalFee = ?, AircraftAge = ?, FlightHours = ?, FlightDistance = ?, LastMaintenanceType = ?, LastMaintenanceDate = ?, WHERE Registration='" + oldReg + "';";
            PreparedStatement pstmt = connection.prepareStatement(updateAircraft);
            pstmt.setString(1, registration);
            pstmt.setInt(2, ownID);
            pstmt.setString(3, makemodel);
            pstmt.setString(4, aircrafttype);
            pstmt.setString(5, airhome);
            pstmt.setString(6, aircurr);
            pstmt.setInt(7, rentfee);
            pstmt.setInt(8, aircraftage);
            pstmt.setDouble(9, flighthours);
            pstmt.setDouble(10, flightdistance);
            pstmt.setString(11, lastmtype);
            pstmt.setDate(12, java.sql.Date.valueOf(lastmdate));
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.err.println("err");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "<p>Registration: " + this.reg + "</p><p>Owner ID: " + this.ownId + "</p><p>Make/Model: " + this.makeModel + "</p><p>Aircraft Type: " + this.airType +
                "</p><p>Airport Home: " + this.airHome + "</p><p>Airport Current: " + this.airCurr + "</p><p>Rental Fee: " + this.rentFee +
               "</p><p>Aircraft Age: " + this.airAge + "</p><p>Flight Hours: " + this.flightHrs + "</p><p>Flight Distance: " + this.flightDist + "</p><p>Last Maintenance Type: " +
                this.lastMaintType + "</p><p>Last Maintenance Date: " + this.lastMaintDate + "</p>";
    }
}