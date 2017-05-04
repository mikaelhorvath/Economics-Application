package controller;

import gui.MainWindow;
import gui.ReportWindow;
import objects.DBObj;

/**
 * Class handles the input of the user and sends it to AWSController for further work with the data
 * Created by mikaelhorvath on 2017-05-04.
 */
public class Controller {
    private MainWindow gui;
    private DBObj dbO;
    private ReportWindow rw;

    /**
     * Constructor recieves gui class
     * @param gui = MainWindow gui
     */
    public Controller(MainWindow gui, ReportWindow r){
        this.gui = gui;
        this.rw = r;
    }

    /**
     * Handles the user input
     * @param name = Name of user
     * @param desc = Description from user
     * @param email = Email of user
     * @param date = Date of entry
     * @param sum = Expenses
     */
    public void handleInput(String name, String desc, String email, String date, String sum) {
        int s = Integer.parseInt(sum);
        dbO = new DBObj(name, desc, email, date, s);
        sendToDB();
    }

    /**
     * Sends the DBObj to AWS to work with the database
     */
    private void sendToDB(){
        AWSController a = new AWSController(dbO);
        a.setController(this); // Setting this controller to AWSController
    }
}
