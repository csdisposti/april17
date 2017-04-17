package org.example;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by cdisp on 3/17/2017.
 */
public class Airports {
    private String faaCode;
    private String airportName;
    private String airportType;
    private String airportSt;
    private String airportCity;
    private double latitude;
    private double longitude;
    private String contactName;
    private String contactPhone;
    private String ctaf;
    private String runwayType;
    private String towerFreq;
    private long fuel; //error message from metadata unknown mySql type
    private String storage;
    private String airportCom;

    public Airports(String faaCode, String airportName, String airportType, String airportSt, String airportCity,
                    double latitude, double longitude, String contactName, String contactPhone, String ctaf,
                    String runwayType, String towerFreq, long fuel, String storage, String airportCom) {
        this.faaCode = faaCode;
        this.airportName = airportName;
        this.airportType = airportType;
        this.airportSt = airportSt;
        this.airportCity = airportCity;
        this.latitude = latitude;
        this.longitude = longitude;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.ctaf = ctaf;
        this.runwayType = runwayType;
        this.towerFreq = towerFreq;
        this.fuel = fuel;
        this.storage = storage;
        this.airportCom = airportCom;
    }

    //get Airport FAA Code
    public String getFaaCode() {
        return faaCode;
    }

    //set Airport FAA Code
    public void setFaaCode(String faaCode) {
        this.faaCode = faaCode;
    }

    //get Airport Name
    public String getAirportName() {
        return airportName;
    }

    //set Airport Name
    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    //get Airport Type
    public String getAirportType() {
        return airportType;
    }

    //set Airport Type
    public void setAirportType(String airportType) {
        this.airportType = airportType;
    }

    //get Airport Street
    public String getAirportSt() {
        return airportSt;
    }

    //set Airport Street
    public void setAirportSt(String airportSt) {
        this.airportSt = airportSt;
    }

    //get Airport City
    public String getAirportCity() {
        return airportCity;
    }

    //set Airport City
    public void setAirportCity(String airportCity) {
        this.airportCity = airportCity;
    }

    //get Airport Latitude
    public double getLatitude() {
        return latitude;
    }

    //set Airport Latitude
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    //get Airport Longitude
    public double getLongitude() {
        return longitude;
    }

    //set Airport Longitude
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    //get Airport Contact Name
    public String getContactName() {
        return contactName;
    }

    //set Airport Contact Name
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    //get Airport Contact Phone
    public String getContactPhone() {
        return contactPhone;
    }

    //set Airport Contact Phone
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    //get Airport CTAF
    public String getCtaf() {
        return ctaf;
    }

    //set Airport CTAF
    public void setCtaf(String ctaf) {
        this.ctaf = ctaf;
    }

    //get Airport Runway Type
    public String getRunwayType() {
        return runwayType;
    }

    //set Airport Runway Type
    public void setRunwayType(String runwayType) {
        this.runwayType = runwayType;
    }

    //get Airport Tower Frequency
    public String getTowerFreq() {
        return towerFreq;
    }

    //set Airport Tower Frequency
    public void setTowerFreq(String towerFreq) {
        this.towerFreq = towerFreq;
    }

    //get Airport Fuel
    public long getFuel() {
        return fuel;
    }

    //set Airport Fuel
    public void setFuel(long fuel) {
        this.fuel = fuel;
    }

    //get Airport Storage
    public String getStorage() {
        return storage;
    }

    //set Airport Storage
    public void setStorage(String storage) {
        this.storage = storage;
    }

    //get Airport Comments
    public String getAirportCom() {
        return airportCom;
    }

    //set Airport Comments
    public void setAirportCom(String airportCom) {
        this.airportCom = airportCom;
    }

    public void readFromDatabase(String FAACode) throws Exception
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
            java.sql.ResultSet rs = statement.executeQuery("SELECT * FROM tblAirports WHERE FAACode="+FAACode+";");

            if (rs != null) {
                //makes sure the resultSet isn't in the header info
                rs.next();

                this.faaCode = rs.getString("FAACode");
                this.airportName = rs.getString("AirportName");
                this.airportType = rs.getString("AirportType");
                this.airportSt = rs.getString("Street");
                this.airportCity = rs.getString("City");
                this.latitude = rs.getDouble("Latitude");
                this.longitude = rs.getDouble("Longitude");
                this.contactName = rs.getString("ContactName");
                this.contactPhone = rs.getString("ContactPhone");
                this.ctaf = rs.getString("CTAF_UNICOM");
                this.runwayType = rs.getString("RunwayType");
                this.towerFreq = rs.getString("TowerFreq");
                this.fuel = rs.getLong("Fuel_100LL");
                this.storage = rs.getString("Storage");
                this.airportCom = rs.getString("AirportComments");
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
