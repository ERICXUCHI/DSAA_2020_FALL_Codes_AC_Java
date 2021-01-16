package A5;

import java.util.Scanner;

public class basic_queue {
    public static void main(String[] args) {
        int max = 20000000;
        int[] queue = new int[max];
        int front = 0;
        int rear = 0;
        Scanner in = new Scanner(System.in);
        int xo = in.nextInt();
        for (int i = 0; i < xo; i++) {
            String operation  = in.next();
            switch (operation) {
                case "E":{
                    int add = in.nextInt();
                    if (rear < max) {
                        queue[rear] = add;
                        rear++;
                    }
                    break;}
                case "D":{
                    if (front < rear) {
                        front++;
                    }
                    break;}
                case "A":{
                    System.out.println(queue[front]);
                    break;}

            }
        }
        for (int i = front; i < rear; i++) {
            System.out.print(queue[i] + " ");
        }

    }
}
