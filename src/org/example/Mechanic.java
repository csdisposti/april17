package org.example;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by cdisp on 3/15/2017.
 */
public class Mechanic {

    private long mechId;
    private long adminNo;
    private String servContNo;
    private String licensure;
    private String mechCom;

    //constrcutor
    public Mechanic(long mechId, long adminNo, String serContNo, String licenseure, String mechCom) {
        this.mechId = mechId;
        this.adminNo = adminNo;
        this.servContNo = serContNo;
        this.licensure = licenseure;
        this.mechCom = mechCom;
    }

    //get Mechanic Id
    public long getMechId() {
        return mechId;
    }

    //set Mechanic Id
    public void setMechId(long mechId) {
        this.mechId = mechId;
    }

    //get Mecahnic Admin Number
    public long getAdminNo() {
        return adminNo;
    }

    //set Mecahnic Admin Number
    public void setAdminNo(long adminNo) {
        this.adminNo = adminNo;
    }

    //get Mecahnic Service Contract Number
    public String getServContNo() {
        return servContNo;
    }

    //set Mecahnic Service Contract Number
    public void setServContNo(String servContNo) {
        this.servContNo = servContNo;
    }

    //get Mecahnic Licensure
    public String getLicensure() {
        return licensure;
    }

    //set Mecahnic Licensure
    public void setLicensure(String licensure) {
        this.licensure = licensure;
    }

    //get Mecahnic Comments
    public String getMechCom() {
        return mechCom;
    }

    //set Mecahnic Comments
    public void setMechCom(String mechCom) {
        this.mechCom = mechCom;
    }

    public void readFromDatabase(String MechanicID)throws Exception
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
            java.sql.ResultSet rs = statement.executeQuery("SELECT * FROM tblMechanic WHERE MechanicID="+MechanicID+";");

            if (rs != null) {
                //makes sure the resultSet isn't in the header info
                rs.next();

                this.mechId = rs.getLong("MechanicID");
                this.adminNo = rs.getLong("AdminNo");
                this.servContNo = rs.getString("ServiceContractNo");
                this.licensure = rs.getString("Licensure");
                this.mechCom = rs.getString("MechanicComments");
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
