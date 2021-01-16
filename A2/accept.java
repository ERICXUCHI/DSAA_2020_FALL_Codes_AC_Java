package A2;

import java.util.Scanner;

public class accept {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int xp = input.nextInt();
        int xl = input.nextInt();
        int[] x_array = new int[xp];
        int[] y_array = new int[xl];

        for (int i = 0; i < xp; i++) {
            x_array[i] = input.nextInt();
        }
        for (int i = 0; i < xl; i++) {
            y_array[i] = input.nextInt();
        }

        for (int i = 0; i < xl; i++) {
            int x_result = different(x_array, y_array[i]);
            if (x_result == -1){
                System.out.println("Accept");
            }
            else {
                System.out.println(x_result);
            }

        }
    }

    static int different(int[] arr, int energy){
        int least = 0;
        int largest = arr.length - 1;
        int result = 0;
        while (least <= largest){
            int x_mid = (least + largest) / 2;
            if (arr[x_mid] == energy){
                result = -1;
                return result;
            }
            else if (arr[x_mid] < energy){
                least = x_mid + 1;
            }
            else if (arr[x_mid] > energy){
                largest = x_mid - 1;
            }
        }
        if (result == 0){
            result = energy - arr[largest];
        }
        return result;
    }
}
