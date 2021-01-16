package Bonus;

import java.util.Scanner;
import java.util.Stack;

public class B {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        Stack<Integer> stackLeft = new Stack<>();
        Stack<Integer> stackRight = new Stack<>();
        int MaxValve = 1000005;
        long[] sum = new long[MaxValve];
        long[] max = new long[MaxValve];
        int count = 0;
        max[0] = -Long.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            String signal = input.next();
            switch (signal){
                case "contest.I":
                    int x = input.nextInt();
                    stackLeft.push(x);
                    count++;
                    sum[count] = sum[count-1] + x;
                    max[count] = Math.max(sum[count],max[count-1]);
                    break;
                case "D":
                    stackLeft.pop();
                    count--;
                    break;
                case "L":
                    if (!stackLeft.isEmpty()) {
                        stackRight.push(stackLeft.pop());
                        count--;
                    }
                    break;
                case "R":
                    if (!stackRight.isEmpty()) {
                        stackLeft.push(stackRight.pop());
                        count++;
                        sum[count] = sum[count - 1] + stackLeft.peek();
                        max[count] = Math.max(sum[count], max[count - 1]);
                    }
                    break;
                case "Q":
                    int m = input.nextInt();
                    System.out.println(max[m]);
                    break;
            }
        }
    }
}
