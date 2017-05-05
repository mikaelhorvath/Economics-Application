package controller;

import objects.DBObj;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * This class handles database events from Amazon Web Services
 * Created by mikaelhorvath on 2017-05-04.
 */
public class AWSController {
    private DBObj dbO;
    private Controller c;
    private ArrayList<DBObj> arr = new ArrayList<DBObj>();

    public AWSController(){
        // Empty
    }
    /**
     * Sets Controller class
     * @param cont = Controller.java
     */
    public void setController(Controller cont){
        this.c = cont;
        loadDBModule();
    }

    /**
     * Setting the object and calling the upload method
     * @param o = object
     */
    public void setDBObj(DBObj o){
        this.dbO = o;
        uploadToAWS();
    }

    /**
     * Loading database module
     */
    private void loadDBModule(){
        try {
            System.out.println("Loading driver...");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find the driver in the classpath!", e);
        }
    }

    /**
     * Method uses SQL logic to upload information to AWS RDS Database
     */
    private void uploadToAWS(){
        String url = "jdbc:mysql://iotapdb.cr5wcbntqpwo.eu-central-1.rds.amazonaws.com:3306/iotapdb";
        String username = "mikaelhorvath";
        String password = "angelica";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement();
            String namez = dbO.getName();
            String descr = dbO.getDesc();
            String emailz = dbO.getEmail();
            int sumz = dbO.getSum();
            stmt.executeUpdate("INSERT INTO `Expenses`(Namn,Description,Mejl,Summa) VALUE ('"+namez+"','"+descr+"','"+emailz+"',"+sumz+")");
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect the database!", e);
        }
        downloadFromAWS();
    }

    /**
     * Method uses SQL logic to download information from AWS RDS Databse
     */
    public void downloadFromAWS(){
        String url = "jdbc:mysql://iotapdb.cr5wcbntqpwo.eu-central-1.rds.amazonaws.com:3306/iotapdb";
        String username = "mikaelhorvath";
        String password = "angelica";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Namn, Description, Mejl, Summa FROM Expenses");
            while(rs.next()) {
                String name = rs.getString("Namn");
                String descr = rs.getString("Description");
                String mail = rs.getString("Mejl");
                int sumz = rs.getInt("Summa");
                // Insert Obj here
                DBObj obj = new DBObj(name, descr, mail, getDate(), sumz);
                arr.add(obj); // Adding to list
                sendBackToController(arr);
            }
            stmt.close();
            connection.close();
            arr.clear();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect the database!", e);
        }
    }

    /**
     * Returns current date
     * @return
     */
    private String getDate(){
        return new SimpleDateFormat("yyyy - MM - dd").format(Calendar.getInstance().getTime());
    }

    /**
     * Sends back the list to controller
     * @param arrayList = list of data
     */
    private void sendBackToController(ArrayList<DBObj> arrayList){
        c.recieveFromAWSController(arrayList);
    }


}
