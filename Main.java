import stuffs.gaem;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        //<editor-fold desc="game">
        gaem g= new gaem();
        g.start();
        //</editor-fold>
    }

}