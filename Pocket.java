import javax.swing.*;
import java.awt.*;

public class Pocket extends JPanel {
    private arrayCalculator calculator = new arrayCalculator();

    public Pocket(int size){pixelsize = size;}

    private int pixelsize;
    private JTextField score = new JTextField("0");

    public JTextField getScore() {
        return score;
    }

    public void draw(Graphics g, block a, int score){
        this.score.setText(String.valueOf(score));
        if(a!=null){
            Boolean[][] got = calculator.mirror(a.getBlock());
            got = calculator.rot(got);
         for (int i = 0; i < got.length; i++) {
            for (int j = 0; j < got[0].length; j++) {
                g.setColor(a.getColor());
                if(a!=null)
                if(got[i][j]){
                    g.fillRect((pixelsize*i)+200,pixelsize*j,pixelsize,pixelsize);
                }
                g.setColor(new Color(0));
                g.drawRect((pixelsize*i)+200,pixelsize*j,pixelsize,pixelsize);
            }
        }}
    }

}
