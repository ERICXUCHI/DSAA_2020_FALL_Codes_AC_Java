package A3;

import java.util.Scanner;

public class better {
    public static void main(String[] args) {
        Scanner x_input = new Scanner(System.in);
        int xt = x_input.nextInt();
        int[][] sorted_arr = new int[xt][];
        String[] result = new String[xt];
        for (int i = 0; i < xt; i++) {
            int count_selection = 0;
            int count_insertion = 0;
            int xn = x_input.nextInt();
            sorted_arr[i] = new int[xn];
            int[] x_array = new int[xn];
            int[] y_array = new int[xn];
            for (int j = 0; j < xn; j++) {
                x_array[j] = x_input.nextInt();
                y_array[j] = x_array[j];

            }

            int k = 0;
            for (int j = 0; j < xn - 1; j++) {
                k = j;
                for (int l = j+1; l < xn; l++) {
                    if (x_array[k] > x_array[l]){
                        k = l;
                    }
                    count_selection++;
                }
                int temp = x_array[j];
                x_array[j] = x_array[k];
                x_array[k] = temp;
                count_selection++;
            }//sum of method_selection

            for (int j = 0; j < xn; j++) {
                sorted_arr[i][j] = x_array[j];
            }//print sorted

            for (int j = 1; j < xn; j++) {
                for (int l = j; l > 0; l--) {
                    if (y_array[l - 1] > y_array[l]){
                        int temp = y_array[l];
                        y_array[l] = y_array[l-1];
                        y_array[l-1] = temp;
                        count_insertion++;
                    }
                    else {
                        count_insertion++;
                        break;
                    }
                    count_insertion++;
                }
            }
            ;//else! sum of method_insertion

            if (count_selection > count_insertion){
                result[i] = "Insertion Sort wins!";
            }
            else {
                result[i] = "Selection Sort wins!";
            }
        }

        for (int i = 0; i < xt; i++) {
            for (int j = 0; j < sorted_arr[i].length-1; j++) {
                System.out.print(sorted_arr[i][j]+" ");
            }
            System.out.println(sorted_arr[i][sorted_arr[i].length-1]);
            System.out.println(result[i]);
        }

    }
}
