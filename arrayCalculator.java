import java.util.ArrayList;
import java.util.Arrays;

public class arrayCalculator {
    public boolean canRotate(Boolean[][] a,Boolean[][] b,position p){
        Boolean[][] temp = rot(b);
        return(canaddTwo(a,temp,p)>0);
    }

    public boolean canMove(char c,Boolean[][] a,Boolean[][] b,position p){
        Boolean[][] temp = rot(b);
        switch (c){
            case('l')->{
                position pot = new position(p.get());
                pot.change(new int[]{-1,0});
                return canaddTwo(a,b,pot)>0;
            }
            case('r')->{
                position pot = new position(p.get());
                pot.change(new int[]{1,0});
                return canaddTwo(a,b,pot)>0;
            }
            default -> {return canMoveDown(a,b,p);}
        }
    }
    public Boolean[][] addTwo(Boolean[][] a,Boolean[][] b,position p){
        /*
        adds b to a at p and returns the result
         */
        int x = p.get()[0],y=p.get()[1];
        for (int i = 0; i < b[0].length; i++) {
            for (int j = 0; j < b.length; j++) {
                if(b[j][i]){
                    a[j+y][i+x] = true;
                }
            }

        }
        return a;
    }
    public int canaddTwo(Boolean[][] a,Boolean[][] b,position p){
        /*
        adds b to a at p and returns the result
        -1 means 2 things overlap
        -2 means out of bounds
        1 means yes it can
         */
        int x = p.get()[0],y=p.get()[1];
        for (int i = 0; i < b[0].length; i++) {
            for (int j = 0; j < b.length; j++) {
                if(b[j][i]){
                    if(
                    !isValid(i+x,j+y,a)
                    ){
                        return -2;
                    }
                    if(a[j+y][i+x]){
                        return -1;
                    }
                }
            }

        }
        return 1;
    }
    public boolean isValid(int x,int y, Boolean[][] a){
        return (
                x>-1&&y>-1
                &&x<a[0].length&&y<a.length
                );
    }
    public boolean canMoveDown(Boolean[][] a,Boolean[][] b,position p){
        position top = new position(p.get());
        top.change(new int[]{0,1});
        return (canaddTwo(a,b,top)>0);
    }
    public ArrayList<ArrayList<Boolean>> a_to_A(Boolean[][] b){
        ArrayList<ArrayList<Boolean>> t = new ArrayList<>();
        for (Boolean[] booleans : b) {
            t.add( new ArrayList<>(Arrays.asList(booleans)));
        }
        return t;
    }
    public Boolean[][] A_to_a(ArrayList<ArrayList<Boolean>> ans){
        Boolean[][] tem= new Boolean[ans.size()][ans.get(0).size()];
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(0).size(); j++) {
                tem[i][j] = ans.get(i).get(j);
            }
        }
        return tem;
    }
    public Boolean[][] rot(Boolean[][] init){
        // rotates clockwise
        Boolean[][] temp = new Boolean[init[0].length][init.length];
        final int M = init.length;
        final int N = init[0].length;


        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                temp[c][M-1-r] = init[r][c];
            }
        }
        return temp;
    }
    public Boolean[][] shave(Boolean[][] init){
        int by = 0,bx=0;
        for (Boolean[] value : init) {
            if (isBlank(value)) {
                bx += 1;
            }
        }
        init = rot(init);
        for (Boolean[] booleans : init) {
            if (isBlank(booleans)) {
                by += 1;
            }
        }
        init = rot(init);init = rot(init);init = rot(init);
        Boolean[][] clean = new Boolean[init.length-bx][init[0].length-by];
        bx=0;by=0;
        int i = 0;
        while (isBlank(init[i])){
            by+=1;i+=1;
        }init = rot(init);
        i=0;
        while (isBlank(init[i])){
            bx+=1;i+=1;
        }
        init = rot(init);init = rot(init);init = rot(init);
        for (int j = 0; j < clean.length; j++) {
            System.arraycopy(init[j + by], bx, clean[j], 0, clean[0].length);

        }
        return clean;
    }
    public int[] shaveInts(Boolean[][] init){
        int by = 0,bx=0;
        int i = 0;
        while (isBlank(init[i])){
            by+=1;i+=1;
        }init = rot(init);
        i=0;
        while (isBlank(init[i])){
            bx+=1;i+=1;
        }
        return(new int[]{bx,by});}
    private boolean isBlank(Boolean[] a){
        for (Boolean b:a) {
           if(b){return false;}
        }
        return true;
    }
}
