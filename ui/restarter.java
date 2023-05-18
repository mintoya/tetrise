package ui;

import stuffs.gaem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class restarter  {
    private JFrame frame;
    private JPanel panel1;
    private JFormattedTextField Score;
    public restarter(int score){
        Score.setText("your score was "+ score);
        Score.setEditable(false);
        frame = new JFrame();
        frame.setBounds(0,0,150,250);
        frame.add(panel1);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}