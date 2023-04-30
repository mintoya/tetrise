import javax.swing.*;
import java.awt.*;

public class Pocket extends JPanel {

    public Pocket(int size){pixelsize = size;}

    private int pixelsize;
    private JTextField score = new JTextField("0");

    public JTextField getScore() {
        return score;
    }

    public void draw(Graphics g, block a, int score){
        this.score.setText(String.valueOf(score));
        if(a!=null)
         for (int i = 0; i < a.getBlock().length; i++) {
            for (int j = 0; j < a.getBlock()[0].length; j++) {
                g.setColor(a.getColor());
                if(a.getBlock()[i][j]){
                    g.fillRect((pixelsize*i)+205,pixelsize*j,pixelsize,pixelsize);
                }
            }
        }
    }

}
