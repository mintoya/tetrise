import javax.swing.*;
import java.awt.*;

public class gaem extends Thread {
    private final speed speed = new speed();
    private field gField;
    private JFrame frame;
    public gaem(){

        //<editor-fold desc="setup">
        frame = new JFrame("testing");
        frame.setSize(300,500-50);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

        block block = new block(new position(3,0));
        block.randobblock(new position(3,0));

        gField = new field(block,frame);



        gField.setBackground(new Color(152, 150, 150));
        gField.setBounds        (0,0,280,500);
        gField.p.setBackground(new Color(146, 146, 146));
        gField.p.setBounds      (200,0,80,50);
        gField.p.getScore().setBounds(200,80,100,40);


        frame.add(gField);
        frame.add(gField.p);
        frame.add(gField.p.getScore());
        //</editor-fold>
        speed.start();

    }
    public void run(){
        while (gField.gameEnd()){
            synchronized (this){
                try{
                    gField.fall();
                    this.wait(speed.interval);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);

                }
            }

        }
    }
}
