import java.awt.*;

public class CBoolean{
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
