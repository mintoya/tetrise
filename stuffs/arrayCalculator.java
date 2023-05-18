package stuffs;

import stuffs.CBoolean;
import stuffs.position;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class arrayCalculator {
    public boolean canRotate(CBoolean[][] a, Boolean[][] b, position p){
        Boolean[][] temp = rot(b);
        return(canaddTwo(a,temp,p)>0);
    }
    public Boolean[][] mirror(Boolean[][] arr) {
        int numRows = arr.length;
        int numCols = arr[0].length;
        Boolean[][] mirroredArr = new Boolean[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                mirroredArr[i][j] = arr[i][numCols - 1 - j];
            }
        }
        return mirroredArr;
    }
    public boolean canMove(char c,CBoolean[][] a,Boolean[][] b,position p){
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
    public CBoolean[][] addTwo(CBoolean[][] a,Boolean[][] b,position p,Color c){
        /*
        adds b to a at p and returns the result
         */
        int x = p.get()[0],y=p.get()[1];
        for (int i = 0; i < b[0].length; i++) {
            for (int j = 0; j < b.length; j++) {
                if(b[j][i]){
                    a[j+y][i+x] = new CBoolean(true,c);
                }
            }

        }
        return a;
    }
    public int canaddTwo(CBoolean[][] a,Boolean[][] b,position p){
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
                    if(a[j+y][i+x].get()){
                        return -1;
                    }
                }
            }

        }
        return 1;
    }
    public boolean isValid(int x,int y, CBoolean[][] a){
        return (
                x>-1&&y>-1
                        &&x<a[0].length&&y<a.length
        );
    }
    public boolean canMoveDown(CBoolean[][] a,Boolean[][] b,position p){
        position top = new position(p.get());
        top.change(new int[]{0,1});
        return (canaddTwo(a,b,top)>0);
    }
    public ArrayList<ArrayList<CBoolean>> a_to_A(CBoolean[][] b){
        ArrayList<ArrayList<CBoolean>> t = new ArrayList<>();
        for (CBoolean[] booleans : b) {
            t.add( new ArrayList<>(Arrays.asList(booleans)));
        }
        return t;
    }
    public CBoolean[][] A_to_a(ArrayList<ArrayList<CBoolean>> ans){
        CBoolean[][] tem= new CBoolean[ans.size()][ans.get(0).size()];
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
    public boolean isBlank(CBoolean[] a){
        for (CBoolean b:a) {
            if(b.get()){return false;}
        }
        return true;
    }
    public CBoolean[][] check(CBoolean[][] grid) {
        ArrayList<ArrayList<CBoolean>> agrid = a_to_A(grid);
        int hm = 0;
        for (int i = 0; i < agrid.size(); i++) {
            if(isFull(agrid.get(i))){
                agrid.remove(i);
                hm+=1;
            }
        }
        ArrayList<CBoolean> temp= new ArrayList<>();
        for (int i = 0; i < agrid.get(0).size(); i++) {
            temp.add(new CBoolean(false));
        }
        for (int i = 0; i < hm; i++) {
            agrid.add(0,temp);
        }
        return A_to_a(agrid);
    }
    public boolean someFull(CBoolean[][] grid){
        for (CBoolean[] a:grid) {
            if(isFull(a)){
                return true;
            }

        }return false;
    }
    public int gridScore(CBoolean[][] grid){

        int i = 0;
        for (CBoolean[] a:grid) {
            if(isFull(a)){
                i+=1;
            }
        }
        return i;
    }
    private boolean isFull(ArrayList<CBoolean> booleans) {
        for (CBoolean a:booleans) {
            if(!a.get()){return false;}
        }
        return true;
    }
    private boolean isFull(CBoolean[] booleans) {
        for (CBoolean a:booleans) {
            if(!a.get()){return false;}
        }
        return true;
    }
}