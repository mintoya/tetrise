package stuffs;

import stuffs.music.playah;
import ui.restarter;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class gaem extends Thread {
    private speed speed = new speed();
    public field gField;
    JFrame frame;
    private int high = 0;
    private int current = 0;

    public gaem(JFrame f) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        //<editor-fold desc="setup">
        stuffs.music.playah song = new playah(3);
        song.start();
        if(frame!=null){frame.dispose();}
        frame = new JFrame("testing");
        frame.setSize(300,500-50);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

        block block = new block(new position(3,0));
        block.randobblock(new position(3,0));

        gField = new field(block, frame);



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
        }// while loop
        interrupt();frame.setVisible(false);

        restarter r = new restarter(Integer.parseInt(gField.p.getScore()));
    }
}
class speed extends Thread{
    //Requirement: different Difficulty modes
    int interval = 1000;
    public void run(){
        while(interval>300){
            synchronized (this){
                try {
                    interval -=10;
                    wait(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
