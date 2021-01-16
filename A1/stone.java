import java.util.ArrayList;
import java.util.Scanner;

public class stone {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int xt = input.nextInt();
        int[] x_array = new int[xt];

        for (int i = 0; i < xt; i++) {
            int xp = 0;
            int xn = input.nextInt();
            ArrayList<Integer> x_arrayList = new ArrayList<>();
            for (int j = 0; j < xn; j++) {
                x_arrayList.add(input.nextInt());
            }

            int x_temp = x_arrayList.get(0);

            for (int j = 1; j < x_arrayList.size(); j++) {
                x_temp = x_temp ^ x_arrayList.get(j);
            }
            if (x_temp == 0){
                x_array[i] = 0;
            }
            else {
                for (int j = 0; j < x_arrayList.size(); j++) {
                    int y_temp = x_temp ^ x_arrayList.get(j);
                    if (y_temp < x_arrayList.get(j)) {
                            xp++;
                    }
                }
                x_array[i] = xp;
            }
        }

        for (int i = 0; i < xt; i++) {
            System.out.println(x_array[i]);
        }
    }
}
