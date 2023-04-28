import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("testing");
        frame.setSize(500,500);
        field gField = new field();
        gField.setBackground(new Color(146, 146, 146));

        gField.setBounds(0,0,280,400);
        frame.add(gField);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        arrayCalculator cal= new arrayCalculator();
        Boolean[][] a = {{false,false,false},
                        {true,true,true},};
        Boolean[][] b = {{false,false,false,false},
                        {false,false,false,false},
                        {false,false,false,false}};
        Boolean[][] c = cal.addTwo(b,a,new position(1,1));
        for (int i = 0; i < b.length; i++) {
            System.out.println(Arrays.toString(c[i]));
        }
        System.out.println();
        Boolean[][] d = {{false,true},{false,true}};

        System.out.println(Arrays.toString(cal.shaveInts(d)));
        for (int i = 0; i < cal.shave(d).length; i++) {
            System.out.println(Arrays.toString(cal.shave(d)[i]));
        }

    }

}