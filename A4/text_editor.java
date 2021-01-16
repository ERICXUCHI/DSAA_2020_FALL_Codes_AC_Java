package A4;

import java.util.Scanner;

class node{
    int digit;
    node pre;
    node next;
    public node(int x){
        digit = x;
    }
}
public class text_editor {
    public static void main(String[] args) {
        Scanner x_input = new Scanner(System.in);
        long xt = x_input.nextLong();
        for (int i = 0; i < xt; i++) {
            long xn = x_input.nextLong();
            String content = x_input.next();
            node head = new node(-1);
            node cur = new node(-2);
            head.next = cur;
            cur.pre = head;
            for (int j = 0; j < xn; j++) {
                Character now = content.charAt(j);
                if (Character.isDigit(now)){
                    node newNode = new node(now - '0');
                    cur.pre.next= newNode;
                    newNode.pre = cur.pre;
                    cur.pre = newNode;
                    newNode.next = cur;

                }
                else if (!Character.isDigit(now)) {
                    if (now.equals('H') && cur.pre.pre != null) {
                        cur = cur.pre;
                    } else if (now.equals('L') && cur.next != null) {
                        cur = cur.next;
                    } else if (now.equals('I')) {
                        cur = head.next;
                    } else if (now.equals('x') && cur.next != null) {
                        cur.pre.next = cur.next;
                        cur.next.pre = cur.pre;
                        cur = cur.next;
                    }
                    else if (now.equals('r')){
                        if (cur.next != null) {
                            if (j != xn - 1) {
                                j++;
                                node newNode = new node(content.charAt(j) - '0');
                                cur.pre.next = newNode;
                                newNode.next = cur.next;
                                cur.next.pre = newNode;
                                newNode.pre = cur.pre;
                                cur = newNode;
                            }
                        }
                        else {
                            if (j != xn - 1){
                                j++;
                                node newNode = new node(content.charAt(j) - '0');
                                cur.pre.next = newNode;
                                newNode.next = cur;
                                newNode.pre = cur.pre;
                                cur.pre = newNode;
                                cur = newNode;
                            }
                        }
                    }
                }

                }

            while (head.next.digit != -2){
                System.out.print(head.next.digit);
                head = head.next;
            }
            System.out.println();
            }
        }

    }

