package org.example;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.Properties;

/**
 * Created by cdisp on 3/17/2017.
 */
public class Account {
    private int acctId;
    private String acctType;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String paymentPlan;
    private int totalChgs; 
    private int totalPays; 
    private int creditReds; 
    private Date lastInvDate;
    private Date lastPayDate;
    private String acctStat;
    private String acctCom;

	//constructor
    public Account(int acctId, String acctType, String street, String city, String state, String zip, String paymentPlan, int totalChgs, int totalPays, int creditReds, Date lastInvDate, Date lastPayDate, String acctStat, String acctCom) {
        this.acctId = acctId;
        this.acctType = acctType;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.paymentPlan = paymentPlan;
        this.totalChgs = totalChgs;
        this.totalPays = totalPays;
        this.creditReds = creditReds;
        this.lastInvDate = lastInvDate;
        this.lastPayDate = lastPayDate;
        this.acctStat = acctStat;
        this.acctCom = acctCom;
    }

    //empty constructor
    public Account() {
        this.acctId = 0;
        this.acctType = null;
        this.street = null;
        this.city = null;
        this.state = null;
        this.zip = null;
        this.paymentPlan = null;
        this.totalChgs = 0;
        this.totalPays = 0;
        this.creditReds = 0;
        this.lastInvDate = null;
        this.lastPayDate = null;
        this.acctStat = null;
        this.acctCom = null;
    }

    //get Account Id
    public int getAcctId() {
        return acctId;
    }

    //set Account Id
    public void setAcctId(int acctId) {
        this.acctId = acctId;
    }

    //get Account Type
    public String getAcctType() {
        return acctType;
    }

    //set Account Type
    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    //get Account Street Address
    public String getStreet() {
        return street;
    }

    //set Account Street Address
    public void setStrett(String strett) {
        this.street = street;
    }

    //get Account City
    public String getCity() {
        return city;
    }

    //set Account City
    public void setCity(String city) {
        this.city = city;
    }

    //get Account State
    public String getState() {
        return state;
    }

    //set Account State
    public void setState(String state) {
        this.state = state;
    }

    //get Account Zip Code
    public String getZip() {
        return zip;
    }

    //set Account Zip Code
    public void setZip(String zip) {
        this.zip = zip;
    }

    //get Account Payment Plan
    public String getPaymentPlan() {
        return paymentPlan;
    }

    //set Account Payment Plan
    public void setPaymentPlan(String paymentPlan) {
        this.paymentPlan = paymentPlan;
    }

    //get Account Total Charges
    public int getTotalChgs() {
        return totalChgs;
    }

    //set Account Total Charges
    public void setTotalChgs(int totalChgs) {
        this.totalChgs = totalChgs;
    }

    //get Account Total Payments
    public int getTotalPays() {
        return totalPays;
    }

    //set Account Total Payments
    public void setTotalPays(int totalPays) {
        this.totalPays = totalPays;
    }

    //get Account Credit Reductions
    public int getCreditReds() {
        return creditReds;
    }

    //set Account Credit Reductions
    public void setCreditReds(int creditReds) {
        this.creditReds = creditReds;
    }

    //get Account Last Invoice Date
    public Date getLastInvDate() {
        return lastInvDate;
    }

    //set Account Last Invoice Date
    public void setLastInvDate(Date lastInvDate) {
        this.lastInvDate = lastInvDate;
    }

    //get Account Last Payment Date
    public Date getLastPayDate() {
        return lastPayDate;
    }

    //set Account Last Payment Date
    public void setLastPayDate(Date lastPayDate) {
        this.lastPayDate = lastPayDate;
    }

    //get Account Statement
    public String getAcctStat() {
        return acctStat;
    }

    //set Account Statement
    public void setAcctStat(String acctStat) {
        this.acctStat = acctStat;
    }

    //get Account Comments
    public String getAcctCom() {
        return acctCom;
    }

    //set Account Comments
    public void setAcctCom(String acctCom) {
        this.acctCom = acctCom;
    }

