import javax.swing.*;
import java.awt.*;

public class field extends JPanel {
    public field() {
        super();
    }

    protected void paintComponent(Graphics g){
        //super.paintComponent(g);
        g.fillRect(0,0,10,10);
    }
}