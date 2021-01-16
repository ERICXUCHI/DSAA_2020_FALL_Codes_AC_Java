package A3;

import java.util.Random;
import java.util.Scanner;

public class kth_biggest {
    public static void main(String[] args) {
        Scanner x_input = new Scanner(System.in);
        int xn = x_input.nextInt();
        int xk = x_input.nextInt();
        int[] x_array = new int[xn + 1];

        for (int i = 1; i <= xn; i++) {
            x_array[i] = x_input.nextInt();
        }
        int x_low = 1;
        int x_high = xn;

        int[] y_array = quicksort(x_array,x_low,x_high,xk);
        System.out.println(y_array[xk]);

    }
    static int partition(int[] x_array, int x_low, int x_high){
        if (x_low < x_high) {
            int[] y_array = new int[x_array.length];
            int p = random(x_low, x_high);
            int pivot = x_array[p];
            int L = x_low;
            int R = x_high;
            for (int i = x_low; i <= x_high; i++) {
                if (i != p) {
                    if (x_array[i] < pivot) {
                        y_array[L++] = x_array[i];

                    } else {
                        y_array[R--] = x_array[i];

                    }
                }
            }
            y_array[L] = pivot;

            for (int i = x_low; i <= x_high; i++) {
                x_array[i] = y_array[i];
            }

            return L;
        }
        return 0;
    }

    static int[] quicksort(int[] x_array, int x_low, int x_high, int k){
        if (x_low < x_high) {
            int p = partition(x_array, x_low, x_high);
            if (p == k){
                return x_array;
            }
            else if (p < k) {
                quicksort(x_array, p + 1, x_high, k);
            } else {
                quicksort(x_array, x_low, p - 1, k);
            }
            return x_array;
        }
        return x_array;
    }

    static int random(int a, int b){
        int num = (int)(Math.random() * (b-a+1)) + a;
        return num;
    }
}
