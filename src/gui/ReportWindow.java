package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mikaelhorvath on 2017-05-04.
 */
public class ReportWindow extends JPanel {

    public ReportWindow(){
        setLayout(null);
        setPreferredSize(new Dimension(350, 350));
        setFrame();
    }

    private void setFrame(){
        JFrame f = new JFrame();
        f.add(this);
        f.pack();
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        f.setTitle("Reports");
        f.setVisible(true);
    }

}
