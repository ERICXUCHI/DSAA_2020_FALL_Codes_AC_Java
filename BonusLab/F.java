package Bonus;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();

        Comparator<Integer> sort = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(sort);

        for (int i = 0; i < k; i++) {
            int signal = input.nextInt();
            int content = input.nextInt();
            if (signal == 1){
                priorityQueue.add(content);
            }
            else {
                for (int j = 0; j < content-1; j++) {
                    priorityQueue.remove();
                }
                System.out.println(priorityQueue.peek());
            }
        }
    }
}
