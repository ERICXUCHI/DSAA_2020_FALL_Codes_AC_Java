package contest;

import java.util.Scanner;

public class G{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int case_number  = input.nextInt();
        for (int i = 0; i < case_number; i++) {
            long[][] array = new long[2][4];
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 4; k++) {
                    array[j][k] = input.nextLong();
                }
            }

            long sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += array[0][j];
            }

            if (sum >= 100){
                System.out.println(0);
                continue;
            }

            merge_sort(array,4);

            long diff = 100 - sum;
            long need = 0;
            long tempScore = 0;
            long tempDay = 0;
            int cnt = 0;

            while (diff > 0){
                tempScore = 30 - array[0][cnt];
                tempDay = array[1][cnt];

                if (diff >= tempScore){
                    need += tempScore * tempDay;
                    cnt++;
                    diff -= tempScore;
                }
                else {
                    need += diff * tempDay;
                    diff = 0;
                }
            }
            System.out.println(need);


        }
    }

    static long[][] merge_sort(long[][] parameter, long xn){
        if (xn > 1){
            long p = xn/2;
            long[][] x_temp1 = new long[2][(int) p];
            long[][] x_temp2 = new long[2][(int) (xn-p)];
            for (int i = 0; i < p; i++) {
                x_temp1[0][i] = parameter[0][i];
                x_temp1[1][i] = parameter[1][i];
            }
            for (int i = (int) p; i < xn; i++) {
                x_temp2[0][(int) (i - p)] = parameter[0][i];
                x_temp2[1][(int) (i - p)] = parameter[1][i];

            }
            merge_sort(x_temp1, p);
            merge_sort(x_temp2, xn - p);
            long[][] temp= merge(x_temp1, p, x_temp2, xn - p);
            for (int i = 0; i < xn; i++) {
                parameter[0][i] = temp[0][i];
                parameter[1][i] = temp[1][i];
            }
        }
        return parameter;
    }

    static long[][] merge(long[][] x_temp1, long nl, long[][] x_temp2, long nr) {
        long n = nl + nr;
        long[][] a_array = new long[2][(int) n];
        int i = 0;
        int j = 0;
        for (int k = 0; k < n; k++) {
            if (i < nl && (j > nr - 1 || x_temp1[1][i] <= x_temp2[1][j])) {
                a_array[0][k] = x_temp1[0][i];
                a_array[1][k] = x_temp1[1][i];
                i++;
            }
            else {
                a_array[0][k] = x_temp2[0][j];
                a_array[1][k] = x_temp2[1][j];
                j++;
            }
        }
        return a_array;
    }
}
