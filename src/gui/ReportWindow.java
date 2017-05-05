package gui;

import objects.DBObj;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by mikaelhorvath on 2017-05-04.
 */
public class ReportWindow extends JPanel {
    private ArrayList<DBObj> arrayList = new ArrayList<DBObj>();

    public ReportWindow(){
        setLayout(null);
        setPreferredSize(new Dimension(350, 350));
    }

    public void populateArray(ArrayList<DBObj> arr){
        this.arrayList = arr;
        System.out.println("Stuff in List:"+" "+arrayList.size());
    }

    public void setFrame(){
        JFrame f = new JFrame();
        f.add(this);
        f.pack();
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        f.setTitle("Reports");
        f.setVisible(true);
    }

}
