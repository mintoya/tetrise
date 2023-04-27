import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("testing");
        field gField = new field();
        gField.setBounds(0,0,100,100);
        frame.add(gField);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        //frame.setVisible(true);

        int[][] b = {{1,0,0},
                     {1,0,0},
                     {1,1,0}};
        block bl = new block(b);
        System.out.println(bl+"\n");
        bl.rotate();
        System.out.println(bl+"\n");




    }

}