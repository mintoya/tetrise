import javax.swing.*;
import java.awt.*;

public class gaem extends Thread {
    private field gField;
    private JFrame frame;
    public gaem(){
        //<editor-fold desc="tests ">
        frame = new JFrame("testing");
        frame.setSize(500,500);
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
        block block = new block(c,new position(0,0));

        gField = new field(block);


        gField.setBackground(new Color(146, 146, 146));
        gField.setBounds(0,0,280,400);
        frame.add(gField);

    }
    public void run(){
        while (true){
            synchronized (this){
                try{

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
                    block block = new block(c,new position(0,0));

                    gField.setCurrentBlock(block);
                    frame.repaint();
                    this.wait(1000);
                    System.out.println("thread runnin");
                }catch (InterruptedException e){
                    throw new RuntimeException(e);

                }
            }

        }
    }
}
