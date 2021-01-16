package A8;

import java.util.Scanner;

public class juan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int case_number = input.nextInt();
        for (int i = 0; i < case_number; i++) {
            int student_number = input.nextInt();
            int[][] valves = new int[student_number+1][2];
            valves[1][0] = input.nextInt();
            valves[1][1] = 1;
            for (int j = 2; j <= student_number; j++) {
                int val = input.nextInt();
                int count = j;
                if (val > valves[count/2][0]){
                    while (val > valves[count/2][0]) {
                        valves[count][0] = valves[count / 2][0];
                        valves[count][1] = valves[count / 2][1];
                        valves[count / 2][0] = val;
                        valves[count / 2][1] = j;
                        count = count / 2;
                        if (count == 1 || count == 0){
                            break;
                        }
                    }
                }
                else {
                    valves[j][0] = val;
                    valves[j][1] = j;
                }
            }

            int index = input.nextInt();
            int pos = 0;
            for (int j = 1; j <= student_number; j++) {
                if (index == valves[j][1]){
                    pos = j;
                    break;
                }
            }

            int x = (int) (Math.log10(pos) / Math.log10(2));
            int y = pos + 1 - (int) Math.pow(2,x);

            System.out.println((x+1)+" "+y);
        }
    }
}
