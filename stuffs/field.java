package stuffs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class field extends JPanel implements KeyListener {
    // inheritance
    //<editor-fold desc="instance variables">
    private final arrayCalculator calculator = new arrayCalculator();
    public   JFrame frame;
    private int score = 0;
    private block currentBlock;
    private block heldBlock=null;
    private final int pixelSize = 20;
    private final int extraLines = 4;
    public Pocket p = new Pocket(pixelSize);
    //</editor-fold>
    private CBoolean[][] grid  = new CBoolean[20+extraLines][10];
    //Requirement: Array
    public field(block b,JFrame f){
        super();
        frame = f;
        currentBlock = b;
        for (CBoolean[] booleans : grid) {
            Arrays.fill(booleans, new CBoolean(false));
        }//Requirement: for each loop
    }
    public void rotate(){
        if(calculator.canRotate(grid,currentBlock.getBlock(),currentBlock.position)){
            currentBlock.rotate();}
        else if(currentBlock.position.get()[0]<grid[0].length/2&&
                calculator.canMove('r',grid,currentBlock.getBlock(),currentBlock.position)){
            if (!calculator.canRotate(grid,currentBlock.getBlock(),currentBlock.position)){
                currentBlock.position.change(new int[]{1,0});
            }
            if(currentBlock.position.get()[0]+currentBlock.getBlock()[0].length<grid[0].length)
                rotate();
        }else{
            if (!calculator.canRotate(grid,currentBlock.getBlock(),currentBlock.position)&&
                    calculator.canMove('l',grid,currentBlock.getBlock(),currentBlock.position)){
                currentBlock.position.change(new int[]{-1,0});
            }
            if(currentBlock.position.get()[0]>0)
                rotate();
        }//Requirement: if/Else if statement
        frame.repaint();
    }//Requirement: recursive method
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
            grid = calculator.addTwo(grid,currentBlock.getBlock(),currentBlock.position,currentBlock.getColor());

            score+=(Math.pow(calculator.gridScore(grid),2))*50;
            while(calculator.someFull(grid)){
                grid = calculator.check(grid);
            }//Requirement: while loop
            int rando = (int)(Math.random()*8);
            currentBlock.randobblock(new position(rando,0));
            currentBlock.hasBeenHeld = false;
        }
        frame.repaint();}
    }//Requirement: fruitful method
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
                g.setColor(new Color(0x333232));
                g.drawRect(size*j,size*(i-extraLines),size,size);
                // responsible for drawing taken blox
                if(grid[i][j].get()) {
                    g.setColor(grid[i][j].getColer());
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

    @Override
    public void keyTyped(KeyEvent e) {
        return;
    }
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
                        heldBlock.position = currentBlock.position;
                        currentBlock = heldBlock;
                        heldBlock = temp;
                        heldBlock.hasBeenHeld = true;}
                    else{
                        heldBlock = currentBlock.randobblock(new position(0,0));
                    }
                }
            }//c
            case(32)->{
                while (calculator.canMoveDown(grid,currentBlock.getBlock(),currentBlock.position)){
                    fall();}fall();
            }//space
        }

    }
    @Override
    public void keyReleased(KeyEvent e) {
        return;
    }
    public void addKeyListener(KeyListener l){
        super.addKeyListener(l);
        System.out.println(l);
    }
}

class Pocket extends JPanel {
    private final arrayCalculator calculator = new arrayCalculator();

    public Pocket(int size){pixelsize = size;}

    private final int pixelsize;
    private JTextField score = new JTextField("0");

    public String getScore() {
        return score.getText();
    }
    public JTextField getTScore(){
        return score;
    }

    public void draw(Graphics g, block a, int score){
        this.score.setText(String.valueOf(score));
        this.score.setEditable(false);
        if(a!=null){
            Boolean[][] got = calculator.mirror(a.getBlock());
            got = calculator.rot(calculator.rot(got));
            for (int i = 0; i < got.length; i++) {
                for (int j = 0; j < got[0].length; j++) {
                    g.setColor(a.getColor());
                    if(got[i][j]){
                        g.fillRect((pixelsize*i)+200,pixelsize*j,pixelsize,pixelsize);
                    }
                    g.setColor(new Color(0));
                    g.drawRect((pixelsize*i)+200,pixelsize*j,pixelsize,pixelsize);
                }
            }}
    }

}
