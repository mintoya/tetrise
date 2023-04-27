import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("testing");
        frame.setSize(200,200);
        field gField = new field();

        int[][] b = {{1,0,0},
                {1,0,0},
                {1,1,0}};
        block bl = new block(b,new position(0,0));

        gField.setBounds(0,0,200,200);
        frame.add(gField);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);





        System.out.println(bl+"\n");
        bl.rotate();
        System.out.println(bl+"\n");




    }

}