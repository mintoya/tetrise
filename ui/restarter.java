package ui;

import stuffs.gaem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class restarter implements ActionListener {
    public JButton button1;
    private JPanel panel1;
    private JFormattedTextField HighScore;
    private JFormattedTextField Score;
    public restarter(int high, int score){
        HighScore.setText(String.valueOf(high));
        HighScore.setEditable(false);
        Score.setText(String.valueOf(score));
        Score.setEditable(false);
        JFrame frame = new JFrame();
        frame.setBounds(0,0,150,250);
        frame.add(panel1);
        frame.setVisible(true);

    }
    public static void main(String args[]){
        restarter r = new restarter(100,100);
        r.button1.addActionListener(r);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        gaem g = new gaem();
        g.gField.frame.addKeyListener(g.gField);
        g.start();
    }
}
