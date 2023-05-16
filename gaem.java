import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class gaem extends Thread {
    private speed speed = new speed();
    private field gField;
    JFrame frame;
    private int high = 0;
    private int current = 0;

    public gaem(){
        //<editor-fold desc="setup">
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
        gField.p.getScore().setBounds(200,80,100,40);


        frame.add(gField);
        frame.add(gField.p);
        frame.add(gField.p.getScore());
        //</editor-fold>
        speed.start();
    }

    public static void set(gaem g) {
        this = g;
    }

    public void reStart(){
        //<editor-fold desc="setup">
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
        gField.p.getScore().setBounds(200,80,100,40);


        frame.add(gField);
        frame.add(gField.p);
        frame.add(gField.p.getScore());
        //</editor-fold>
        speed = new speed();
        speed.start();
        start();

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
        prompt p = new prompt(this);
        p.setVisible(true);

    }
}
class prompt extends JFrame{
    public prompt(gaem game){
        super("Again?");
        setBounds(0,0,100,70);
        JButton button = new JButton("?");
        button.setBounds(0,0,50,70);
        add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 gaem g = new gaem();
                 gaem.set(g);
            }
        }
    );
    }

}
