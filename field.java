import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class field extends JPanel {

    private int score = 0;
    private final arrayCalculator calculator = new arrayCalculator();
    private final JFrame frame;

    private block currentBlock;
    private block heldBlock=null;
    public field(block b,JFrame f){
        super();
        frame = f;
        currentBlock = b;
        for (Boolean[] booleans : grid) {
            Arrays.fill(booleans, false);
        }
        //<editor-fold desc="controls">
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
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
                    case(67)-> {block temp = currentBlock;
                        if(!currentBlock.hasBeenHeld){
                        if(heldBlock!=null){
                            heldBlock.position = new position(0,0);
                            currentBlock = heldBlock;
                        heldBlock = temp;
                        heldBlock.hasBeenHeld = true;}
                        else{
                            heldBlock = currentBlock;
                            //<editor-fold desc="c is random char">
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
                            //</editor-fold>
                            currentBlock = new block(c,new position(0,0));
                        }
                        }
                    }//c
                    case(32)->{
                        while (calculator.canMoveDown(grid,currentBlock.getBlock(),currentBlock.position)){
                            fall();}
                    }//space
                }

            }
        });
        //</editor-fold>
    }
    public void rotate(){
        if(calculator.canRotate(grid,currentBlock.getBlock(),currentBlock.position)){
            currentBlock.rotate();}
        else if(currentBlock.position.get()[0]<grid[0].length/2){
            if (!calculator.canRotate(grid,currentBlock.getBlock(),currentBlock.position)){
                currentBlock.position.change(new int[]{1,0});
            }
            rotate();
        }else{
            if (!calculator.canRotate(grid,currentBlock.getBlock(),currentBlock.position)){
                currentBlock.position.change(new int[]{-1,0});
            }
            rotate();
        }
        frame.repaint();
    }

    private final int pixelSize = 20;
    private final int extraLines = 4;

    Pocket p = new Pocket(pixelSize);
    private Boolean[][] grid  = new Boolean[20+extraLines][10];

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        p.draw(g,heldBlock,score);
        paintBlox(currentBlock,g,currentBlock.getColor());
        drawGrid(g);
        paintCast(g);
    }

    public void fall(){
        if(gameEnd()){
        score+=10;
        if(calculator.canMove('d',grid,currentBlock.getBlock(),currentBlock.position)){
            currentBlock.position.change(new int[]{0,1});
        }else{
            grid = calculator.addTwo(grid,currentBlock.getBlock(),currentBlock.position);

            score+=(Math.pow(calculator.gridSccore(grid),2))*50;
            while(calculator.someFull(grid)){
                grid = calculator.check(grid);
            }
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
            int rando = (int)(Math.random()*8);
            currentBlock = new block(c,new position(rando,0));
        }
        frame.repaint();}
    }
    public boolean gameEnd(){
        for (int i = 0; i < extraLines; i++) {
            if(!calculator.isBlank(grid[i])){
                return false;
            }

        }return true;
    }

    protected void drawGrid(Graphics g){
        int size = pixelSize;
        for (int i = extraLines;i<grid.length;i+=1){
            for(int j = 0;j<grid[i].length;j+=1){
                g.setColor(new Color(0x000000));
                g.drawRect(size*j,size*(i-extraLines),size,size);
                // responsible for drawing taken blox
                if(grid[i][j]) {
                    g.fillRect((size * j) + 1, (size * (i-extraLines)) + 1, size, size);
                }
            }
        }
    }
    protected void paintBlox(block b, Graphics g, Color c){
        int size = pixelSize;
        for (int i = 0; i < b.getBlock().length; i++) {
            for (int j = 0; j < b.getBlock()[i].length; j++) {
                int[] pos = b.position.get();
                if(b.getBlock()[j][i]){
                    g.setColor(c);
                    g.fillRect(size*(i)+((pos[0]*size)),
                               size*(j-extraLines)+((pos[1]*size)),
                            size,size);

                }
            }

        }
    }
    protected void paintCast(Graphics g){
        int size = pixelSize;
        block b= new block(currentBlock);
        while (calculator.canMoveDown(grid,b.getBlock(),b.position)){
            b.position.change(new int[]{0,1});
        }
        for (int i = 0; i < b.getBlock().length; i++) {
            for (int j = 0; j < b.getBlock()[i].length; j++) {
                int[] pos = b.position.get();
                if(b.getBlock()[j][i]){
                    g.setColor(b.getColor().brighter());
                    g.drawRect(size*(i)+((pos[0]*size)+1),
                            size*(j-extraLines)+((pos[1]*size)+1),
                            size-2,size-2);

                }
            }

        }
    }

}