import javax.swing.*;
import java.awt.*;

public class gaem extends Thread {
    private field gField;
    private JFrame frame;
    public gaem(){
        //<editor-fold desc="setup">
        frame = new JFrame("testing");
        frame.setSize(300,500-50);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

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
        block block = new block(c,new position(3,0));

        gField = new field(block,frame);



        gField.setBackground(new Color(146, 146, 146));
        gField.setBounds(0,0,280,500);
        gField.p.setBackground(new Color(146, 146, 146));
        gField.p.setBounds(200,0,80,50);
        gField.p.getScore().setBounds(200,80,100,40);


        frame.add(gField);
        frame.add(gField.p);
        frame.add(gField.p.getScore());
        //</editor-fold>

    }
    public void run(){
        while (gField.gameEnd()){
            synchronized (this){
                try{

                    //<editor-fold desc="tests">
                    //                    char c; int rand = (int)(Math.random()*7)+1;
//                    switch (rand){
//                        case(1)->{c = 'l';}
//                        case(2)->{c = 'j';}
//                        case(3)->{c = 'o';}
//                        case(4)->{c = 'T';}
//                        case(5)->{c = 's';}
//                        case(6)->{c = 'z';}
//                        default -> {c = 'L';}
//                    }
//                    block block = new block(c,new position(0,0));
//
//                    gField.setCurrentBlock(block);
                    //</editor-fold>
                    gField.fall();
                    this.wait(500);
                    System.out.println("thread runnin");
                }catch (InterruptedException e){
                    throw new RuntimeException(e);

                }
            }

        }
    }
}
