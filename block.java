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
    public String toString(){
        String a ="";
        for (Boolean[] b:form) {
            a+=Arrays.toString(b)+"\n";
        }
        return a;
    }
    public static void main(String args[]){

        int[][] b = {{0,1,0},
                     {0,1,0},
                     {0,1,0}};
        block bl = new block(b);
        System.out.println(b.toString());


    }
}
