package A2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class recurrence {
    public static void main(String[] args) {
        Scanner x_input = new Scanner(System.in);
        int xt = x_input.nextInt();
        int[] x_array = new int[xt];
        int[] z_array = new int[xt];

        for (int i = 0; i < xt; i++) {
            x_array[i] = x_input.nextInt();
            z_array[i] = x_array[i];
        }

        Arrays.sort(z_array);
        long[] y_array = new long[z_array[z_array.length - 1] + 1];

        for (int i = 4; i <= z_array[z_array.length - 1]; i++) {

            y_array[0] = 1;
            y_array[1] = 1;
            y_array[2] = 1;
            y_array[3] = 1;
            y_array[i] = y_array[i/2 - 1] + y_array[i/2] + y_array[i/2 + 1];
        }
        for (int i = 0; i < xt; i++) {
            System.out.println(y_array[x_array[i]]);
        }
    }
}
