package A9;

import java.util.Scanner;

public class matrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int case_number = input.nextInt();
        for (int i = 0; i < case_number; i++) {
            int city_number = input.nextInt();
            int road_number = input.nextInt();
            int[][] matrix = new int[city_number][city_number];
            for (int j = 0; j < road_number; j++) {
                int a = input.nextInt();
                int b = input.nextInt();
                matrix[a-1][b-1]++;
            }

            for (int j = 0; j < city_number; j++) {
                for (int k = 0; k < city_number; k++) {
                    System.out.print(matrix[j][k] +" ");
                }
                System.out.println();
            }


        }
    }
}
