package A7;

import java.util.Scanner;

public class b_tree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long case_number = input.nextLong();
        for (long i = 0; i < case_number; i++) {
            long nodes_number = input.nextLong();
            long k_ary = 2;

            long h = (long) ((Math.log10(nodes_number) / Math.log10(k_ary)));
//            if (Math.pow(k_ary,h)-1 < nodes_number){
//                h++;
//            }
            System.out.println(h);
        }
    }
}
