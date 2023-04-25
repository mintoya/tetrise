import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class block {
    Boolean[][] form;
    public block(Boolean[][] a){
        form = a;
    }
    public void rotate(){
        int i = form.length;
        int o = form[0].length;
        Boolean[][] temp = new Boolean[i][o];

    }

    public ArrayList<ArrayList<Boolean>> A_to_A(Boolean[][] b){
        ArrayList<ArrayList<Boolean>> t = new ArrayList<>();
        for (Boolean[] booleans : b) {
            t.add((ArrayList<Boolean>) Arrays.asList(booleans));
        }
        return t;
    }

    private static ArrayList<Boolean> enflatten(ArrayList<ArrayList<Boolean>> a){

        ArrayList<Boolean> flat = new ArrayList<>();

        Boolean[] et = new Boolean[a.size()];
        for (int i = 0; i < a.size(); i++) {et[i] = a.get(0).get(i);}
        Collections.addAll(flat, et);
        flat.remove(flat.size()-1);

        et = new Boolean[a.size()];
        for (int i = 0; i < a.size(); i++) {
            System.out.println("i is :"+i+" and a.size()-1 is:"+(a.size()-1));
            et[i] = a.get(i).get(a.size()-1);
        }
        Collections.addAll(flat, et);
        flat.remove(flat.size()-1);

        et = new Boolean[a.size()];
        for (int i = 0; i < a.size(); i++) {
            et[i] = a.get(a.size()-1).get((a.size()-1)-i);
        }
        Collections.addAll(flat, et);
        flat.remove(flat.size()-1);

        et = new Boolean[a.size()];
        for (int i = 0; i < a.size(); i++) {
            et[i] = a.get((a.size()-1)-i).get(0);
        }
        Collections.addAll(flat, et);
        flat.remove(flat.size()-1);

        return flat;
    }
    public static void main(String args[]){
        ArrayList<ArrayList<Boolean>> a = new ArrayList<>();
        a.add(new ArrayList<>());
        a.add(new ArrayList<>());
        a.add(new ArrayList<>());

        a.get(0).add(false);a.get(0).add(true);a.get(0).add(false);
        a.get(1).add(false);a.get(1).add(true);a.get(1).add(false);
        a.get(2).add(false);a.get(2).add(true);a.get(2).add(false);

        ArrayList<Boolean> b = enflatten(a);
        System.out.println(b);
    }
}
