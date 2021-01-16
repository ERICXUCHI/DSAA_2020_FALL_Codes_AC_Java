package A5;

import java.io.*;
import java.util.*;

public class subsequence {

    public static void main(String[] args) {
        Scanner x_input = new Scanner(System.in);

        int abs = x_input.nextInt();

        int number = x_input.nextInt();

        int[] x_array = new int[number];

        for (int i = 0; i < number; i++) {
            x_array[i] = x_input.nextInt();
        }

        int result = 1;

        int l = 0;
        int r = 0;
        int min = x_array[0];
        int max = x_array[0];

        while (r < number-1){

            r++;

            while (Math.abs(x_array[r]-max) > abs || Math.abs(x_array[r]-min) > abs){

                l++;

                min = x_array[l];
                max = x_array[l];
                for (int i = l; i <= r; i++) {
                    if (x_array[i] > max){
                        max = x_array[i];
                    }
                    if (x_array[i] < min){
                        min = x_array[i];
                    }
                }

            }



            if (x_array[r] > max){
                max = x_array[r];
            }
            else if (x_array[r] < min){
                min = x_array[r];
            }

            if (r - l + 1 > result){
                result = r - l + 1;
            }

//            if (l == 0 && r == number-1){
//                result = number;
//            }




        }
        System.out.println(result);


    }
}



