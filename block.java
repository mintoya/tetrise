import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class block {
    Boolean[][] form;
    public block(Boolean[][] a){
        form = a;
    }
    public block (int[][] a){
        form = new Boolean[a.length][a[0].length];
        for(int i = 0;i<a.length;i+=1){
            for (int j = 0; j < a[0].length; j++) {
                form[i][j] = (a[i][j]==1);
            }
        }
    }
    public void rotate(){
    }

    public static ArrayList<ArrayList<Boolean>> a_to_A(Boolean[][] b){
        ArrayList<ArrayList<Boolean>> t = new ArrayList<>();
        for (Boolean[] booleans : b) {
            t.add( new ArrayList<>(Arrays.asList(booleans)));
        }
        return t;
    }
    public static Boolean[][] A_to_a(ArrayList<ArrayList<Boolean>> ans){
        Boolean[][] tem= new Boolean[ans.size()][ans.get(0).size()];
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(0).size(); j++) {
                tem[i][j] = ans.get(i).get(j);
            }
        }
        return tem;
    }
    public static Boolean[][] test(Boolean[][] init){
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
    public static void main(String args[]){
        ArrayList<ArrayList<Boolean>> a = new ArrayList<>();
        a.add(new ArrayList<>());
        a.add(new ArrayList<>());
        a.add(new ArrayList<>());

        a.get(0).add(false);a.get(0).add(true);a.get(0).add(false);
        a.get(1).add(false);a.get(1).add(true);a.get(1).add(false);
        a.get(2).add(false);a.get(2).add(true);a.get(2).add(false);
        int[][] b = {{0,1,0},{0,1,0},{0,1,0}};
        block bl = new block(b);

        System.out.println(a.equals(    a_to_A(bl.form)  ) );


    }
}
