package A6;

import java.util.Scanner;

public class next {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String temp = in.next();
        int[] a = next(temp);
        for (int i = 0; i < temp.length(); i++) {
            System.out.println(a[i]);
        }

    }

    static int[] next(String temp){
        int length = temp.length();
        int[] result = new int[length];
        result[0] = 0;
        int k = 0;
        int j = 1;
        while (j < length){
            if (temp.charAt(j) == temp.charAt(k)){
                k++;
                result[j] = k;
                j++;
            }
            else if (k == 0){
                result[j] = 0;
                j++;
            }
            else {
                k = result[k-1];
            }

        }

        return result;

    }
}
