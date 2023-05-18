import stuffs.gaem;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //<editor-fold desc="game">
        JFrame frame = new JFrame();
        gaem g= new gaem(frame);
        g.start();
        //</editor-fold>
    }

}