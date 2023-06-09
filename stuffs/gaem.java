package stuffs;

import stuffs.music.playah;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class gaem extends Thread {
    private final speed speed = new speed();
    public field gField;
    JFrame frame; 
    public gaem(int choice){
        //<editor-fold desc="setup">
        playah song;
        try {
            song = new playah(choice);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
        song.start();
        if(frame!=null){frame.dispose();}
        frame = new JFrame("testing");
        frame.setSize(300,500-50);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

        block block = new block(new position(3,0));
        block.randobblock(new position(3,0));

        gField = new field(block, frame,song);



        gField.setBackground(new Color(28, 28, 28));
        gField.setBounds        (0,0,280,500);
        gField.p.setBackground(new Color(146, 146, 146));
        gField.p.setBounds      (200,0,80,50);
        gField.p.getTScore().setBounds(200,80,100,40);


        frame.add(gField);
        frame.add(gField.p);
        frame.add(gField.p.getTScore());
        frame.addKeyListener(gField
        );
        //</editor-fold>
        speed.start();
        frame.setAlwaysOnTop(true);
    }

    public void run(){
        while (gField.gameEnd()){
            synchronized (this){
                try{
                    gField.fall();
                    wait(speed.interval);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }//Requirement: while loop
        interrupt();
        VFrame v = new VFrame("score",300,70,
                "your score was "+ gField.p.getScore());
        frame.setVisible(false);


    }
}
class speed extends Thread{
    //Requirement: different Difficulty modes
    int interval = 1000;
    public void run(){
        while(interval>250){
            synchronized (this){
                try {
                    interval -=10;
                    wait(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

class VFrame extends JFrame{
    public VFrame(String name, int width, int height, String Message){
        super(name);

        setSize(width,height);
        JTextField f = new JTextField(Message);
        f.setEnabled(true);
        f.setBounds(0,0,width,height-50);
        add(f);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setAlwaysOnTop(true);
        System.out.println(Message);
    }
}
