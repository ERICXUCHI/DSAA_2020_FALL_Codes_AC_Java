import java.util.ArrayList;
import java.util.Scanner;

public class maximum_difference {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int xt = input.nextInt();
        int[] x_print = new int[xt];
        for (int i = 0; i < xt; i++) {
            int xn = input.nextInt();
            ArrayList<Integer> x_arraylist = new ArrayList<>();
            for (int j = 0; j < xn; j++) {
                x_arraylist.add(input.nextInt());
            }

            int max_dif = x_arraylist.get(0) - x_arraylist.get(1);
            int max_index = 0;
            for (int j = 1; j < x_arraylist.size(); j++) {
                if (x_arraylist.get(max_index)-x_arraylist.get(j) > max_dif){
                    max_dif = x_arraylist.get(max_index)-x_arraylist.get(j);
                }
                if (x_arraylist.get(j) > x_arraylist.get(max_index)){
                    max_index = j;
                }
            }
            x_print[i] = max_dif;
        }

        for (int i = 0; i < xt; i++) {
            System.out.println(x_print[i]);
        }
    }
}
