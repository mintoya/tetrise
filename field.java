import javax.swing.*;
import java.awt.*;

public class field extends JPanel {

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int[][] b ={{1,0,0,0},
                    {1,0,0,0},
                    {1,0,0,0},
                    {1,0,0,0}};
        block bl = new block(b,new position(0,0));
        paintBlox(bl,g);
        //g.fillRect(0,0,10,10);
    }
    protected void paintBlox(block b, Graphics g){
        int size = 10;
        for (int i = 0; i < b.getBlock().length; i++) {
            for (int j = 0; j < b.getBlock()[i].length; j++) {
                int[] pos = b.position.get();
                if(b.getBlock()[j][i]){

                    g.fillRect(size*i+pos[0],size*j+pos[1],size,size);
                }
            }

        }
    }
}