    //read entire member from database using account id in column AccountID
    public void readFromDatabase(int accID) throws Exception {
        //open database connection
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
            //create statement
            java.sql.Statement statement = connection.createStatement();
            java.sql.ResultSet rs = statement.executeQuery("SELECT * FROM AscendDB.tblAccount WHERE AccountID=" + accID + ";");

            if (rs != null) {
                //makes sure the resultSet isn't in the header info
                rs.next();

                this.acctId = rs.getInt("AccountID");
                this.acctType = rs.getString("AccountType");
                this.street = rs.getString("StreetAddress");
                this.city = rs.getString("City");
                this.state = rs.getString("State");
                this.zip = rs.getString("Zip");
                this.paymentPlan = rs.getString("PaymentPlan");
                this.totalChgs = rs.getInt("TotalCharges");
                this.totalPays = rs.getInt("TotalPayments");
                this.creditReds = rs.getInt("Credits_Reductions");
                this.lastInvDate = rs.getDate("LastInvoiceDate");
                this.lastPayDate = rs.getDate("LastPaymentDate");
                this.acctStat = rs.getString("AccountStatus");
                this.acctCom = rs.getString("AccountComments");
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

    //add an account to the database
    protected void addToDatabase(String street, String city, String state, String zip, String acccomms) throws Exception {
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
            //create statement
            java.sql.Statement statement = connection.createStatement();
            //create new account
            String newAcc = "INSERT INTO AscendDB.tblAccount () VALUES ()";
            PreparedStatement ps = connection.prepareStatement(newAcc);
            ps.executeUpdate();

            //get account just created
            java.sql.ResultSet rs = statement.executeQuery("SELECT AccountID FROM AscendDB.tblAccount ORDER BY AccountID DESC LIMIT 1");
            rs.next();
            this.acctId = rs.getInt("AccountID");

            //update newly created account with user data
            String updateAccount = "UPDATE AscendDB.tblAccount SET AccountType = ?, StreetAddress = ?, City = ?, State = ?, Zip = ?, PaymentPlan = ?, TotalCharges = ?, TotalPayments = ?, Credits_Reductions = ?, LastInvoiceDate = ?, LastPaymentDate = ?, AccountStatus = ?, AccountComments = ? WHERE AccountID =" + acctId +";";

           PreparedStatement pstmt = connection.prepareStatement(updateAccount);
           pstmt.setString(1, "T");
           pstmt.setString(2, street);
           pstmt.setString(3, city);
           pstmt.setString(4, state);
           pstmt.setString(5, zip);
           pstmt.setString(6, "P");
           pstmt.setInt(7, 0);
           pstmt.setInt(8, 0);
           pstmt.setInt(9, 0);
           pstmt.setNull(10, java.sql.Types.DATE);
           pstmt.setNull(11, java.sql.Types.DATE);
           pstmt.setString(12, "N");
           pstmt.setString(13, acccomms);
           pstmt.executeUpdate();

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

    //update an account in the database

    protected void updateAccount(int accid, String accttype, String street, String city, String state, String zip, String payplan, int totcharges, int totpayments, int creditreduc,  Date lastinvoicedate, Date lastpaymentdate, String accountstatus, String acccomms ) throws Exception {
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
            //create statement
            //update account with user data
            String updateAccount = "UPDATE AscendDB.tblAccount SET AccountType = ?, StreetAddress = ?, City = ?, State = ?, Zip = ?, PaymentPlan = ?, TotalCharges = ?, TotalPayments = ?, Credits_Reductions = ?, LastInvoiceDate = ?, LastPaymentDate = ?, AccountStatus = ?, AccountComments = ? WHERE AccountID =" + accid +";";

            PreparedStatement pstmt = connection.prepareStatement(updateAccount);
            pstmt.setString(1, accttype);
            pstmt.setString(2, street);
            pstmt.setString(3, city);
            pstmt.setString(4, state);
            pstmt.setString(5, zip);
            pstmt.setString(6, payplan);
            pstmt.setInt(7, totcharges);
            pstmt.setInt(8, totpayments);
            pstmt.setInt(9, creditreduc);
            pstmt.setDate(10, new java.sql.Date(lastinvoicedate.getTime()));
            pstmt.setDate(11, new java.sql.Date(lastpaymentdate.getTime()));
            pstmt.setString(12, accountstatus);
            pstmt.setString(13, acctCom);
            pstmt.executeUpdate();

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

    //get current date - not currently used
    private static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    //return the newly created account that was created in addToDatabase
    protected int getNewAcctId() throws Exception {
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
            java.sql.ResultSet rs = statement.executeQuery("SELECT AccountID FROM tblAccount ORDER BY AccountID DESC LIMIT 1");

            rs.next();
            this.acctId = rs.getInt("AccountID");
            System.out.println(acctId);

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
        return this.acctId;
    }

    @Override
    public String toString() {
        /*private Date lastInvDate;
        private Date lastPayDate;*/
        return "<p>Account ID: "+this.acctId +"</p><p>Account Type: "+this.acctType+"</p><p>Street: "+ this.street+"</p><p>City: "+this.city+"</p><p>State: "+this.state+"</p><p>Zip Code: "+
                this.zip+"</p><p>Payment Plan: "+this.paymentPlan+"</p><p>Total Charges: "+this.totalChgs+"</p><p>Total Payments: "+this.totalPays+"</p><p>Credits Reductions: "+
                this.creditReds+"</p><p>Account Status: " + this.acctStat +"</p><p>Account Comments: " + this.acctCom +"</p>";
    }
}
