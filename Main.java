import stuffs.gaem;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {


        //<editor-fold desc="choser test">
        Scanner scan = new Scanner(System.in);
        System.out.println("Controls:\n     movement: arrow keys\n      hold: c\n      down: space\n\n");
        System.out.print("pick a theme\n normal(1)\n fast(2)\n choose: ");
        int i = scan.nextInt();
        gaem g= new gaem(i);
        g.start();
        //</editor-fold>


    }
}