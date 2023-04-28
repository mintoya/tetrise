import java.lang.invoke.SwitchPoint;

public class position {
    private int x,y;
    public position(int x,int y){
        this.x = x;this.y = y;
    }
    public int[] get(){
        int[] pos ={x,y};
        return pos;
    }
    public void change(int[] ammount) {
        if (ammount.length != 2) {return;}
        x+=ammount[0];y+=ammount[1];
    }
}
