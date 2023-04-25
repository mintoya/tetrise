import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("testing");
        field gField = new field();
        gField.setBounds(0,0,100,100);
        frame.add(gField);
        frame.setLayout(null);
        frame.setVisible(true);
    }

}