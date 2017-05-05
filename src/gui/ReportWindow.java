package gui;

import objects.DBObj;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Shows the report window with downloaded data from AWS RDS Database
 * Created by mikaelhorvath on 2017-05-04.
 */
public class ReportWindow extends JPanel {
    private ArrayList<DBObj> arrayList = new ArrayList<DBObj>();
    private DefaultListModel<DBObj> listModel = new DefaultListModel<DBObj>();
    private JList<DBObj> list = new JList<DBObj>(listModel);

    /**
     * Constructor
     */
    public ReportWindow(){
        setLayout(null);
        setPreferredSize(new Dimension(380, 350));

        // Handles listModel with scroll
        // List
        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(5, 5, 370, 340);
        scroll.setViewportView(list);
        add(scroll);
    }

    /**
     * Method populates the list with an arrayList
     * @param arr = arrayList of data
     */
    public void populateArray(ArrayList<DBObj> arr){
        listModel.clear();
        for (DBObj d : arr){
            listModel.addElement(d);
        }
        list.setModel(listModel);
    }

    /**
     * Setting the frame
     */
    public void setFrame(){
        JFrame f = new JFrame();
        f.add(this);
        f.pack();
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        f.setTitle("Reports");
        f.setVisible(true);
    }

}
