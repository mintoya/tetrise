package ui;

import javax.swing.*;

public class restarter {
    public JButton button1;
    private JPanel panel1;
    private JFormattedTextField HighScore;
    private JFormattedTextField Score;
    public restarter(int high, int score){
        HighScore.setText(String.valueOf(high));
        HighScore.setEnabled(false);
        Score.setText(String.valueOf(score));
        Score.setEnabled(false);
        JFrame frame = new JFrame();
        frame.setBounds(0,0,100,100);
        frame.add(panel1);
        frame.setVisible(true);

    }
}
