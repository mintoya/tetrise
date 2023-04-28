import java.util.ArrayList;
import java.util.Arrays;

public class arrayCalculator {
    public Boolean[][] addTwo(Boolean[][] a,Boolean[][] b,position p){
        /*
        adds b to a at p and returns the result
         */
        Boolean[][] c = a;
        int x = p.get()[0],y=p.get()[1];
        for (int i = 0; i < b[0].length; i++) {
            for (int j = 0; j < b.length; j++) {
                if(b[j][i]){
                    a[j+y][i+x] = true;
                }
            }

        }
        return c;
    }
    public boolean isValid(int x,int y, Boolean[][] a){
        return (
                x>0&&y>0
                &&x<a[0].length&&y<a.length
                );
    }
    public boolean canMoveDown(Boolean[][] a,Boolean[][] b,position p){
        ArrayList<Integer> xposes = new ArrayList<>();
        ArrayList<Integer> yposes = new ArrayList<>();
        int x = p.get()[0],y=p.get()[1];
        for (int i = b[0].length-1; i >-1 ; i--) {
            boolean found = false;
            int j = b.length-1;
            while(j>-1){
                if(!found&&b[j][i]){
                    xposes.add(j+y);
                    yposes.add(i+x);
                    found = true;
                }
                j-=1;
            }
        }

        for (int i = 0; i < xposes.size(); i++) {
            int xp = xposes.get(i),yp=yposes.get(i);
            if(isValid(x,y+1,b)&&a[y+1][x]){return false;}
        }
        return true;
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
}
