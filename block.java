import java.util.ArrayList;
import java.util.Arrays;

public class block {
    public position position;
    private Boolean[][] form;

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
    public block(Character a,position o){
        position = o;
        int[][] fin = L;
        switch (a){
            case('L')->{fin = l;}
            case('j')->{fin = j;}
            case('o')->{fin = this.o;}
            case('T')->{fin = T;}
            case('s')->{fin = s;}
            case('z')->{fin = z;}
        }
        form = new Boolean[fin.length][fin[0].length];
        for(int i = 0;i<fin.length;i+=1){
            for (int j = 0; j < fin[0].length; j++) {
                form[i][j] = (fin[i][j]==1);
            }
        }
    }
    public block(Boolean[][] a,position o){
        form = a;
        position = o;
    }
    public block (int[][] a,position p){
        form = new Boolean[a.length][a[0].length];
        for(int i = 0;i<a.length;i+=1){
            for (int j = 0; j < a[0].length; j++) {
                form[i][j] = (a[i][j]==1);
            }
        }
        position = p;
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
