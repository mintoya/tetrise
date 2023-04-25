import java.util.ArrayList;
import java.util.Arrays;

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

    private static ArrayList<Boolean> enflatten(ArrayList<ArrayList<Boolean>> a){

        ArrayList<Boolean> flat = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            flat.add(a.get(0).get(i));
        }
        for (int i = 0; i < a.size()-1; i++) {
            flat.add(a.get(i+1).get(a.get(0).size()-1));
        }
        for (int i = 1; i < a.size(); i++) {
            flat.add(a.get(a.size()-1).get(a.size()-(i+1)));
        }
        for(int i = a.size()-1;i>1;i-=1){
            flat.add(a.get(i).get(0));
        }

        return flat;
    }
    public static void main(String args[]){
        ArrayList<ArrayList<Boolean>> a = new ArrayList<>();
        a.add(new ArrayList<>());
        a.add(new ArrayList<>());

        a.get(0).add(false);a.get(0).add(true);

        a.get(1).add(true);a.get(1).add(false);

        ArrayList<Boolean> b = enflatten(a);
        System.out.println(b);
    }
}
