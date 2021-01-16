package A1;

import java.util.Scanner;

public class sum_digits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int xt = input.nextInt();
        long[] x_array = new long[xt];
        for (int i = 0; i < xt; i++) {
            long[] y_array = new long[2];
            y_array[0] = input.nextLong();
            y_array[1] = input.nextLong();
            String x_str = String.valueOf(y_array[0]);
            int[] z_array = new int[x_str.length()+1];
            int x_sum = 0;
            for (int j = 0; j < x_str.length(); j++) {
                z_array[j] = x_str.charAt(x_str.length() - 1 - j) - '0';
            }

            for (int j = 0; j < x_str.length(); j++) {
                x_sum += z_array[j];
            }

            if (x_sum <= y_array[1]){
                x_array[i] = 0;
            }
            else {
                int counter = -1;
                while (x_sum > y_array[1]) {
                    counter++;
                    x_sum = x_sum - z_array[counter] + 1;
                    z_array[counter + 1] += 1;
                    x_array[i] += (10 - z_array[counter]) * (long) Math.pow(10, counter);
                }
            }
        }

        for (int i = 0; i < xt; i++) {
            System.out.println(x_array[i]);
        }
    }

}
