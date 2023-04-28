import javax.swing.*;
import java.awt.*;

public class field extends JPanel {

    private int pixelsize = 10;
    private Boolean[][] grid  = new Boolean[20][10];

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        drawGrid(g);
        //<editor-fold desc="test section">
//        block[] bl = new block[7];
//        bl[0] = new block('j',new position(0,0)) ;bl[4] = new block('l',new position(160,0));
//        bl[1] = new block('s',new position(40,0)) ;bl[5] = new block('z',new position(200,0));
//        bl[2] = new block('T',new position(80,0));bl[6] = new block('L',new position(240,0));
//        bl[3] = new block('o',new position(120,0));
//
//        for (block a:bl) {
//            a.rotate();
//            paintBlox(a,g,new Color(255,255,255));
//        }
        //</editor-fold>
    }

    protected void drawGrid(Graphics g){
        int size = pixelsize;
        for (int i = 0;i<grid.length;i+=1){
            for(int j = 0;j<grid[i].length;j+=1){
                g.drawRect(size*j,size*i,size,size);
            }
        }
    }
    protected void paintBlox(block b, Graphics g, Color c){
        int size = pixelsize;
        for (int i = 0; i < b.getBlock().length; i++) {
            for (int j = 0; j < b.getBlock()[i].length; j++) {
                int[] pos = b.position.get();
                if(b.getBlock()[j][i]){
                    g.setColor(c);
                    g.fillRect(size*i+pos[0]+1,size*j+pos[1]+1,size-2,size-2);

                }
            }

        }
    }
}