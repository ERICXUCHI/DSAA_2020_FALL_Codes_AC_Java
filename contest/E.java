package contest;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int q = input.nextInt();
        long[] s = new long[n + 1];
        s[0] = 0;
        for (int i = 1; i <= n; i++) {
            s[i] = input.nextLong();
        }

        for (int i = 0; i < q; i++) {
            long[] s0 = new long[n + 1];
            for (int j = 0; j < s.length; j++) {
                s0[j] = s[j];
            }
            long x = input.nextLong();
            long y = input.nextLong();
            long temp0 = s0[1] + s0[2];
            if (temp0 < x) {
                y -= x - temp0;
                s0[2] = x - s0[1];
                if (y < 0) {
                    System.out.println("No");
                    continue;
                }

            }
            long temp1 = s0[n - 1] + s0[n];
            if (temp1 < x) {
                y -= x - temp1;
                s0[n - 1] = x - s0[n];

                if (y < 0) {
                    System.out.println("No");
                    continue;
                }
            }

            int cnt = 1;
            while (cnt < n - 1) {
                long temp = s0[cnt] + s0[cnt + 1] + s0[cnt + 2];
                if (temp < x) {
                    y -= x - temp;
                    s0[cnt + 2] = x - s0[cnt] - s0[cnt + 1];
                }
                cnt++;
            }



            if (y < 0){
                System.out.println("No");
            }
            else {
                System.out.println("Yes");
            }
        }
    }
}
