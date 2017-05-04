package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This is the main window of the application
 * Created by mikaelhorvath on 2017-05-04.
 */
public class MainWindow extends JPanel implements ActionListener {
    private JLabel headerLbl = new JLabel("Economics Application v1.0");
    private JLabel nameLbl, descLbl, sumLbl, emailLbl, dateLbl;
    private JTextField nameTxt, descTxt, sumTxt, emailTxt;
    private JButton regBtn = new JButton("Register entry!");
    private JButton repBtn = new JButton("Open report window!");
    private ReportWindow r;
    private Controller c;
    /**
     * Constructor
     */
    public MainWindow(){
        setController();

        setLayout(null);
        setPreferredSize(new Dimension(300,380));
        headerLbl.setBounds(60, 10, 220, 30);
        add(headerLbl);
        headerLbl.setFont(new Font("default", Font.BOLD, 12));

        // Setting labels
        nameLbl = new JLabel("Name:");
        descLbl = new JLabel("Descr:");
        sumLbl = new JLabel("Sum:");
        emailLbl = new JLabel("Email:");

        nameLbl.setBounds(15, 65, 60, 30);
        add(nameLbl);
        nameTxt = new JTextField();
        nameTxt.setBounds(70, 65, 210, 30);
        add(nameTxt);

        descLbl.setBounds(15, 100, 60, 30);
        add(descLbl);
        descTxt = new JTextField();
        descTxt.setBounds(70, 100, 210, 30);
        add(descTxt);

        emailLbl.setBounds(15, 135, 60, 30);
        add(emailLbl);
        emailTxt = new JTextField();
        emailTxt.setBounds(70, 135, 210, 30);
        add(emailTxt);

        sumLbl.setBounds(15, 170, 60, 30);
        add(sumLbl);
        sumTxt = new JTextField();
        sumTxt.setBounds(70, 170, 210, 30);
        add(sumTxt);

        dateLbl = new JLabel();
        dateLbl.setBounds(15, 205, 210, 30);
        dateLbl.setText("Date today:"+" "+getDate());
        add(dateLbl);

        regBtn.setBounds(70, 255, 160, 30);
        add(regBtn);
        regBtn.addActionListener(this);

        repBtn.setBounds(70, 290, 160, 30);
        add(repBtn);
        repBtn.addActionListener(this);
    }

    private String getDate(){
        return new SimpleDateFormat("yyyy - MM - dd").format(Calendar.getInstance().getTime());
    }

    private void setController(){
        r = new ReportWindow();
        c = new Controller(this, r);
    }

    /**
     * Handles events on our buttons
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == regBtn){
            // Sends the input from the user to controller for further work
            if(nameTxt.getText().length() == 0 || descTxt.getText().length() == 0
                    || emailTxt.getText().length() == 0 || sumTxt.getText().length() == 00){
                JOptionPane.showMessageDialog(null, "You must fill out the form!");
            }else{
                c.handleInput(nameTxt.getText(), descTxt.getText(), emailTxt.getText(), getDate(), sumTxt.getText());
            }
        }

        if(e.getSource() == repBtn){
            r.setFrame();
        }
    }

    public static void main(String[] args) {
        MainWindow w = new MainWindow();
        JFrame f = new JFrame();
        f.add(w);
        f.setTitle("Economics 1.0");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
