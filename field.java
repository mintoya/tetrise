import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class field extends JPanel {
    arrayCalculator calculator = new arrayCalculator();
    JFrame frame;
    public field(block b,JFrame f){
        super();
        requestFocusInWindow();
        frame = f;

        currentBlock = b;
        for(int i = 0;i<grid.length;i+=1){
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = false;
            }
        }
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Key pressed: " + e.getKeyCode());
                switch(e.getKeyCode()){
                    case(38)->{rotate();}//up
                    case(39)->{
                        if(calculator.canMove('r',grid,currentBlock.getBlock(),currentBlock.position)){
                            currentBlock.position.change(new int[]{1,0});
                        }
                        frame.repaint();
                    }//right
                    case(37)->{
                        if(calculator.canMove('l',grid,currentBlock.getBlock(),currentBlock.position)){
                            currentBlock.position.change(new int[]{-1,0});
                        }
                        frame.repaint();
                    }//left
                    case(40)->{fall();}//down
                }

            }
        });
    }

    private block currentBlock;
    public void setCurrentBlock(block currentBlock) {
        this.currentBlock = currentBlock;
    }
    public void rotate(){
        System.out.println(calculator.canRotate(grid,currentBlock.getBlock(),currentBlock.position));
        if(calculator.canRotate(grid,currentBlock.getBlock(),currentBlock.position))
            currentBlock.rotate();
        frame.repaint();
    }

    private int pixelsize = 20;
    private Boolean[][] grid  = new Boolean[20][10];

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        drawGrid(g);
        paintBlox(currentBlock,g,new Color(217, 214, 214));
        //fall();
        //<editor-fold desc="test section">
        //block[] bl = new block[2];
        //bl[0] = new block('j',new position(0,0)) ;//bl[4] = new block('l',new position(160,0));
        //bl[1] = new block('s',new position(4,0)) ;//bl[5] = new block('z',new position(200,0));
        //bl[2] = new block('T',new position(80,0));bl[6] = new block('L',new position(240,0));
        //bl[3] = new block('o',new position(120,0));

        //for (block a:bl) {
        //    paintBlox(a,g,new Color(255,255,255));
        //}
        //</editor-fold>
    }
    public void fall(){
        if(calculator.canMove('d',grid,currentBlock.getBlock(),currentBlock.position)){
            currentBlock.position.change(new int[]{0,1});
        }else{
            grid = calculator.addTwo(grid,currentBlock.getBlock(),currentBlock.position);

            char c; int rand = (int)(Math.random()*7)+1;
            switch (rand){
                        case(1)->{c = 'l';}
                        case(2)->{c = 'j';}
                        case(3)->{c = 'o';}
                        case(4)->{c = 'T';}
                        case(5)->{c = 's';}
                        case(6)->{c = 'z';}
                        default -> {c = 'L';}
                    }
            currentBlock = new block(c,new position(0,0));
        }
        frame.repaint();
    }

    protected void drawGrid(Graphics g){
        int size = pixelsize;
        for (int i = 0;i<grid.length;i+=1){
            for(int j = 0;j<grid[i].length;j+=1){
                g.drawRect(size*j,size*i,size,size);
                // responsible for drawing taken blox
                if(grid[i][j]) {
                    g.fillRect((size * j) + 1, (size * i) + 1, size - 2, size - 2);
                }
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
                    g.fillRect(size*i+((pos[0]*size)+1),size*j+((pos[1]*size)+1),size-2,size-2);

                }
            }

        }
    }

}