import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class block {
    public position position;
    private Boolean[][] form;
    public boolean hasBeenHeld = false;

    arrayCalculator calculator = new arrayCalculator();

    //<editor-fold desc="Defaults">
    public final int[][] l = {{1,0,0,0}, {1,0,0,0}, {1,0,0,0}, {1,0,0,0}};
    public final int[][] L = {{1,0,0},{1,0,0},{1,1,0}};
    public final int[][] j = {{0,0,1},{0,0,1},{0,1,1}};
    public final int[][] o = {{1,1},{1,1}};
    public final int[][] T = {{0,0,0},{0,1,0},{1,1,1}};
    public final int[][] s = {{0,0,0},{0,1,1},{1,1,0}};
    public final int[][] z = {{1,1,0},{0,1,1},{0,0,0}};
    //</editor-fold>

    //<editor-fold desc="Constructors">
    public Boolean[][] getBlock(){
        return form;
    }
    private Color c;
    public Color getColor(){return c;}

    public block(Character a,position o){
        position = o;
        int[][] fin = L;
        switch (a){
            case('L')->{fin = l;c = new Color(0x3535B7);}
            case('j')->{fin = j;c = new Color(0xD97F28);}
            case('o')->{fin = this.o;c = new Color(0xFFFF00);}
            case('T')->{fin = T;c = new Color(0x930D7D);}
            case('s')->{fin = s;c = new Color(0x047B00);}
            case('z')->{fin = z;c = new Color(0x007B48);}
        }
        form = new Boolean[fin.length][fin[0].length];
        for(int i = 0;i<fin.length;i+=1){
            for (int j = 0; j < fin[0].length; j++) {
                form[i][j] = (fin[i][j]==1);
            }
        }

    }
    //</editor-fold>


    public void rotate(){
        form = calculator.rot(form);
    }

    public String toString(){
        StringBuilder a = new StringBuilder();
        for (Boolean[] b:form) {
            a.append(Arrays.toString(b)).append("\n");
        }
        return a.toString();
    }

}
