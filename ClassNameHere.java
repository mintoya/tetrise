import java.util.Arrays;
public class ClassNameHere {
    public static int[][] test(int[][] init){
        int[][] temp = new int[init[0].length][init.length];
        final int M = init.length;
        final int N = init[0].length;


        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                temp[c][M-1-r] = init[r][c];
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        int[][] a = {{1,2,3}
                    ,{4,5,6},{7,8,9}};
        for(int i =0;i<3;i+=1){
            System.out.println(Arrays.toString(test(a)[i]));
        }


    }
}