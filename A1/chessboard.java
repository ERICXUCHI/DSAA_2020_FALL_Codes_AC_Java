import java.util.Scanner;

public class chessboard {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int xn = input.nextInt();
        int[][] x_array = new int[xn][2];
        for (int i = 0; i < xn; i++) {
            for (int j = 0; j < 2; j++) {
                x_array[i][j] = input.nextInt();
            }
        }

        for (int i = 0; i < xn; i++) {
            if (x_array[i][0]==1 & x_array[i][1]==1){
                System.out.println("Bob");
        }
            else{
                System.out.println("Alice");
            }
        }
    }
}
