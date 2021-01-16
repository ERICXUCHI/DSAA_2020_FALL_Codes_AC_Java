import java.util.Scanner;

public class hanio{
    public static void main(String[] args) {
        long integer = 1000000007;
        Scanner input = new Scanner(System.in);
        int xi = input.nextInt();
        int[] array = new int[xi];

        for (int i = 0; i < xi; i++) {
            array[i] = input.nextInt();
        }

        for (int i = 0; i < xi; i++) {
            long initial = 1;
            long a = 3 % integer;
            while(array[i] > 0){

                if (array[i] % 2 == 1){
                    initial = (initial * a) % integer;
                }
                array[i] = array[i]/2;
                a = (a * a) % integer;
            }
            System.out.println(initial-1);
        }

    }
}