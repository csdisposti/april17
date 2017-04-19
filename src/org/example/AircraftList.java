package org.example;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

/**
 * Created by cdisp on 3/17/2017.
 */
public class AircraftList {
    private String reg;

    private String makeModel;


    //constructor
    public AircraftList(String reg,String makeModel) {
        this.reg = reg;

        this.makeModel = makeModel;
    }

    //empty constructor
    public AircraftList() {
        this.reg = null;

        this.makeModel = null;

    }


    //get Aircraft Registration
    public String getReg() {
        return reg;
    }

    //set Aircraft Registration
    public void setReg(String reg) {
        this.reg = reg;
    }



    //get Aircraft Make Model
    public String getMakeModel() {
        return makeModel;
    }

    //set Aircraft Make Model
    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }



    public ArrayList<AircraftList> populateResourcesReserved() throws Exception {

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

        ArrayList<AircraftList> aircrafts = new ArrayList<AircraftList>();

        try {
            java.sql.Statement statement = connection.createStatement();
            java.sql.ResultSet rs = statement.executeQuery("SELECT Registration, Make_Model FROM AscendDB.tblAircraft");

            if (rs != null) {
                //makes sure the resultSet isn't in the header info
                while (rs.next()) {
                    AircraftList aircraft = new AircraftList();
                    aircraft.setReg(rs.getString("Registration"));
                    aircraft.setMakeModel(rs.getString("Make_Model"));
                    aircrafts.add(aircraft);
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
        return aircrafts;
    }
    @Override
    public String toString() {
        return "<span>" + this.reg + " " + this.makeModel + "</span>";
    }
}