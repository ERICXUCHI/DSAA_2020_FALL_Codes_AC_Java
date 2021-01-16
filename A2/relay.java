package A2;

import java.util.Arrays;
import java.util.Scanner;

public class relay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int xn = input.nextInt();
        int xm = input.nextInt();
        int xl = input.nextInt();
        int xll = xl;
        int[] x_array = new int[xn];
        int[] y_array = new int[xn];
        int[] z_array = new int[xn];
        for (int i = 0; i < xn; i++) {
            x_array[i] = input.nextInt();
        }

        for (int i = 0; i < xn-1; i++) {
            y_array[i] = x_array[i+1] - x_array[i];
            z_array[i] = y_array[i];
        }
        y_array[xn - 1] = xl - x_array[xn - 1];
        z_array[xn - 1] = y_array[xn - 1];

        Arrays.sort(z_array);
        int min = z_array[z_array.length - 1];
        int min1 = min;
        //int min_distance = 0;
        //int mid1 = mid(min, xll);

        while(min1 != mid(min1, xll)) {
            while (group(y_array, xn, mid(min1, xll)) <= xm) {
                xll = mid(min1, xll);
            }

            while (group(y_array, xn, mid(min1, xll)) > xm && xll - min1 != 1) {
                min1 = mid(min1, xll);
            }

        }

        System.out.println(xll);


        }

        static int mid(int a, int b) {
            int mid = (a + b) / 2;
            return mid;
        }

        static int group(int[] y_array, int xn, int mid1){
            int group = 0;
            int counter = 0;
            int sum = 0;
            while(counter < xn){
                sum += y_array[counter];
                if (sum <= mid1){
                    counter++;
                }
                else {
                    sum = 0;
                    group++;
                }
            }
            return group+1;
        }

}
