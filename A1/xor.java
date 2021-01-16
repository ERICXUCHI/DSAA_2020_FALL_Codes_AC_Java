import java.util.Scanner;

public class xor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int xn = input.nextInt();
        long[][] x_array = new long[xn][3];
        for (int i = 0; i < xn; i++) {
            for (int j = 0; j < 3; j++) {
                x_array[i][j] = input.nextLong();
            }
        }

        for (int i = 0; i < xn; i++) {
            long x = x_array[i][0]^x_array[i][1];
            int xm = (int)x_array[i][2]%3;
            switch (xm){
                case 0:
                    System.out.println(x_array[i][0]);
                    break;
                case 1:
                    System.out.println(x_array[i][1]);
                    break;
                case 2:
                    System.out.println(x);
                    break;
            }
        }
    }
}

