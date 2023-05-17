import java.awt.*;
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
    public block(position o){
        this.position = o;
    }

    public block randobblock(position p){
        block returnblock = new block(this);
        char c; int rand = (int)(Math.random()*7)+1;
        switch (rand){
            case(1)->{c = 'l';}
            case(2)->{c = 'j';}
            case(3)->{c = 'o';}
            case(4)->{c = 'T';}
            case(5)->{c = 's';}
            case(6)->{c = 'z';}
            default -> {c = 'L';}
        }
        int[][] fin = L;
        switch (c){
            case('L')->{fin = l;this.c =      new Color(0x050598);}
            case('j')->{fin = j;this.c =      new Color(0xD97F28);}
            case('o')->{fin = this.o;this.c = new Color(0xD3C202);}
            case('T')->{fin = T;this.c =      new Color(0xB20096);}
            case('s')->{fin = s;this.c =      new Color(0x86FF04);}
            case('z')->{fin = z;this.c =      new Color(0x00A963);}
            case('l')->{this.c = new Color(0x059F00);}
        }
        form = new Boolean[fin.length][fin[0].length];
        for(int i = 0;i<fin.length;i+=1){
            for (int j = 0; j < fin[0].length; j++) {
                form[i][j] = (fin[i][j]==1);
            }
        }
        this.position = p;
        return returnblock;
    }
    public block(block b){
        hasBeenHeld = b.hasBeenHeld;
        position = new position(b.position.get());
        c = b.getColor();
        form = b.getBlock();
    }
    //</editor-fold>


    public void rotate(){
        form = calculator.rot(form);
    }

}

 class CBoolean{
    public CBoolean(boolean b,Color c){
        bol = b;
        coler=c;
    }
    public CBoolean(boolean b){
        bol = b;
        coler=null;
    }
    public void setColer(Color c){
        coler = c;
    }
    public void set(boolean a){
        bol = a;
    }
    private Color coler;
    private Boolean bol;
    public Boolean get(){
        return bol;
    }
    public Color getColer(){
        return coler;
    }
}
class position {
    private int x,y;
    public position(int x,int y){
        this.x = x;this.y = y;
    }
    public position(int[] a){
        x = a[0];y=a[1];
    }
    public int[] get(){
        return new int[]{x,y};
    }
    public void change(int[] ammount) {
        if (ammount.length != 2) {return;}
        x+=ammount[0];y+=ammount[1];
    }
}

