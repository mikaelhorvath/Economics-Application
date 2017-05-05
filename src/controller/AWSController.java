package controller;

import objects.DBObj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class handles database events from Amazon Web Services
 * Created by mikaelhorvath on 2017-05-04.
 */
public class AWSController {
    private DBObj dbO;
    private Controller c;

    public AWSController(DBObj d){
        this.dbO = d;
        uploadToAWS();
    }
    /**
     * Sets Controller class
     * @param cont = Controller.java
     */
    public void setController(Controller cont){
        this.c = cont;
        loadDBModule();
    }

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
            // Not working just yet!
            stmt.executeUpdate("INSERT INTO `Expenses`(Namn,Description,Mejl,Summa) VALUE ('"+namez+"','"+descr+"','"+emailz+"',"+sumz+")");
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect the database!", e);
        }
    }

    /**
     * Method uses SQL logic to download information from AWS RDS Databse
     */
    public void downloadFromAWS(){

    }

}
