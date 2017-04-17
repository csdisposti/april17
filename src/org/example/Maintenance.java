package org.example;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Date;
import java.util.Properties;

/**
 * Created by cdisp on 3/17/2017.
 */
public class Maintenance {
    private String servConId;
    private double conTotal; //error unknown mySql type
    private Date conStaDate;
    private Date conEndDate;
    private String payMethod;

    public Maintenance(String servConId, double conTotal, Date conStaDate, Date conEndDate, String payMethod) {
        this.servConId = servConId;
        this.conTotal = conTotal;
        this.conStaDate = conStaDate;
        this.conEndDate = conEndDate;
        this.payMethod = payMethod;
    }

    //get Maintenance Service Contract Id
    public String getServConId() {
        return servConId;
    }

    //set Maintenance Service Contract Id
    public void setServConId(String servConId) {
        this.servConId = servConId;
    }

    //get Maintenance Contract Total
    public double getConTotal() {
        return conTotal;
    }

    //set Maintenance Contract Total
    public void setConTotal(double conTotal) {
        this.conTotal = conTotal;
    }

    //get Maintenance Contract Start Date
    public Date getConStaDate() {
        return conStaDate;
    }

    //set Maintenance Contract Start Date
    public void setConStaDate(Date conStaDate) {
        this.conStaDate = conStaDate;
    }

    //get Maintenance Contract End Date
    public Date getConEndDate() {
        return conEndDate;
    }

    //set Maintenance Contract End Date
    public void setConEndDate(Date conEndDate) {
        this.conEndDate = conEndDate;
    }

    //get Maintenance Payment Method
    public String getPayMethod() {
        return payMethod;
    }

    //set Maintenance Payment Method
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public void readFromDatabase(String contractID)throws Exception
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
            java.sql.ResultSet rs = statement.executeQuery("SELECT * FROM tblMaintenance WHERE FName="+contractID+";");

            if (rs != null) {
                //makes sure the resultSet isn't in the header info
                rs.next();

                this.servConId = rs.getString("ServiceContractID");
                this.conTotal = rs.getDouble("ContractTotal");
                this.conStaDate = rs.getDate("ContractStartDate");
                this.conEndDate = rs.getDate("ContractEndDate");
                this.payMethod = rs.getString("PaymentMethod");
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

