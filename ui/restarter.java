package ui;

import javax.swing.* ;

public class restarter  {
    public JFrame frame;
    public JPanel score;
    private JFormattedTextField Score;
    public restarter(int score){
        Score.setText("your score was "+ score);
        Score.setEditable(false);

        frame = new JFrame();
        frame.setBounds(0,0,170 ,60);
        frame.add(this.score);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}