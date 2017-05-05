package controller;

import objects.DBObj;

/**
 * This class handles database events from Amazon Web Services
 * Created by mikaelhorvath on 2017-05-04.
 */
public class AWSController {
    private DBObj dbO;
    private Controller c;

    public AWSController(DBObj d){
        this.dbO = d;
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

    }

    /**
     * Method uses SQL logic to download information from AWS RDS Databse
     */
    public void downloadFromAWS(){

    }

}
