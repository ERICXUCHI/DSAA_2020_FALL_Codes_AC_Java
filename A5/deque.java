package A5;

import java.util.Scanner;

class node{
    long val;
    node pre;
    node next;
    node(long x){
        val = x;
    }
}

public class deque {
    public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

        long max = 100001;
        while (in.hasNext()){
        long xn = in.nextLong();
        long xo = in.nextLong();
        node[][] nodes = new node[(int) xn][2];
        for (int i = 0; i < xn; i++) {
            nodes[i][0] = new node(0);
            nodes[i][1] = new node(max);
            nodes[i][0].next = nodes[i][1];
            nodes[i][1].pre = nodes[i][0];
        }
        for (long i = 0; i < xo; i++) {

            int signal = in.nextInt();
            switch (signal) {
                case 1:
                    long index = in.nextLong();
                    long direction = in.nextLong();
                    long value = in.nextLong();
                    node newNode = new node(value);
                    if (direction == 0) {
                        nodes[(int) (index - 1)][0].next.pre = newNode;
                        newNode.next = nodes[(int) (index - 1)][0].next;
                        nodes[(int) (index - 1)][0].next = newNode;
                        newNode.pre = nodes[(int) (index - 1)][0];
                    } else{
                        nodes[(int) (index - 1)][1].pre.next = newNode;
                        newNode.pre = nodes[(int) (index - 1)][1].pre;
                        nodes[(int) (index - 1)][1].pre = newNode;
                        newNode.next = nodes[(int) (index - 1)][1];
                    }
                    break;

                case 2:
                    long index0 = in.nextLong();
                    long direction0 = in.nextLong();
                    if (nodes[(int) (index0 - 1)][0].next.val == max) {
                        System.out.println(-1);
                    } else {
                        if (direction0 == 0) {
                            System.out.println(nodes[(int) (index0 - 1)][0].next.val);
                            node temp = nodes[(int) (index0-1)][0].next;

                            temp.next.pre = nodes[(int) (index0-1)][0];
                            nodes[(int) (index0-1)][0].next = temp.next;

                            temp.pre = null;
                            temp.next = null;

                        } else{
                            System.out.println(nodes[(int) (index0 - 1)][1].pre.val);

                            node temp = nodes[(int) (index0 - 1)][1].pre;

                            temp.pre.next = nodes[(int) (index0-1)][1];
                            nodes[(int) (index0-1)][1].pre = temp.pre;

                            temp.pre = null;
                            temp.next = null;

                        }
                    }
                    break;


                case 3:
                    long index1 = in.nextLong();
                    long index2 = in.nextLong();
                    long direction1 = in.nextLong();
                    if (direction1 == 0) {
                        if (nodes[(int) (index2 - 1)][1].pre.val != 0) {
                            nodes[(int) (index1 - 1)][1].pre.next = nodes[(int) (index2 - 1)][0].next;
                            nodes[(int) (index2 - 1)][0].next.pre = nodes[(int) (index1 - 1)][1].pre;

                            nodes[(int) (index1 - 1)][1].pre = nodes[(int)(index2-1)][1].pre;
                            nodes[(int)(index2-1)][1].pre.next = nodes[(int) (index1 - 1)][1];
                        }
                    } else{
                        if (nodes[(int) (index2 - 1)][1].pre.val != 0) {
                            node cur = nodes[(int) (index2 - 1)][1].pre;
                            node point = nodes[(int) (index1 - 1)][1].pre;
                            while (cur.val != 0) {
                                point.next = cur;
                                cur = cur.pre;
                                cur.next.pre = point;
                                point = point.next;
                            }
                            point.next = nodes[(int) (index1 - 1)][1];
                            nodes[(int) (index1 - 1)][1].pre = point;

                        }
                    }

                    nodes[(int) (index2 - 1)][0].next = nodes[(int) (index2 - 1)][1];
                    nodes[(int) (index2 - 1)][1].pre = nodes[(int) (index2 - 1)][0];
                    break;


            }
        }
    }
    }
}
