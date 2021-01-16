package A7;

import java.util.Scanner;


public class k_tree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int case_number = input.nextInt();
        for (int i = 0; i < case_number; i++) {
            int nodes_number = input.nextInt();
            int k_ary = input.nextInt();

            int h = (int) (Math.log10(nodes_number) / Math.log10(k_ary));
            if (Math.pow(k_ary,h) < nodes_number){
                h++;
            }
            int cur_num = nodes_number - (int)( (Math.pow(k_ary,h) - 1) / (k_ary-1) );
            int left = (int) (Math.pow(k_ary,h-1) - Math.ceil(cur_num*1.0 / k_ary));
            int sum = cur_num + left;

            System.out.println(sum);

        }
    }
}
