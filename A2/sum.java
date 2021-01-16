package A2;

import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
        int mod = 1000000007;
        Scanner input = new Scanner(System.in);
        int xt = input.nextInt();
        long[] x_array = new long[xt];
        for (int i = 0; i < xt; i++) {
            x_array[i] = input.nextLong();
        }
        for (int i = 0; i < xt; i++) {
            long xi = (x_array[i] * (x_array[i]+1) / 2 % 1000000007);
            long b =   xi * xi % 1000000007;
            System.out.println(b);
        }
    }
}
