package A8;

import java.util.Scanner;

public class player {
    static long leftChild(long i)
    {
        return 2*i;
    }
    static long rightChild(long i)
    {
        return 2 * i + 1;
    }

    static void heap(long[] array,long n,long index)
    {

        long min = index;
        long left = leftChild(index);
        long right = rightChild(index);
        if(left <= n && array[(int) left] < array[(int) min])
        {
            min = left;
        }
        if(right <= n && array[(int) right] < array[(int) min])
        {
            min = right;
        }
        if(min != index)
        {
            long tmp = array[(int) index];
            array[(int) index] = array[(int) min];
            array[(int) min] = tmp;
            heap(array,n,min);
        }
    }

    static long[][] merge_sort(long[][] parameter, long xn){
        if (xn > 1){
            long p = xn/2;
            long[][] x_temp1 = new long[(int) p][2];
            long[][] x_temp2 = new long[(int) (xn-p)][2];
            for (int i = 0; i < p; i++) {
                x_temp1[i][0] = parameter[i][0];
                x_temp1[i][1] = parameter[i][1];
            }
            for (int i = (int) p; i < xn; i++) {
                x_temp2[(int) (i - p)][0] = parameter[i][0];
                x_temp2[(int) (i - p)][1] = parameter[i][1];
            }
            merge_sort(x_temp1, p);
            merge_sort(x_temp2, xn - p);
            long[][] temp= merge(x_temp1, p, x_temp2, xn - p);
            for (int i = 0; i < xn; i++) {
                parameter[i][0] = temp[i][0];
                parameter[i][1] = temp[i][1];
            }
        }
        return parameter;
    }

    static long[][] merge(long[][] x_temp1, long nl, long[][] x_temp2, long nr) {
        long n = nl + nr;
        long[][] a_array = new long[(int) n][2];
        int i = 0;
        int j = 0;
        for (int k = 0; k < n; k++) {
            if (i < nl && (j > nr - 1 || x_temp1[i][1] < x_temp2[j][1])) {
                a_array[k][0] = x_temp1[i][0];
                a_array[k][1] = x_temp1[i][1];
                i++;
            }

            else if (i < nl && (j > nr - 1 || x_temp1[i][1] == x_temp2[j][1])){
                if (x_temp1[i][0] < x_temp2[j][0]){
                    a_array[k][0] = x_temp1[i][0];
                    a_array[k][1] = x_temp1[i][1];
                    i++;
                }
                else {
                    a_array[k][0] = x_temp2[j][0];
                    a_array[k][1] = x_temp2[j][1];
                    j++;
                }
            }
            else {
                a_array[k][0] = x_temp2[j][0];
                a_array[k][1] = x_temp2[j][1];
                j++;
            }
        }
        return a_array;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long case_number = input.nextLong();
        for (int i = 0; i < case_number; i++) {
            int number = input.nextInt();
            long[][] players = new long[number][2];
            for (int j = 0; j < number; j++) {
                players[j][0] = input.nextLong();
            }
            for (int j = 0; j < number; j++) {
                players[j][1] = input.nextLong();
            }
            merge_sort(players, number);

            long[] buy = new long[number+1];
            int count = 1;
            buy[1] = players[0][0];

            for (int j = 1; j <= number-1; j++) {

                if (count < players[j][1]){
                    buy[count+1] = players[j][0];
                    count++;
                    int counter = count;
                    long a = players[j][0];
                    for (int k = 2; k <= counter; k++) {
                        if (a < buy[(int) (counter / 2)]) {
                            while (a < buy[(int) (counter / 2)]) {
                                buy[(int) counter] = buy[(int) (counter / 2)];
                                buy[(int) (counter / 2)] = a;
                                counter = counter / 2;
                                if (counter == 1) {
                                    break;
                                }
                            }
                        }
                        else {
                            break;
                        }
                    }
                }

                else {
                    if (players[j][0] > buy[1]){
                        buy[1] = players[j][0];
                        heap(buy,count,1);
                    }
                }

            }

            long sum = 0;

            for (int j = 0; j < buy.length; j++) {
                sum += buy[j];
            }

            System.out.println(sum);

        }
    }
}
