package A4;

import java.util.Random;
import java.util.Scanner;

class ListNode {
    long val;
    ListNode next;
    ListNode(){
        val = 0;
    }
    ListNode(long x) {
        val = x; }
}

public class H_basicOperation{
    public static void main(String[] args){

        Scanner x_input = new Scanner(System.in);
        long xn = x_input.nextLong();
        long xo = x_input.nextLong();
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (int i = 0; i < xn; i++) {
            cur.next = new ListNode(x_input.nextLong());
            cur = cur.next;
        }

        for (int i = 0; i < xo; i++) {
            String content = x_input.next();
            if (content.equals("i")){
                ListNode now = head;
                long pos = x_input.nextLong();
                long change = x_input.nextLong();
                for (int j = 0; j < pos-1; j++) {
                    now = now.next;
                }
                ListNode tmp = now.next;
                now.next = new ListNode(change);
                now = now.next;
                now.next = tmp;
            }
            else if (content.equals("r")){
                ListNode now = head;
                long pos = x_input.nextLong();
                for (int j = 0; j < pos-1; j++) {
                    now = now.next;
                }
                now.next = now.next.next;
            }
            else if (content.equals("q")){
                ListNode now = head;
                long pos = x_input.nextLong();
                for (int j = 0; j < pos-1; j++) {
                    now = now.next;
                }
                System.out.println(now.next.val);
            }
        }
    }
    static void change(ListNode A, int x){
        ListNode p = new ListNode();
        p = A;
        while (p != null){
            if (p.val == x){
                p.val = 100;
            }
            p = p.next;
        }

    }

    static void traverse(ListNode A){
        if (A == null){
        }
        else {
            System.out.print(A.val+" ");
            traverse(A.next);
        }

    }



}