package org.example;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by cdisp on 3/17/2017.
 */
public class AirportList extends Airports{
    private String faa;
    private String airportname;

    //constructor
    public AirportList(String faa, String airportname) {
        this.faa = faa;
        this.airportname = airportname;
    }

    //empty constructor
    public AirportList() {
        this.faa = null;
        this.airportname = null;
    }


    //get Airport FAA
    public String getFAA() {
        return faa;
    }

    //set Airport FAA
    public void setFAA(String faa) {
        this.faa = faa;
    }

    //get Airrport Name
    public String getAirportName() {
        return airportname;
    }

    //set Airport Name
    public void setAirportName(String airportname) {
        this.airportname = airportname;
    }



    public ArrayList<AirportList> populateResources() throws Exception {

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

        ArrayList<AirportList> airportsindb = new ArrayList<AirportList>();

        try {
            java.sql.Statement statement = connection.createStatement();
            java.sql.ResultSet rs = statement.executeQuery("SELECT FAACode, AirportName FROM AscendDB.tblAirports");

            if (rs != null) {
                //makes sure the resultSet isn't in the header info
                while (rs.next()) {
                    AirportList airportsL = new AirportList();
                    airportsL.setFAA(rs.getString("FAACode"));
                    airportsL.setAirportName(rs.getString("AirportName"));
                    airportsindb.add(airportsL);
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
        return airportsindb;
    }
    @Override
    public String toString() {
        return this.faa + " " + this.airportname;
    }
}