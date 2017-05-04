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
        printInfo();
    }

    private void printInfo(){
        System.out.println("AWS:"+" "+dbO.getEmail());
    }

    /**
     * Sets Controller class
     * @param cont = Controller.java
     */
    public void setController(Controller cont){
        this.c = cont;
    }

}
